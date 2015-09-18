package Game.code;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Game.code.graphics.Screen;
import Game.code.inputs.Keyboard;

public class Display extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 13 * 9;
	public static int scale = 3;
	private boolean running = false;

	public static String tittle = "Death Claw Alpha 0.0.6";

	private Thread thread;
	JFrame frame;
	private Screen screen;
	private Keyboard key;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public static void main(String[] args) {

		Display game = new Display();
		game.frame.setResizable(false);
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();

	}

	public Display() {

		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		frame = new JFrame();
		screen = new Screen(width, height);
		key = new Keyboard();
		addKeyListener(key);
	}

	public synchronized void start() {

		running = true;
		thread = new Thread(this, "Display");
		thread.start();

	}

	public synchronized void stop() {

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();

		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
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
				frame.setTitle(tittle + " ||F.P.S: " + frames + "  ,  " + "UPds: " + updates + " ||");
				updates = 0;
				frames = 0;
			}

		}

	}
int xos = 0;
int yos = 0;
	public void update() {
		key.update();
		if(key.up)yos--;
		
		if(key.down)yos++;

		if(key.right)xos++;

		if(key.left)xos--;
}

	public void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		screen.render(xos,yos);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];

		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();

	}
}
