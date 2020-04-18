package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TrackContrller implements KeyListener{
    private Track t;
    private TheView view;
    private boolean endflag;
    private boolean pauseflag;
    public TrackContrller(Track t, TheView view)
    {
        this.t=t;
        this.view=view;
        endflag=false;
        pauseflag=false;
    }
    public void run(JFrame win)
    {
        AnimationEngine running = new AnimationEngine(t.getLoader().getActorrun(),(int)(120000/t.getDino().getSpd()),t.getDino(),0);
        long updatetime = 0l;
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        running.start();
        while(!endflag)
        {
            if(t.didColide())
            {
                running.interrupt();
                new ScoreIO().add((int)t.getScore());
                String[] buttons = {"Restart","Exit to Main Menu","Exit"};
                Menu mOverMenu = new Menu(t.getLoader(),t.WIDTH/2,t.HEIGHT/2,408,60,20,"Game Over");
                mOverMenu.setButtons(buttons);
                MenuControler OverMenu = new MenuControler(mOverMenu,view);
                view.setRenderer(new InGameMenuRenderer(mOverMenu,t));
                win.addKeyListener(OverMenu);
                win.revalidate();
                int selected = OverMenu.run();
                switch (selected)
                {
                    case 0:
                        t=new Track(t.getSdino(),t.WIDTH,t.HEIGHT,t.getAcceleration(),t.getSgrav());
                        this.run(win);
                        break;
                    case 1:
                        endflag=true;
                        break;
                    case 2:
                        System.exit(0);
                        break;
                }
            }else if(pauseflag)
            {
                running.interrupt();
                String[] buttons = {"Resume","Exit to Main Menu","Exit"};
                Menu mPauseMneu = new Menu(t.getLoader(),t.WIDTH/2,t.HEIGHT/2,408,60,20,"Pause");
                mPauseMneu.setButtons(buttons);
                MenuControler PauseMenu = new MenuControler(mPauseMneu,view);
                view.setRenderer(new InGameMenuRenderer(mPauseMneu,t));
                win.addKeyListener(PauseMenu);
                win.revalidate();
                int selected = PauseMenu.run();
                switch (selected)
                {
                    case 0:
                        pauseflag=false;
                        break;
                    case 1:
                        endflag=true;
                        break;
                    case 2:
                        System.exit(0);
                        break;
                }
                running=new AnimationEngine(running.getAnimation(),running.getTime(),running.getE(),running.getCurrent_frame());
                running.start();
            }else
            {
                view.setRenderer(new TrackRenderer(t));
                long lastTime = System.nanoTime();
                t.go(updatetime);
                t.updateObstacles();
                t.updateGround();

                //stopping animation while in the air
                if(t.getDino().getVerSpd()!=0)
                {
                    running.interrupt();
                }
                else if(!running.isAlive())
                {
                    running=new AnimationEngine(running.getAnimation(),running.getTime(),running.getE(),running.getCurrent_frame());
                    running.start();
                }

                running.setTime((int)(120000/t.getDino().getSpd()));
                view.repaint();
                try {
                    Thread.sleep((OPTIMAL_TIME+lastTime-System.nanoTime())/1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updatetime = System.nanoTime() - lastTime;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            t.getDino().jump(t.HEIGHT-t.LEVEL);
        }
        if(e.getKeyCode() == KeyEvent.VK_P)
        {
            pauseflag=true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

