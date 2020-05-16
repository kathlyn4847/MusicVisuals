package c18359766;

import processing.core.*;
import ie.tudublin.Visual;

public class RotatingBands
{
    MusicProject rotat;

    float radius = 200;
    float smoothedBoxSize = 0;
    float rot = 0;

    public RotatingBands(MusicProject rotat)
    {
        this.rotat = rotat;
    }

    public void render()
    {
    
        rotat.colorMode(PApplet.HSB);

        rotat.noFill();
        rotat.stroke(255);
        rotat.lights();

        rotat.stroke(
            PApplet.map(rotat.getSmoothedAmplitude(), 0, 1, 0, 255)
            , 255
            , 255
        );
        rotat.camera(0, -500, 500, 0, 0, 0, 0, 1, 0);


        rot += rotat.getAmplitude() / 8.0f;

        rotat.rotateY(rot);
        float[] bands = rotat.getSmoothedBands();

        for(int i = 0 ; i < bands.length ; i ++)
        {
            float theta = PApplet.map(i, 0, bands.length, 0, rotat.TWO_PI);

            rotat.stroke(
                PApplet.map(i, 0, bands.length, 0, 255)
                , 255
                , 255
            );
            float x = rotat.sin(theta) * radius;
            float z = rotat.cos(theta) * radius;
            float h = bands[i];
            rotat.pushMatrix();
            rotat.translate(x, - h / 2 , z);
            rotat.rotateY(theta);
            rotat.box(50, h, 50);
            rotat.popMatrix();
        }

    }

    float angle = 0;

}