package com.best.great.repository;


import com.best.great.entity.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SpringDataTestRepository extends JpaRepository<TestTable, Long>, TestRepository {

    @Override
    Optional<TestTable> findByName(String name);

}
