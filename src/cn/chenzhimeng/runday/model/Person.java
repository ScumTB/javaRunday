package cn.chenzhimeng.runday.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.chenzhimeng.runday.controller.GameFrame;

/**
 * 
 * @author 陈志蒙 玩家实体类： 玩家类型：包括玩家的属性和功能
 */
public class Person {
	private BufferedImage image;// 玩家当前显示图片
	private BufferedImage[] images;// 玩家所有图片 即图片数组

	public static final int WIDTH = 70;// 玩家宽高
	public static final int HEIGHT = 90;

	// 玩家初始位置坐标
	private int x, y;
	private int index;// 图片切换的参数变量
	// 玩家得分
	private int score;
	// 玩家跑酷距离
	private int distance;

	public Person() {
		init();
		image = images[0];// 默认显示当前图片

		x = 50;
		y = 330;

		index = 0;
		score = 0;
		distance = 0;
	}

	// 玩家自由下落方法
	public void drop() {
		y++;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (y >= 330) {
			y = 330;
		}
	}

	// 玩家移动的方法
	public void step() {
		// 玩家图片的切换
		image = images[index++ / 60 % images.length];
		distance += 1;

	}

	// 绘制玩家的方法
	public void paintPerson(Graphics g) {
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}

	// 判断玩家是否越界
	public boolean outOfBounds() {
		return this.x >= GameFrame.WIDTH || this.x <= -WIDTH;
	}

	// 图片连续
	private void init() {
		images = new BufferedImage[9];
		for (int i = 0; i < images.length; i++) {
			try {
				images[i] = ImageIO.read(new File("image/" + (i + 1) + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 方法公开
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage[] getImages() {
		return images;
	}

	public void setImages(BufferedImage[] images) {
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

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int setDistance() {
		return distance;
	}

	public void getDistance(int distance) {
		this.distance = distance;
	}

	public int getTotalScore() {
		// TODO Auto-generated method stub
		return (int) (score * 1 + distance * 0.6);
	}

}
