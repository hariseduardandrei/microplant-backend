package ro.esolutions.hacktonbackend;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiRestController {


    @NonNull
    private final TelemetryService telemetryService;

    @GetMapping("/telemetry")
    public ResponseEntity<TelemetryModel> getTelemetryModel() {
        return ResponseEntity.ok(telemetryService.getTelemetryModel());
    }
}
