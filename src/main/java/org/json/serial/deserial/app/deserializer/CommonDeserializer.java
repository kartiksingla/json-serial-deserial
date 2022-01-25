package org.json.serial.deserial.app.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Map;

public class CommonDeserializer<T> extends JsonDeserializer<T> implements IDeserializer<T> {

    private Map<String, Class<? extends T>> requestTypeToClassMap;

    public CommonDeserializer(Class<T> clz, String... packages) {
        requestTypeToClassMap = getAllImplementations(clz, packages);
    }

    @Override
    public T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return deserializeAndGet(jp, ctxt);
    }

    @Override
    public Map<String, Class<? extends T>> getRequestTypeToClassMap() {
        return requestTypeToClassMap;
    }

    public static <T> CommonDeserializer<T> build(Class<T> clz, String... packages) {
        return new CommonDeserializer<T>(clz, packages);
    }
}
