package ua.codegym.serializer.json.handler;


import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.ListOfShapes;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.xml.handler.CircleXmlSerializer;

import java.io.IOException;
import java.io.OutputStream;

public class CircleJsonSerializer implements Serializer {

  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {

    Circle circle = (Circle) shape;
    int x = circle.getX();
    int y = circle.getY();
    int radius = circle.getRadius();
    String out = String.format("{\"nameOfShape\": \"Circle\",\"properties\": {\"x\": %d,\"y\": %d,\"radius\": %d}}", x, y, radius);
    os.write(out.getBytes());
  }
}
