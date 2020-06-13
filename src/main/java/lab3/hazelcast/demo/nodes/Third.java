package lab3.hazelcast.demo.nodes;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Third {
    public static void main(String[] args) {
        final Config config3 = new Config();
        config3.setClusterName("dev");
        config3.setInstanceName("Third");
        HazelcastInstance hz3 = Hazelcast.newHazelcastInstance(config3);
    }

}
