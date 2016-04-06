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

public class GroupJsonSerialize implements Serializer{
  private Map<String, Serializer> object = new HashMap<>();

  public GroupJsonSerialize(){
    object.put(Circle.class.getCanonicalName(), new CircleJsonSerialize());
    object.put(Triangle.class.getCanonicalName(), new TriangleJsonSerialize());
    object.put(Group.class.getCanonicalName(), this);
  }
  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    Group group = (Group) shape;
    int num = group.getShapes().size();
    int count = 0;
    os.write("{\"group\": [".getBytes());
    for (Shape innerShape: group.getShapes()) {
      Serializer serializer = object.get(innerShape.getType());
      serializer.serialize(innerShape,os);
      count++;
      if (count < num) os.write(",".getBytes());
    }
    os.write("]}".getBytes());

  }
}
