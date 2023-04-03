--

熟悉springboot + mybatis plus 入门到掌握

--

spring boot 官网上推荐 BellSoft Liberica JDK版本 17,据说是因为这是一个长期支持的版本

使用openJDK 17,下载地址 https://bell-sw.com/pages/downloads/#/java-17-lts

可以直接用idea下载

## 开始编写代码

1、依赖

```   
 <dependencies>
        <!--基础包-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

springboot版本使用最新的3.0.5，但是maven提示找不到，然后加上仓库地址就可以了

```
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.0.5</version>
        <relativePath/>
    </parent>
    <repositories>
        <!-- for spring milestone -->
        <repository>
            <id>spring.milestone</id>
            <url>https://repo.spring.io/milestone</url>
        </repository>
    </repositories>
    <pluginRepositories>
        <!-- for spring milestone -->
        <pluginRepository>
            <id>spring.milestone</id>
            <url>https://repo.spring.io/milestone</url>
        </pluginRepository>
    </pluginRepositories>
```

2、基础

我的数据库是本地，新建一个数据库 ripe

mysql-connect `8.0.32` 但是组织变了 com.mysql » mysql-connector-j

mybatis-plus   `3.5.3.1`

直接写测试类即可，报错 `Table 'ripe.user_p_o' doesn't exist`,默认映射问题(qa)

使用注解查询测试成功

3、进阶

使用mybatis自动生成代码,最新版本 `3.5.3.1`

```
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.5.3.1</version>
</dependency>
```

java.lang.NoClassDefFoundError: freemarker/template/Configuration 报错,加入依赖

```
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.32</version>
            <scope>compile</scope>
        </dependency>
```

可以生成，但是会全部生成，不好用，mybatis-plus本身代码很少，所以暂不使用
