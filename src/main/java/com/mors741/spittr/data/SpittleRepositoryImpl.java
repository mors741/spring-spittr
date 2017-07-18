package com.mors741.spittr.data;

import com.mors741.spittr.Spittle;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class SpittleRepositoryImpl implements SpittleRepository{
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = Arrays.asList(
                new Spittle("Message1", new Date()),
                new Spittle("Message2", new Date()),
                new Spittle("Message3", new Date(), 12.34, 43.21),
                new Spittle("Message4", new Date(), 56.78, 87.65)
        );
        return spittles;
    }
}
