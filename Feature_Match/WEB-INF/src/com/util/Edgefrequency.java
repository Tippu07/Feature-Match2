package com.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

/** 
 *	It is a sub-class of the FeatureExtractionModule class.
 * It can get the edge frequency feature from a 
 * DiscovirImage class and return a 1024-dimension vector
 * to represent that image. It can compare 2 25-dimension
 * vectors and return their difference.
 */

public class Edgefrequency extends FeatureExtractionModule {

	/** 
	 * Constructor
	 * It is the constructor. It initialize some varibles which tell
	 * the feature name, feature length, feature category and version
	 * of this class. The varible _featureDescription tells the class
	 * can get the edge frequency from a DiscovirImage.
	 */

	public Edgefrequency () {
		super();
		this._featureName="Edgefrequency";
		this._featureLength=25;
		this._featureCategory="texture";
		this._featureVersion=new Double(1.0);
		this._featureDescription="Get the edge frequency.";

	};
	/**
	 * Method
	 * It gets the feature vector using default parameters
	 * and it will return a 25-dimension vector.
	 *
	 * @param image It is a DiscovirImage
	 * @return edgeFrequency It is a 25-dimension vector representing the image.
	 */



	public  Vector getFeatureVector(DiscovirImage image) {
		Vector edgeFrequency=new Vector(25);

		int i=0, k=0, up=0, down=0, left=0, right=0;
		double texture=0;
		int width=image.getWidth();
		int height=image.getHeight();
		int size=width*height;
		int[] pixels=image.getPackedRGBPixel();
		pixels = ColorConversion.RGB2grayscale(pixels, 256);

		int[] gradient = new int[size];

		for(i=1 ; i<50 ; i+=2){
			for(k=0 ; k<size ; k++){
				if(k >= i*width)
					up = Math.abs(pixels[k]-pixels[k-i*width]);
				else
					up = 0;

				if(((width*height)-k) > (i*width))
					down = Math.abs(pixels[k]-pixels[k+i*width]);
				else
					down = 0;

				if(i < (width-(k%width)))
					right = Math.abs(pixels[k]-pixels[k+i]);
				else
					right = 0;

				if(i <= (k%width))
					left = Math.abs(pixels[k]-pixels[k-i]);
				else
					left = 0;

				gradient[k]=up+down+right+left;
			}

			for(k=0 ; k<size ; k++)
				texture = texture + gradient[k];

			texture = texture/size;
			edgeFrequency.add(new Double(texture));
		}

		return edgeFrequency;
	}

	
	/**
	 * Method
	 * It gets the feature vector using user define parameters
	 * and it will return a d*d*64-dimension vector.
	 *
	 * @param image It is a DiscovirImage
	 * @return localColorHistogram It is a 1-dimension vector representing the image.
	 */


	public Vector getFeatureVector(DiscovirImage image, int d) {
		Vector edgeFrequency=new Vector(1);

		int k=0, up=0, down=0, left=0, right=0;
		double texture=0;
		int width=image.getWidth();
		int height=image.getHeight();
		int size=width*height;
		int[] pixels=image.getRGBPixel();
		int[] gradient = new int[size];

		for(k=0 ; k<size ; k++){
			if(k >= d*width)
				up = Math.abs(pixels[k]-pixels[k-d*width]);
			else
				up = 0;

			if(((width*height)-k) > (d*width))
				down = Math.abs(pixels[k]-pixels[k+d*width]);
			else
				down = 0;

			if(d < (width-(k%width)))
				right = Math.abs(pixels[k]-pixels[k+d]);
			else
				right = 0;

			if(d <= (k%width))
				left = Math.abs(pixels[k]-pixels[k-d]);
			else
				left = 0;

			gradient[k]=up+down+right+left;
		}

		for(k=0 ; k<size ; k++)
			texture = texture + gradient[k];

		texture = texture/size;
		edgeFrequency.add(new Double(texture));
		return edgeFrequency;
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
		return 1.0;
		//return 35.672;
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
	
/* Testing The Development */	
	
	public static void main(String[] args)
	{
		Vector<Double> featureVectorImgA1=null;
		BufferedImage img = null;
		String filePath = "Files/Search/C_0321_1.LEFT_CC.LJPEG.png";
		img = Edgefrequency.readImage(filePath);
		
		Edgefrequency e=new Edgefrequency();
		
		featureVectorImgA1=e.getFeatureVector(img);
		System.out.println("Features : "+featureVectorImgA1);
	}
}
