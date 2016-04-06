package ua.codegym.serializer;

import org.junit.Test;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JsonSerializerTest {
  @Test
  public void serializeTriangleToJsonTest() throws IOException{
    //given
    Shape shape = new Triangle(0, 3, 2, 4, 3, 1);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("{\"nameOfShape\": \"Triangle\",\"properties\": {\"xA\": 0,\"yA\": 3,\"xB\": 2,\"yB\": 4,\"xC\": 3,\"yC\": 1}}",output);
  }

  @Test
  public void serializeCircleToJsonTest() throws IOException{
    //given
    Shape shape = new Circle(2,3,8);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("{\"nameOfShape\": \"Circle\",\"properties\": {\"x\": 2,\"y\": 3,\"radius\": 8}}", output);
  }

  @Test
  public void serializeGroupToJsonTest() throws IOException{
    //given
    Group shape = new Group();
    shape.add(new Triangle(0, 3, 2, 4, 3, 1));
    shape.add(new Circle(2,3,8));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape,out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("{\"group\": [{\"nameOfShape\": \"Triangle\",\"properties\": {\"xA\": 0,\"yA\": 3,\"xB\": 2,\"yB\": 4,\"xC\": 3,\"yC\": 1}},{\"nameOfShape\": \"Circle\",\"properties\": {\"x\": 2,\"y\": 3,\"radius\": 8}}]}", output);
  }
}
