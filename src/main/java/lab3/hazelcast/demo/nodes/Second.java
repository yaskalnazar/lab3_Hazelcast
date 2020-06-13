package lab3.hazelcast.demo.nodes;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Second {
    public static void main(String[] args) {
        final Config config2 = new Config();
        config2.setClusterName("dev");
        config2.setInstanceName("Second");
        HazelcastInstance hz2 = Hazelcast.newHazelcastInstance(config2);
    }

}
