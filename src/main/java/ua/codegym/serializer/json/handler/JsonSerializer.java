package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.*;

import java.io.IOException;
import java.io.OutputStream;

public class JsonSerializer implements Serializer {

  public JsonSerializer(){
    String typeGroup = Group.class.getCanonicalName() + "JSON";
    String typeCircle = Circle.class.getCanonicalName() + "JSON";
    String typeTriangle = Triangle.class.getCanonicalName() + "JSON";

    ListOfShapes.addToShapesMap(typeGroup, new GroupJsonSerializer());
    ListOfShapes.addToShapesMap(typeCircle, new CircleJsonSerializer());
    ListOfShapes.addToShapesMap(typeTriangle, new TriangleJsonSerializer());
  }

  public void serialize(Shape shape, OutputStream os) throws IOException {

    Serializer serializer = ListOfShapes.getShapesMap().get(shape.getType() + "JSON");
    serializer.serialize(shape,os);
  }
}
