package com.sqc.war;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//测试对象情况
public class TestPanel extends JPanel{
	//1.定义图像
	public Image img;
	public Image imgBg;
	public Image bullet;
	public Image em;
	//造成英雄机
	Hero h=new Hero();
	
//在类的构造方法中显示对象
	public TestPanel() {
		
		//设英雄机的值
		//位置（将设置的x,y坐标定义为新变量）
		h.setX(150);
		h.setY(500);
		//规格-宽高
		h.setW(60);
		h.setH(60);
		h.setFire(false);//不开火
		//2.获取图像对象，两步合一（icon->image）	
		//定义游戏背景图
		img=new ImageIcon("./image/hero.png").getImage();
		imgBg=new ImageIcon("./image/bg1.jpg").getImage();
		bullet=new ImageIcon("./image/fire.png").getImage();
		em=new ImageIcon("./image/ep15.png").getImage();
	}
	@Override
		public void paint(Graphics g) {
			// 重绘方法，画出英雄机
			super.paint(g);
		//3步,先要图像变量+获取图像来源+画出此图
			//画出图像(先背景后飞机)				
			g.drawImage(imgBg, 0, 0, 500, 700, this);
			g.drawImage(img, h.getX(), h.getY(), null);
			g.drawImage(bullet, h.getX()+20, h.getY()-100, null);
			g.drawImage(em, h.getX()+8, h.getY()-300, null);
			//最后画分数、关卡信息
			
			h.draw(g);
		}
}
