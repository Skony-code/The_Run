package Model;

import java.awt.*;

public class Entity {
    private double x;
    private double y;
    private double a;
    private double b;
    private Image sprite;
    public Entity(double x, double y, double a, double b, Image sprite)
    {
        this.sprite=sprite;
        this.x=x;
        this.y=y;
        this.a=a;
        this.b=b;
    }
    public double getx()
    {
        return x;
    }
    public double gety()
    {
        return y;
    }
    public double geta()
    {
        return a;
    }
    public double getb()
    {
        return b;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public void setx(double x)
    {
        this.x=x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
