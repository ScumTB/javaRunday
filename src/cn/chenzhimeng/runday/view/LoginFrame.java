package cn.chenzhimeng          .runday.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
	//定义用户名和密码属性
	JLabel username,password;//声明 没有创建对象
	JTextField usernameField;//定义用户名输入框
	JPasswordField passwordField;//定义密码输入框
	JButton login,cancel;//定义登录取消按钮
	public LoginFrame(){
		//创建用户名对象
		username = new JLabel("用户名");
		//对username进行布局（定位）
		username.setBounds(10, 150, 120, 30);
		this.add(username);
		//创建用户名输入框对象
		usernameField = new JTextField();
		//定位
		usernameField.setBounds(60, 150, 150, 30);
		//修饰文本框样式
		usernameField.setBorder(BorderFactory.createLoweredBevelBorder());//凹陷效果
		usernameField.setOpaque(false);//设置背景透明
		this.add(usernameField);
		//创建密码对象
		password = new JLabel("密 码");
		//对password进行布局（定位）
		password.setBounds(10, 200, 120, 30);
		this.add(password);
		//创建密码输入框对象
		passwordField = new JPasswordField();
		//定位
		passwordField.setBounds(60, 200, 150, 30);
		//修饰文本框样式
		passwordField.setBorder(BorderFactory.createLoweredBevelBorder());//凹陷效果
		passwordField.setOpaque(false);//设置背景透明
		this.add(passwordField);
		//创建登录对象
		login = new JButton("登录");
		//定位
		login.setBounds(60, 250, 120, 30);
		//添加登录按钮的功能
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 点击登录按钮时候 执行的内容
				//获取用户名输入框内容和密码输入框内容
				String username = usernameField.getText();
				String password = passwordField.getText();
				System.out.println("用户名为:"+username+"密码为:"+password);
				if(username.length()==0||password.length()==0){
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
					// ==用来比较整数的值 如果对字符串进行比较 ==比较的是地址值 而不是字符串内容
					//所以如果比较字符串内容是否相等 ,使用equals
				}else if(username.equals("1")&&password.equals("1")){
					JOptionPane.showMessageDialog(null, "欢迎"+username+"来到天天酷跑");
					//后续完成下一个界面的跳转
					new MenuFrame();
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
			}
		});
		
		this.add(login);
		//创建取消对象
		cancel = new JButton("取消");
		//定位
		cancel.setBounds(250, 250, 120, 30);
		//添加取消按钮的功能 点击 关闭窗体
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 点击按钮时候   执行的内容
				dispose(); //关闭窗体
			}
		});
		
		
		this.add(cancel);
		
		//创建背景面板，并添加到窗体上去
		LoginBack back = new LoginBack();
		this.add(back);
		
		this.setSize(599,330);
		this.setLocationRelativeTo(null);//居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭按钮功能
		this.setUndecorated(true);//取消边框
		//设置LOGE图标
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setVisible(true);//可见
	}

	public static void main1(String[] args) {
		new LoginFrame();
	}
	//面板内部类 :加载背景图片 login.jpg
class LoginBack extends JPanel{
	//声明背景图片变量
	Image backgorund;
	public LoginBack() {
		//在构造方法中加载背景图片
		try {
			backgorund = ImageIO.read(new File("image/login.jpg"));
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
			g.drawImage(backgorund, 0, 0, null);
		}
  }



	
	



	





	public static void main(String[] args) {
		new LoginFrame();

	}
class LoginBack1 extends JPanel{
	Image backgorund;
	public LoginBack1(){
		try {
			backgorund = ImageIO.read(new File("image/login.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(backgorund,0,0,null);
	}
}
}
