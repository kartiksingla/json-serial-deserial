package org.json.serial.deserial.app.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ValueNode;
import org.json.serial.deserial.app.utils.ThrowableFunction;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.json.serial.deserial.app.utils.ThrowableFunction.uncheckedThrow;

public interface IDeserializer<T> {

    Map<String, Class<? extends T>> getRequestTypeToClassMap();

    default Map<String, Class<? extends T>> getAllImplementations(Class<T> interfaze, String... packages) {
        Map<String, Class<? extends T>> requestTypeToClassMap = new HashMap<>();
        Arrays.asList(packages).forEach(pkg -> {
            Reflections reflections = new Reflections(pkg);
            reflections.getSubTypesOf(interfaze).stream()
                    .filter(cls -> !cls.isInterface() && !Modifier.isAbstract(cls.getModifiers()))
                    .forEach(clz -> {
                        requestTypeToClassMap.put(clz.getSimpleName(), clz);
                    });
        });
        return requestTypeToClassMap;
    }

    default T deserializeAndGet(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        TreeNode jsonNode = jp.readValueAsTree();
        T req = null;
        TreeNode node = null;
        TreeNode type = jsonNode.get("classType");
        node = type;
        if (node == null) {
            System.out.println();
        } else {
            String reqType = ((ValueNode) node).textValue();
            ThrowableFunction<Class<? extends T>, T, JsonProcessingException> tFunc = (clazz) -> mapper.treeToValue(jsonNode, clazz);
            req = Optional.of(getRequestTypeToClassMap().get(reqType)).map(uncheckedThrow(tFunc)).orElse(null);
        }
        return req;
    }
}
