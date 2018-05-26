package com.cxgt.commmon.util;

import com.cxgt.commmon.constants.ResultCodeEnum;
import com.cxgt.commmon.vo.Result;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/26
 */
public class ResultUtil {

    public static Result ok() {
        return ok(null);
    }

    public static Result ok(Object o) {
        return new Result(ResultCodeEnum.SUCCESS.value(), ResultCodeEnum.SUCCESS.getMessage(), o);
    }

    public static Result fail(ResultCodeEnum resultCodeEnum) {
        return fail(resultCodeEnum, null);
    }

    public static Result fail(ResultCodeEnum resultCodeEnum, Object o) {
        return new Result(resultCodeEnum.value(), resultCodeEnum.getMessage(), o);
    }


}
