package lab3.hazelcast.demo;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class RunInstanses {
    public static void main(String[] args) {
        final Config config = new Config();
        config.setClusterName("dev");
        config.setInstanceName("First");
        HazelcastInstance hz1 = Hazelcast.newHazelcastInstance(config);
        final Config config2 = new Config();
        config2.setClusterName("dev");
        config2.setInstanceName("Second");
        HazelcastInstance hz2 = Hazelcast.newHazelcastInstance(config2);
        final Config config3 = new Config();
        config3.setClusterName("dev");
        config3.setInstanceName("Third");
        HazelcastInstance hz3 = Hazelcast.newHazelcastInstance(config3);
    }



}
