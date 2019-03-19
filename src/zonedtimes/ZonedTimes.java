package zonedtimes;

import java.time.*;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/6/13
 *  Last updated:  2018/6/13
 *  Compilation:   javac ZonedTimes.java
 *  Description: 
 *
 ******************************************************************************/


public class ZonedTimes {

    public static void main(String[] args) {
        ZonedDateTime apollolllaunch = ZonedDateTime.of(1969, 7, 16, 9, 32, 0,
          0, ZoneId.of("America/New_York"));

        System.out.println("apollolllaunch: " + apollolllaunch);

        Instant instant = apollolllaunch.toInstant();
        System.out.println("instant: " + instant);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        System.out.println("zonedDateTime: " + zonedDateTime);

        ZonedDateTime skipped = ZonedDateTime.of(LocalDate.of(2013, 3, 31), LocalTime.of(2, 30), ZoneId.of("Europe/Berlin"));
        System.out.println("Skipped: " + skipped);

        ZonedDateTime amniguous = ZonedDateTime.of(LocalDate.of(2013, 10, 27), LocalTime.of(2, 30), ZoneId.of("Europe/Berlin"));
        ZonedDateTime anHourLater = amniguous.plusHours(1);
        System.out.println("ambiguous: " + amniguous);
        System.out.println("anHourLater: " + anHourLater);

        ZonedDateTime meeting = ZonedDateTime.of(LocalDate.of(2013, 10 ,31), LocalTime.of(14, 30), ZoneId.of("America/Los_Angeles"));
        System.out.println("meeting: " + meeting);

        ZonedDateTime nextMeeting = meeting.plus(Duration.ofDays(7));

        System.out.println("nextMeeting: " + nextMeeting);
        nextMeeting = meeting.plus(Period.ofDays(7));
        System.out.println("neexMeeting: " + nextMeeting);


    }
}
