package com.yesi.api_exercise.validations;

import jakarta.validation.Payload;
import jakarta.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CompareDateValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface ValidDates {
    String message() default "La fecha de entrada debe ser anterior a la fecha de salida."; //{com.yesi.api_exercise.validations.ValidDates};
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
    
    String before();
    String after();
}
