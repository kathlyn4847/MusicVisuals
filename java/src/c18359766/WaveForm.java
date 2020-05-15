package c18359766;

import ie.tudublin.Visual;
import processing.core.*;

// This is an example of a visual that uses the audio bands
public class WaveForm
{
    MusicProject mv;

    public WaveForm(MusicProject mv)
    {
        this.mv = mv; 
    }

    public void render()
    {

        float gap = mv.width / (float) mv.getBands().length;
        mv.noStroke();
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.stroke(PApplet.map(i, 0, mv.getSmoothedBands().length, 255, 0), 255, 255);
            mv.rect(i * gap, mv.height, gap,-mv.getSmoothedBands()[i] * 0.2f); 
        }
    }
}