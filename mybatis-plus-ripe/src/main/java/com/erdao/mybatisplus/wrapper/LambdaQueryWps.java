package com.erdao.mybatisplus.wrapper;

import com.baomidou.mybatisplus.core.conditions.SharedString;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.support.LambdaMeta;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.Arrays;

/**
 * 代理包装类.
 *
 * @version : 1.0 2023/04/03
 * @since : 1.0
 **/
public class LambdaQueryWps<T> extends LambdaQueryWrapper<T> {

    private final SharedString wrapperSqlSelect = new SharedString();


    @SafeVarargs
    public final String getColumns(SFunction<T, ?>... columns) {
        return columnsToString(true, columns);
    }

    @SafeVarargs
    public final LambdaQueryWps<T> wrapperSelect(SFunction<T, ?>... columns) {
        if (CollectionUtils.isNotEmpty(Arrays.asList(columns))) {
            for (SFunction<T, ?> column : columns) {
                LambdaMeta meta = LambdaUtils.extract(column);
                System.out.println(meta);
                System.out.println(meta.getImplMethodName());
                System.out.println(columnToString(column, false));
                System.out.println(meta.getInstantiatedClass());
            }
            this.wrapperSqlSelect.setStringValue(columnsToString(false, columns));
        }
        return this;
//        return columnsToString(true, columns);
    }

    @Override
    public String getSqlSelect() {
        String sqlSelect = super.getSqlSelect();
        return sqlSelect.concat(StringPool.COMMA).concat(this.wrapperSqlSelect.getStringValue());
    }


}
