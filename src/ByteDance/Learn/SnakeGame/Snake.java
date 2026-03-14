package ByteDance.Learn.SnakeGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Point> body;
    private Direction direction;
    private final int SIZE = 20;
    private boolean growing;

    public Snake(int startX, int startY) {
        this.body = new ArrayList<>();
        this.direction = Direction.RIGHT;
        this.growing = false;
        
        // 初始化蛇的身体，长度为 3
        for (int i = 0; i < 3; i++) {
            body.add(new Point(startX - i * SIZE, startY));
        }
    }

    public void move() {
        Point head = getHead();
        int newX = head.x;
        int newY = head.y;

        switch (direction) {
            case UP:
                newY -= SIZE;
                break;
            case DOWN:
                newY += SIZE;
                break;
            case LEFT:
                newX -= SIZE;
                break;
            case RIGHT:
                newX += SIZE;
                break;
        }

        body.add(0, new Point(newX, newY));

        if (!growing) {
            body.remove(body.size() - 1);
        } else {
            growing = false;
        }
    }

    public void setDirection(Direction direction) {
        // 防止蛇直接掉头
        if ((this.direction == Direction.UP && direction != Direction.DOWN) ||
            (this.direction == Direction.DOWN && direction != Direction.UP) ||
            (this.direction == Direction.LEFT && direction != Direction.RIGHT) ||
            (this.direction == Direction.RIGHT && direction != Direction.LEFT)) {
            this.direction = direction;
        }
    }

    public void grow() {
        this.growing = true;
    }

    public Point getHead() {
        return body.get(0);
    }

    public List<Point> getBody() {
        return body;
    }

    public boolean checkCollision(int width, int height) {
        Point head = getHead();
        
        // 检查是否撞到墙壁
        if (head.x < 0 || head.x >= width || head.y < 0 || head.y >= height) {
            return true;
        }

        // 检查是否撞到自己
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }

        return false;
    }

    public boolean eats(Food food) {
        return getHead().x == food.getX() && getHead().y == food.getY();
    }

    public void draw(Graphics g) {
        for (int i = 0; i < body.size(); i++) {
            Point segment = body.get(i);
            if (i == 0) {
                g.setColor(Color.GREEN); // 蛇头是深绿色
            } else {
                g.setColor(new Color(144, 238, 144)); // 蛇身是浅绿色
            }
            g.fillRect(segment.x, segment.y, SIZE, SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(segment.x, segment.y, SIZE, SIZE);
        }
    }

    public int getSIZE() {
        return SIZE;
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }
}
