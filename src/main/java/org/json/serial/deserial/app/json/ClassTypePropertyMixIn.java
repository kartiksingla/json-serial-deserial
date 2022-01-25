package org.json.serial.deserial.app.json;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.json.serial.deserial.app.main.ClassTypeWriter;

@JsonAppend(props = {
        @JsonAppend.Prop(value = ClassTypeWriter.class, name = "classType", type = String.class)
})
public class ClassTypePropertyMixIn {
}