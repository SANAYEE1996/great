package com.best.great.repository;

import com.best.great.entity.TestTable;

import java.util.List;
import java.util.Optional;

public interface TestRepository{

    TestTable save(TestTable test);
    Optional<TestTable> findById(Long id);
    List<TestTable> findAll();



}
