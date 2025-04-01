package L2024.L07.L682;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王强
 * @since 2024/7/29
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
    }

    public static int calPoints(String[] operations) {
        List<Integer> cores = new ArrayList<>();
        for (String operation : operations) {
            switch (operation) {
                case "+" : cores.add(cores.get(cores.size() - 1) + cores.get(cores.size() - 2));break;
                case "D" : cores.add(cores.get(cores.size() - 1) * 2);break;
                case "C" : cores.remove(cores.size() - 1);break;
                default: cores.add(Integer.parseInt(operation));
            }
        }
        return cores.stream().reduce(0, Integer::sum);
    }
}
