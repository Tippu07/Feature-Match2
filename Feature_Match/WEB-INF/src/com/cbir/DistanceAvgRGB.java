/**
 
 File : Distance.java
 Package : com.util
*/

package com.cbir;

import java.text.DecimalFormat;

public class DistanceAvgRGB
{
	public static double getDistanceImgA_ImgB(int Ra,int Ga,int Ba,int Rb,int Gb,int Bb)
	{
		double distance = 0;//Always 0-255
		double R=0,G=0,B=0,RGB=0;
		try 
		{
			/*//Reference
				//Math.pow ( x,y ); // x^y 		Ex: Math.pow ( 3,2 ); // 3^2 = 9
				System.out.println("3^2 = " + Math.pow ( 3,2 ));
				System.out.println("Math.sqrt(" + 9 + ") = " + Math.sqrt(9));//sqrt(9)=3.0
				
				//Formula
				d(Ia,Ib) = Math.sqrt((Math.pow ((Ra-Rb),2 )+Math.pow ((Ga-Gb),2 )+Math.pow ((Ba-Bb),2 ))/3)
			*/
			
			R = Math.pow ((Ra-Rb),2 );
			G = Math.pow ((Ga-Gb),2 );
			G = Math.pow ((Ba-Bb),2 );
			
			RGB = (R+G+B)/3;
			
			distance = Math.sqrt(RGB);
			
			//Rounding To 2 Decimal Points
			distance = roundTwoDecimals(distance);
		}
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In util-Distance==>getDistanceImgA_ImgB() :");
			e.printStackTrace();
		}
		
		return distance;
	}
	
	public static double roundTwoDecimals(double d) 
	{
		//double number = 651.5176515121351;
	    //The output will be 651.52
	    DecimalFormat twoDForm = new DecimalFormat("#.##");
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
		int Ra = 225,Ga = 215,Ba = 194;
		int Rb = 229,Gb = 218,Bb = 223;
		
		double distance = getDistanceImgA_ImgB(Ra, Ga, Ba, Rb, Gb, Bb);
		
		System.out.println("Distance : " + distance);
	}
}
