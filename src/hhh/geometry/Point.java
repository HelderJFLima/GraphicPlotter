package hhh.geometry;

public class Point implements Comparable<Point> 	// An ordered pair of numerical values.
{
	private double x, y;
	private String label;
	
	// Setters:
	
	public void setX (double x)			// Inserts a value in 'x'.
	{
		this.x = x;
	}
	
	public void setY (double y)			// Inserts a value in 'y'.
	{
		this.y = y;
	}
	
	public void setLabel(String label)	// Inserts a name for the point.
	{
		this.label = label;
	}
	
	// Getters:
	
	public double getX()				// Gets the 'x' value.
	{
		return this.x;
	}
	
	public double getY()				// Gets the 'y' value.
	{
		return this.y;
	}
	
	public String getLabel()			// Gets the name of the point.
	{
		return this.label;
	}
	
	// Inherited method of interface Comparable:
	
	public int compareTo(Point other)
	{
		if (other == null)
			throw new NullPointerException("Inexistent point to compare!");
		
		else if (this.x != other.getX())
		{
			if (this.x < other.getX())
				return -1;
			
			else
				return 1;
		}
		else  		// Two points are equal if, and only if, their 'x' and 'y' values are equal.
		{
			if (this.y < other.getY())
				return -1;
			
			else if (this.y == other.getY())
				return 0;
			else
				return 1;
		}
	}
	
	// Constructor:
	
	Point (double x, double y) 			// Points without values of 'x' and 'y' cannot exist.
	{
		this.setX(x);
		
		this.setY(y);
	}
}
