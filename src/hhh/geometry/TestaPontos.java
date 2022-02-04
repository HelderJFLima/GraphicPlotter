package hhh.geometry;

public class TestaPontos
{
	public static void main(String[] args)
	{
		PointsSet pontos = new PointsSet();
		GraphicWindow graf;
//		Point p;
//		int n;
//		boolean test = true;
		
		pontos.addPoint(1.5, 2, "ponto01");
		pontos.addPoint(-2, 1.5, "ponto02");
		pontos.addPoint(0, 0, "ponto03");
		pontos.addPoint(5, 6.5, "ponto04");
		pontos.addPoint(-3, -5.7, "ponto05");
		pontos.addPoint(1, -1, "ponto06");
		pontos.addPoint(-3, 1, "ponto07");
		pontos.addPoint(4, -2, "ponto08");
		pontos.addPoint(3, 2.5, "ponto09");
		pontos.addPoint(0, -3, "ponto10");
		pontos.addPoint(3.5, 5, "ponto11");
		pontos.addPoint(-5, -3, "ponto12");
		
		graf = new GraphicWindow(pontos);
	}
}
		
/*		n = pontos.getSize();
		
		if(pontos.putInFirstPosition())
		{
			System.out.println("Pontos:\n");
			
			while(test)
			{
				System.out.println(pontos.getActualX()+" "+pontos.getActualY()+" "+pontos.getActualLabel());
				
				test = pontos.putInNextPosition();
			}
		}
		else
			System.out.println("Conjunto vazio!");
		
/*		if(!pontos.pset.isEmpty())
		{
			p = pontos.pset.first();
			
			System.out.println("Pontos:\n");
			
			System.out.println(p.getX()+" "+p.getY()+" "+p.getLabel());
			
			while(p != null)
			{
				p = pontos.pset.higher(p); 		// Next point
				
				if(p != null)
					System.out.println(p.getX()+" "+p.getY()+" "+p.getLabel());
			}
		}
		else
			System.out.println("Conjunto vazio!");
*/
/*		System.out.println("\nElementos: " + n);
		System.out.println("\nLimites:\n");
		System.out.println("Min X: " + pontos.getMinX());
		System.out.println("Max X: " + pontos.getMaxX());
		System.out.println("Min Y: " + pontos.getMinY());
		System.out.println("Max Y: " + pontos.getMaxY());
		
		pontos.axisLimits();
		
		System.out.println("\nMin X: " + pontos.getMinX());
		System.out.println("Max X: " + pontos.getMaxX());
		System.out.println("Min Y: " + pontos.getMinY());
		System.out.println("Max Y: " + pontos.getMaxY());
		
		pontos.clearPoints();
		
		n = pontos.getSize();
		
		System.out.println("\nElementos: " + n); */
		
//		pontos.getAxisLimits();
		
/*		System.out.println("There is points?: " + pontos.putInFirstPosition());
		
		System.out.println(pontos.getActualX()+" "+pontos.getActualY()+" "+pontos.getActualLabel());
	}
} */
