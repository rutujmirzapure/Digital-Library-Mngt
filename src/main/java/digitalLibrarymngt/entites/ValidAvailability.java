package digitalLibrarymngt.entites;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AvailabilityValidator.class)
@Documented
public @interface ValidAvailability {
    String message() default "Invalid availability status";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}