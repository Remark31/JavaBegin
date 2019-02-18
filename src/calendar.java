import java.time.DayOfWeek;
import java.time.LocalDate;

/*
 * 日历
 * @author:Remark
 * @version: 2019-1-29
 */
public class calendar {

    final static int WEEKDAY = 7;

    private static int getMonthDay(LocalDate date) {
        int month = date.getMonthValue();
        int year = date.getYear();

        int[] days = {31, 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};

        if (month == 2 && year % 4 == 0 && year % 100 != 0){
            return days[month-1]+1;
        }
        return days[month-1];
    }

    private static int getWeekDay(LocalDate date) {
        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        return weekday.getValue();
    }

    public static void main(String[] args){
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
        LocalDate now = LocalDate.now();

        int monthBegin = getWeekDay(now);
        int totaldays = getMonthDay(now);
        int nowdays = now.getDayOfMonth();

        int i = 0;

        for(int j = 0 ; j < monthBegin ; j ++){
            System.out.print("    ");
        }
        for(int j = monthBegin; j < WEEKDAY; j ++){
            System.out.printf("%3d ", i+1);
            i ++;
        }
        System.out.println();

        while (i <= totaldays ){
            for(int j = 0 ; j < WEEKDAY; j ++) {
                if (i + 1 == nowdays) {
                    System.out.printf("%3d*", i + 1);
                }
                System.out.printf("%3d ", i + 1);
                i ++;
                if (i > totaldays) {
                    break;
                }
            }
            System.out.println();
        }

    }
}
