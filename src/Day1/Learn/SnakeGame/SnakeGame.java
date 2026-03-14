package Day1.Learn.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int DELAY = 150;

    private Snake snake;
    private Food food;
    private Timer timer;
    private int score;
    private boolean gameOver;
    private boolean gameStarted;
    private boolean paused;
    private JFrame frame;

    public SnakeGame() {
        initGame();
        setupPanel();
        setupKeyboard();
        startGame();
    }

    public void setupUI() {
        setupMenuBar();
    }

    private void initGame() {
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        food = new Food(WIDTH, HEIGHT);
        score = 0;
        gameOver = false;
        gameStarted = false;
        paused = false;
    }

    private void setupPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu gameMenu = new JMenu("Game");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAbout());
        gameMenu.add(aboutItem);
        
        menuBar.add(gameMenu);
        
        // Set the menu bar to the frame
        if (frame != null) {
            frame.setJMenuBar(menuBar);
        }
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this,
            "Snake Game\n\n" +
            "Author: Drew Jun\n" +
            "Created: 2026/3/14\n\n" +
            "How to Play:\n" +
            "- Use Arrow Keys or WASD to control the snake\n" +
            "- Eat the food to grow and score points\n" +
            "- Avoid hitting walls or yourself\n" +
            "- Press SPACE to start/pause/restart",
            "About Snake Game",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void setupKeyboard() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyCode());
            }
        });
    }

    private void handleKeyPress(int keyCode) {
        if (!gameStarted && keyCode == KeyEvent.VK_SPACE) {
            gameStarted = true;
            paused = false;
            return;
        }

        if (gameOver && keyCode == KeyEvent.VK_SPACE) {
            restartGame();
            return;
        }

        if (gameStarted && !gameOver && keyCode == KeyEvent.VK_SPACE) {
            paused = !paused;
            return;
        }

        if (!gameStarted || gameOver || paused) return;

        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                snake.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                snake.setDirection(Direction.RIGHT);
                break;
        }
    }

    private void startGame() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void restartGame() {
        initGame();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStarted && !gameOver && !paused) {
            snake.move();

            if (snake.checkCollision(WIDTH, HEIGHT)) {
                gameOver = true;
            }

            if (snake.eats(food)) {
                snake.grow();
                score += 10;
                food.relocate(WIDTH, HEIGHT);
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }

    private void drawGame(Graphics g) {
        if (!gameStarted) {
            drawStartScreen(g);
        } else {
            drawGameField(g);
            if (gameOver) {
                drawGameOver(g);
            } else if (paused) {
                drawPaused(g);
            }
        }
    }

    private void drawStartScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Snake Game", WIDTH / 2 - 60, HEIGHT / 2 - 40);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Press SPACE to start", WIDTH / 2 - 60, HEIGHT / 2);
        g.drawString("Use Arrow Keys or WASD", WIDTH / 2 - 75, HEIGHT / 2 + 30);
        g.drawString("Press SPACE to pause in using", WIDTH / 2 - 92, HEIGHT / 2 + 60);
    }

    private void drawGameField(Graphics g) {
        snake.draw(g);
        food.draw(g);
        drawScore(g);
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Score: " + score, 10, 20);
    }

    private void drawGameOver(Graphics g) {
        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString("Game Over!", WIDTH / 2 - 100, HEIGHT / 2 - 20);
        
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Final Score: " + score, WIDTH / 2 - 70, HEIGHT / 2 + 20);
        g.drawString("Press SPACE to restart", WIDTH / 2 - 80, HEIGHT / 2 + 50);
    }

    private void drawPaused(Graphics g) {
        g.setColor(new Color(0, 0, 0, 100));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString("Paused", WIDTH / 2 - 70, HEIGHT / 2 - 20);
        
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Press SPACE to continue", WIDTH / 2 - 75, HEIGHT / 2 + 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Snake Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            
            SnakeGame game = new SnakeGame();
            game.frame = frame;
            game.setupUI();
            frame.add(game);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
