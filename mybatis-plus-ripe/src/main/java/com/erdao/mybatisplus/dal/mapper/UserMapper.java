package com.erdao.mybatisplus.dal.mapper;

import com.erdao.mybatisplus.dal.AgentMapper;
import com.erdao.mybatisplus.dal.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户操作类.
 *
 * @version : 1.0 2023/04/03
 * @since : 1.0
 **/
@Mapper
public interface UserMapper extends AgentMapper<UserPO> {
}
