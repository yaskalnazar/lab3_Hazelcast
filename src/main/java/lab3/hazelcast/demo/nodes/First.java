package lab3.hazelcast.demo.nodes;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class First {
    public static void main(String[] args) {
        final Config config = new Config();
        MapConfig mapConfig = new MapConfig("default").setBackupCount(1);
        config.addMapConfig(mapConfig);
        config.setClusterName("dev");
        config.setInstanceName("First");
        HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);
    }


}
