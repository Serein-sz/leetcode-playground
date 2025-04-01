package L2024.L09.L1845;

import java.util.PriorityQueue;

/**
 * @author 王强
 * @since 2024/9/30
 */
public class Main {
    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5);
    }

}
class SeatManager {

    PriorityQueue<Integer> priorityQueue;

    public SeatManager(int n) {
        priorityQueue = new PriorityQueue<>(n);
        for (int i = 1; i <= n; i++) {
            priorityQueue.add(i);
        }
    }

    public int reserve() {
        return priorityQueue.poll();
    }

    public void unreserve(int seatNumber) {
        priorityQueue.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */