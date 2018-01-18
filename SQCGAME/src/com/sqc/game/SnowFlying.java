package com.sqc.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
//了解界面设计
public class SnowFlying extends JFrame{
//1.确定你的界面是哪种？JFrame/JPanel/JDialog？
//2.采取相应的继承类？与你选择有关。

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		JFrame jf=new JFrame();//创建新的窗体对象
		//根据新对象调用不同方法，解决不同问题
		
		//1.设置窗体大小
		jf.setSize(400, 600);
		
		//2.设置窗体的标题
		jf.setTitle("飞雪");
		
		//3.设置窗体的背景
		//背景色是由颜色类Color来控制的
		//为什么背景颜色不显示？设置只对新的面板有效，不会改变当前窗体，只要更新就可以了
		//jf.setBackground(Color.BLACK);
		
		//4.设置位置及初始大小(参数分别代表窗体的初始位置，及最初大小)
		//默认是从0,0原点开始的-屏幕左上角
		jf.setBounds(500, 100, 400, 600);
		
		//5.关闭窗口(默认关闭功能)
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//6.居中显示（设置定位相对对象为空）
		jf.setLocationRelativeTo(null);
		
		
		//将绘制图像的面板加入窗体中
		MyPanel mp=new MyPanel();//通过面板类的构造方法
		mp.setBackground(Color.BLACK);		
		jf.add(mp);//窗体jf中添加面板mp
		
		//设置窗体可见性（默认是不会显示的-false）
		jf.setVisible(true);
		
	}
}
	
	class MyPanel extends JPanel{

		private static final long serialVersionUID = 1L;
		@Override
		protected void paintComponent(Graphics g) {
			// 重写绘制组件的方法
			super.paintComponent(g);//调用父类方法
			
//=================第一组件：星星或雪花=================		
			//设置位置（坐标）
			int placex;//控制横向坐标
			int placey;//控制纵向坐标
			int size;//存放字体大小,控制星星或雪花大小
			//循环画出雪花或星星
			for(int i=0;i<500;i++){
				//使用Math类中的随机方法random()
				//random()方法返回的结果是0-1之间的小数
				double d=Math.random();
			//纵横坐标全用整数处理
			//随机取值大小由两个因素决定
				
				//1.随机方法random()方法取值大小
				//2.控制坐标大小的常量100的倍数
				placex=(int)(400*Math.random());//强制变坐标（由小数变整数）
				placey=(int)(500*Math.random());//保证x,y不全为0
				
			//字体大小也由随机数控制
				size=(int)(10*Math.random());
				
			//绘制雪花，规定颜色-通过默认的图像对象g
				g.setColor(Color.WHITE);
				g.drawString("*",placex,placey);
				this.setVisible(true);
				
		}
//=================第二组件：月亮==================		
			//用不同的方法来绘制:drawOval()-线   fillOval()-面
			//w,h画椭圆或正圆(两个相同的圆设置不同的颜色（一个与底色相同），则可以切割出月亮)
				//x,y控制位置     w,h控制半轴长
			placex=(int)(400*Math.random());
			g.setColor(Color.WHITE);
			g.fillOval(placex, 60, 80, 80);
			g.setColor(Color.BLACK);
			g.fillOval(placex+15, 55, 80, 80);
			g.setColor(Color.RED);
			g.fillOval(-50, -50, 100, 100);

//=================第三组件：大地==================	
			//绘制思路与星光月牙差不多
			//绘制大地坐标以窗体和面板w,h(宽高)来设计
			//x,是负数靠左，
			g.setColor(Color.GRAY);
			g.fillOval(-50,400,1000,400);
						
//=================第四组件：图片（加载或重绘）==================	
			//最重要的知识点：游戏中常用
			//变成图标icon
			ImageIcon icon=new ImageIcon("./image/bg1.jpg");
			//变成图像img（由图片对象变化而来）
			Image img=icon.getImage();
			//绘制出图像（由图片对象Graphics g）
			g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), this);
			//img-图像, x, y-绘制坐标0,0, width, height-图像宽高, observer-观察位置
			this.setVisible(true);
	}
}
