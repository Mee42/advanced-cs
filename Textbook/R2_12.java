import java.awt.*;

public class R2_12 {
}

class Goat {
    private boolean tail = false;

    public void milk(){
        System.out.println("milk");
    }
    public void jump(){
        System.out.println("jump");
    }

    public boolean hasTail() {
        return tail;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }

    public Goat(boolean tail) {
        this.tail = tail;
    }
}
class Pig {
    private boolean nose;

    public boolean isNose() {
        return nose;
    }

    public void setNose(boolean nose) {
        this.nose = nose;
    }

    public Pig(boolean nose) {
        this.nose = nose;
    }

    public void eat(int food){
        System.out.println("ate " + food + " food");
    }
    public void wallow(){
        System.out.println("wallow");
    }

}

class Horse {
    private int height;
    private Color color;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Horse(int height, Color color) {
        this.height = height;
        this.color = color;
    }

    public void run(){
        System.out.println("run");
    }
    public void jump(){
        System.out.println("jump");
    }
}

class Racer extends Horse {
    public Racer(int height, Color color) {
        super(height, color);
    }
}
class Equestrian extends Horse {
    private int weight;
    private boolean isTrained;

    public Equestrian(int height, Color color, int weight, boolean isTrained) {
        super(height, color);
        this.weight = weight;
        this.isTrained = isTrained;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }
}