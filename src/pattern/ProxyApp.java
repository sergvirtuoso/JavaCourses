package pattern;

public class ProxyApp {
    public static void main(String[] args){
        Image2 image2 = new ProxyImage("D:/my.png");
        image2.display();
    }
}

interface Image2{
    void display();
}

class RealImage implements Image2 {

    String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }

    void load() {
        System.out.println("Loading" + file);
    }

    public void display() {
        System.out.println("Show" + file);
    }
}

class ProxyImage implements Image2 {
    RealImage image;
    String file;
    public ProxyImage(String file) {
        this.file = file;
    }
    public void display() {
        if(image == null) {
            image = new RealImage(file);
        }
        image.display();
    }
}