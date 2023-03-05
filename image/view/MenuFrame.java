package cn.chenzhimeng.runday.view;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author 陈志蒙
 * @param <MenuBack>
 *
 */
public class MenuFrame extends JFrame implements MouseListener{
	JLabel start,help,exit;
	
	public MenuFrame(){
		start = new JLabel(new ImageIcon("image/hh1.png"));
		start.setBounds(280, 270, 150, 40);
		//设置start组件 不可用
		start.setEnabled(false);		
		start.addMouseListener(this);
		this.add(start);
		
		help = new JLabel(new ImageIcon("image/hh2.png"));
		help.setBounds(280, 350, 150, 40);
		//设置help组件 不可用
		help.setEnabled(false);
		help.addMouseListener(this);
		this.add(help);
		
		exit = new JLabel(new ImageIcon("image/hh3.png"));
		exit.setBounds(280, 430, 150, 40);
		//设置exit组件 不可用
		exit.setEnabled(false);
		exit.addMouseListener(this);
		this.add(exit);
		
		MenuBack back = new MenuBack();
		this.add(back);
			
		this.setSize(1000,550);
		this.setLocationRelativeTo(null);//居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭按钮功能
		this.setUndecorated(true);//取消边框
		//设置LOGE图标
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setVisible(true);//可见
		
	}
	public MenuFrame(JLabel start, JLabel help, JLabel exit)
			throws HeadlessException {
		super();
		this.start = start;
		this.help = help;
		this.exit = exit;
	}
	private void add(Menu back) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new MenuFrame();

	}
	class MenuBack extends JPanel{
		//声明背景图片变量
		Image backgorund;
		public  MenuBack() {
			//在构造方法中加载背景图片
			try {
				backgorund = ImageIO.read(new File("image/main.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//绘制方法
		@Override//          画笔的类型   一支画笔
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				g.drawImage(backgorund, 0, 0,1000,550, null);
			}
	  }
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(start)){
			new WindowFrame().start_TThread();
			
			dispose();}
			if(e.getSource().equals(help)){
				dispose();
				
			}
			if(e.getSource().equals(exit)){
				dispose();}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// 鼠标移入 执行的内容
		if(e.getSource().equals(start)){
			start.setEnabled(true);
		}
		if(e.getSource().equals(help)){
			help.setEnabled(true);
		}
		if(e.getSource().equals(exit)){
			exit.setEnabled(true);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// 鼠标移出 执行的内容
		if(e.getSource().equals(start)){
			start.setEnabled(false);
		}
		if(e.getSource().equals(help)){
			help.setEnabled(false);
		}
		if(e.getSource().equals(exit)){
			exit.setEnabled(false);
		}
	}

}
