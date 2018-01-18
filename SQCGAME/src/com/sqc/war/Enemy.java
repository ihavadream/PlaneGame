package com.sqc.war;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.util.concurrent.locks.Condition;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



//创建敌机并初始化（9个变量）
public class Enemy extends JPanel{
//第一部分：静态的属性-成员变量
	//1.定位(坐标控制位置)
	private int x;
	private int y;
	//2.规格(宽高)
	private int w;
	private int h;
	//3.图像
	private Image img;
	private Image deathimg;//单张爆炸图
	
//	private Image[] deadImages={
//		new ImageIcon("").getImage(),
//		new ImageIcon("").getImage()	
//	};
	
	//4.速度
	private int speed;
	//5.移动方向
	private int direction;
	//6.面板
	private JPanel panel;
	//7.类型,掌握生死L-Live D-Dead
	private String type;
	//补充常量（敌机不可省略）
	public static final int UP=0;
	//敌机纵坐标-速度   y-speed
	public static final int DOWN=1;
	//敌机纵坐标+速度   y+speed
	
//第二部分：动态处理-成员方法	

	//补充方法1：draw()-画出敌机击中或未击中图像
	public void draw(Graphics g){
		//条件语句，根据类型type控制敌机生死状态
		if("L".equals(type)){//Live 活-未击中
			g.drawImage(img, x, y, w, h, panel);
			
		}else if("D".equals(type)){//Dead 死-击中
			deathimg=new ImageIcon("/bomb.png").getImage();
			g.drawImage(deathimg, x, y, w, h, panel);
//			g.drawImage(deadImages[new Random().nextInt(3)], x, y, w, h, panel);
		}
	}
	
	//补充方法2：move-控制敌机的移动（移动方向和速度）
	public void move(){
		switch(direction){
			case UP:
				y=y-speed;
				break;
			case DOWN:
				y=y+speed;
				break;
			default:
				break;
		}
	}
	
	public Enemy() {
	super();
}
	
	public Enemy(int x, int y, int w, int h, Image img, int speed, int direction, JPanel panel, String type) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.img = img;
		this.speed = speed;
		this.direction = direction;
		this.panel = panel;
		this.type = type;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
