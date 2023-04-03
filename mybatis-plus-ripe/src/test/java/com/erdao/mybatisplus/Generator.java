package com.erdao.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * 代码生成.
 *
 * @version : 1.0 2023/04/03
 * @since : 1.0
 **/
public class Generator {
    @Test
    public void generator() {
        String url = "jdbc:mysql://localhost:3306/ripe?useSSL=false&autoReconnect=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        String baseDir = "D:\\temp\\github\\erdao\\mybatis-plus-ripe\\src\\main\\java";

        FastAutoGenerator.create(url, username, password)
                //全局配置
                .globalConfig(builder -> {
                    builder.author("erdao") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(baseDir); // 指定输出目录
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("com.erdao.mybatisplus.dal.mapper") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml
                                    , baseDir + "/com/erdao/mybatisplus/dal/mapper")); // 设置mapperXml生成路径
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("user2") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
