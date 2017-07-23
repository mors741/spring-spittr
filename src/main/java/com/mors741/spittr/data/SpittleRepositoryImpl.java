package com.mors741.spittr.data;

import com.mors741.spittr.Spittle;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SpittleRepositoryImpl implements SpittleRepository{

    private static List<Spittle> spittles = Arrays.asList(
            new Spittle("Message1", new Date()),
            new Spittle("Message2", new Date()),
            new Spittle("Message3", new Date(), 12.34, 43.21),
            new Spittle("Message4", new Date(), 56.78, 87.65)
    );

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        if (count < spittles.size()) {
            return spittles.subList(0, count);
        } else {
            return spittles;
        }
    }

    @Override
    public Spittle findOne(long id) {
        for (Spittle spittle : spittles) {
            if (spittle.getId() == id) {
                return spittle;
            }
        }
        return null;
    }
}
