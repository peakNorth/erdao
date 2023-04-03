package com.erdao.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erdao.mybatisplus.dal.mapper.UserMapper;
import com.erdao.mybatisplus.dal.po.UserPO;
import org.springframework.stereotype.Service;

/**
 * 用户服务.
 *
 * @version : 1.0 2023/04/03
 * @since : 1.0
 **/
@Service
public class UserService extends ServiceImpl<UserMapper, UserPO> {
}
