package StatkovskiyDmitriy.bookstore.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TimeRange {

    public ArrayList<LocalDate> createDatesRangeList(LocalDate from, LocalDate to) {
        LocalDate start = from;
        LocalDate end = to.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

        ArrayList<LocalDate> dates = (ArrayList<LocalDate>) Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());

        return dates;
    }
}
