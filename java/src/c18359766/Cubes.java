package c18359766;

import ie.tudublin.Visual;
import processing.core.*;

// This is a visual that uses the audio bands
public class Cubes
{
    MusicProject cubes;
    float angle = 0;
    float smoothedBoxSize = 0;

    public Cubes(MusicProject cubes)
    {
        this.cubes = cubes; 
    }

    public void render()
    {
        cubes.colorMode(PApplet.HSB);

        cubes.calculateAverageAmplitude();
        cubes.noFill();
        cubes.lights();
        cubes.stroke(PApplet.map(cubes.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        cubes.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        cubes.translate(0, 0, -250);
               
        float boxSize = 20 + (cubes.getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = cubes.lerp(smoothedBoxSize, boxSize, 0.2f);        

        cubes.pushMatrix();
        cubes.translate(-250, -100, 0);
        cubes.rotateY(angle);
        cubes.rotateX(angle);
        cubes.box(smoothedBoxSize);
        cubes.strokeWeight(1);
        //sphere(smoothedBoxSize);
        cubes.popMatrix();


        cubes.pushMatrix();
        cubes.translate(250, 100, 0);
        cubes.rotateX(angle);
        cubes.rotateY(angle);
        cubes.strokeWeight(5); 
        cubes.box(smoothedBoxSize);
        cubes.popMatrix();

        cubes.pushMatrix();
        cubes.translate(-250, 100, 0 );
        cubes.rotateX(angle);
        cubes.rotateY(angle);
        cubes.strokeWeight(5); 
        cubes.box(smoothedBoxSize);
        cubes.popMatrix();
        
        cubes.pushMatrix();
        cubes.translate(250, -100, 0 );
        cubes.rotateY(angle);
        cubes.rotateX(angle);
        cubes.strokeWeight(5); 
        cubes.box(smoothedBoxSize);
        cubes.popMatrix();

        angle += 0.01f;
    }
}