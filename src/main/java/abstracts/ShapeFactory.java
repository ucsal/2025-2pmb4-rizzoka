package abstracts;

import java.awt.Shape;

public interface ShapeFactory {
	Shape createShape(double x, double y, double width, double height);
}
