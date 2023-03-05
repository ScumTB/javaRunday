package cn.chenzhimeng.runday.controller;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import cn.chenzhimeng.runday.model.Person;
import cn.chenzhimeng.runday.view.MenuFrame;
import cn.chenzhimeng.runday.view.WindowFrame;
 
 
public class EndFrame extends JFrame implements MouseListener {
  //创建继续游戏按钮、返回主菜单按钮、退出按钮 
    JLabel again,back,exit;
 
  public EndFrame(Person person) { 
    again = new JLabel(new ImageIcon("image/hh5.png"));
    again.setBounds(300, 370, 150, 40);
    again.addMouseListener(this);
    this.add(again);  
    back = new JLabel(new ImageIcon("image/hh6.png"));
    back.setBounds(300, 470, 150, 40);
    back.addMouseListener(this);
    this.add(back);
    exit = new JLabel(new ImageIcon("image/hh3.png"));
    exit.setBounds(300, 570, 150, 40);
    exit.addMouseListener(this);
    this.add(exit);
 
    EndPanel end = new EndPanel(person);
    this.add(end);//将结束面板组件添加到结束窗口上
 
    this.setSize(1000, 650);
    this.setLocationRelativeTo(null);
    this.setUndecorated(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(new ImageIcon("image/115.png").getImage());
    this.setVisible(true);
  }
 
  public static void main(String[] args) { 

//new EndFrame(null);
  }
  class EndPanel extends JPanel{
    Image background;
    Person p;
    public EndPanel(Person person) {
      this.p = person;
      try {
        background = ImageIO.read(new File("image/chou.png"));
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    @Override
    public void paint(Graphics g) {
      // TODO Auto-generated method stub
      super.paint(g);
      g.drawImage(background, 0, 0,1000,650 ,null);
      g.setColor(Color.ORANGE);
      g.setFont(new Font("微软雅黑",Font.BOLD,30));
      g.drawString(p.getScore()+"",720,505);
      
      g.drawString(p.setDistance() + " ", 720, 455);
 
      g.setFont(new Font("微软雅黑",Font.BOLD,50));
      g.setColor(Color.ORANGE);
      g.drawString(p.getTotalScore() + "", 720, 370);
    }
  }
  @Override
  public void mouseClicked(MouseEvent e) {
    if(e.getSource().equals(again)){
      //跳转到下一界面  
        new WindowFrame().start_TThread();;
     
       dispose();
    }  else if(e.getSource().equals(back)){
      new MenuFrame();
    //关闭当前界面
      dispose();
    }else if(e.getSource().equals(exit)){
      System.exit(0);
    }
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
    // TODO Auto-generated method stub
 
  }
 
  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
 
  }
 
}