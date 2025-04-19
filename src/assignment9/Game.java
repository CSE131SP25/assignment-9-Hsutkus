package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake s1;
	private Food f1;
	private int score;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		this.score = 0;
		s1 = new Snake();
		f1 = new Food();
	}
	
	public void play() {
		while (s1.isInbounds()) { 
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			s1.changeDirection(dir);
			s1.move();
			if (s1.eatFood(f1)) {
				f1 = new Food();
				s1.eatFood(f1);
				this.score++;
			}
			this.updateDrawing();
		}
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	public void drawScore(int score) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.8, 0.9, "score: " + score);
	}
	
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		this.drawScore(score);
		s1.draw();
		f1.draw();
		StdDraw.pause(50);
		StdDraw.show();
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
