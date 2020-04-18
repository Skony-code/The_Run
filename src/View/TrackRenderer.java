package View;

import Model.Track;

import java.awt.*;

public class TrackRenderer implements Renderer {
    protected Track t;
    public TrackRenderer(Track t)
    {
        this.t=t;
    }
    @Override
    public void render(Graphics g) {
        renderBackGround(g);
        renderObstacles(g);
        new EntityRenderer(t.getDino()).render(g);
        renderGround(g);
        renderScore(g);
    }
    private void renderObstacles(Graphics g)
    {
        for(int i=0;i<t.getObstacles().size();i++) new EntityRenderer(t.getObstacles().get(i)).render(g);
    }
    private void renderGround(Graphics g)
    {
        for(int i=0;i<t.getGround().size();i++)
        {
            new EntityRenderer(t.getGround().get(i)).render(g);
        }
    }
    private void renderScore(Graphics g)
    {
        g.setColor(Color.black);
        g.setFont(g.getFont().deriveFont(26F));
        String text="Score: "+(int)(t.getScore());
        g.drawString(text,t.WIDTH-160,50);
    }
    private void renderBackGround(Graphics g)
    {
        g.drawImage(t.getLoader().getBackground(),0,0,t.WIDTH,t.HEIGHT,null);
    }
}
