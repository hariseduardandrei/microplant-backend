package ro.esolutions.hacktonbackend;

public final class TelemetryMapper {

    private TelemetryMapper() {

    }

    public static Telemetry toTelemetry(final TelemetryModel telemetryModel) {
        return Telemetry.builder()
                .temperature(telemetryModel.getTemperature())
                .airHumidity(telemetryModel.getAirHumidity())
                .soilHumidity(telemetryModel.getSoilHumidity())
                .containerVolume(telemetryModel.getContainerVolume())
                .build();
    }

    public static TelemetryModel toTelemetryModel(final Telemetry telemetry) {
        return TelemetryModel.builder()
                .temperature(telemetry.getTemperature())
                .airHumidity(telemetry.getAirHumidity())
                .soilHumidity(telemetry.getSoilHumidity())
                .build();
    }
}
