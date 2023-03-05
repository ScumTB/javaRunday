package cn.chenzhimeng.runday.controller;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import cn.chenzhimeng.runday.controller.GamePanel;

/**
 * 
 * @author 
 *
 */
public class GameFrame extends JFrame{
	//设置窗体宽高属性
	public static final int WIDTH=1000;
	public static final int HEIGHT=550;
	public GameFrame(){
		//创建游戏面板对象
		GamePanel panel = new GamePanel();
		
		this.addKeyListener(panel);		
		this.add(panel);
		
		//设置窗体基本属性
		this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);//居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭按钮功能
		this.setUndecorated(true);//取消边框
		//设置LOGE图标
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setVisible(true);//可见
		panel.action();
	}

//	public static void main(String[] args) {
//		new GameFrame();
//
//	}

}
