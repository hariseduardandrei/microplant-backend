package ro.esolutions.hacktonbackend;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelemetryService {

    @NonNull
    private final TelemetryRepository telemetryRepository;

    public TelemetryModel getTelemetryModel() {
        final Optional<Telemetry> telemetryOptional = telemetryRepository.findTopByOrderByIdDesc();

        return telemetryOptional
                .map(TelemetryMapper::toTelemetryModel)
                .orElse(null);
    }
}
