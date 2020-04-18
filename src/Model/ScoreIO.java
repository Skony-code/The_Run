package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreIO {
    private File f;
    private int max;
    private List<String> list;
    public ScoreIO()
    {
        max=5;
        f=new File("src/Scores.txt");
        list=new ArrayList<>();
    }
    private void write()
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for(int i=0;i<list.size();i++)
            {
                bw.write(list.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void read()
    {
        list.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            String st;
            while ((st = br.readLine()) != null)list.add(st);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void add(int x)
    {
        read();
        int size=list.size();
        for(int i=0;i<size;i++)
        {
            if(new Integer(list.get(i))<x)
            {
                list.add(i,x+"");
                break;
            }
        }
        if(list.size()<max) list.add(x+"");
        else list.remove(list.size()-1);
        write();
    }
    public String[] getScores()
    {
        read();
        list.add("Exit");
        return list.toArray(new String[list.size()]);
    }
}
