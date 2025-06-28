package com.facilcondo.backend.repository;

import com.facilcondo.backend.model.CondominiumModel;

import java.util.List;

public interface CondominiumRepository {
    List<CondominiumModel> findAll();
    CondominiumModel save(CondominiumModel model);
}
