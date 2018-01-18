package com.sqc.war;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.util.concurrent.locks.Condition;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



//�����л�����ʼ����9��������
public class Enemy extends JPanel{
//��һ���֣���̬������-��Ա����
	//1.��λ(�������λ��)
	private int x;
	private int y;
	//2.���(����)
	private int w;
	private int h;
	//3.ͼ��
	private Image img;
	private Image deathimg;//���ű�ըͼ
	
//	private Image[] deadImages={
//		new ImageIcon("").getImage(),
//		new ImageIcon("").getImage()	
//	};
	
	//4.�ٶ�
	private int speed;
	//5.�ƶ�����
	private int direction;
	//6.���
	private JPanel panel;
	//7.����,��������L-Live D-Dead
	private String type;
	//���䳣�����л�����ʡ�ԣ�
	public static final int UP=0;
	//�л�������-�ٶ�   y-speed
	public static final int DOWN=1;
	//�л�������+�ٶ�   y+speed
	
//�ڶ����֣���̬����-��Ա����	

	//���䷽��1��draw()-�����л����л�δ����ͼ��
	public void draw(Graphics g){
		//������䣬��������type���Ƶл�����״̬
		if("L".equals(type)){//Live ��-δ����
			g.drawImage(img, x, y, w, h, panel);
			
		}else if("D".equals(type)){//Dead ��-����
			deathimg=new ImageIcon("/bomb.png").getImage();
			g.drawImage(deathimg, x, y, w, h, panel);
//			g.drawImage(deadImages[new Random().nextInt(3)], x, y, w, h, panel);
		}
	}
	
	//���䷽��2��move-���Ƶл����ƶ����ƶ�������ٶȣ�
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