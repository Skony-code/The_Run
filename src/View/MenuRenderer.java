package View;

import Model.Menu;

import java.awt.*;

public class MenuRenderer implements Renderer {
    private Menu menu;
    private Font font;
    public MenuRenderer(Menu menu)
    {
        this.menu=menu;
        font=new Font("Copper Black", Font.BOLD, 12);
    }
    public void render(Graphics g)
    {
        drawBackground(g);
        drawSelectedButton(g);

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(30F));
        drawCenteredString(menu.getName(),menu.getX(),menu.getMenuButtons()[0].getY()-menu.getSpace()*5,g);
        for(int i=0;i<menu.getMenuButtons().length;i++)
        {
            new MenuButtonRenderer(menu.getMenuButtons()[i]).render(g);
        }
    }
    private void drawCenteredString(String s, int x, int y, Graphics g)
    {
        FontMetrics fm = g.getFontMetrics();
        int xx = x - fm.stringWidth(s) / 2;
        int yy = y+fm.getHeight()/4;
        g.drawString(s, xx, yy);
    }
    private void drawSelectedButton(Graphics g)
    {
        g.drawImage(menu.getLoader().getButtonselected(),menu.getMenuButtons()[menu.getSelectedButton()].getX()-menu.getLoader().getButtonselected().getWidth(null)/2,
                menu.getMenuButtons()[menu.getSelectedButton()].getY()-menu.getLoader().getButtonselected().getHeight(null)/2,null);
    }
    protected void drawBackground(Graphics g)
    {
        g.drawImage(menu.getLoader().getMenuBackground(),0,0,null);
    }
}
