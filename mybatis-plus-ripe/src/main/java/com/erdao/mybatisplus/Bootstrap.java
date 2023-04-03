package com.erdao.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类.
 *
 * @version : 1.0 2023/04/03
 * @since : 1.0
 **/
@SpringBootApplication
//@MapperScan("com.erdao.mybatisplus.dal.mapper")
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }
}
