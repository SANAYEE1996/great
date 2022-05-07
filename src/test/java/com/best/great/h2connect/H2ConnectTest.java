package com.best.great.h2connect;

import com.best.great.entity.TestTable;
import com.best.great.repository.TestRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class H2ConnectTest {

    private final TestRepository tr;

    @Autowired
    public H2ConnectTest(TestRepository tr){
        this.tr = tr;
    }

    @Test
    void join(){

        TestTable t = new TestTable();
        t.setId(1000);
        t.setName("이호식");
        tr.save(t);

        TestTable find = tr.findById(t.getId()).get();
        Assertions.assertThat(t.getName()).isEqualTo(find.getName());


    }


}
