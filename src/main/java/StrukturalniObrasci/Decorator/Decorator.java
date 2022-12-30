package StrukturalniObrasci.Decorator;

interface ChristmasTree {
    String decorate();
}

class ChristmasTreeImpl implements ChristmasTree {
    @Override
    public String decorate() {
        System.out.print("Christmas tree");
        return "Christmas tree";
    }
}
abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;

    public TreeDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public String decorate() {
        return tree.decorate();
    }
}

class BubbleLights extends TreeDecorator {

    public BubbleLights(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        System.out.print(" with Bubble Lights");
        return " with Bubble Lights";
    }
}

class Garland extends TreeDecorator {

    public Garland(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        System.out.print(" with Garland");
        return " with Garland";
    }
}

public class Decorator {

    public static void main(String[] args) {
        ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
        tree1.decorate();

        System.out.println("\n");

        ChristmasTree tree2 = new BubbleLights(
                new Garland(new Garland(new ChristmasTreeImpl())));
        tree2.decorate();

        System.out.println("\n");

    }
}
