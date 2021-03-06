package com.cbir;

import java.util.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

/** This is a sub-class of FeatureExtractionModule. It stores numerous methods useful
 * in shape features computation
 * 
 
 */
public abstract class ShapeModule
{
	// Some constants usefull in the shape feature extraction functions
	protected static final int FRONT = 255;
	protected static final int BKGRND = 0;
	protected static final double PI = 3.1415926;
	
	// Total number of FRONT pixels wanted to use
	private static int totalNumPixels = 300;
	
	public static String featureCategory = "Shape";
	
	
	
/** This is an abstract method. Class extends this Module have to implement this method
 * 
 * @param image Discovir Image
 * @return Vector containing the desired feature
 */
	public abstract Vector getFeatureVector(BufferedImage image);

// Returns an Black & White and normalized image array
/** This method encapsulates the process of Image segmentation and pixel normalization
 * 
 * @param img Discovir Image
 * @param size size of the image and may change during pixel 
 *     normalization
 * @return A pixel array containing Black & White ONLY
 */
	public static int[] getProcessedImage(BufferedImage image, Dimension size)
	{
		// Conversion of Black & White(area) image
		ImageSegment seg = new ImageSegment();
		Vector feature0 = seg.getXYAreaVector(image);
		
		int dimension0 = feature0.size();
		int imgSize = image.getWidth() * image.getHeight();
		int bw[] = new int[imgSize];
		
		for(int i=0; i<imgSize; i++)
			bw[i] = FRONT;
		
		int j = 0;	
		for(int i=0 ; i<dimension0 ; i+=2)
		{
			j = ((Integer)feature0.elementAt(i)).intValue()
				+ ((Integer)feature0.elementAt(i+1)).intValue()*image.getWidth();
			bw[j] = 0;
		}
		
		// Normalize the image
		int result[] = objectPixelNormalized(bw, size, totalNumPixels);
		if (result == null)
			result = bw;
		
		return (result);
	}
	
	/** This method simply returns the variable totalNumPixels
	 * 
	 * @return int value of totalNumPixels
	 */
	public int getTotalNumPixels()
	{
		return (totalNumPixels);
	}
	
	/** This method sets the variable totalNumPixels
	 * 
	 * @param n The new value of totalNumPixels
	 */
	public void setTotalNumPixels(int n)
	{
		totalNumPixels = n;
	}
	
	/** This method normalize the number of FRONT pixels in the image file and
	 * update its dimension if necessary
	 * 
	 * @param pixels pixel array containing Black & White ONLY
	 * @param size size of the image and may change
	 * @param totalPixels Total number of FRONT pixels used 
	 * @return A normalized pixel array
	 */
	public static int[] objectPixelNormalized(int pixels[], Dimension size, int totalPixels)
	{
		int result[] = null;
		int mx = size.width;
		int my = size.height;
		
		int sum = 0;
		for (int i=0; i<mx*my; i++)
			sum += pixels[i] / FRONT;
		
		if (sum == 0)
			return null;
			
		double a, a2;
		a2 = (double)totalPixels / (double)sum;
		a = Math.sqrt(a2);
		
		// There will be "totalPixels" front pixels in the new image of nX*nY
		int nX = (int)(mx*a);
		int nY = (int)(my*a);
		result = new int[nX*nY];
		
		for (int j=0; j<nY; j++)
			for (int i=0; i<nX; i++)
			{
				int j1 = (int)((double)(j) / a);
				int i1 = (int)((double)(i) / a);
				if ( (j1>my-1) || (i1>mx-1) )
					result[j*nX+i] = BKGRND;
				else
					result[j*nX+i] = pixels[j1*mx+i1];
			}
		
		// Update the new dimension of the file
		size.setSize(nX, nY);
		
		//result[] is composed of BKGRND and FRONT
		return (result);
	}
	
	// pixels[] is assumed to be composed of FRONT and BKGRND only
	/** This method computes the Object weight of the input pixel array
	 * 
	 * @param pixels pixel array composed of Black & White ONLY
	 * @param size size of the image the pixel array is representing
	 * @return A double array containing the 4 weights
	 */
	public static double[] objectWeightPoint(int pixels[], Dimension size)	
	{
		int imageHeight = size.height;
		int imageWidth = size.width;
		
		double[] result = null;
		
		int sum = 0;
		float	xsum = 0,
				ysum = 0;
		for (int j=0; j<imageHeight; j++)
			for (int i=0; i<imageWidth; i++)
				if (pixels[j*imageWidth + i] == FRONT)
				{
					sum++;
					xsum += i;
					ysum += j;
				}
		if (sum != 0)
		{
			result = new double[2];
			result[0] = xsum / sum;
			result[1] = ysum / sum;
		}
		return (result);
	}
	
	/** This method computes the Object projection along the x-axis
	 * 
	 * @param pixels pixel array composed of Black & White ONLY
	 * @param w width of the image the pixel array is representing
	 * @param h height of the image the pixel array is representing
	 * @param theta theta value of the projection
	 * @return An int array of the computed values
	 */
	private int[] findObjectProjX(int pixels[], int w, int h, double theta)
	{
		// sum is the total number of the FRONT pixels
		int sum = 0;
		int width = w;
		int height = h;
		// Here, pxsum is the projection on x-axis 
		int pxsum[] = new int[width];
		int xthreshold = 0;
		
		// result[0] = left
		// result[1] = right
		int result[] = new int[2];
		
		for (int i=0; i<width; i++)
		{
			pxsum[i] = 0;
			for (int j=0; j<height; j++)
				if (pixels[j*width + i] == FRONT)
				{
					pxsum[i]++;
					sum++;
				}
		}
		
		// xthreshold is chosen to be 10%
		xthreshold = (int)(sum / (width * theta));
		if (xthreshold < 1)
			xthreshold = 1;
		
		for (int i=0; i<width; i++)
			if (pxsum[i] >= xthreshold)
			{
				result[0] = i;
				break;
			}
		for (int i=width-1; i>=0; i--)
			if (pxsum[i] >= xthreshold)
			{
				result[1] = i;
				break;
			}
			
		return (result);
	}
	
	/** This method computes the Object projection along the x-axis
	 * 
	 * @param pixels pixel array composed of Black & White ONLY
	 * @param w width of the image the pixel array is representing
	 * @param h height of the image the pixel array is representing
	 * @param theta theta value of the projectio
	 * @return An int array of the computed values
	 */
	private int[] findObjectProjY(int pixels[], int w, int h, double theta)
	{
		// sum is the total number of the FRONT pixels
		int sum = 0;
		int width = w;
		int height = h;
		// Here, pxsum is the projection on y-axis 
		int pysum[] = new int[height];
		int ythreshold = 0;
		
		// result[0] = top
		// result[1] = bottom
		int result[] = new int[2];
		
		for (int j=0; j<height; j++)
		{
			pysum[j] = 0;
			for (int i=0; i<width; i++)
				if (pixels[j*width + i] == FRONT)
					pysum[j]++;
		}
		
		// ythreshold is chosen to be 10%
		ythreshold = (int)(sum / (height * theta));
		if (ythreshold < 1)
			ythreshold = 1;
		for(int j=0; j<height; j++)
			if(pysum[j]>=ythreshold)
			{
				result[0] = j;
				break;
			}
		for(int j=height-1; j>=0; j--)
			if(pysum[j] >= ythreshold)
			{
				result[1] = j;
				break;
			}
			
		return (result);
	}

	/** This method computes the Object box values and return the corresponding array
	 * 
	 * @param pixels pixel array composed of Black & White ONLY
	 * @param size size of the image the pixel array is representing
	 * @param weight Object weight
	 * @return An int array of the computed values
	 */
	public int[] objectBoxCircumscribe(int pixels[], Dimension size, double weight[])
	{
		int width = size.width;
		int height = size.height;
		double theta = 0.1;
		// result[0] = left	result[1] = right
		// result[2] = top	result[3] = bottom
		int result[] = new int[4];
		int lr[] = findObjectProjX(pixels, width, height, theta);
		int tb[] = findObjectProjY(pixels, width, height, theta);
		
		// The center of the box obtained may not be the weight-center of the object (FRONT)
  		// Therefore, the box obtained should be improved
  		double xweight = weight[0];
  		double yweight = weight[1];
  		int lx = lr[0];	int rx = lr[1];
  		int ly = tb[0];	int ry = tb[1];
  		
  		// Adjust the interval on x-axis
		if( rx-xweight > xweight-lx)
			lx = (int)(xweight-(rx-xweight));
		else
			rx = (int)(xweight+(xweight-lx));
			
		if(lx < 0)
			lx=0;
		if(rx > width-1)
			rx = width-1;
			
		// Adjust the interval on y-axis
		if(ry-yweight > yweight-ly)
			ly = (int)(yweight-(ry-yweight));
		else
			ry = (int)(yweight+(yweight-ly));
			
		if(ly < 0)
			ly = 0;
		if(ry > height-1)
			ry = height-1;
		
		result[0] = lx;	result[1] = rx;
		result[2] = ly;	result[3] = ry;
		return (result);
	}
	
	/** This method computes the factorial of the input value
	 * 
	 * @param n The value to take factorial
	 * @return A double value of the computed value
	 */
	public double factorial(int n)
	{
		double result = 1;
		double sum = 1.0;
		
		if (n == 0)
			result = 1;
		else
		{
			for (int i=0; i<=n; i++)
				sum *= i;
		}
		
		return (result);
	}
	
	/** This method converts the XY coordinate to polar sense
	 * 
	 * @param x 
	 * @param y 
	 * @param centerx 
	 * @param centery 
	 * @return A double array containing the compued values
	 */
	public double[] convertXYToPolar(int x, int y, double centerx, double centery)
	{
		// result[0] = ruo
		// result[1] = sita
		double result[] = new double[2];
		
		double relativex = x-centerx;
		double relativey = y-centery;
		
		result[0] = Math.sqrt( (relativex*relativex) + (relativey*relativey) );
		if ( (Math.abs(relativey) < 1e-6) && (Math.abs(relativex) < 1e-6) )
			result[1] = 0.0;
		else 
			result[1] = Math.atan2(relativey,relativex);
			
		if(result[1] < 0) 
			result[1] += 2*PI;
			
		return (result);
	}

}