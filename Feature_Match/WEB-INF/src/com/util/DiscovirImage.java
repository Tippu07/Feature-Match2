/*
 *  IMAGE EXTRACTION LIBRARY

 */

package com.util;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.geom.*;

/**
 * Self Defined image class for the ease of reading image and passing to feature extraction module for processing
 */
public class DiscovirImage {
	/**
	 * The Actual Image content
	 */
	private BufferedImage _image;
	/**
	 * File name of the image file
	 */
	private String _filename;
	/**
	 * Color Model used in the _image
	 */
	private ColorModel _colorModel;
	
	/**
	 * Constructor accpeting a full path filename
	 */
	public DiscovirImage (String filename) {
		_image=null;
		this._filename=filename;
		
	}
	
	/**
	 * Constructor accpeting a file handle of type java.io.File
	 */
	public DiscovirImage (File fileHandle) {
		_image=null;
		try {
			this._filename=fileHandle.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Constructor accepting a java.awt.image.BufferedImage
	 */
	public DiscovirImage (BufferedImage image) {
		this._image=image;
		this._filename="temp";
	}
	
	/**
	 * Constructor accepting a java.awt.image.BufferedImage
	 */
	public DiscovirImage (BufferedImage image, String filename) {
		this._image=image;
		this._filename=filename;
	}
	
	/**
	 * Function to acutally load a image from the file to memory
	 * return : true - read successfully
	 *		  : false - read unsuccessfully
	 */
	public boolean readImage() {
		try {
			_image=ImageIO.read(new File(_filename));
			_colorModel=_image.getColorModel();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Get the width of image
	 */
	public int getWidth () {
		return _image.getWidth();
	}
	
	/**
	 * Get the height of image
	 */
	public int getHeight () {
		return _image.getHeight();
	}
	
	/**
	 * Get full path file name of the image
	 */
	public String getFileName () {
		return  _filename;
	}
	
	
	/**
	 * Get the packed pixel content of whole image
	 * return int[] - an array showing the [(packedRGB)(packedRGB)(packedRGB)....] value of the image in a row by row manner
	 */
	public int[] getPackedRGBPixel () {
		return _image.getRGB(0,0,_image.getWidth(),_image.getHeight(),null,0,_image.getWidth());
	}
	
	/**
	 * Get the pixel content of whole image
	 * return int[] - an array showing the [(RGB)(RGB)(RGB)....] value of the image in a row by row manner
	 */
	public int[] getRGBPixel () {
		int size=_image.getHeight()*_image.getWidth();
		int[] pixel=new int[size];
		int[] pixels=new int[size*3];
		
		PixelGrabber pg = new PixelGrabber(_image, 0, 0, _image.getWidth(), _image.getHeight(), pixel, 0, _image.getWidth());
		try
		{
			pg.grabPixels();
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			return null;
		}
		if ((pg.getStatus() & ImageObserver.ABORT) != 0)
		{
			System.out.println("Error in grabbing pixel");
			return null;
		}
		for (int i=0;i<size;i++) {
			pixels[i*3]  =(pixel[i] >> 16) & 0xff;
			pixels[i*3+1]=(pixel[i] >>  8) & 0xff;
			pixels[i*3+2]=(pixel[i]      ) & 0xff;
			//pixels[i*3]=_colorModel.getRed(pixel[i]);
			//pixels[i*3+1]=_colorModel.getGreen(pixel[i]);
			//pixels[i*3+2]=_colorModel.getBlue(pixel[i]);
		}
		return (pixels);
	}
	/**
	 * Get the RGB pixel value of a specific point sepcified by x,y
	 * return : and int value wiht RGB value packed of that particular pixel
	 */
	public int getPackedRGBPixel (int x, int y) {
		return _image.getRGB(x,y);
	}
	
	/**
	 * Get the RGB pixel value of a specific point sepcified by x,y
	 * return : and int array of the form [RGB] of that particular pixel
	 */
	public int[] getRGBPixel (int x, int y) {
		int[] pixel=new int[1];
		int[] pixels=new int[3];
		
		PixelGrabber pg = new PixelGrabber(_image, x, y, 1, 1, pixel, 0, _image.getWidth());
		try
		{
			pg.grabPixels();
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			return null;
		}
		if ((pg.getStatus() & ImageObserver.ABORT) != 0)
		{
			System.out.println("Error in grabbing pixel");
			return null;
		}

		pixels[0]=(pixel[0] >> 16) & 0xff;
		pixels[1]=(pixel[0] >>  8) & 0xff;
		pixels[2]=(pixel[0]      ) & 0xff;
		return (pixels);
	}
	
	/**
	 * Given a full path filename and the width and height, write the thumbnail version of image to that file
	 * the output format will be in jpeg
	 * return : true thumbnail generation success
	 *          false thumbnail generation fail
	 */
	public boolean generateThumbnail (String filename, int width, int height) {
		int originalWidth=_image.getWidth();
		int originalHeight=_image.getHeight();
		double x=(double)width/(double)originalWidth;
		double y=(double)height/(double)originalHeight;
		AffineTransformOp transformFilter=new AffineTransformOp(new AffineTransform(x,0.0,0.0,y,0.0,0.0),AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		// 5 because I don't konw the name of the color model, it should be BufferedImage.xxx
		BufferedImage dest=new BufferedImage(width,height,5);
		transformFilter.filter(_image,dest);
		File output=new File(filename);
		try {
			ImageIO.write(dest,"jpg",output);
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Given a full path filename , write the thumbnail version of image to that file
	 * the output format will be in jpeg, default size is at most 100x100 pixel
	 * return : true thumbnail generation success
	 *          false thumbnail generation fail
	 */
	public boolean generateDefaultThumbnail (String filename) {
		int x,y;
		if (_image.getWidth()>_image.getHeight()) {
			x=100;
			y=_image.getHeight()*100/_image.getWidth();
		} else {
			y=100;
			x=_image.getWidth()*100/_image.getHeight();
		}
		return generateThumbnail (filename,x,y);
	}
	
	/**
	 * Given the width and height, the current DiscovirImage is resized according to this parameter
	 */
	public void resize (int width, int height) {
		int originalWidth=_image.getWidth();
		int originalHeight=_image.getHeight();
		double x=(double)width/(double)originalWidth;
		double y=(double)height/(double)originalHeight;
		AffineTransformOp transformFilter=new AffineTransformOp(new AffineTransform(x,0.0,0.0,y,0.0,0.0),AffineTransformOp.TYPE_BILINEAR);
		BufferedImage dest=new BufferedImage(width,height,_image.getType());
		transformFilter.filter(_image,dest);
		_image=null;
		_image=dest;
	}
	
	/**
	 * Given the width and height, a new DiscovirImage resized to the given parameter is return
	 * The current DiscovirImage is unchanged.
	 */
	public DiscovirImage getResizedImage(int width, int height) {
		int originalWidth=_image.getWidth();
		int originalHeight=_image.getHeight();
		double x=(double)width/(double)originalWidth;
		double y=(double)height/(double)originalHeight;
		AffineTransformOp transformFilter=new AffineTransformOp(new AffineTransform(x,0.0,0.0,y,0.0,0.0),AffineTransformOp.TYPE_BILINEAR);
		BufferedImage dest=new BufferedImage(width,height,_image.getType());
		transformFilter.filter(_image,dest);
		return new DiscovirImage(dest,this._filename);
	}
	
	/**
	 * This function will blur the DiscovirImage by applying a filter
	 * [1/9 1/9 1/9]
	 * [1/9 1/9 1/9]
	 * [1/9 1/9 1/9]
	 */
	public void blur () {
		float weight = 1.0f/9.0f;
		float[] elements = new float[9]; // create 2D array

		// fill the array with nine equal elements
		for (int i = 0; i < 9; i++) {
   			elements[i] = weight;
		}
		// use the array of elements as argument to create a Kernel
		Kernel myKernel = new Kernel(3, 3, elements);
		//ConvolveOp simpleBlur = new ConvolveOp(myKernel);
		ConvolveOp simpleBlur = new ConvolveOp(myKernel, ConvolveOp.EDGE_NO_OP, null);

		// sourceImage and destImage are instances of BufferedImage
		
		if (_colorModel instanceof IndexColorModel) {
			// 5 because I don't know the name of the color model, it should be BufferedImage.xxx
			BufferedImage des = new BufferedImage(_image.getWidth(),_image.getHeight(),5);
			simpleBlur.filter(_image, des);
			_image=des;
		} else {
			BufferedImage des=new BufferedImage(_image.getWidth(),_image.getHeight(),_image.getType());
			//System.out.println(_image.getType());
			simpleBlur.filter(_image, des);
			_image=des;
		}
	}
	
	protected void finalize () throws Throwable {
		_image=null;
		_filename=null;
		_colorModel=null;
	}
}