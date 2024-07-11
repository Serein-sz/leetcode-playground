package L202407.L1997;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2024/7/11
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(firstDayBeenInAllRooms(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public static int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int[] rooms = Arrays.copyOf(nextVisit, n);
        Arrays.fill(rooms, 0);
        int visitRoom = 0;
        int i = 0;
        int day = 0;
        for (;;) {
            if (rooms[i] == 0) {
                visitRoom += 1;
            }
            if (visitRoom == n) {
                return day % 1000000007;
            }
            rooms[i] += 1;
            if (rooms[i] % 2 == 1) {
                i = nextVisit[i];
            } else {
                i = (i + 1) % n;
            }
            day++;
        }
    }
}
