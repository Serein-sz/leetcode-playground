package L202407.L721;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王强
 * @since 2024/7/15
 */
public class Main {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>(){{
            add(new ArrayList<>(List.of("John", "johnsmith@mail.com", "john00@mail.com")));
            add(new ArrayList<>(List.of("John", "johnnybravo@mail.com")));
            add(new ArrayList<>(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com")));
            add(new ArrayList<>(List.of("Mary", "mary@mail.com")));
        }};
        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> account : accounts) {
            List<String> sameEmailList = null;
            List<String> notSameEmailList = new ArrayList<>();
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (map.containsKey(email)) {
                    sameEmailList = map.get(email);
                    continue;
                }
                notSameEmailList.add(email);
            }
            for (String email : notSameEmailList) {
                if (sameEmailList != null) {
                    sameEmailList.add(email);
                } else {
                    map.put(email, account);
                }
            }

        }
        return new ArrayList<>(map.values()).stream().distinct().toList();
    }
}
//[["John","johnnybravo@mail.com"],["John","johnsmith@mail.com","john_newyork@mail.com","john00@mail.com"],["Mary","mary@mail.com"]]
//[["John","johnnybravo@mail.com"],["John","johnsmith@mail.com","john_newyork@mail.com","john00@mail.com"],["Mary","mary@mail.com"]]
