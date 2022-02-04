package hhh.geometry;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicWindow extends JFrame  		// Plots the points of a set on a graphic.
{
	private int MIN_X = 12;  						// Element's sizes
	private int MAX_X = 664;
	private int MIN_Y = 0;
	private int MAX_Y = 652;
	private int POINT_SIZE = 7;
	
	private int windowSize = MAX_X - MIN_X;
	private int tempX, tempY;
	private double graphSize, scale, height, width, correction;
	private boolean test = true;
	
	private static final long serialVersionUID = 1L;
	private JPanel window;
	
	public GraphicWindow(PointsSet points_set)
	{		
		try
		{
			points_set.axisLimits();   				// Calculates the maximum and minimum X and Y values.
		}
		catch (NullPointerException ex)
		{
			throw new NullPointerException("Empty set of points!");
		}
		
		this.width = Math.abs( points_set.getMaxX() - points_set.getMinX() );
		
		this.height = Math.abs( points_set.getMaxY() - points_set.getMinY() );
		
		this.graphSize = Math.max(width, height); 	// Graph dimension
		
		this.scale = 0.9 * windowSize / graphSize;  // Little adjust to fill the window correctly
		
		correction = windowSize / 2;      			// To correct the coordinates on the graph plotting
		
		window = new JPanel()
		{
			private static final long serialVersionUID = 1L;
			
			@Override
			
			public void paintComponent(Graphics g)
			{
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, window.getWidth(), window.getHeight());
				
				g.setColor(Color.BLUE);
/*				g.drawLine(0, 240, 640, 240);
				g.drawRect(10, 25, 20, 20);
				g.drawOval(30, 20, 40, 30);
				g.fillOval(MIN_X, MIN_Y, POINT_SIZE, POINT_SIZE);
				g.fillOval(MAX_X, MIN_Y, POINT_SIZE, POINT_SIZE);
				g.fillOval(MAX_X, MAX_Y, POINT_SIZE, POINT_SIZE);
				g.fillOval(MIN_X, MAX_Y, POINT_SIZE, POINT_SIZE); */
				
				if( points_set.putInFirstPosition() )
				{
					while(test)  					// "While there is a point to plot"
					{
						tempX = (int) Math.round( points_set.getActualX() * scale + correction );
						
						tempY = MAX_Y - (int) Math.round( points_set.getActualY() * scale + correction );
						
						g.fillOval(tempX, tempY, POINT_SIZE, POINT_SIZE);
						
						System.out.println(tempX + " " + " " + tempY + " " + points_set.getActualLabel());
						
						test = points_set.putInNextPosition();
					}
				}
				else
					throw new NullPointerException("Empty set of points!");
				
/*				g.setColor(Color.YELLOW);
				g.drawLine(320, 0, 320, 480);
				g.fillRect(110, 125, 120, 120);
				g.fillOval(230, 220, 240, 230);
				
				g.setColor(Color.RED);
				g.drawString("Eu seria um ótimo Score! ", 5, 10); */
			}
		};
		
		getContentPane().add(window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 700);
		setVisible(true);
		window.repaint();
	}
}
