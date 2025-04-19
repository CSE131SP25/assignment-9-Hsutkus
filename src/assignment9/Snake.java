package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private static final double TRAIL_AMOUNT = 0.004;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	private double snakeX = 0.5;
	private double snakeY = 0.5;
	
	public Snake() {
		this.segments = new LinkedList<>();
		segments.add(new BodySegment(snakeX, snakeY, SEGMENT_SIZE));
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		
		for (int i = segments.size() - 1; i > 0; i--) {
	        BodySegment prev = segments.get(i - 1);
	        segments.get(i).setX(prev.getX());
	        segments.get(i).setY(prev.getY());
		}
		
		BodySegment bodySegment = segments.get(0);
		double newX = bodySegment.getX() + deltaX;
		double newY = bodySegment.getY() + deltaY;
		bodySegment.setX(newX);
		bodySegment.setY(newY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for(int i = 0; i < segments.size(); i++) {
			BodySegment bodySegment = segments.get(i);
			bodySegment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	
	public boolean eatFood(Food f) {
		if (Math.sqrt(Math.pow(segments.get(0).getX() - f.getX(), 2) + Math.pow(segments.get(0).getY() - f.getY(), 2)) <= SEGMENT_SIZE + f.getFoodSize()) {
			BodySegment tail = segments.get(segments.size()-1);
			BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE);
			segments.add(newSegment);
			
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		if (segments.get(0).getX() > SEGMENT_SIZE && segments.get(0).getX() < 1 - SEGMENT_SIZE && segments.get(0).getY() > SEGMENT_SIZE && segments.get(0).getY() < 1 - SEGMENT_SIZE) {
			return true;
		}
		return false;
	}
}
