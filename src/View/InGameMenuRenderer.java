package View;

import Model.Menu;
import Model.Track;

import java.awt.*;

public class InGameMenuRenderer extends MenuRenderer {
    private Track t;
    private TrackRenderer tr;
    public InGameMenuRenderer(Menu menu,Track t)
    {
        super(menu);
        this.t=t;
        this.tr=new TrackRenderer(t);
    }

    @Override
    public void drawBackground(Graphics g)
    {
        tr.render(g);
    }
}
