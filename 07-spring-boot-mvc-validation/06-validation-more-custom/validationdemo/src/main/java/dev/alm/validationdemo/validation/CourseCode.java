package dev.alm.validationdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CourseCodeConstraintValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    String value() default "ALM";

    // def default error message
    String message() default "Invalid Course Code: must start with ALM";

    // define default groups
    Class<?>[] groups() default {};

    // define default payloads
    Class<? extends Payload>[] payload() default {};

}
