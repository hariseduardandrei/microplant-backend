DROP TABLE IF EXISTS telemetry;
DROP SEQUENCE IF EXISTS telemetry_seq;

CREATE SEQUENCE telemetry_seq;


CREATE TABLE telemetry
(
    id            bigint PRIMARY KEY,
    temperature   numeric   NOT NULL,
    air_humidity  numeric   NOT NULL,
    soil_humidity numeric   NOT NULL,
    last_updated  timestamp not null default now()
);
