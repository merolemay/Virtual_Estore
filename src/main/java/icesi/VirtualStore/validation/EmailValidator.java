package icesi.VirtualStore.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<CustomAnnotations.EmailValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        String emailValidationRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        return s.matches(emailValidationRegex);
    }
}
