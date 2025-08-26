package com.acme.apolice.core.ports.driven;

public interface EventPublisher {
    void publish(String topic, String key, String payload);
}