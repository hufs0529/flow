package Assignment.Flow.extension.dto;

import Assignment.Flow.extension.entity.CustomExtension;
import Assignment.Flow.extension.entity.FixedExtension;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
public class CustomExtensionDto {

    @Size(max=20)
    private String extension;

    private Long userId;

    public CustomExtension toEntity() {
        return CustomExtension.builder()
                .extension(this.extension)
                .userId(this.userId)
                .build();
    }
}
