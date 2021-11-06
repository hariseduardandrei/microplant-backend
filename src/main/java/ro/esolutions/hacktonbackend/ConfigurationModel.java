package ro.esolutions.hacktonbackend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class ConfigurationModel {

    private String team;
    private Integer lightStartHour;
    private Integer lightStartMinute;
    private Integer lightEndHour;
    private Integer lightEndMinute;
    private Integer containerVolume;
    private Integer minSoilHum;
}
