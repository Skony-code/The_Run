package Model;

import java.awt.*;

public class AnimationEngine extends Thread{
    private Image[] animation;
    private Entity e;
    private int time;
    private int current_frame;
    public AnimationEngine(Image[] animation,int time,Entity e,int startframe)
    {
        this.animation=animation;
        this.time=time;
        this.e=e;
        current_frame=startframe;
    }

    @Override
    public void run() {
        while (!this.isInterrupted())
        {
            e.setSprite(animation[current_frame]);
            if(current_frame<animation.length-1) current_frame++;
            else current_frame=0;
            try {
                this.sleep(time/animation.length);
            } catch (InterruptedException ex) {
                this.interrupt();
            }
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCurrent_frame() {
        return current_frame;
    }

    public Entity getE() {
        return e;
    }

    public Image[] getAnimation() {
        return animation;
    }
}
