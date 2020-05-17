package c18359766;

import ie.tudublin.Visual;
import processing.core.*;

// This is a visual that uses the audio bands
public class Spheres
{
    MusicProject spheres;
    float angle = 0;
    float smoothedBoxSize = 0;

    public Spheres(MusicProject spheres)
    {
        this.spheres = spheres; 
    }

    public void render()
    {
        spheres.colorMode(PApplet.HSB);
        
        spheres.calculateAverageAmplitude();
        spheres.noFill();
        spheres.lights();
        spheres.stroke(PApplet.map(spheres.getSmoothedAmplitude(), 0, 6, 0, 255), 255, 255);
        spheres.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        spheres.translate(0, 0, -250);
               
        float boxSize = 20 + (spheres.getAmplitude() * 300);
        smoothedBoxSize = spheres.lerp(smoothedBoxSize, boxSize, 0.2f);        

        spheres.pushMatrix();
        spheres.translate(-100, 0, 0);
        spheres.rotateY(angle);
        spheres.rotateX(angle);
        spheres.rotateZ(angle);
        spheres.box(smoothedBoxSize);
        spheres.strokeWeight(1);
        spheres.sphere(smoothedBoxSize);
        spheres.popMatrix();

        spheres.pushMatrix();
        spheres.translate(100, 0, 0);
        spheres.rotateY(angle);
        spheres.rotateX(angle);
        spheres.box(smoothedBoxSize);
        spheres.strokeWeight(1);
        spheres.sphere(smoothedBoxSize);
        spheres.popMatrix();


        angle += 0.01f;
    }
}