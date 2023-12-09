package Assignment.Flow.extension.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@Table(name="fixed_extension")
@jakarta.persistence.Entity
public class FixedExtension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String extension;

    private boolean isChecked;

    @Builder
    public FixedExtension(String extension, boolean isChecked){
        this.extension = extension;
        this.isChecked = isChecked;
    }

}
