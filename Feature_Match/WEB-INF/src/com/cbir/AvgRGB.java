/**
 
 File : AvgRGB.java
 Package : com.kumar
*/

package com.cbir;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class AvgRGB 
{
	
	public static Vector getAvgRGBFeature(BufferedImage img) 
	{
		Vector vector = new Vector(3);
		int TotPix = img.getWidth() * img.getHeight();
		int RGBArray[] = AvgRGB.getRGBPixel(img);
		int R = 0;
		int G = 0;
		int B = 0;
		for (int i1 = 0; i1 < TotPix; i1++) 
		{
			R += RGBArray[i1 * 3];
			G += RGBArray[i1 * 3 + 1];
			B += RGBArray[i1 * 3 + 2];
		}

		
/*		double d = (double) R / (double) TotPix;
		double d1 = (double) G / (double) TotPix;
		double d2 = (double) B / (double) TotPix;
		vector.add(new Double(d));
		vector.add(new Double(d1));
		vector.add(new Double(d2));
		return vector;
*/		
		//Enhancements
		vector.add(R/TotPix);
		vector.add(G/TotPix);
		vector.add(B/TotPix);
		return vector;
	}
	
	public static int[] getRGBPixel(BufferedImage img) 
	{
		int size = img.getHeight() * img.getWidth();
		int pixel[] = new int[size];
		int pixels[] = new int[size * 3];
		PixelGrabber pg = new PixelGrabber(img, 0, 0, img.getWidth(),img.getHeight(), pixel, 0, img.getWidth());
		try 
		{
			pg.grabPixels();
		} 
		catch
		(InterruptedException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		if ((pg.getStatus() & 0x80) != 0) 
		{
			System.out.println("Error in grabbing pixel");
			return null;
		}
		
		for (int i = 0; i < size; i++) 
		{
			pixels[i * 3] = pixel[i] >> 16 & 0xff;
			pixels[i * 3 + 1] = pixel[i] >> 8 & 0xff;
			pixels[i * 3 + 2] = pixel[i] & 0xff;
		}

		return pixels;
	}
	
	public static BufferedImage readImage(String filePath)
	{
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File(filePath));
        } 
        catch(IOException e) 
        {
            e.printStackTrace();
        }
        return img;
    }
	
/* Testing The Developement */	
	
	public static void main(String[] args) 
	{
		BufferedImage img = null;
		String filePath = "Files/Search/C_0321_1.LEFT_CC.LJPEG.png";
		
		img = readImage(filePath);
		Vector avgRgbVal = getAvgRGBFeature(img);
		System.out.println("Avg RGB Value : " +avgRgbVal);
		
/*		Double d = new Double(1.23);
		int i = d.intValue();
*/
		
	}
}
