package Assignment.Flow.extension;

import Assignment.Flow.extension.dto.CustomExtensionDto;
import Assignment.Flow.extension.dto.FixedExtensionDto;
import Assignment.Flow.extension.entity.FixedExtension;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
@RequestMapping("/extensions")
@CrossOrigin(origins = "http://localhost:5505")
public class ExtensionController {

    private final ExtensionService extensionService;

    @GetMapping("/fixed/status")
    public ResponseEntity<List<FixedExtensionDto>> getExtensionStatus() {
        List<FixedExtensionDto> dtoList = extensionService.getAllExtensionsStatus();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/custom/status")
    public ResponseEntity<List<CustomExtensionDto>> getCustomStatus() {
        List<CustomExtensionDto> customList = extensionService.getAllCustomStatus();
        return ResponseEntity.ok(customList);
    }

    @PutMapping("/save")
    public ResponseEntity fixedExtension(@RequestBody FixedExtensionDto feDto) {
        extensionService.defaultSave(feDto);
        return ResponseEntity.ok(Collections.singletonMap("success", true));
    }

    @PostMapping("/add")
    public ResponseEntity addExtension(@RequestBody @Valid CustomExtensionDto ceDto) {
        extensionService.addExtension(ceDto);
        return ResponseEntity.ok(Collections.singletonMap("success", true));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteExtension(@RequestParam String extension){
        boolean isDeleted = extensionService.deleteExtension(extension);
        if(isDeleted) {
            return ResponseEntity.ok(Collections.singletonMap("success", true));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "Extension not found or could not be deleted"));
        }
    }

}
