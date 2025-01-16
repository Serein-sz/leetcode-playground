package L2025.L01.L729;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王强
 * @since 2025/1/3
 */
public class Main {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        Integer[][] integers = {{47, 50}, {33, 41}, {39, 45}, {33, 42}, {25, 32}, {26, 35}, {19, 25}, {3, 8}, {8, 13}, {18, 27}};
        for (Integer[] integer : integers) {
            System.out.println("myCalendar.book(" + integer[0] + ", " + integer[1] + ") = " + myCalendar.book(integer[0], integer[1]));
        }
    }
}
// 25-32, 33-41, 47-50
class MyCalendar {

    private final List<Integer[]> calender;

    public MyCalendar() {
        calender = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (Integer[] section : calender) {
            int startSection = section[0], endSection = section[1];
            if (startTime < endSection && endTime > startSection) {
                return false;
            }
        }
        calender.add(new Integer[]{startTime, endTime});
        return true;
    }

}
