package abstracts;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class CircleFactory implements ShapeFactory{
	
	@Override
	public Shape createShape(Point p) {
		int diametro = 50;
		return new Ellipse2D.Double(p.x - diametro, p.y - diametro, diametro * 2, diametro * 2);
	}

}
