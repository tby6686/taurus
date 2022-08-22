package cn.com.taurus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"cn.com.taurus.**.mapper"})
@SpringBootApplication
public class TaurusApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaurusApplication.class, args);
    }
}
