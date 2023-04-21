package pack2;

import java.awt.Color;

public class Point {
	int x, y;
	boolean isFill;
	Color color;
	int shape;

	public Point(int x, int y, boolean isFill, Color color, int shape) {
		this.x = x;
		this.y = y;
		this.isFill = isFill;
		this.color = color;
		this.shape = shape;
	}

}
