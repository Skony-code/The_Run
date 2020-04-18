package Model;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private MenuButton[] menuButtons;

    private int bwidth;//buttons dimensions
    private int bheight;
    private int x;//middle of menu
    private int y;
    private int space;

    private int selectedButton;
    private String name;

    private ResourceLoader loader;
    public Menu(ResourceLoader loader,int x,int y,int bwidth,int bheight,int space,String name)
    {
        this.loader=loader;
        this.name=name;
        this.x=x;
        this.y=y;
        this.bwidth=bwidth;
        this.bheight=bheight;
        this.space=space;
        selectedButton=0;
    }
    public void setButtons(String[] buttons)//does not work correctly on one button
    {
        menuButtons=new MenuButton[buttons.length];
        menuButtons[0]=new MenuButton(buttons[0],x,y-((buttons.length-1)/2*(space+bheight)),bwidth,bheight,loader.getButton());
        for(int i=1;i<buttons.length;i++)
        {
            menuButtons[i]=new MenuButton(buttons[i],x,menuButtons[i-1].getY()+space+bheight,bwidth,bheight,loader.getButton());
        }

    }
    public void moveUp()
    {
        if(selectedButton>0)selectedButton--;
        else selectedButton=menuButtons.length-1;
    }
    public void moveDown()
    {
        if(selectedButton<menuButtons.length-1)selectedButton++;
        else selectedButton=0;
    }

    public MenuButton[] getMenuButtons() {
        return menuButtons;
    }

    public int getSpace() {
        return space;
    }

    public int getSelectedButton() {
        return selectedButton;
    }

    public int getBheight() {
        return bheight;
    }

    public int getBwidth() {
        return bwidth;
    }

    public String getName() {
        return name;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public ResourceLoader getLoader() {
        return loader;
    }
}
