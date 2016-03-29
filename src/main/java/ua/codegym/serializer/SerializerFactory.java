package ua.codegym.serializer;

import ua.codegym.serializer.xml.handler.XmlSerializer;

public final class SerializerFactory {

    private SerializerFactory() {}

    public static Serializer newXmlSerializer() {
        return new XmlSerializer();
    }
}
