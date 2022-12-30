package StrukturalniObrasci.Composite;

import java.util.ArrayList;
import java.util.List;

interface IShape {
    void draw();
}

class Circle implements IShape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle!");
    }
}

class Line implements IShape {
    @Override
    public void draw() {
        System.out.println("Drawing Line!");
    }
}

class Rectangle implements IShape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle!");
    }
}

class CompositeShape implements IShape {
    private List<IShape> shapes = new ArrayList<IShape>();

    @Override
    public void draw() {
        System.out.println("Drawing Composite - Start!");
        for(IShape shape: shapes){
            shape.draw();
        }
        System.out.println("Drawing Composite - End!");
    }

    public CompositeShape add(IShape shape){
        shapes.add(shape);
        return this;
    }

    public void remove(int index){
        shapes.remove(index);
    }

    public int getChildrenCount(){
        return shapes.size();
    }

    public IShape getChild(int index){
        return shapes.get(index);
    }
}

class Canvas {

    private List<IShape> shapes = new ArrayList<IShape>();

    public Canvas(List<IShape> shapes) {
        super();
        this.shapes = shapes;
    }

    public void repaint(){
        for(IShape shape:shapes){
            shape.draw();
        }
    }
}

public class Composite {

    public static void main(String[] args) {

        List<IShape> shapes = new ArrayList<IShape>();

        shapes.add(new Circle());

        // Kreiranje kompozita korišćenjem Fluent Interface obrasca
        shapes.add(new CompositeShape()
                .add(new Line())
                .add(new Circle())
                .add(new Rectangle()));

        shapes.add(new Line());
        shapes.add(new Rectangle());

        Canvas canvas = new Canvas(shapes);
        canvas.repaint();

    }
}
