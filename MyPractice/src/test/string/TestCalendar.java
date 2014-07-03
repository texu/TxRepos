package test.string;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class TestCalendar {
  private static Date calNextExcuteTime(String startTime, long now) {
    int hour = 0;
    int min = 0;
    if ( !StringUtils.isEmpty(startTime) ) {
      int index = startTime.indexOf(":");
      if ( index > 0 ) {
        try {
          hour = Integer.parseInt(startTime.substring(0, index));
          min = Integer.parseInt(startTime.substring(index + 1));
        } catch ( NumberFormatException ex ) {
          return null;
        }
      } else {
        // error
        return null;
      }
    }

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, min);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    // if now > today.starttime, turn to tomorrow
    if ( calendar.getTimeInMillis() < now ) {
      calendar.add(Calendar.DAY_OF_MONTH, 1);
    }

    return calendar.getTime();
  }
  
  public static void main(String[] args) {
    Date time = calNextExcuteTime("23:00", System.currentTimeMillis());
    System.out.println("time="+time);
  }
  
}
