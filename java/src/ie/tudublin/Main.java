package ie.tudublin;

import example.CubeVisual;
import example.CubeVisual1;
import example.WaveForm;
import example.MyVisual;
import example.AudioBandsVisual;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual());		
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