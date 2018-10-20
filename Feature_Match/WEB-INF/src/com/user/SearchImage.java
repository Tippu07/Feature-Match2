
package com.user;

import java.awt.image.BufferedImage;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cbir.AvgRGB;
import com.cbir.Distance;
import com.cbir.DistanceAvgRGB;
import com.cbir.ShapeGeometricMoment;
import com.cbir.TextureCoOcurrence;
import com.dao.AdminDAO;
import com.util.DistanceLocalHistogram;
import com.util.Edgefrequency;
import com.util.LocalColorHistogram;
import com.util.Utility;


@SuppressWarnings("serial")
public class SearchImage extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		//PrintWriter out1 = response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		boolean flag = false;
		int imageId = 0,Ra=0,Ga=0,Ba=0,Rb=0,Gb=0,Bb=0;//R = Red, G = Green, B = Blue
		double distance = 0,distance2 = 0,distance3 = 0;
		String fileName="",root = "",imageFileName="",filePath = "",classsificationName="";
		BufferedImage img = null;
		String feature="";
		String[] featureString;
		Double[] featureDoubles;
		Vector<Integer> avgRgbVal = null;
		Vector<Double> featureVectorImgA1 = null,featureVectorImgA2 = null,featureVectorImgB1 = null,featureVectorImgB2 = null;
		int totalNoOfImgInDb=0,noOfRecords = 0,classificationId=0;
		long start=0,end=0,f1ProcessingTime=0,f2ProcessingTime=0,f3ProcessingTime=0;
		
		try
		{
		   root = request.getRealPath("")+"\\Files\\Search\\";
		   //long startTime = System.currentTimeMillis();
		   start = System.nanoTime();
		 
		   if( session.getAttribute( "waitPage" ) == null ) 
		   {  
			   PrintWriter out = response.getWriter();
		 
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );
	    	   out.println("<section id='content' style='position: absolute;top:25;left:100px;width: 650px;'>");
	    	   out.println("<center>");
	    	   //out.println("<br>");
	    	   out.println("<font color='white' size='5'>");
	    	   out.println( "Wait Please...<br>" );
	    	   out.println( "Image Search Process is in Progress.....<br><br>" );
	    	   out.print( "<img src='res/images/spinner.gif'></img><br><br>");
	    	   out.println("<font color='red' size='5'>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println("</font><br>");
	    	   out.println("<font color='green' size='5'>");
	    	   out.println( "Images Are Getting Searched..... " );
	    	   out.println("</font><br>");
	    	   out.println( "Please wait....</h1><br>");  
	    	   out.println("</center>");
	    	   out.println("</section>");
	    	   out.close();  
		     }
			 else
			 {
				session.removeAttribute( "waitPage" );
				
				try
				{
					
					 fileName = (String) session.getAttribute("img_name");
					 filePath = root+fileName;
					 System.out.println("Selected Image File Path : " + filePath);
					 img = TextureCoOcurrence.readImage(filePath);
					 	
					 //1. All About Feature1 : TextureCoOcurrence (STARTS)	
							 featureVectorImgA1 = TextureCoOcurrence.getFeatureVector(img);
					 //All About Feature1 : TextureCoOcurrence (ENDS)
					
					
					 //2. All About Feature1 : Edgefrequency (STARTS)	
							 Edgefrequency e=new Edgefrequency();
							 featureVectorImgB1 = e.getFeatureVector(img);
					 //All About Feature2 : Edgefrequency (ENDS)
							 
					 //Getting Distance With All DB Files
					 root = request.getRealPath("")+"\\Files\\UploadedImg\\";
					 
				 
					 System.out.println("Feature1(Average RGB) Comparision is in Process.......................");
					 
					 rs = AdminDAO.getImage();
					 while(rs.next())
					 {
						totalNoOfImgInDb++;
						
						imageId = rs.getInt(1);
						fileName = rs.getString(2);
						filePath = root+fileName;
						//System.out.println("Image File Path : " + filePath);
						//img = TextureCoOcurrence.readImage(filePath);
						
						 //1. All About Feature1 : TextureCoOcurrence (STARTS)	
						
							//img = TextureCoOcurrence.readImage(filePath);
							//featureVectorImgA2 = TextureCoOcurrence.getFeatureVector(img);
							
							feature = AdminDAO.getImageFeature1(imageId);
							featureVectorImgA2 = Utility.getFeatureVector(feature);
						    distance = Distance.getDistance(featureVectorImgA1, featureVectorImgA2);
						    //Updating The Distance For Feature1
						    flag = AdminDAO.updateImgDist4Feature1(imageId,distance);
					    
					    //1. All About Feature1 : TextureCoOcurrence (ENDS)	
						    
						 //2. All About Feature2 : Edgefrequency (STARTS)	
							
							//featureVectorImgB2 = e.getFeatureVector(img);
							
							feature = AdminDAO.getImageFeature2(imageId);
							featureVectorImgB2 = Utility.getFeatureVector(feature);
						    distance2 = Distance.getDistance(featureVectorImgB1,featureVectorImgB2);
						    //Updating The Distance For Feature1
						    flag = AdminDAO.updateImgDist4Feature2(imageId,distance2);
					    
					     //2. All About Feature2 : Edgefrequency (ENDS)	    
							    
					 }
					 
					 end = System.nanoTime();
					 f1ProcessingTime = ((end - start) / 1000)/1000;//in Milliseconds
					 
					 System.out.println("Feature1 Processing Time : " + f1ProcessingTime+" Milliseconds");
					 System.out.println("Feature1 Comparision Completed Successfully..........");
					 
					 if(flag)
					 {
						 
						classificationId = AdminDAO.getClassifiedImageId();
						classsificationName = AdminDAO.getClassificationName(classificationId);
						
						//Getting The No. Of Images That Belongs To This Classification(STARTS)
						rs = AdminDAO.getClassifiedImageResult();
						// Point to the last row in resultset.  
						rs.last();
						int noOfclassifiedImg = rs.getRow();
						// Reposition at the beginning of the ResultSet to take up rs.next() call.  
						rs.beforeFirst();  
						System.out.println("No Of Classified Image : " + noOfclassifiedImg);
						//Getting The No. Of Images That Belongs To This Classification(ENDS)
						 
						request.setAttribute("tatal_img",totalNoOfImgInDb);
						request.setAttribute("no_classified_img",noOfclassifiedImg);
						request.setAttribute("f1_time",f1ProcessingTime);
						//request.setAttribute("f2_time",f2ProcessingTime);
						//request.setAttribute("f3_time",f3ProcessingTime);
						
						request.setAttribute("classsification_name",classsificationName);
						
						
						rd=request.getRequestDispatcher("/res/JSP/User/serach_img.jsp?no=22");
						rd.forward(request, response);
						
					 }
					 else
					 {
						rd=request.getRequestDispatcher("/res/JSP/User/serach_img.jsp?no=0&no1=2");
						rd.forward(request, response);
					 }
					
					
/*					//Delaying The Process Manually(Starts)
					try
				    {
				        Thread.currentThread().sleep(10000);
				    }
				    catch (InterruptedException e)
				    {
				        Thread.currentThread().interrupt();
				    }
					
					//Delaying The Process Manually(Starts)
*/				
					 
				}
				catch (Exception e)
				{
					System.out.println("Opps,Exception In SearchImage Servlet Main Block : " );
					e.printStackTrace();
					rd=request.getRequestDispatcher("/res/JSP/User/serach_img.jsp?no=0&no1=2");
					rd.forward(request, response);
				}
		   
			 }
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in SearchImage Servlet : ");
			e.printStackTrace();
			//out.println("Opps's Error is in SearchImage Servlet : "+e);
			rd=request.getRequestDispatcher("/res/JSP/User/serach_img.jsp?no=0&no1=2");
			try
			{
				rd.forward(request, response);
			} 
			catch (ServletException e1)
			{
				e1.printStackTrace();
			}
		}
	}
}
