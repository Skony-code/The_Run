package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class ResourceLoader {
    private Image obstalce;
    private Image actor;
    private Image ground;
    private Image background;
    private Image menubackground;
    private Image button;
    private Image buttonselected;
    private Image[] actorrun;

    public Image getObstalce() {
        if(obstalce==null)
        {
            try
            {
                obstalce = ImageIO.read(new File("src/rsc/Obstacle.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obstalce;
    }
    public Image getActor() {
        if(actor==null)
        {
            try
            {
                actor = ImageIO.read(new File("src/rsc/Actor.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return actor;
    }
    public Image getGround() {
        if(ground==null)
        {
            try
            {
                ground = ImageIO.read(new File("src/rsc/Ground_block.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ground;
    }
    public Image getBackground() {
        if(background==null)
        {
            try
            {
                background = ImageIO.read(new File("src/rsc/Background.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return background;
    }
    public Image getMenuBackground() {
        if(menubackground==null)
        {
            try
            {
                menubackground = ImageIO.read(new File("src/rsc/Background_menu.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return menubackground;
    }
    public Image getButton() {
        if(button==null)
        {
            try
            {
                button = ImageIO.read(new File("src/rsc/Button.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return button;
    }
    public Image getButtonselected(){
        if(buttonselected==null)
        {
            try
            {
                buttonselected = ImageIO.read(new File("src/rsc/Button_selected.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buttonselected;
    }
    public Image[] getActorrun(){
        if(actorrun==null)
        {
            actorrun=new Image[6];
            try
            {
                for(int i=0;i<actorrun.length;i++) actorrun[i] = ImageIO.read(new File("src/rsc/Actor/Run_"+i+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return actorrun;
    }
}

