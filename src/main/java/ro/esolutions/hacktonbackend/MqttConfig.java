package ro.esolutions.hacktonbackend;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("mqtt")
@Setter
@Getter
public class MqttConfig {
    @Autowired
    private MqttPushClient mqttPushClient;

    /**
     * Connection address
     */
    private String hostUrl;
    /**
     * Customer Id
     */
    private String clientID;
    /**
     * Default connection topic
     */
    private String defaultTopic;
    /**
     * Timeout time
     */
    private int timeout;
    /**
     * Keep connected
     */
    private int keepalive;

    @Bean
    public MqttPushClient getMqttPushClient() {
        System.out.println("hostUrl: " + hostUrl);
        System.out.println("clientID: " + clientID);
        System.out.println("timeout: " + timeout);
        System.out.println("keepalive: " + keepalive);
        mqttPushClient.connect(hostUrl, clientID, timeout, keepalive);
        // End with / / to subscribe to all topics starting with test
        mqttPushClient.subscribe(defaultTopic, 0);
        return mqttPushClient;
    }
}