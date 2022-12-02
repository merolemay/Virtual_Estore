package icesi.VirtualStore.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

public interface CustomAnnotations {

    @Documented
    @Constraint(validatedBy = UsernameValidator.class)
    @Target({ ElementType.METHOD, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @interface ValidUsername {


        String message() default "Username is not valid";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }
    @Documented
    @Constraint(validatedBy = EmailValidator.class)
    @Target({ ElementType.METHOD, ElementType.FIELD,ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ValidEmail {


        String message() default "Email is invalid";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }


    @Documented
    @Constraint(validatedBy = UsernameValidator.class)
    @Target({ ElementType.METHOD, ElementType.FIELD,ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ValidPhoneNumber {


        String message() default "PhoneNumber is not valid";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }

}




