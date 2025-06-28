package com.facilcondo.backend.repository;

import com.facilcondo.backend.model.CondominiumModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CondominiumRepositoryInMemoryImpl implements CondominiumRepository {

    private final List<CondominiumModel> fakeDb = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public List<CondominiumModel> findAll() {
        return new ArrayList<>(fakeDb);
    }

    @Override
    public CondominiumModel save(CondominiumModel model) {
        if (model.getId() == null) {
            model.setId(idGenerator.incrementAndGet());
        }
        fakeDb.add(model);
        return model;
    }
}
