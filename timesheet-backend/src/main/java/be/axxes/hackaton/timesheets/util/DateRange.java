package be.axxes.hackaton.timesheets.util;

import java.util.Calendar;
import java.util.Date;

public class DateRange {

    private final Date fromDate;
    private final Date toDate;

    private DateRange(Date fromDate, Date toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public static DateRange forWeek(int year, int weekNumber) {
        Calendar calendar = Calendar.getInstance();

        calendar.setWeekDate(year, weekNumber, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dateBeginWeek = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date dateEndWeek = calendar.getTime();

        return  new DateRange(dateBeginWeek, dateEndWeek);
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
