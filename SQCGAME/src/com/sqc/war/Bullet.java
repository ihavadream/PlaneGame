package com.sqc.war;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Bullet extends JPanel{
//第一部分：静态的属性-成员变量	
	//1.定位(坐标控制位置)
	private int x;
	private int y;
	//2.规格(宽高)
	private int w;
	private int h;
	//3.图像
	private Image img;
	//4.速度
	private int speed;
	//5.移动方向
	private int direction;
	//6.面板
	private JPanel panel;
	//7.颜色
	private Color color;
	
	public static final int UP=0;
	public static final int DOWN=1;
	
//第二部分：动态处理-成员方法
	public void draw(Graphics g){
		g.drawImage(img, x, y, w, h, panel);
	}
	public void move(){
		switch (direction) {
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
	
	public Bullet() {
	super();
}
	
	public Bullet(int x, int y, int w, int h, Image img, int speed, int direction, JPanel panel, Color color) {
	super();
	this.x = x;
	this.y = y;
	this.w = w;
	this.h = h;
	this.img = img;
	this.speed = speed;
	this.direction = direction;
	this.panel = panel;
	this.color = color;
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
