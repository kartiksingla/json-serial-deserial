package org.json.serial.deserial.app.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.json.serial.deserial.app.model.IFourWheelerRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IVehicleDeserializer extends JsonDeserializer<IFourWheelerRequest> implements IDeserializer<IFourWheelerRequest> {

    private Map<String, Class<? extends IFourWheelerRequest>> requestTypeToClassMap;

    public IVehicleDeserializer() {
        super();
        List<String> packages = new ArrayList<>();
        packages.add("org");
        requestTypeToClassMap = getAllImplementations(IFourWheelerRequest.class, packages.get(0));
    }

    @Override
    public IFourWheelerRequest deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        IFourWheelerRequest req = deserializeAndGet(jp, ctxt);
        return req;
    }

    public Map<String, Class<? extends IFourWheelerRequest>> getRequestTypeToClassMap() {
        return requestTypeToClassMap;
    }

}
