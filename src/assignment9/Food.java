package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		this.x = 0.02 + Math.random() * (0.98-0.02);
		this.y = 0.02 + Math.random() * (0.98-0.02);
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(ColorUtils.transparentColor());
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getFoodSize() {
		return FOOD_SIZE;
	}
	
//	public static void main(String[] args) {
//		Food f1 = new Food();
//		f1.draw();
//	}
}
