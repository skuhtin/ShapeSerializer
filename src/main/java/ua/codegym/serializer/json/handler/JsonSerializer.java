package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer implements Serializer {
  public Map<String, Serializer> object = new HashMap<>();

  public JsonSerializer(){
    object.put(Triangle.class.getCanonicalName(), new TriangleJsonSerialize());
    object.put(Circle.class.getCanonicalName(), new CircleJsonSerialize());
    object.put(Group.class.getCanonicalName(), new GroupJsonSerialize());
  }

  public void serialize(Shape shape, OutputStream os) throws IOException {
    Serializer serializer = object.get(shape.getType());
    serializer.serialize(shape,os);
  }
}
