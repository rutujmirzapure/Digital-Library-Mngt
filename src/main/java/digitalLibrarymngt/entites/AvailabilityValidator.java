package digitalLibrarymngt.entites;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AvailabilityValidator implements
        ConstraintValidator<ValidAvailability, Book.AvailabilityStatus> {

    @Override
    public boolean isValid(Book.AvailabilityStatus value,
                           ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value == Book.AvailabilityStatus.AVAILABLE ||
                value == Book.AvailabilityStatus.CHECKED_OUT;
    }
}