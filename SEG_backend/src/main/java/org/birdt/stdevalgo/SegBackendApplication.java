package org.birdt.stdevalgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration; // 新增这行

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // 排除数据源配置
public class SegBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SegBackendApplication.class, args);
    }

}
