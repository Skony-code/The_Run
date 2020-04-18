package View;

import Model.Entity;

import java.awt.*;

public class EntityRenderer {
    Entity e;
    public EntityRenderer(Entity e)
    {
        this.e = e;
    }
    public void render(Graphics g)
    {
        g.drawImage(e.getSprite(),(int)(e.getx()-e.getSprite().getWidth(null)/2),(int)(e.gety()-e.getSprite().getHeight(null)/2),null);
    }
}
