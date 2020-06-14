package lab3.hazelcast.demo.maps;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.map.IMap;

import java.io.Serializable;

public class WithoutLock {
    public static void main(String[] args) throws InterruptedException {
        distributedMapWithoutLock();
    }

    private static void distributedMapWithoutLock() throws InterruptedException {
        ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        var hz = HazelcastClient.newHazelcastClient(config);
        IMap<String, Value> map = hz.getMap( "WithoutLock" );
        String key = "1";
        map.put( key, new Value() );
        System.out.println( "Starting" );
        for ( int k = 0; k < 1000; k++ ) {
            if ( k % 100 == 0 ) System.out.println( "At: " + k );
            Value value = map.get( key );
            Thread.sleep( 10 );
            value.amount++;
            map.put( key, value );
        }
        System.out.println( "Finished! Result = " + map.get(key).amount );

    }

    static class Value implements Serializable {
        public int amount;
    }
}
