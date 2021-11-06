package ro.esolutions.hacktonbackend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Telemetry {

    @Id
    @GeneratedValue(generator = "telemetry_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "telemetry_seq_gen", sequenceName = "telemetry_seq", allocationSize = 1)
    private Long id;
    private BigDecimal temperature;
    private BigDecimal airHumidity;
    private BigDecimal soilHumidity;
    private BigDecimal containerVolume;

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime lastUpdated;

    @PrePersist
    public void prePersist() {
        this.lastUpdated = LocalDateTime.now();
    }
}
