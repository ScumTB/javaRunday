package cn.chenzhimeng.runday.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import cn.chenzhimeng.runday.controller.GameFrame;

public class WindowFrame extends JFrame implements Runnable{
	JLabel background;//背景图片
	JProgressBar jdt;//进度条
	public WindowFrame(){
	background = new JLabel(new ImageIcon("image.jpg"));
	this.add(background,BorderLayout.NORTH);
	
	jdt = new JProgressBar();
	jdt.setBackground(Color.ORANGE);
	jdt.setStringPainted(true);//进度条以字符串的形式加载情况
	this.add(jdt,BorderLayout.SOUTH);
	this.setSize(568,340);
	this.setLocationRelativeTo(null);//居中显示
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭按钮功能
	this.setUndecorated(true);//取消边框
	//设置LOGE图标
	this.setIconImage(new ImageIcon("image/115.png").getImage());
	this.setVisible(true);//可见
	}
	public void start_TThread(){
		Thread t = new Thread(this);
		t.start();
		}
	public static void main(String[] args) {
		new WindowFrame().start_TThread();
		
	}
	public void run() {
		int [] values = {0,1,5,10,15,25,32,39,41,46,50,53,59,64,69,76,79,87,93,99,99,99,100};
		for(int i=0;i<values.length;i++){
			
			jdt.setValue(values[i]);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	new GameFrame();
}
}
