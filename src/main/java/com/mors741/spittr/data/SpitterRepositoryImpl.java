package com.mors741.spittr.data;

import com.mors741.spittr.Spitter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
    private static List<Spitter> spitters = new ArrayList<>();

    @Override
    public void save(Spitter spitter) {
        spitters.add(spitter);

    }

    @Override public Spitter getByUsername(String username) {
        for (Spitter spitter : spitters) {
            if (spitter.getUsername().equals(username)) {
                return spitter;
            }
        }
        return null;
    }
}
