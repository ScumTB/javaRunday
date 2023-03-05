package cn.chenzhimeng.runday.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.io.File;

import javax.imageio.ImageIO;

import cn.chenzhimeng.runday.controller.GameFrame;

public class Barrs_1 {
	private Image image;
	private Image[] images;
	public static final int WIDTH = 70;
	public static final int HEIGHT = 90;
	private int x, y;
	private int index;
	private int speed;

//螃蟹
	public Barrs_1() {
		images = new Image[2];
		try {
			images[0] = ImageIO.read(new File("image/a2.png"));
			images[1] = ImageIO.read(new File("image/a4.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		image = images[0];
		x = GameFrame.WIDTH + 100;
		y = 330;
		speed = 2;
		index = 0;
	}

	public void step() {
		image = images[index++ / 120 % images.length];// 切换图片
		x -= speed;// 向左移动
	}

	public void paintBarrs(Graphics g) {
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}

	public boolean outofBounds() {
		return this.x <= -WIDTH;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image[] getImages() {
		return images;
	}

	public void setImages(Image[] images) {
		this.images = images;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

}