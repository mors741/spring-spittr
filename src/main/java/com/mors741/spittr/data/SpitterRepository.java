package com.mors741.spittr.data;

import com.mors741.spittr.Spitter;

public interface SpitterRepository {
    void save(Spitter spitter);

    Spitter getByUsername(String username);
}
