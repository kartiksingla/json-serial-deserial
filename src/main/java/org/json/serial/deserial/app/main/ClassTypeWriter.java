package org.json.serial.deserial.app.main;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.fasterxml.jackson.databind.util.Annotations;

public class ClassTypeWriter extends VirtualBeanPropertyWriter {
    public ClassTypeWriter() {
    }

    public ClassTypeWriter(BeanPropertyDefinition propDef,
                           Annotations contextAnnotations,
                           JavaType declaredType) {
        super(propDef, contextAnnotations, declaredType);
    }

    @Override
    protected Object value(Object bean, JsonGenerator gen, SerializerProvider prov) {
        return bean.getClass().getSimpleName();
    }

    @Override
    public VirtualBeanPropertyWriter withConfig(MapperConfig<?> config,
                                                AnnotatedClass declaringClass,
                                                BeanPropertyDefinition propDef,
                                                JavaType type) {
        return new ClassTypeWriter(propDef, declaringClass.getAnnotations(), type);
    }
}