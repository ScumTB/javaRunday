package cn.chenzhimeng.runday.model;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import cn.chenzhimeng.runday.controller.GameFrame;

/**
 * 金币障碍物 周六是客舍 周五布置课设内容
 * 
 * @author 
 * renwu 完成金币的出场
 *
 */

public class Barrs_2 {
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
	private BufferedImage image;
	private BufferedImage[] images;
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	private int x, y;
	Random random=new Random();

	public Barrs_2() {
		images = new BufferedImage[6];
		for(int i=0;i<images.length;i++) {
			try {
				images[i]=ImageIO.read(new File("image/"+(i+21)+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			image=images[random.nextInt(images.length)];
			x= GameFrame.WIDTH+random.nextInt(400);
			y=100+random.nextInt(250);
			
			
		
		}

	}
	public void step() {
		//应为金币是静态图片所以不需要切换 只是坐标的移动
		x--;
				
	}
	//绘制金币 对绘制金币的功能进行封装 到 各自类中
	public void paintBarrs_2(Graphics g) {
		 g.drawImage(image, x, y, WIDTH, HEIGHT, null);

	}
	public boolean outofBounds() {
	      return this.x<=-WIDTH;
	    }
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

	public Random getRandom() {
		return random;
	}
	public void setRandom(Random random) {
		this.random = random;
	}
	public static int getWidth() {
		return WIDTH;
	}
	public static int getHeight() {
		return HEIGHT;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
