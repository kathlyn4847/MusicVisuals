package c18359766;

import processing.core.*;
import ie.tudublin.Visual;

// This is an example of a visual that renders the waveform
public class Wave
{
    MusicProject mv;
    float cy = 0;

    public Wave(MusicProject mv)
    {
        this.mv = mv;
        cy = this.mv.height/6;
    }

    public void render()
    {
        mv.colorMode(PApplet.HSB/2);
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );
            mv.camera(0, -500, 800, 0, 0, 0, 0, 1, 0);
            mv.line(-1300, cy, 10, cy + cy * mv.getAudioBuffer().get(i));
            mv.line(1300, cy, -10, cy + cy * mv.getAudioBuffer().get(i));
        }
    }
}