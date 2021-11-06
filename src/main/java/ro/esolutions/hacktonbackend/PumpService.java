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
public class PumpService {

    @NonNull
    private final MqttPushClient mqttPushClient;

    public void runDemo() {
        mqttPushClient.publish(0, false, "7C:9E:BD:47:2C:14-pump","run-pump-demo");
    }
}
