package Assignment.Flow.extension;

import Assignment.Flow.extension.dto.CustomExtensionDto;
import Assignment.Flow.extension.dto.FixedExtensionDto;
import Assignment.Flow.extension.entity.CustomExtension;
import Assignment.Flow.extension.entity.FixedExtension;
import Assignment.Flow.extension.repository.CustomRepository;
import Assignment.Flow.extension.repository.FixedRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class ExtensionService {

    private final FixedRepository fixedRepository;

    private final CustomRepository customRepository;

    public List<FixedExtensionDto> getAllExtensionsStatus() {
        List<FixedExtension> fixedExtensions = fixedRepository.findAll();

        return fixedExtensions.stream()
                .map(ext -> new FixedExtensionDto(ext.getExtension(), ext.isChecked()))
                .collect(Collectors.toList());

    }

    public List<CustomExtensionDto> getAllCustomStatus() {
        List<CustomExtension> customExtensions = customRepository.findAll();
        System.out.println(customExtensions);
        return customExtensions.stream()
                .map(ext -> new CustomExtensionDto(ext.getExtension(), ext.getUserId()))
                .collect(Collectors.toList());
    }

    public FixedExtension defaultSave(FixedExtensionDto feDto) {
        FixedExtension existingExtension = fixedRepository.findByExtension(feDto.getExtension());

        if (existingExtension != null) {
            existingExtension.setChecked(feDto.isChecked());
            fixedRepository.save(existingExtension);
            return existingExtension;
        } else {
            FixedExtension newExtension = feDto.toEntity();
            fixedRepository.save(newExtension);
            return newExtension;
        }
    }

    public CustomExtension addExtension(CustomExtensionDto ctDto){
        Optional<CustomExtension> existingExtension = customRepository.findByExtension(ctDto.getExtension());
        if (existingExtension.isPresent()) {

            throw new IllegalStateException("이미 존재하는 Extension");
        }

        if(customRepository.count() >= 200) {
            throw new IllegalStateException("최대 등록 Extension 초과");
        }

        CustomExtension extension = ctDto.toEntity();
        customRepository.save(extension);
        return extension;
    }

    public boolean deleteExtension(String extension) {
        int deletedCount = customRepository.deleteByExtension(extension);
        return deletedCount > 0;
    }


}
