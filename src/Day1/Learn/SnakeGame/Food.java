package Day1.Learn.SnakeGame;

import java.awt.*;
import java.util.Random;

public class Food {
    private int x;
    private int y;
    private final int SIZE = 20;
    private Color color;
    private Random random;

    public Food(int maxX, int maxY) {
        this.random = new Random();
        this.color = Color.RED;
        relocate(maxX, maxY);
    }

    public void relocate(int maxX, int maxY) {
        this.x = random.nextInt(maxX / SIZE) * SIZE;
        this.y = random.nextInt(maxY / SIZE) * SIZE;
        this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSIZE() {
        return SIZE;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, SIZE, SIZE);
    }
}
