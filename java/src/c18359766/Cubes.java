package c18359766;

import ie.tudublin.Visual;
import processing.core.*;

// This is a visual that uses the audio bands
public class Cubes
{
    MusicProject cubes;
    float smoothedBoxSize = 0;

    public Cubes(MusicProject cubes)
    {
        this.cubes = cubes; 
    }

    public void render()
    {
        cubes.colorMode(PApplet.HSB);
        cubes.calculateAverageAmplitude();
        cubes.background(0);
        cubes.noFill();
        cubes.stroke(PApplet.map(cubes.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        cubes.translate(0, 0, -250);

        float boxSize = 50 + (cubes.getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = cubes.lerp(smoothedBoxSize, boxSize, 0.2f); 

    }
}