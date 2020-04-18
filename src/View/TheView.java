package View;

import javax.swing.*;
import java.awt.*;

public class TheView extends JPanel {
    private Renderer r;
    public TheView(int width,int height)

    {
        setPreferredSize(new Dimension(width,height));
        r=new DefaultRenderer();
    }
    public void setRenderer(Renderer r)
    {
        this.r=r;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        r.render(g);
    }
}
