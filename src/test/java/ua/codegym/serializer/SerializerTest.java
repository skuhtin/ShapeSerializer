package ua.codegym.serializer;

import org.junit.Test;
import org.junit.Assert;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class SerializerTest {

    @Test
    public void test() {
        Shape shape = new Square();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Serializer xml = SerializerFactory.newXmlSerializer();
        xml.serialize(shape, out);

        String output = new String(out.toByteArray());
        Assert.assertEquals("<square></square>", output);
    }
}