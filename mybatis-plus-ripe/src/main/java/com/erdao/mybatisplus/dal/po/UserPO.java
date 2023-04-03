package com.erdao.mybatisplus.dal.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体.
 *
 * @version : 1.0 2023/04/03
 * @since : 1.0
 **/
@Data
@TableName("user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String nameS;
    private Integer age;
    private String email;
}
