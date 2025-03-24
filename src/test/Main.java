package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 王强
 * @since 2024/11/6
 */
public class Main {

    public static void main(String[] args) {
        List<String> times = List.of("2025-03-19 1:00", "2025-03-19 01:00", "2025-03-19 1", "2025-03-19 01");
        for (String time : times) {
            System.out.println(handleTime(time));
        }
    }

    private static String handleTime(String datetime) {

        String[] strings = datetime.split(" ");

        String date = strings[0];

        String time = strings.length == 2 ? strings[1] : "";

        return date + time;
    }

    private static boolean requireHandleTime() {
        LocalDateTime now = LocalDateTime.now();
        String currentDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime start = LocalDateTime.parse(currentDate + "08:00:00");
        LocalDateTime end = LocalDateTime.parse(currentDate + "21:00:00");
        return now.isAfter(start) && now.isBefore(end);
    }

}
