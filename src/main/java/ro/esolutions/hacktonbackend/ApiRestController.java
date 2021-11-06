package ro.esolutions.hacktonbackend;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiRestController {

    @NonNull
    private final TelemetryService telemetryService;
    @NonNull
    private final ConfigurationService configurationService;

    @GetMapping("/telemetry")
    public ResponseEntity<TelemetryModel> getTelemetryModel() {
        return ResponseEntity.ok(telemetryService.getTelemetryModel());
    }

    @PostMapping("/save_config")
    public ResponseEntity<Object> saveConfig(@RequestBody final ConfigurationModel configurationModel) {
        configurationService.saveConfig(configurationModel);
        return ResponseEntity.ok("{}");
    }
}
