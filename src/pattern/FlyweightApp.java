package pattern;

import java.util.*;

public class FlyweightApp {
    public static void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape3> shapes = new ArrayList< >();

        shapes.add(shapeFactory.getShape("Square"));
        shapes.add(shapeFactory.getShape("Circle"));
        shapes.add(shapeFactory.getShape("Circle"));
        shapes.add(shapeFactory.getShape("Point"));
        shapes.add(shapeFactory.getShape("Square"));
        shapes.add(shapeFactory.getShape("Point"));

        Random rand = new Random();
        for (Shape3 shape3 : shapes) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape3.draw2(x,y);
        }
    }
}

// Flyweight
interface Shape3 {
    void draw2(int x, int y);
}

// Point Flyweight
class Point3 implements Shape3{
    public void draw2(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw point");
    }
}

// Circle Flyweight
class Circle3 implements Shape3{
    public void draw2(int x, int y) {
        int r = 5;
        System.out.println("(" + x + "," + y + "): draw Circle" + r);
    }
}

// Square Flyweight
class Square3 implements Shape3{
    public void draw2(int x, int y) {
        int a = 10;
        System.out.println("(" + x + "," + y + "): draw Square" + a);
    }
}

class ShapeFactory {
    private static final Map<String, Shape3> shapes = new HashMap<>();
    public Shape3 getShape(String shapeName) {

        Shape3 shape3 = shapes.get(shapeName);
        if (shape3==null){
            switch (shapeName) {
                case "Circle":
                    shape3 = new Circle3();
                case "Square":
                    shape3 = new Square3();
                case "Point":
                    shape3 = new Point3();
            }
            shapes.put(shapeName, shape3);
        }
        return shape3;
    }
}