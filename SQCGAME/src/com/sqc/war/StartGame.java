package com.sqc.war;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;

public class StartGame extends JFrame{
//1.完成界面设计（窗体、面板相关）
//继承窗体类JFrame
	//可将界面封装到一个方法中showWin()，便于代码复用
	//1.定义音乐对象
	private MusicPlayer bgMusic;
	private GamePanel panel;
	
	//2.在构造方法中初始化音乐
	public StartGame(){
		bgMusic=new MusicPlayer("/game_music.wav");
	}
	
	public void showWin(){
		//自定义显示窗口的方法
		//设置标题
		this.setTitle("飞机大战");
		//设置大小(优先级3)
		this.setSize(500, 700);
		//设置初始位置(x,y)和大小(优先级2)
		this.setBounds(400, 100, 500, 700);
		//设置居中对齐(优先级1)
		this.setLocationRelativeTo(null);
		//设置默认关闭操作
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//建议取消窗口放大功能
		this.setResizable(false);
		
		panel=new GamePanel();
		Thread t=new Thread(panel);
		t.start();
		this.add(panel);
		panel.setPanel(panel);
		this.addMouseListener(panel);
		this.addKeyListener(panel);
		this.addMouseMotionListener(panel);
		
//		//调用新面板类创建面板
//			NewPanel np=new NewPanel();	
//			this.add(np);		
			
//		//创建英雄飞机
//			TestPanel tPanel=new TestPanel();
//			this.add(tPanel);
			
		//3.显示窗口时开始放音乐
			this.bgMusic.play();
		
		//设置可见性（其它的初始化需要在这个之前）
		this.setVisible(true);
					
	}
	
	//添加小图标的方法
	public void addIcon() {
		//获得小图标路径
		String path="./image/GW.png";
		//将新获取的资源小图片替换掉原有的小图标
		//方法一：通过类取得图片资源
//			Image image=ImageIO.read(this.getClass().getResource(path));
		
		//方法二：通过工具集取得图像资源的
		Image img=Toolkit.getDefaultToolkit().getImage(path);
		this.setIconImage(img);
	}
		
	
	//2.给游戏界面美化：添加背景图
	//加载图像图标类ImageIcon、图像类Image
	//重写绘制图像的方法paint()或paintComponent()方法
	
	public static void main(String[] args) {
		//调用封装的方法，显示窗口界面
		StartGame sg=new StartGame();//用构造方法实例化
		sg.showWin();//显示窗体
		sg.addIcon();//在窗体上添加小图标（用户指定图标）
	}		
}
