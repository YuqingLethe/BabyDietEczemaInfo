package com.babylog.babydieteczemainfo;

import com.babylog.babydieteczemainfo.service.InputConsoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BabyDietEczemaInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabyDietEczemaInfoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(InputConsoleService inputConsoleService) {
        return args -> {
            // 调用独立的输入服务
            inputConsoleService.startConsoleInput();
        };
    }

}
