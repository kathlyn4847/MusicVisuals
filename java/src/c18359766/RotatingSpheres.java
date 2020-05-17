package c18359766;

import ie.tudublin.Visual;
import processing.core.*;

// This is a visual that uses the audio bands
public class RotatingSpheres
{
    MusicProject rotspheres;
    float angle = 0;
    float smoothedBoxSize = 0;

    public RotatingSpheres(MusicProject rotspheres)
    {
        this.rotspheres = rotspheres; 
    }

    public void render()
    {
        rotspheres.colorMode(PApplet.HSB);
        
        rotspheres.calculateAverageAmplitude();
        rotspheres.noFill();
        rotspheres.lights();
        rotspheres.stroke(PApplet.map(rotspheres.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        rotspheres.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        rotspheres.translate(0, 0, -500);
               
        float boxSize = 20 + (rotspheres.getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = rotspheres.lerp(smoothedBoxSize, boxSize, 0.2f);        

        for (int i = -100 ; i < 2000 ; i = i+100)
        {
            rotspheres.pushMatrix();
            rotspheres.translate(0,0, i);
            rotspheres.rotateY(angle);
            rotspheres.rotateX(angle);
            rotspheres.box(smoothedBoxSize);
            rotspheres.strokeWeight(1);
            rotspheres.sphere(smoothedBoxSize);
            rotspheres.popMatrix();
        }


        angle += 0.01f;
    }
}