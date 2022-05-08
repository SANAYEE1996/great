package com.best.great.repository;

import com.best.great.entity.Test_Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Test_MemberRepository extends CrudRepository<Test_Member, Long> {
    List<Test_Member> findById(long id);

    List<Test_Member> findByFirstName(String firstName);

    List<Test_Member> findByLastName(String lastName);

    List<Test_Member> findByEmail(String email);

}
