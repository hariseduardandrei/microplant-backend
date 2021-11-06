package ro.esolutions.hacktonbackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfigurationService {

    @NonNull
    private final MqttPushClient mqttPushClient;

    public void saveConfig(final ConfigurationModel configurationModel) {
        final MqttConfigurationModel mqttConfigurationModel = createMqttConfigurationModel(configurationModel);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String json = ow.writeValueAsString(mqttConfigurationModel);
            mqttPushClient.publish(0, false, "7C:9E:BD:47:2C:14-config", json);
        } catch (JsonProcessingException e) {
            log.info("[saveConfig] - Save config", e);
        }
    }

    private MqttConfigurationModel createMqttConfigurationModel(final ConfigurationModel configurationModel) {
        final Team team = getTeamByName(configurationModel.getTeam());
        return MqttConfigurationModel.builder()
                .red1(team.getRed1())
                .green1(team.getGreen1())
                .blue1(team.getBlue1())
                .red2(team.getRed2())
                .green2(team.getGreen2())
                .blue2(team.getBlue2())
                .lightStart(configurationModel.getLightStartHour() * 60 + configurationModel.getLightStartMinute())
                .lightEnd(configurationModel.getLightEndHour() * 60 + configurationModel.getLightEndHour())
                .containerVolume(configurationModel.getContainerVolume())
                .minSoilHum(configurationModel.getMinSoilHum())
                .build();
    }

    private Team getTeamByName(final String name) {
        return Arrays.stream(Team.values())
                .filter(team -> team.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
