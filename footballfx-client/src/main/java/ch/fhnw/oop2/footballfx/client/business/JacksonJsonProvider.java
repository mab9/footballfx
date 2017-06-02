package ch.fhnw.oop2.footballfx.client.business;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JacksonJsonProvider extends JacksonJaxbJsonProvider {
    private static final ObjectMapper mapper = createMapper();

    public JacksonJsonProvider() {
        setMapper(mapper);
    }

    private static ObjectMapper createMapper() {
        final ObjectMapper result = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(StringProperty.class, new StringPropertyDeserializer());
        module.addSerializer(StringProperty.class, new StringPropertySerializer());
        result.registerModule(module);
        return result;
    }

    private static class StringPropertyDeserializer extends JsonDeserializer<StringProperty> {

        @Override
        public StringProperty deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                throws IOException {
            SimpleStringProperty newProperty = new SimpleStringProperty();
            newProperty.setValue(deserializationContext.readValue(jsonParser, String.class));
            return newProperty;
        }
    }

    private static class StringPropertySerializer extends JsonSerializer<StringProperty> {

        @Override
        public void serialize(StringProperty stringProperty, JsonGenerator jsonGenerator,
                SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(stringProperty.getValue());
        }
    }
}