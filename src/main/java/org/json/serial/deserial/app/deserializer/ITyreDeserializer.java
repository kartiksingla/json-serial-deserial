package org.json.serial.deserial.app.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.json.serial.deserial.app.model.ITyre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ITyreDeserializer extends JsonDeserializer<ITyre> implements IDeserializer<ITyre> {

    private Map<String, Class<? extends ITyre>> requestTypeToClassMap;

    public ITyreDeserializer() {
        List<String> packages = new ArrayList<>();
        packages.add("org");
        requestTypeToClassMap = getAllImplementations(ITyre.class, packages.get(0));
    }

    @Override
    public ITyre deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        return deserializeAndGet(jp,ctxt);
    }

    public Map<String, Class<? extends ITyre>> getRequestTypeToClassMap() {
        return requestTypeToClassMap;
    }

}
