package ro.esolutions.hacktonbackend;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MqttConfigurationModel {
    private Integer red1;
    private Integer green1;
    private Integer blue1;
    private Integer red2;
    private Integer green2;
    private Integer blue2;
    private Integer lightStart;
    private Integer lightEnd;
    private Integer containerVolume;
}
