package lab3.hazelcast.demo;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.map.IMap;

public class DistributedMap {
    public static void main(String[] args) {
        distributedMap();
    }

    private static void distributedMap() {
        ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        var hz = HazelcastClient.newHazelcastClient(config);
        IMap map = hz.getMap("distributedMap");
        for (int i = 1000; i < 2000; i++) {
            map.put(i, "value: " + i);
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println(map.get(i));
        }

    }
}