package Model;

import java.awt.*;

public class Actor extends Entity {
    private double spd;
    private double jump;
    private double verSpd;
    public Actor(double x, double y, double a, double b, double jump, double spd, Image sprite)
    {
        super(x, y, a, b,sprite);
        this.spd=spd;//px per second
        this.jump=jump;//starting velocity in px/s
        this.verSpd=0;
    }
    public boolean doesColide(Entity e)
    {
        if(Math.abs(this.getx()-e.getx())<=Math.abs(this.geta()/2+e.geta()/2)
                && Math.abs(this.gety()-e.gety())<=Math.abs(this.getb()/2+e.getb()/2))
            return true;
        else
            return false;
    }
    public void jump(int lvl)
    {
        if(gety()+getb()/2==lvl)
        verSpd=jump;
    }
    public Actor copy()
    {
        return new Actor(getx(),gety(),geta(),getb(),jump,spd,getSprite());
    }
    public double getJump() {
        return jump;
    }
    public void setJump(double jump) {
        this.jump = jump;
    }
    public double getVerSpd() {
        return verSpd;
    }
    public void setVerSpd(double verSpd) {
        this.verSpd = verSpd;
    }
    public void setSpd(double spd) {
        this.spd = spd;
    }
    public double getSpd()
    {
        return spd;
    }
}
