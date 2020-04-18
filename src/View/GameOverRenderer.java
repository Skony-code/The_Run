package View;

import Model.Track;

import java.awt.*;

public class GameOverRenderer extends TrackRenderer implements Renderer {

    public GameOverRenderer(Track t) {
        super(t);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        String banner = "Game Over";
        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(32F));
        g.drawChars(banner.toCharArray(),0,9,t.WIDTH/2-160,t.HEIGHT/2);
    }
}
