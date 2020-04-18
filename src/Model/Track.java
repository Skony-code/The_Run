package Model;

import java.util.ArrayList;
import java.util.List;

public class Track {

    public final int WIDTH;
    public final int HEIGHT;
    public final int LEVEL = 80;

    private double acceleration;
    private double score;
    private double grav;
    private Actor dino;
    private ResourceLoader loader;

    private Actor sdino;
    private double sgrav;

    private List<Entity> Obstacles;
    private List<Entity> Ground;
    public Track(Actor dino,int width,int height,double acceleration,double grav)
    {
        this.WIDTH=width;
        this.HEIGHT=height;
        this.acceleration=acceleration;
        this.grav=grav;
        this.score=0;
        this.dino=dino;

        this.sdino=dino.copy();
        this.sgrav=grav;

        loader=new ResourceLoader();

        Ground = new ArrayList<Entity>();
        for(int i=0;i<12;i++)
        {
            Ground.add(new Entity(38+i*78,HEIGHT-40,78,80,loader.getGround()));
        }

        Obstacles = new ArrayList<Entity>();
        Obstacles.add(new Entity(1600,HEIGHT-LEVEL-22,78,45,loader.getObstalce()));
        Obstacles.add(new Entity(1200,HEIGHT-LEVEL-22,78,45,loader.getObstalce()));
    }
    public void addObstacle()
    {
        Obstacles.add(new Entity(WIDTH,HEIGHT-LEVEL-22,78,45,loader.getObstalce()));
    }
    public void addRandomObstacle()
    {
        
    }
    public void go(double delta)
    {
        //moving obstacles
        for(int i=0;i<Obstacles.size();i++)
        {
            Obstacles.get(i).setx(Obstacles.get(i).getx()-dino.getSpd()*delta/1000000000);
        }
        //moving ground
        for(int i=0;i<Ground.size();i++)
        {
            Ground.get(i).setx(Ground.get(i).getx()-dino.getSpd()*delta/1000000000);
        }

        //increasing difficulty by increasing speed
        dino.setSpd(dino.getSpd()+acceleration);
        double dif=dino.getSpd()/(dino.getSpd()-acceleration);
        dino.setJump(dino.getJump()*dif);
        grav=grav*dif*dif;

        //score
        score=score+dino.getSpd()*delta/1000000000;

        //jumping
        dino.setY(dino.gety()-(dino.getVerSpd()*delta/1000000000));
        if(dino.gety()<(HEIGHT-LEVEL-dino.getb()/2))
        {
            dino.setVerSpd(dino.getVerSpd()-grav);
        }
        else
        {
            dino.setVerSpd(0);
            dino.setY(HEIGHT-LEVEL-dino.getb()/2);
        }
    }
    public void updateObstacles()
    {
        for(int i=0;i<Obstacles.size();i++)
        {
            if(Obstacles.get(i).getx()<0-Obstacles.get(i).getSprite().getWidth(null)/2)
            {
                Obstacles.remove(i);
                addObstacle();
            }
        }
    }
    public void updateGround()
    {
        if(Ground.get(0).getx()<0-Ground.get(0).getSprite().getWidth(null)/2)
        {
            Ground.add(new Entity(Ground.get(0).getx()+12*78,HEIGHT-40,78,80,loader.getGround()));
            Ground.remove(0);
        }
    }
    public boolean didColide()//checks for collisions with obstacles
    {
        for(int i=0;i<Obstacles.size();i++)
        {
            if(dino.doesColide(Obstacles.get(i))) return true;
        }
        return false;
    }
    public List<Entity> getObstacles()
    {
        return Obstacles;
    }
    public Actor getDino()
    {
        return dino;
    }
    public double getAcceleration() {
        return acceleration;
    }
    public double getScore() {
        return score/10;
    }
    public double getGrav() {
        return grav;
    }

    public Actor getSdino() {
        return sdino;
    }

    public double getSgrav() {
        return sgrav;
    }

    public List<Entity> getGround() {
        return Ground;
    }

    public ResourceLoader getLoader() {
        return loader;
    }
}
