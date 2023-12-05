package luckyBox;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ConfettiParticle {
	private int x;
	private int y;
	private int size;
	private Color color;
	private int speedX;
	private int speedY;
	private int fallSpeed;
	

public ConfettiParticle(int windowWidth, int windowHeight, int fallSpeed) {
    this.x = (int)(Math.random() * windowWidth);
    this.y = (int)(Math.random() * windowHeight);
    this.size = 10;
    this.color = getRandomColor();
    this.speedX = (new Random().nextInt(900)); // Random horizontal speed (-2 to 2 pixels)
    this.speedY = (new Random().nextInt(100)); // Random vertical speed (-2 to 2 pixels)
    this.fallSpeed = fallSpeed;
}

private Color getRandomColor() {
    Random random = new Random();
    int r = random.nextInt(256);
    int g = random.nextInt(256);
    int b = random.nextInt(256);
    return new Color(r, g, b);
}

public void move() {
    // Update the particle's position by adding random values for horizontal movement
    x += speedX;
    
    // Move the particle downward at a constant speed
    y += fallSpeed;
}

public void draw(Graphics g) {
    g.setColor(color);
    g.fillOval(x, y, size, size);
}

public int getY() {
    return y;
}
}






