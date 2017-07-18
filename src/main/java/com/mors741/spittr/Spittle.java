package com.mors741.spittr;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@EqualsAndHashCode(of={"id","time"})
public class Spittle {

    public static long idGen = 0;

    @Getter private long id;
    @Getter private final String message;
    @Getter private final Date time;
    @Getter private Double latitude;
    @Getter private Double longitude;

    public Spittle(String message, Date time) {
        this.id = idGen++;
        this.message = message;
        this.time = time;
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id = idGen++;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
