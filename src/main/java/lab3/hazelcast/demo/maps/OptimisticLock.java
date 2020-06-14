package lab3.hazelcast.demo.maps;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.map.IMap;

import java.io.Serializable;

public class OptimisticLock {
    public static void main(String[] args) throws InterruptedException {
        distributedMapWithOptimisticLock();
    }

    private static void distributedMapWithOptimisticLock() throws InterruptedException {
        ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        var hz = HazelcastClient.newHazelcastClient(config);
        IMap<String, Value> map = hz.getMap( "OptimisticLock" );
        String key = "1";
        map.put( key, new Value() );
        System.out.println( "Starting" );
        for ( int k = 0; k < 1000; k++ ) {
            if ( k % 10 == 0 ) System.out.println( "At: " + k );
            for (; ; ) {
                Value oldValue = map.get( key );
                Value newValue = new Value( oldValue );
                Thread.sleep( 10 );
                newValue.amount++;
                if ( map.replace( key, oldValue, newValue ) )
                    break;
            }
        }
        System.out.println( "Finished! Result = " + map.get( key ).amount );

    }

    static class Value implements Serializable {
        public int amount;

        public Value() {
        }

        public Value( Value that ) {
            this.amount = that.amount;
        }

        public boolean equals( Object o ) {
            if ( o == this ) return true;
            if ( !( o instanceof Value ) ) return false;
            Value that = ( Value ) o;
            return that.amount == this.amount;
        }
    }
}
