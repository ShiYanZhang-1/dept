package top.shiyana.dept;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("top.shiyana.dept.mapper")
@SpringBootApplication
public class DeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication.class, args);
    }

}
