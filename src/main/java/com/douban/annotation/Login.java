package com.douban.annotation;

import java.lang.annotation.*;

/**
 * Created by ruikai.lin  on 2018/1/31 下午6:15.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@Inherited
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
