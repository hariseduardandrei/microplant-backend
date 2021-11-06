package ro.esolutions.hacktonbackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LightsService {

    @NonNull
    private final MqttPushClient mqttPushClient;

    public void start(LightsModel lightsModel) {
        final MqttLightsModel mqttLightsModel = createMqttLightsModel(lightsModel);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String json = ow.writeValueAsString(mqttLightsModel);
            mqttPushClient.publish(0, false, "7C:9E:BD:47:2C:14-lights", json);
        } catch (JsonProcessingException e) {
            log.info("[saveConfig] - Save config", e);
        }
    }

    private MqttLightsModel createMqttLightsModel(final LightsModel lightsModel) {
        return MqttLightsModel.builder()
                .duration(lightsModel.getDuration())
                .build();
    }
}
