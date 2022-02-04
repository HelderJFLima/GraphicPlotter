package hhh.geometry;

import java.util.TreeSet;

public class PointsSet			// A set of ordered points with no repetition
{
	private Point point;
	private double[] limits = new double[4];		//Coordinates limits in this order: minX, maxX, minY, maxY.
	private TreeSet<Point> pset = new TreeSet<>();	// Set of points
	
	// Methods:
	
	public boolean addPoint(double x, double y, String label) 	// Adds a point to the set.
	{
		Point p;
		boolean t;
		
		p = new Point(x, y);
		
		p.setLabel(label);
		
		t = this.pset.add(p);
		
		if (t == false)
			return false;
		else
			return true;
	}
	
	public void clearPoints() 			// Removes all the points from the set.
	{
		this.pset.clear();
	}
	
	public void axisLimits() 			//Determines the coordinates limits.
	{
		Point p;
		
		if(!this.pset.isEmpty())
		{
			p = this.pset.first(); 							// First point (with lowest X value).
			
			this.limits[0] = this.limits[1] = p.getX(); 	// Initializes the limits values.
			
			this.limits[2] = this.limits[3] = p.getY();
			
			while(p != null)
			{
				p = this.pset.higher(p); 					// Next point
				
				if(p != null)
				{
					if(p.getX() > this.limits[1])  			// Maximum X
						this.limits[1] = p.getX();
					
					if(p.getY() < this.limits[2]) 			// Minimum Y
						this.limits[2] = p.getY();
					
					if(p.getY() > this.limits[3]) 			// Maximum Y
						this.limits[3] = p.getY();
				}
			}
		}
		else
			throw new NullPointerException("Empty set!");
	}
	
	public boolean putInFirstPosition()	// Sets a reference in the first point of the set.
	{
		if(!this.pset.isEmpty())
		{
			this.point = this.pset.first();
			
			return true;  					// Returns 'true' if there is a first point.
		}
		else
			return false;
	}
	
	public boolean putInNextPosition()	// Sets a reference in the next point of the set.
	{
		if(point == null)
			return false;
		else
		{
			this.point = this.pset.higher(point);
			
			if(point == null)
				return false;
			else
				return true; 				// Returns 'true' if there is a next point.
		}
	}
	
	// Getters:
	
 	public double getMinX() 			// Returns the minimum X value of the points.
	{
		return this.limits[0];
	}
	
	public double getMaxX() 			// Returns the maximum X value of the points.
	{
		return this.limits[1];
	}
	
	public double getMinY() 			// Returns the minimum Y value of the points.
	{
		return this.limits[2];
	}
	
	public double getMaxY() 			// Returns the maximum Y value of the points.
	{
		return this.limits[3];
	}
	
	public int getSize() 				// Returns the number of points in the set.
	{
		return this.pset.size();
	}
	
	public double getActualX()    		// Returns the X value of the actual referenced point.
	{
		if(this.point != null)
			return this.point.getX();
		else
			throw new NullPointerException("Null point!");
	}
	
	public double getActualY() 			// Returns the Y value of the actual referenced point.
	{
		if(this.point != null)
			return this.point.getY();
		else
			throw new NullPointerException("Null point!");
	}
	
	public String getActualLabel() 		// Returns the label of the actual referenced point.
	{
		if(this.point != null)
			return this.point.getLabel();
		else
			throw new NullPointerException("Null point!");
	}
	
	// Constructor:
	
	public PointsSet(){}
}
