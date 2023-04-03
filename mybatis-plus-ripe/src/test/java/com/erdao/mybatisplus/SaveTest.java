package com.erdao.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erdao.mybatisplus.dal.mapper.UserMapper;
import com.erdao.mybatisplus.dal.po.UserPO;
import com.erdao.mybatisplus.service.UserService;
import com.erdao.mybatisplus.wrapper.LambdaQueryWps;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 新增测试.
 *
 * @version : 1.0 2023/04/03
 * @since : 1.0
 **/
@SpringBootTest
public class SaveTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    //新增
    @Test
    public void save() {
        UserPO user = new UserPO();
        userMapper.insert(user);
        userMapper.deleteById(1L);
        userMapper.updateById(UserPO.builder().id(1L).nameS("zs-update").build());

        //两种查询
        LambdaQueryWrapper<UserPO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWps<UserPO> wps = new LambdaQueryWps<>();

        userMapper.selectList(lambdaQueryWrapper.in(UserPO::getAge, 1, 23, 4, 5));
        userMapper.selectList(lambdaQueryWrapper.inSql(UserPO::getAge, "1,2,34,5,6"));

        QueryWrapper<UserPO> wrapper = new QueryWrapper<UserPO>().groupBy("age", "xx");
        userMapper.selectList(wrapper);
        userMapper.selectList(lambdaQueryWrapper.select());

        List<UserPO> pos = userMapper.selectList(wps.select(UserPO::getAge, UserPO::getAge, UserPO::getAge));
        userMapper.selectList(
                wps.wrapperSelect(p -> "", UserPO::getAge)
                        .select(UserPO::getNameS, UserPO::getAge)

        );
        userMapper.selectList(lambdaQueryWrapper.having("username like {0}", 1, 23, 2));
        userMapper.selectList(lambdaQueryWrapper.func(p -> {
            if (true) {
                p.eq(UserPO::getAge, 1);
            } else {
                p.eq(UserPO::getAge, 2);
            }
        }));
    }

    @Test
    public void select() {
        LambdaQueryWps<UserPO> wps = new LambdaQueryWps<>();

        userMapper.selectList(
                wps.wrapperSelect(UserPO::getNameS, UserPO::getAge)
                        .select(UserPO::getNameS, UserPO::getAge)

        );
    }
}
