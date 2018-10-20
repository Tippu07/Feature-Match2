package com.cbir;

import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.Vector;

public class Distance 
{
	public static double getDistance(Vector a, Vector b) 
	{
			double total = 0.0D,distance = 0.0D;	
			int noOfDimension = a.size();
			if (noOfDimension != b.size())
				return 99999.899999999994D;
			for (int i = 0; i < noOfDimension; i++) 
			{
				double doubleA = ((Double) a.elementAt(i)).doubleValue();
				double doubleB = ((Double) b.elementAt(i)).doubleValue();
				total += (doubleA - doubleB) * (doubleA - doubleB);
			}

			distance = Math.sqrt(total / (double) noOfDimension);
			distance = round4Decimals(distance);//Rounding To 4 Decimal Point
			return distance;
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
	
/* Testing The Development */	
	
	public static void main(String[] args) 
	{
		double distance = 0.0D;
		String filePath = "Files/test.jpg";
		String filePath1 = "Files/check.jpg";
		//String filePath1 = "Files/609.jpg";
		BufferedImage image = TextureCoOcurrence.readImage(filePath);
		BufferedImage image1 = TextureCoOcurrence.readImage(filePath1);
		
/*		//TextureCoOccurence
		System.out.println("Texture CoOccurence Image Feature");
		Vector a = TextureCoOcurrence.getFeatureVector(image);//TextureCoOccurence
		Vector b = TextureCoOcurrence.getFeatureVector(image1);//TextureCoOccurence
*/		
		
		//Shape GeometricMoment
		System.out.println("Shape GeometricMoment Image Feature");
		ShapeGeometricMoment gm = new ShapeGeometricMoment();
		Vector a = gm.getFeatureVector(image);//ShapeGeometricMoment
		Vector b = gm.getFeatureVector(image1);//ShapeGeometricMoment
	
		System.out.println("Image1 Fetaute Value : \n"+a);
		System.out.println("Image2 Fetaute Value : \n"+b);
		
		
		distance = Distance.getDistance(a, b);
		System.out.println("Distance : " + distance);
		
	}
}
