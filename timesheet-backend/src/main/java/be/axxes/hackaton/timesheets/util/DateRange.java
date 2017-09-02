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

    public static DateRange forMonth(int year, int monthNumber){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, monthNumber-1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date beginMonth = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        Date endMonth = calendar.getTime();

        return new DateRange(beginMonth, endMonth);
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
