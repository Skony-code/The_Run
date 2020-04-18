package Controller;

import Model.Menu;
import View.MenuRenderer;
import View.TheView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuControler implements KeyListener {
    private Menu menu;
    private TheView view;
    private boolean endflag;
    public MenuControler(Menu menu, TheView view)
    {
        this.menu = menu;
        this.view = view;
        endflag=false;
    }
    public int run()
    {

        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        while(!endflag)
        {
            long lastTime = System.nanoTime();
            view.repaint();
            try {
                Thread.sleep((OPTIMAL_TIME+lastTime-System.nanoTime())/1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        endflag=false;
        return menu.getSelectedButton();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) menu.moveUp();
        if(e.getKeyCode()==KeyEvent.VK_DOWN) menu.moveDown();
        if(e.getKeyCode()==KeyEvent.VK_ENTER)endflag=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
