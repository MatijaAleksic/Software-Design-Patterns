package StrukturalniObrasci.Proxy;

import java.util.ArrayList;
import java.util.List;

interface IImage {
    int getWidth();
    int getHeight();
    String getFileName();
    void draw();
}

class ImageImpl implements IImage {

    private int width;
    private int height;
    private String fileName;

    public ImageImpl(String fileName) {
        super();
        System.out.println("Kreiram ImageImpl i učitavam sliku " + fileName + " !");
        this.width = 50;
        this.height = 100;
        this.fileName = fileName;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void draw() {
        System.out.println("Prikazujem sliku!");
    }

    @Override
    public String getFileName() {
        return fileName;
    }

}

class LazyImage implements IImage {

    private int width;
    private int height;
    private String fileName;
    private IImage realImage;

    public LazyImage(int width, int height, String fileName) {
        super();
        this.fileName = fileName;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return realImage!=null ?
                realImage.getWidth():this.width;
    }

    @Override
    public int getHeight() {
        return realImage!=null ?
                realImage.getHeight():this.height;
    }

    @Override
    public void draw() {
        if(realImage==null){
            realImage = new ImageImpl(fileName);
        }
        realImage.draw();
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

}

class Client {
    List<IImage> images;

    public Client(List<IImage> images) {
        this.images = images;
    }

    public void doJob(){
        for(IImage image: images){
            System.out.println('\n');
            System.out.println("Dimenzije slike " + image.getFileName());
            System.out.println(image.getWidth() + "x" + image.getHeight());
            System.out.println("Iscrtavam sliku "+ image.getFileName());
            image.draw();
            System.out.println("Dimenzije slike " + image.getFileName());
            System.out.println(image.getWidth() + "x" + image.getHeight());
        }
    }

}


public class Proxy {

    public static void main(String[] args) {
        @SuppressWarnings("serial")
        Client c = new Client(new ArrayList<IImage>(){{
            add(new LazyImage(50, 50, "slika1.jpg"));
            add(new LazyImage(50, 50, "slika2.jpg"));
        }}
        );
        c.doJob();
    }
}
