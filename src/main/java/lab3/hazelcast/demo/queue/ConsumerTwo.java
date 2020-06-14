package lab3.hazelcast.demo.queue;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.collection.IQueue;

public class ConsumerTwo {

    public static void main(String[] args) throws Exception {
        consume();
    }

    public static void consume() throws Exception {
        ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        var hz = HazelcastClient.newHazelcastClient(config);
        IQueue<Integer> queue = hz.getQueue("boundedQueue");
        while ( true ) {
            int item = queue.take();
            System.out.println( "Consumed: " + item );
            if ( item == -1 ) {
                queue.put( -1 );
                break;
            }
            Thread.sleep( 2000 );
        }
        System.out.println( "Consumer Finished!" );
    }
}
