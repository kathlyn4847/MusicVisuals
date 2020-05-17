package c18359766;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class MusicProject extends Visual
{	
	Wave wf;
    Cubes cub;
    Spheres sph;
    RotatingSpheres rtsph;
 

    boolean cube = false;
    boolean wave =false;
    boolean sphere =false;
    boolean rotsphere = false;


    public void settings()
    {
        size(1024, 500, P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("RunAway.mp3");   
        
        wf = new Wave(this);
        cub = new Cubes(this);
        sph = new Spheres(this);
        rtsph = new RotatingSpheres(this);

    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

        //key for wave
        if (key == '1')
        {
            wave = ! wave;
        }

        //key for bands
        if (key == '2')
        {
            cube = ! cube;
        }

        //key for spheres
        if (key == '3')
        {
            sphere= ! sphere;
        }

        //key for rotatingspheres
        if (key == '4')
        {
            rotsphere= ! rotsphere;
        }

        //key for multiple visuals
        if (key == '5')
        {
            
            cube= !cube;
            sphere =!sphere;
            wave =! wave;
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();  

        if (wave)
        {
            wf.render();
        }

        if (cube)
        {
            cub.render();
        }

        if (sphere)
        {
            sph.render();
        }

        if (rotsphere)
        {
            rtsph.render();
        }



    }
}