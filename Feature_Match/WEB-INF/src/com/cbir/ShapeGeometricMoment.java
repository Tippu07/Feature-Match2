
package com.cbir;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.imageio.ImageIO;

/** This is a sub-class of the ShapeModule. This class computes the geometric moment of a specified image
 * 

 */
public class ShapeGeometricMoment extends ShapeModule
{
	private final static int p = 1;	// Default value of order p
	private final static int q = 1;	// Default value of order q
	

/** It returns the threshold for determining the similarity of 2 different images.
 * When 2 images have feature difference less than this threshold is said to be
 * similar. It is set to 20% of the maximum feature value.
 * 

 */
	public double getThreshold()
	{
		return (880.0);
	}
	
/** The vector representing the Geometric Moment. It is a 1D vector
 * 
 * @param img Discovir Image
 * @return Vector containing the geometric moment
 */
	public Vector getFeatureVector(BufferedImage image)
	{
		Dimension size = new Dimension(image.getWidth(), image.getHeight());
		int pixels[] = getProcessedImage(image, size);
		double weight[] = objectWeightPoint(pixels, size);
		
		return (findGeometricMoment(pixels, size, weight, p, q));
	}
	
/** @param img Discovir Image
 * @param weight Object weight
 * @param p order in x-coordinate
 * @param q order in y-coordinate
 * @return Vector  contating the geometric moment
 */
	public static Vector getFeatureVector(BufferedImage image, double weight[], int p, int q)
	{
		Dimension size = new Dimension(image.getWidth(),image.getHeight());
		int pixels[] = getProcessedImage(image, size);
		
		return (findGeometricMoment(pixels, size, weight, p, q));
	}	

/** Same as above
 * 
 * @param pixels pixel array containg Black & White ONLY
 * @param size size of the image the pixel array is representing
 * @return Vector containing the geometric moment
 */
	public static Vector getFeatureVector(int pixels[], Dimension size)
	{
		double weight[] = objectWeightPoint(pixels, size);
		
		return (findGeometricMoment(pixels, size, weight, p, q));
	}

/** Same as above
 * 
 * @param pixels pixel array containing Black & White ONLY
 * @param size size of the image the pixel array is representing
 * @param weight object weight
 * @param p order in x coordinate
 * @param q order in y coordinate
 * @return Vector containing the geometric moment
 */
	public static Vector getFeatureVector(int pixels[], Dimension size, double weight[], int p, int q)
	{
		return (findGeometricMoment(pixels, size, weight, p, q));
	}

/** Same as above
 * 
 * @param pixels pixel array containing Black & White ONLY
 * @param size size of the image the pixel array is representing
 * @param weight object weight
 * @param p order in x coordinate
 * @param q order in y coordinate
 * @return Vector containing the geometric moment
 */
	private static Vector findGeometricMoment(int pixels[], Dimension size, double weight[], int p, int q)
	{
		double moment = 0;
		Vector geometricMoment = new Vector(1);
		
		for (int j=0; j<size.height; j++)
			for (int i=0; i<size.width; i++)
				if (pixels[j*size.width + i] == FRONT)
					moment += Math.pow(i-weight[0],p) * Math.pow(j-weight[1],q);
				
		//Enhancement(Starts)
				moment = round4Decimals(moment);//Rounding To 4 Decimal Points
		//Enhancement(Ends)
		geometricMoment.add(new Double( moment ));
		return (geometricMoment);
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
	
	public static double roundTwoDecimals(double d) 
	{
		//double number = 651.5176515121351;
	    //The output will be 651.52
	    DecimalFormat twoDForm = new DecimalFormat("#.##");
	    return Double.valueOf(twoDForm.format(d));
	}
	
	public static double round4Decimals(double d) 
	{
	    DecimalFormat twoDForm = new DecimalFormat("#.####");
	    return Double.valueOf(twoDForm.format(d));
	}
	
	public static double round2Decimals(double d) 
	{
		//double number = 651.5176515121351;
		//The output will be 651.52
		
		d = Math.round(d * 100);
		d = d/100;
		return d;
	}
	
/* Testing The Development	*/
	public static void main(String[] args) 
	{
		//String filePath = "Files/test.jpg";
		//String filePath = "Files/check.jpg";
		//String filePath = "Files/314.jpg";
		//String filePath = "Files/609.jpg";
		String filePath = "Files/Search/C_0321_1.LEFT_CC.LJPEG.png";
		BufferedImage image = ShapeGeometricMoment.readImage(filePath);
		ShapeGeometricMoment gm = new ShapeGeometricMoment();
		Vector v = gm.getFeatureVector(image);
		System.out.println("Fetaute Value : \n"+v);
	}

	

	

	

}