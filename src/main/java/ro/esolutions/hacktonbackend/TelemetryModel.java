package ro.esolutions.hacktonbackend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class TelemetryModel {

    private BigDecimal temperature;
    private BigDecimal airHumidity;
    private BigDecimal soilHumidity;
}
