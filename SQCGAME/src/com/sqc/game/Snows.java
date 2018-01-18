package com.sqc.game;

import javax.swing.JFrame;

//绘制雪花，完成动作-飘雪
public class Snows extends JFrame{
//两个方法：添加面板addPanel()、显示方法showMe()
//继承窗体,完成设计
	
	//第一个方法：添加面板-在窗体基础上添加新面板***
	public void addPanel(){		
		
		//创建一个面板对象-参考标准的系统自带的面板类
		//JPanel panel=new JPanel();//产生新面板panel
		
		//创建一个面板对象-参考手工创建的面板类
		SnowPanel panel=new SnowPanel();//产生新面板panel
		
		//将新面板加入到窗体中
		this.add(panel);
		
		//调用面板的一个重要方法降雪的方法:startDown()
		panel.startDown();
	}
	
	//第二个方法：显示界面
	public void showMe(){
		this.setAlwaysOnTop(true);//显示在最前
		this.setSize(800, 600);//初始化窗体大小
		this.setTitle("雪花飞舞");//设置标题
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置默认关闭
		this.setLocationRelativeTo(null);//相对定位居中
		this.setVisible(true);//设置可见性
	}
	
	//在程序主入口调用上述两个方法
	public static void main(String[] args) {
		//使用类的构造方法完成实例化，创建对象
		Snows s=new Snows();
		
		//利用对象，调用类中方法
		s.addPanel();//添加新面板***
		s.showMe();//显示界面
	}
}
