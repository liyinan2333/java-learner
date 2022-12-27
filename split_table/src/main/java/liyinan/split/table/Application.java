package liyinan.split.table;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("liyinan.split.table.mapper")
public class Application {

    public static void main(String[] args) {

        new SpringApplication(Application.class).run(args);

    }

}
