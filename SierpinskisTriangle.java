/*
 * Written by Christian Rios
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class SierpinskisTriangle extends Canvas
{
	public static void main(String[] args) {
//The main method initializes the window, and here I made the window longer than it is tall in order for the white triangles to line up with the black triangle.
		JFrame frame = new JFrame("Sierpinski's Triangle");
		frame.setSize(1000,600);
		SierpinskisTriangle st = new SierpinskisTriangle();
		frame.add(st);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void paint(Graphics g)
//This is the paint method, used to call the methods that draw the triangles in the window.
	{
		initTriangle(0,0,this.getSize().height,g);
		
		drawTriangles(0,0,this.getSize().height,g);
	}
	
	
	public void drawTriangles(int x, int y, int side, Graphics g)
//This method is the recursive method that draws the white triangles on top of the black triangle.
	{
		int ysub = side/2;
		int xsub = side/4;
		int newx[] = {x+xsub*3,x+xsub*4,x+xsub*5};
		int newy[] = {y+ysub,y+ysub*2,y+ysub};
		int n = 3;
		Color myWhite = new Color(255,255,255);
		g.setColor(myWhite);
		g.fillPolygon(newx, newy, n);
		if(xsub>=20)
//I used the number 20 here so it wouldn't create so many triangles. The lower the number is, the more triangles appear.
		{
			drawTriangles(x+xsub, y+ysub, ysub, g);
			drawTriangles(x+xsub*2, y, ysub, g);
			drawTriangles(x+xsub*3, y+ysub, ysub, g);
			
		}
	
		
	}

	public void initTriangle(int x, int y, int side, Graphics g)
//This methods sets up the initial triangle, the large black triangle that acts as the frame for the rest of the triangles.
	{
		int ysub = side/2;
		int xsub = side/4;
		int xpoints[] = {x,x+side,x+side*2};
		int ypoints[] = {y+side*2, y, y+side*2};
		int n = 3;
		Color myBlack = new Color(0, 0, 0);
		//The rgb for black is 0,0,0 so that's what the numbers correspond to.
		g.setColor(myBlack);
		g.fillPolygon(xpoints, ypoints, n);
		//Since the fillPolygon command requires two integer arrays, I had to create two arrays, one for the x values of the triangle, and one for the y values.
	}
}
