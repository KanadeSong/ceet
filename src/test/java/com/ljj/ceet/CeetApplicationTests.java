package com.ljj.ceet;

import com.ljj.ceet.service.HrmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CeetApplicationTests {

    @Autowired
    HrmService hrmService;

    @Test
    public void contextLoads() {

    }

}
