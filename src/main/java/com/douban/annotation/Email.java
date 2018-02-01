package com.douban.annotation;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ruikai.lin  on 2018/1/31 下午6:41.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 * 使用该注解时，类上面必须加上@Validated注解才能生效
 */
@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
@Pattern(regexp = "")
@NotBlank
public @interface Email {
    String message() default "邮箱格式错误";

    /**
     * @return an additional regular expression the annotated string must match. The default is any string ('.*')
     */
    @OverridesAttribute(constraint = Pattern.class, name = "regexp")
    String regexp() default "^[A-Za-z0-9\\u4e00-\\u9fa5/.]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * @return the groups the constraint belongs to
     */
    Class<?>[] groups() default { };

    /**
     * @return the payload associated to the constraint
     */
    Class<? extends Payload>[] payload() default { };
}
