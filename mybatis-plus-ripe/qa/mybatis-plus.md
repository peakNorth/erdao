Q: mybatis 表名、字段名，解决名称不一致问题?

1、统一加前缀

```
# MyBatis-Plus全局配置
mybatis-plus:
    db-config:
      table-prefix: t_  # 设置实体类所对应表的统一前缀
```

2、注解
`@TableName(“t_user”) `