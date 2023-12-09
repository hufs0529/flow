package Assignment.Flow.extension.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@Table(name="custom_extension")
@jakarta.persistence.Entity
public class CustomExtension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String extension;

    @Builder
    public CustomExtension(String extension, Long userId){
        this.extension = extension;
        this.userId = userId;
    }
}
