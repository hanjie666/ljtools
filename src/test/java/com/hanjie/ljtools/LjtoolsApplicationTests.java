package com.hanjie.ljtools;


import com.hanjie.ljtools.dao.IJumpDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class LjtoolsApplicationTests {
    @Autowired
    IJumpDao dao;
    @Test
    void contextLoads() {
        System.out.println(dao.deleteAddr("364101"));
    }

}
