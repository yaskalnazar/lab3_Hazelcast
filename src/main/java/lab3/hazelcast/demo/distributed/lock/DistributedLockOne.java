package lab3.hazelcast.demo.distributed.lock;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;

import java.util.concurrent.TimeUnit;


public class DistributedLockOne {

    public static void main(String[] args) throws InterruptedException {
        ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        var hz = HazelcastClient.newHazelcastClient(config);
        var lock = hz.getCPSubsystem().getLock("testLock");

        System.out.println("Getting lock");
        if ( lock.tryLock ( 10, TimeUnit.SECONDS ) ) {
            try {
                System.out.println("Got lock");
                Thread.sleep(10000);
            } finally {
                lock.unlock();
                System.out.println("Unlocked");
            }
        } else {
            System.out.println("Could not get lock");
        }
    }


}
