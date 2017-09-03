/**
 * 
 */
package com.wr.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author soft1-3
 *
 */
public class UserServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		
		BufferedImage image=new BufferedImage(80,25,BufferedImage.TYPE_INT_RGB);
		
		Graphics g=image.getGraphics();
		
		g.setColor(new Color(255,255,255));
		
		g.fillRect(0, 0, 100,30);
		
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));		
		String number = getNumber(4);
		HttpSession session=request.getSession();
		session.setAttribute("number", number);
		g.setFont(new Font(null,Font.ITALIC,24));
		g.drawString(number, 5, 25);
		for(int i=0;i<4;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.drawLine(r.nextInt(80),r.nextInt(30),r.nextInt(80), r.nextInt(30));
		}
		response.setContentType("image/jpeg");		
		OutputStream ops=response.getOutputStream(); 		
		javax.imageio.ImageIO.write(image, "jpeg", ops);
		ops.close();
		
		
		
		
		
		
		
	}
	private String getNumber(int size) {
		String chars = 
			"ABCDEFGHIJKMN" +
			"PQRSTUVWXYZ23456789";
		Random r = new Random();
		String number = "";
		for(int i = 0; i < size; i ++){
			number += 
			chars.charAt(
				r.nextInt(
						chars.length()));
		}
		return number;
	}


}
