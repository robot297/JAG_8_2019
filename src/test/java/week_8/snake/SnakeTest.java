package week_8.snake;

import org.junit.Test;
import java.awt.*;
import java.awt.event.KeyEvent;


import static org.junit.Assert.*;


public class SnakeTest {
    
    @Test
    public void warpWallTest() throws Exception {
        
        // This program is not very well set up for testing, so this test is a bit hacky,
        // and doesn't cover the test posibilities very well.
        
        // Speed up timer, ensure snake faces right, hide kibble(?)
        // don't change direction, assert no game over
        // 'Press' up key. Assert snake doesn't die after wall collision
        // 'Press' left. assert snake doesn't die
        // 'Press' down. Assert snakes doesn't die
        
        Snake.speed = 100;
        Snake.nextMove = new int[]{1, 0};
        
        int vertSquares = Snake.height / Snake.squareSize;
        int horizontalSquares = Snake.width / Snake.squareSize;
        
        Snake game = new Snake();
    
        Thread.sleep(Snake.speed * 2);
    
        System.out.println(game.snake);
        
        // Three times around the board
        Thread.sleep( Snake.speed * horizontalSquares * 3);
        assertEquals(1, Snake.resets);    // one reset when game starts.
        
        // Move up
        game.keyPressed(new KeyEvent(game.snakePanel,0,0,0,KeyEvent.VK_UP, '\0', 0));
        Thread.sleep( Snake.speed * vertSquares * 3);
        assertEquals(1, Snake.resets);    // one reset when game starts.
        
        // Move left
        game.keyPressed(new KeyEvent(game.snakePanel,0,0,0,KeyEvent.VK_LEFT, '\0', 0));
        Thread.sleep( Snake.speed * horizontalSquares * 3);
        assertEquals(1, Snake.resets);    // one reset when game starts.
        
        // Move down
        game.keyPressed(new KeyEvent(game.snakePanel,0,0,0,KeyEvent.VK_DOWN, '\0', 0));
        Thread.sleep( Snake.speed * vertSquares * 3);
        assertEquals(1, Snake.resets);    // one reset when game starts.
        
        
        // A better test would look at the data structure and make
        // sure the snake is reappearing in the right place.
        // Define exact warp wall behavior, refactor code to make it more testable, write test.
        
        // Also check warping at the corners and edges
        // Also check what happens if the Snake eats a kibble while warping
        
    }
    
    @Test
    public void largerSizeTest() {
        
        int originalSquares = ( 300 / 50 ) * ( 400 / 50);
        
        int updatedSquares = ( Snake.height / Snake.squareSize )  * (Snake.width / Snake.squareSize);
        
        assertTrue("Increase the number of squares in the game", updatedSquares > originalSquares);
        
    }
    
    
    @Test
    public void changedColorTest() {
        
        assertNotEquals("Change the color of the snake.", Color.RED, Snake.SNAKE);
        assertNotEquals("Change the color of the kibble.", Color.BLUE, Snake.SNAKE);
        
    }
    
}