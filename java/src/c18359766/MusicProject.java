package c18359766;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class MusicProject extends Visual
{	
	Wave wf;
    Cubes cub;
    RotatingBands bnds;
    Spheres sph;
 

    boolean cube = false;
    boolean bands = false;
    boolean wave =false;
    boolean sphere =false;


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
        bnds = new RotatingBands(this);
        sph = new Spheres(this);

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
            bands = ! bands;
           
        }

        //key for cubes
        if (key == '3')
        {
            cube = ! cube;
        }

        //key for spheres
        if (key == '4')
        {
            sphere= ! sphere;
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

        if (bands)
        {
            bnds.render();
        }

        if (cube)
        {
            cub.render();
        }

        if (sphere)
        {
            sph.render();
        }


    }
}