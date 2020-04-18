import Controller.MenuControler;
import Controller.TrackContrller;
import Model.*;
import Model.Menu;
import View.MenuRenderer;
import View.TheView;
import View.TrackRenderer;
import View.Window;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MVCRun {
    public static void main(String[] args) throws InterruptedException{

        Properties prop = new Properties();
        //loading settings
        try (InputStream input = new FileInputStream("src/settings.properties"))
        {
            prop.load(input);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        final int WIDTH = new Integer(prop.getProperty("w_width"));
        final int HEIGHT = new Integer(prop.getProperty("w_height"));

        Window win = new Window();

        //Main view, used by all controllers
        TheView view = new TheView(WIDTH,HEIGHT);
        win.add(view);
        win.pack();

        String[] butt={"New","High Scores","Exit"};

        Menu mMM = new Menu(new ResourceLoader(),WIDTH/2,HEIGHT/2,408,60,20,"The Run");
        mMM.setButtons(butt);
        MenuControler MM = new MenuControler(mMM,view);//Main menu
        while(true) {
            view.setRenderer(new MenuRenderer(mMM));
            win.addKeyListener(MM);
            win.revalidate();
            int choosen = MM.run();
            win.removeKeyListener(MM);
            switch (choosen) {
                case 0:
                    double spd = new Double(prop.getProperty("speed"));
                    double jmp = new Double(prop.getProperty("jump"));
                    Actor act = new Actor(100, HEIGHT - 80 - 36, 20, 72, jmp, spd,new ResourceLoader().getActor());
                    double acc= new Double(prop.getProperty("acceleration"));
                    double grav = new Double(prop.getProperty("gravity"));
                    Track track = new Track(act,WIDTH,HEIGHT,acc,grav);
                    TrackContrller tc = new TrackContrller(track, view);
                    view.setRenderer(new TrackRenderer(track));
                    win.addKeyListener(tc);
                    win.revalidate();
                    tc.run(win);
                    break;
                case 1:
                    Menu mSM = new Menu(new ResourceLoader(),WIDTH/2,HEIGHT/2,408,60,20,"High Scores");
                    String[] buttons=new ScoreIO().getScores();
                    mSM.setButtons(buttons);
                    MenuControler SM = new MenuControler(mSM,view);
                    view.setRenderer(new MenuRenderer(mSM));
                    win.addKeyListener(SM);
                    win.revalidate();
                    boolean endflag=false;
                    while (!endflag)
                    {
                        if(SM.run()==buttons.length-1) endflag=true;
                    }
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
        }
    }
}
