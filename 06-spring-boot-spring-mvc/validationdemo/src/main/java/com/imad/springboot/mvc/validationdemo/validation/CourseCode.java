package com.imad.springboot.mvc.validationdemo.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "OII";

    // define default error message
    public String message() default "must start with OII";

    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads
    // payload can basically give you additional details about the error message that has occurred
    public Class<? extends Payload>[] payload() default {};

}
