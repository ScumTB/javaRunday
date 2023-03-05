package cn.chenzhimeng.runday.controller;

import java.awt.Color;

import java.awt.Font;
/**
 * @author scum
 *  主面板类:核心逻辑代码区
 *  背景图片 背景图片的滚动 玩家的实现 障碍物的实现 玩家的障碍物的碰撞逻辑 程序的暂停 继续 结束的逻辑
 *  1.背景图片的滚动效果
 *  2.显示玩家的动态效果 同时通过键盘来操作玩家的移动
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cn.chenzhimeng.runday.model.Barrs_1;
import cn.chenzhimeng.runday.model.Barrs_2;
import cn.chenzhimeng.runday.model.Barrs_3;
import cn.chenzhimeng.runday.model.Barrs_4;
import cn.chenzhimeng.runday.model.Person;
import cn.chenzhimeng.runday.controller.GameFrame;

//完成背景图片的滚动效果
public class GamePanel extends JPanel implements KeyListener { // 键盘事件监听
	Image background;// 背景图片
	Image score;// fenshu
	Person person;// 游戏角色
	Barrs_2 barrs_2;// 金币
	Barrs_4 barrs_4;// 导弹

	Barrs_1[] barrs1 = {};// 螃蟹有很多，数组
	Barrs_2[] barrs2 = {};// 金币也有很多
	Barrs_3[] barrs3 = {};
	Barrs_4[] barrs4 = {};// 鱼钩

	public GamePanel() {
		background = new ImageIcon("image/cc.png").getImage();
		try {
			score = ImageIO.read(new File("image/a12.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		person = new Person();
	}

	int x = 0;

	public void paint(Graphics g) {
		super.paint(g);
		x--;
		g.drawImage(background, x, 0, GameFrame.WIDTH, GameFrame.HEIGHT, null);
		g.drawImage(background, x + GameFrame.WIDTH, 0, GameFrame.WIDTH, GameFrame.HEIGHT, null);

		if (x <= -GameFrame.WIDTH) {
			x = 0;
		}
		// 绘制玩家
		g.drawImage(person.getImage(), person.getX(), person.getY(), person.getWidth(), person.getHeight(), null);

		g.drawImage(score, 10, 10, null);
		g.setColor(Color.orange);
		g.setFont(new Font("微软雅黑", Font.BOLD, 20));
		g.drawString("玩家得分：" + person.getScore() + "分", 25, 50);

		// 绘制 螃蟹 鱼钩到导弹 还有金币

		for (int i = 0; i < barrs1.length; i++) {
			barrs1[i].paintBarrs(g);
		}
		for (int i = 0; i < barrs2.length; i++) {
			barrs2[i].paintBarrs_2(g);
		}
		for (int i = 0; i < barrs3.length; i++) {
			barrs3[i].paintBarrs(g);
		}
		for (int i = 0; i < barrs4.length; i++) {
			barrs4[i].paintBarrs(g);
		}

	}

	int index = 0;

	// 实现生成障碍物的效果
	public void enteredAction() {
		index++;
		// 生成螃蟹障碍物
		// 250出现速度控制
		if (index % 250 == 0) {
			// 生成一个螃蟹
			Barrs_1 b1 = new Barrs_1();
			Barrs_3 b3 = new Barrs_3();
			Barrs_4 b4 = new Barrs_4();

			barrs1 = Arrays.copyOf(barrs1, barrs1.length + 1);// 数组扩容
			barrs1[barrs1.length - 1] = b1;// 放到数组最后一个元素的位置
			barrs3 = Arrays.copyOf(barrs3, barrs3.length + 1);
			barrs3[barrs3.length - 1] = b3;
			barrs4 = Arrays.copyOf(barrs4, barrs4.length + 1);
			barrs4[barrs4.length - 1] = b4;

			// 出现速度控制
			if (index % 15 == 0) {
				Barrs_2 b2 = new Barrs_2();
				barrs2 = Arrays.copyOf(barrs2, barrs2.length + 1);
				barrs2[barrs2.length - 1] = b2;
			}
		}
	}

	public void stepAction() {

		person.step();
		person.drop();

		// 螃蟹障碍物移动
		for (int i = 0; i < barrs1.length; i++) {
			barrs1[i].step();
			// 判断当前障碍物是否 越界，并做越界处理
			if (barrs1[i].outofBounds()) {
				// 删除越界的螃蟹障碍物
				barrs1[i] = barrs1[barrs1.length - 1];// 将螃蟹数组最后一个元素，赋给越界的螃蟹，覆盖了，相当于间接删除了。
				barrs1 = Arrays.copyOf(barrs1, barrs1.length - 1);// 数组缩容
			}
		}
		for (int i = 0; i < barrs4.length; i++) {
			barrs4[i].step();
			// 删除越界的鱼叉障碍物
			if (barrs4[i].outofBounds()) {
				barrs4[i] = barrs4[barrs4.length - 1];
				barrs4 = Arrays.copyOf(barrs4, barrs4.length - 1);
			}
		}
		for (int i = 0; i < barrs3.length; i++) {
			barrs3[i].step();
			// 删除越界的导弹障碍物
			if (barrs3[i].outofBounds()) {
				barrs3[i] = barrs3[barrs3.length - 1];
				barrs3 = Arrays.copyOf(barrs3, barrs3.length - 1);
			}
		}

		for (int i = 0; i < barrs2.length; i++) {
			barrs2[i].step();
			if (barrs2[i].outofBounds()) {
				// 删除越界的金币
				barrs2[i] = barrs2[barrs2.length - 1];
				barrs2 = Arrays.copyOf(barrs2, barrs2.length - 1);
			}
		}
	}

	public void pengAction() {
		for (int i = 0; i < barrs2.length; i++) {
			if (barrs2[i].getX() + barrs2[i].getWidth() >= person.getX()
					&& barrs2[i].getX() <= person.getX() + person.getWidth()
					&& barrs2[i].getY() + barrs2[i].getHeight() >= person.getY()
					&& person.getY() + person.getHeight() >= barrs2[i].getY()) {
				barrs2[i] = barrs2[barrs2.length - 1];
				barrs2 = Arrays.copyOf(barrs2, barrs2.length - 1);
				int score = person.getScore();
				person.setScore(score + 10);// 一个金币10分
				System.out.println(person.getScore());

			}
		}
		for (int i = 0; i <= barrs4.length - 1; i++) {
			if (person.getX() + Person.WIDTH >= barrs4[i].getX() && person.getX() <= barrs4[i].getX() + Barrs_4.WIDTH
					&& person.getY() + Person.HEIGHT >= barrs4[i].getY()
					&& person.getY() <= barrs4[i].getY() + Barrs_4.HEIGHT) {
				if (person.getX() + Person.WIDTH <= barrs4[i].getX() + Barrs_4.WIDTH) {

					person.setX(barrs4[i].getX() - Barrs_4.WIDTH);
				} else {

					person.setX(barrs4[i].getX() + Barrs_4.WIDTH);
				}
			}
		}
		//鱼钩
		for (int i = 0; i < barrs1.length; i++) {
			if (barrs1[i].getX() + barrs1[i].getWidth() >= person.getX()
					&& barrs1[i].getX() <= person.getX() + person.getWidth()
					&& barrs1[i].getY() + barrs1[i].getHeight() >= person.getY()
					&& person.getY() + person.getHeight() >= barrs1[i].getY()) {
				if (person.getX() + person.WIDTH <= barrs1[i].getX() + Barrs_1.WIDTH / 2) {
					person.setX(barrs1[i].getX() - person.WIDTH);
				} else {
					person.setX(barrs1[i].getX() + Barrs_1.WIDTH);
				}

			}
		}

		for (int i = 0; i < barrs3.length; i++) {
			if (person.getX() + Person.WIDTH >= barrs3[i].getX() && person.getX() <= barrs3[i].getX() + Barrs_3.WIDTH
					&& person.getY() + Person.getHeight() >= barrs3[i].getY()
					&& person.getY() <= barrs3[i].getY() + Barrs_3.HEIGHT) {
				if (person.getX() + Person.WIDTH <= barrs3[i].getX() + Barrs_3.WIDTH) {

					person.setX(barrs3[i].getX() - Barrs_3.WIDTH);
				} else {

					person.setX(barrs3[i].getX() + Barrs_3.WIDTH);
				}
			}
		}

	}

	// 结束逻辑
	public void gameOverAction() {
		if (person.outOfBounds()) {
			// 程序结束
			isGameOver = true;// 给isGameOver赋值为TRUE

			new EndFrame(person);

			person = new Person();
			barrs1 = new Barrs_1[] {};
			barrs3 = new Barrs_3[] {};

		}

	}

	public static boolean isGameOver = false;

	boolean flag = true;

	public void action() {
		new Thread() {
			// 线程里面的run方法
			public void run() {
				while (!isGameOver) {
					
					if (flag) {
						enteredAction();// 生成了障碍物
						stepAction();// 移动
						pengAction();// 玩家和障碍物碰撞
						gameOverAction();// 结束

					}
					// 重绘方法
					repaint();

					try {
						Thread.sleep(6); // 线程休眠
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}

			};
		}.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 按键盘时候执行的内容
		// 获取玩家当前位置坐标
		int x = person.getX();
		int y = person.getY();
		// 向右
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			person.setX(x + 20);
			if (person.getX() >= GameFrame.WIDTH - Person.WIDTH) {
				person.setX(GameFrame.WIDTH - Person.WIDTH);
			}
		}
		// 向左
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			person.setX(x - 20);
		}
		// 向上
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			person.setY(y - 100);
			if (person.getY() <= 10) {
				person.setY(10);
			}

		}
		// 游戏暂停
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			flag = !flag;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
