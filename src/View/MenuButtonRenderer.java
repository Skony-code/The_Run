package View;

import Model.MenuButton;

import java.awt.*;

public class MenuButtonRenderer implements Renderer {
    private MenuButton mb;
    public MenuButtonRenderer(MenuButton mb)
    {
        this.mb=mb;
    }
    public void render(Graphics g )
    {
        g.drawImage(mb.getTexture(),mb.getX()-mb.getWidth()/2,mb.getY()-mb.getHeight()/2,null);
        g.setColor(Color.lightGray);
        g.setFont(g.getFont().deriveFont(20f));
        drawCenteredString(mb.getText(),mb.getX(),mb.getY(),g);
    }
    private void drawCenteredString(String s, int x, int y, Graphics g)
    {
        FontMetrics fm = g.getFontMetrics();
        int xx = x - fm.stringWidth(s) / 2;
        int yy = y+fm.getHeight()/4;
        g.drawString(s, xx, yy);
    }
}
