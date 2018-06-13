package localdates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/6/12
 *  Last updated:  2018/6/12
 *  Compilation:   javac LocalDates.java
 *  Description: 
 *
 ******************************************************************************/


public class LocalDates {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        LocalDate alonzosBirthday = LocalDate.of(1903, 6, 14);
        alonzosBirthday = LocalDate.of(1903, Month.JULY, 14);
        System.out.println("alonzosBirthday: " + alonzosBirthday);

        LocalDate programersDay = LocalDate.of(2018, 1, 1).plusDays(255);
        System.out.println("programmersDays: " + programersDay);

        LocalDate independenceDay = LocalDate.of(2018, Month.JULY, 4);
        LocalDate christmas = LocalDate.of(2018, Month.DECEMBER, 25);
        System.out.println("Until christmas: " + independenceDay.until(christmas));
        System.out.println("Until christmas: " + independenceDay.until(christmas, ChronoUnit.DAYS));

        System.out.println(LocalDate.of(2016, 1, 31).plusMonths(1));
        System.out.println(LocalDate.of(2016, 3, 31).minusMonths(1));


        DayOfWeek startOFLastMillennium = LocalDate.of(1900, 1, 1).getDayOfWeek();
        System.out.println("startOFLastMillennium: " + startOFLastMillennium);
        System.out.println(DayOfWeek.SATURDAY.plus(3));

        LocalDate firstTuesday = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        System.out.println("firstTuesDay: " + firstTuesday);

        TemporalAdjuster NEXT_WORKDAY = w -> {
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            }
            while (result.getDayOfWeek().getValue() >= 1);
            return result;
        };
        LocalDate backToWork = today.with(NEXT_WORKDAY);
        System.out.println("backToWord: " + backToWork);




    }
}
