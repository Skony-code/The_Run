package Model;

import java.awt.*;

public class MenuButton {
    private String text;
    private int x;
    private int y;
    private int width;
    private int height;
    private Image texture;
    public MenuButton(String text,int x,int y,int width,int height,Image texture)
    {
        this.texture=texture;
        this.text=text;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getText() {
        return text;
    }

    public Image getTexture() {
        return texture;
    }
}

