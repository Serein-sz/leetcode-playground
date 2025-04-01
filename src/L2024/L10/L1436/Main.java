package L2024.L10.L1436;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王强
 * @since 2024/10/8
 */
public class Main {
    public static void main(String[] args) {
        List<List<String>> paths = List.of(List.of("London", "New York"), List.of("New York", "Lima"), List.of("Lima","Sao Paulo"));
        System.out.println(new Main().destCity(paths));
    }

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> graph = new HashMap<>();
        for (List<String> path : paths) {
            int start = graph.getOrDefault(path.get(0), 0) + 1;
            int end = graph.getOrDefault(path.get(1), 0);
            graph.put(path.get(0), start);
            graph.put(path.get(1), end);
        }
        for (Map.Entry<String, Integer> entry : graph.entrySet()) {
            if (entry.getValue().equals(0)) {
                return entry.getKey();
            }
        }
        return "";
    }
}
