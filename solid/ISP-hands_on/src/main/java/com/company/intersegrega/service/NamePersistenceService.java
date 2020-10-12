package com.company.intersegrega.service;

import com.company.intersegrega.entity.Entity;

import java.util.List;

public interface NamePersistenceService<T extends Entity> {

    public List<T> findByName(String name);
}
