package c18359766;

import processing.core.*;
import ie.tudublin.Visual;

// This is an example of a visual that renders the waveform
public class Wave
{
    MusicProject mv;
    float cy = 0;
    float cz = 0;

    public Wave(MusicProject mv)
    {
        this.mv = mv;
        cy = this.mv.height/4;
    }

    public void render()
    {
        mv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            mv.line(i, cy, i, cy + cy * mv.getAudioBuffer().get(i));
        }
    }
}