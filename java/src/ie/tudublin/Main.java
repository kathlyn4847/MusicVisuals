package ie.tudublin;

import example.CubeVisual;
import example.CubeVisual1;
import example.WaveForm;
import example.MyVisual;
<<<<<<< HEAD
import example.AudioBandsVisual;
=======
import example.RotatingAudioBands;
>>>>>>> cc0250fe11bfd31233735e224c9253c06ad1e5b1

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new RotatingAudioBands());		
	}

	public void cubeVisual2()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual1());		
	}

	public void waveForm()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new WaveForm());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.waveForm();			
	}
}