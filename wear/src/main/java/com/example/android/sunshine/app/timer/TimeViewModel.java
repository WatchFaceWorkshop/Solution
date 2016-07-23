package com.example.android.sunshine.app.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeViewModel {
    public static final String DATE_PATTERN = "EEE, MMM dd yyyy";
    public static final String COLON = " : ";
    private Time time;

    public TimeViewModel(Time time) {
        this.time = time;
    }

    public String formattedDate() {
        return format(DATE_PATTERN);
    }

    public String formattedTime() {
        return formatWithPadding(time.hour()) + COLON +
                formatWithPadding(time.minutes()) + COLON +
                formatWithPadding(time.seconds());
    }

    private String format(String pattern) {
        Date date = new Date();
        date.setTime(time.currentTimeInMillis);
        return new SimpleDateFormat(pattern).format(date);
    }

    private String formatWithPadding(int hour) {
        return String.format("%02d", hour);
    }
}