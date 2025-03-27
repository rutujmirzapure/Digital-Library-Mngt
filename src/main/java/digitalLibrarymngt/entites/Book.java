package digitalLibrarymngt.entites;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
public class Book {

    @Id
    @NotBlank(message = "Book ID is required")
    private String id;

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Author is required")
    @Column(nullable = false)
    private String author;

    private String genre;

    @NotNull(message = "Availability status is required")
    @ValidAvailability
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AvailabilityStatus availability;

    public enum AvailabilityStatus {
        AVAILABLE, CHECKED_OUT
    }
}