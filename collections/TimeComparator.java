
import java.util.Comparator;

import tana.Time2;

public class TimeComparator implements Comparator<Time2> {

  @Override
  public int compare(Time2 time1, Time2 time2) {

     int differenceHour = time1.getHour() - time2.getHour();

     if (differenceHour != 0)
        return differenceHour; 

     int differenceMinute = time1.getMinute() - time2.getMinute();
     if (differenceMinute != 0)
        return differenceMinute;

     int differenceSecond = time1.getSecond() - time2.getSecond();
     return differenceSecond;
  }
}