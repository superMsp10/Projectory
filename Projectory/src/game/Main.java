package game;

import entity.menu.MainMenu;
import entity.mob.player.Player;
import game.graphics.Display;
import game.graphics.skins.Sprite;
import game.graphics.skins.SpriteSheet;
import game.inputs.Keyboard;
import game.inputs.Mouse;
import game.sounds.Sound;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import level.levels.Level;
import level.levels.MenuLevel;

public class Main extends Canvas implements Runnable {
	//main stuff
	private static final long serialVersionUID = 1L;

	JFrame frame;
	private Thread thread;

	public static int WIDTH = 250;
	public static int HEIGHT = (WIDTH / 3) * 2;
	public static int SCALE = 4;
	public boolean running = false;
	int yScroll = 0;
	int xScroll = 0;

	public String g;
	public static String TITLE = "Projectory 0.0.5";

	public static Display SCREEN;
	private Keyboard keyboard;
	private Mouse mouse;
	public static Cursor chcursor = new Cursor(1);
	private static Level currlevel;
	public static Player player1;
	private MainMenu startMenu;


	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	//SpriteSheet
	public static SpriteSheet FLOORS = new SpriteSheet("/textures/walls and floors.png", 256);
	public static SpriteSheet PLAYER = new SpriteSheet("/textures/player/playerSprite.png", 64);
	public static SpriteSheet MainMenus = new SpriteSheet("/textures/Menus/MainMenus.png", 1020);

	public Main() {
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		frame = new JFrame();
		SCREEN = new Display();
		keyboard = Keyboard.defKeyboard;
		mouse = new Mouse();
		currlevel = new MenuLevel(128, 128, mouse);
		player1 = new Player(keyboard, currlevel.width / 2, currlevel.height / 2, 20, 0xFF4D7AFD);
		addKeyListener(keyboard);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		setCursor(chcursor);
		startMenu = new MainMenu(Sprite.MainMenu, Sound.SMSL, mouse, (MenuLevel) currlevel);
		currlevel.add(startMenu);
		startMenu.init(currlevel);
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		SCREEN.clear();

		int playerX = (int) player1.getX();
		int playerY = (int) player1.getY();

		if (playerY < (currlevel.height << 3) - HEIGHT / 2 + 2 && playerY > (HEIGHT / 2) - 2) {
			yScroll = playerY;
		}

		if (playerX < (currlevel.width << 3) - WIDTH / 2 + 2 && playerX > (WIDTH / 2) - 2) {
			xScroll = playerX;
		}

		currlevel.render(xScroll - WIDTH / 2, yScroll - HEIGHT / 2);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = SCREEN.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public void update() {
		keyboard.update();
		currlevel.update();

	}

	public static void  setLevel(Level level) {
		currlevel = level;
	}


	public static void main(String[] args) {
		Main main = new Main();
		main.frame.setResizable(false);
		main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.frame.add(main);
		main.frame.pack();
		main.frame.setLocationRelativeTo(null);
		main.frame.setVisible(true);
		main.start();

	}

	public static int getWindowWidth() {
		return WIDTH * SCALE;
	}

	public static int getWindowHeight() {
		return HEIGHT * SCALE;
	}

	private void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();

	}

	public void run() {

		int frames = 0;
		int updates = 0;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();

		final double ns = 1000000000.0 / 60.0;
		double delta = 0;

		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				g = " ||frames/sec: " + frames + "  ---  " + "updates/sec: " + updates + "  || ";
				updates = 0;
				frames = 0;
			}
			frame.setTitle(TITLE + g + mouse.mouseX() + " " + mouse.mouseY());

		}

	}

	public synchronized void stop() {

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
