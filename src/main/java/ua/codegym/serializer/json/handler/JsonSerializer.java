package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;

import java.io.IOException;
import java.io.OutputStream;

public class JsonSerializer implements Serializer {

  public JsonSerializer(){}

  public void serialize(Shape shape, OutputStream os) throws IOException {
    Serializer serializer = new TriangleJsonSerialize();
    serializer.serialize(shape,os);
  }
}
