package Assignment.Flow.extension.dto;

import Assignment.Flow.extension.entity.FixedExtension;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class FixedExtensionDto {

    private String extension;
    private boolean isChecked;

    public FixedExtension toEntity() {
        return FixedExtension.builder()
                .extension(this.extension)
                .isChecked(this.isChecked)
                .build();
    }

}
