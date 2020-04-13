import java.util.*;
public class TestCanlender {
    public static void main(String[] args) {
 
        GregorianCalendar calendar = new GregorianCalendar(2999, 10, 9, 22, 10, 50);
        int year = calendar.get(Calendar.YEAR); 
        int month = calendar.get(Calendar.MONTH); 
        int day = calendar.get(Calendar.DAY_OF_MONTH); 
        int day2 = calendar.get(Calendar.DATE); 
        int date = calendar.get(Calendar.DAY_OF_WEEK); 

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(day2);
        System.out.println(date);
     
        GregorianCalendar calendar2 = new GregorianCalendar();
        calendar2.set(Calendar.YEAR, 2999);
        calendar2.set(Calendar.MONTH, Calendar.FEBRUARY); 
        calendar2.set(Calendar.DATE, 3);
        calendar2.set(Calendar.HOUR_OF_DAY, 10);
        calendar2.set(Calendar.MINUTE, 20);
        calendar2.set(Calendar.SECOND, 23);
        printCalendar(calendar2);
   
        GregorianCalendar calendar3 = new GregorianCalendar(2999, 10, 9, 22, 10, 50);
        calendar3.add(Calendar.MONTH, -7); 
        calendar3.add(Calendar.DATE, 7); 
        printCalendar(calendar3);
    
        java.util.Date d = calendar3.getTime();
        GregorianCalendar calendar4 = new GregorianCalendar();
        calendar4.setTime(new java.util.Date());
        long g = System.currentTimeMillis();
    }
    static void printCalendar(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
        String week = "" + ((date == 0) ? "day" : date);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.printf("%d:year %d:month %d:day,week: %s %d: %d: %d\n", year, month, day,week, hour, minute, second);
    }
}