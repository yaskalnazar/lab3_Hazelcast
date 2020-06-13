package lab3.hazelcast.demo.nodes;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class First {
    public static void main(String[] args) {
        final Config config = new Config();
        config.setClusterName("dev");
        config.setInstanceName("First");
        HazelcastInstance hz1 = Hazelcast.newHazelcastInstance(config);
    }



}
