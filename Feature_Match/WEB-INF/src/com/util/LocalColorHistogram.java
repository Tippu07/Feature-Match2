/**

 File : AvgRGB.java
 Package : com.kumar
*/

package com.util;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.imageio.ImageIO;


/**
 *	It is a sub-class of the FeatureExtractionModule class.
 * It can get the local color histogram feature from a
 * DiscovirImage class and return a 1024-dimension vector
 * to represent that image. It can compare 2 1024-dimension
 * vectors and return their difference.
 *
 */

public class LocalColorHistogram 
{

/**
 * Constructor
 * It is the constructor. It initialize some varibles which tell
 * the feature name, feature length, feature category and version
 * of this class. The varible _featureDescription tells the class
 * can get the local clolor histogram from a DiscovirImage.
 */

	


	public static Vector getFeatureVector(BufferedImage img) 
	{
		return getFeatureVector(img, 4);
	}

/**
 * Method
 * It gets the feature vector using user define parameters
 * and it will return a d*d*64-dimension vector.
 *
 * @param image It is a DiscovirImage
 * @return localColorHistogram It is a 1024-dimension vector representing the image.
*/


	public static Vector getFeatureVector(BufferedImage img, int d) 
	{
		final int dimen = d*d;
		Vector localColorHistogram = new Vector(dimen*64);

		int i=0, j=0, k=0;
		int width = img.getWidth();
		int height = img.getHeight();
		int size=width*height;
		//int pixels[] = getRGBPixel(img);
		int pixels[] = getPackedRGBPixel(img);
		double[][] histogram = new double[dimen][64];

		System.out.println("LCH - Get Feature Vector ");

		for(i=0 ; i<dimen ; i++)
		{
			histogram[i] = new double[64];
			for(j=0 ; j<64 ; j++)
			{
				histogram[i][j] = 0.0;
			}
		}

		for(i=0 ; i<size ; i++)
		{
//			k = pixels[i*3]/64*16 + pixels[i*3+1]/64*4 + pixels[i*3+2]/64;
			k = (pixels[i]>>18 & 0x30) | (pixels[i]>>12 & 0xc) | (pixels[i]>>6 & 0x3);
			j =	decideLocal(i, width, height, d);
			//System.out.println("Pixel"+i);
			//System.out.println("Area"+j);
			histogram[j][k] += 1.0;
		}

		for(i=0 ; i<dimen ; i++)
			for(j=0 ; j<64 ; j++)
				localColorHistogram.add(roundTwoDecimals(new Double(histogram[i][j]/(size/dimen))));

		return localColorHistogram;
	}
/**
 * Method
 * It decides the pixel j is belongs to which local area of the image.
 *
 * @param j It is the jth pixel of the inputted image.
 * @param w It is the width of the inputted image.
 * @param h It is the height of the inputted image.
 * @param d It is the dimension used in dividing the image..
 * @return area It is an integer representing a local area of the inputted image.
 */


	private static int decideLocal(double j, double w, double h, int d)
	{
		double localWidth = w/d;
		double localHeight = h/d;

		int area = (int)(j/w/localHeight)*d + (int)((j%w)/localWidth);
		return area;
	}
/**
 * Method
 * It returns the threshold for determining the similarity of 2 different images.
 * When 2 images have feature difference less than this threshold is said to be
 * similar. It is set to 20% of the maximum feature value.
 *
 * @return the double value of the threshold
*/

	public double getThreshold() 
	{
            
              return 2.0*16.0*0.2;
		
	}
	
	public static int[] getPackedRGBPixel(BufferedImage img)
	{
		return img.getRGB(0, 0, img.getWidth(), img.getHeight(), null,0, img.getWidth());
	}
	
/*	public static int[] getRGBPixel(BufferedImage img) 
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
*/	
	
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
	
	public static double roundTwoDecimals(double d) 
	{
		//double number = 651.5176515121351;
	    //The output will be 651.52
	    DecimalFormat twoDForm = new DecimalFormat("#.##");
	    return Double.valueOf(twoDForm.format(d));
	}
	
/* Testing The Development(Starts) */	
	
	public static void main(String[] args) 
	{
		BufferedImage img = null;
		String filePath = "Files/Search/C_0321_1.LEFT_CC.LJPEG.png";
		//String filePath = "Files/Search/check.jpg";
		img = readImage(filePath);
		
		Vector v = LocalColorHistogram.getFeatureVector(img);
		
		System.out.println("Value :\n"+v);
	}
}

