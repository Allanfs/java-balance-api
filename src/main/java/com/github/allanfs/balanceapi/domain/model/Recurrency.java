package com.github.allanfs.balanceapi.domain.model;

import java.util.Calendar;
import java.util.Date;

interface Incrementable {
    Date Increment(Date orig);
}
public enum Recurrency implements Incrementable{
    DAY(Calendar.DATE),
    WEEK(0),
    MONTH(Calendar.MONTH),
    YEAR(Calendar.YEAR);

    private int type;
    Recurrency(int type) {
        this.type = type;
    }
    @Override
    public Date Increment(Date orig) {
        Calendar c = Calendar.getInstance();
        c.setTime(orig);
        c.add(this.type, 1);
        return c.getTime();
    }
}
