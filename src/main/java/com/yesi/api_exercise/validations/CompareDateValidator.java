package com.yesi.api_exercise.validations;

import java.lang.reflect.Field;
import java.time.LocalDate;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CompareDateValidator implements ConstraintValidator <ValidDates, Object> {
    private String beforeFieldName;
    private String afterFieldName;

  @Override
  public void initialize(final ValidDates constraintAnnotation) {
    beforeFieldName = constraintAnnotation.before();
    afterFieldName = constraintAnnotation.after();
  }

  @Override
  public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    try {
      final Field beforeDateField = value.getClass().getDeclaredField(beforeFieldName);
      beforeDateField.setAccessible(true);

      final Field afterDateField = value.getClass().getDeclaredField(afterFieldName);
      afterDateField.setAccessible(true);

      final LocalDate beforeDate = (LocalDate) beforeDateField.get(value);
      final LocalDate afterDate = (LocalDate) afterDateField.get(value);

      return beforeDate == null && afterDate == null || beforeDate != null && beforeDate.isBefore(afterDate);
    } catch (final Exception e) {
      e.printStackTrace();
      
      return false;
    }
  }
}
