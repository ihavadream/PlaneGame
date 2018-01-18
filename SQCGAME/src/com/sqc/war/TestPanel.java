package com.sqc.war;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//���Զ������
public class TestPanel extends JPanel{
	//1.����ͼ��
	public Image img;
	public Image imgBg;
	public Image bullet;
	public Image em;
	//���Ӣ�ۻ�
	Hero h=new Hero();
	
//����Ĺ��췽������ʾ����
	public TestPanel() {
		
		//��Ӣ�ۻ���ֵ
		//λ�ã������õ�x,y���궨��Ϊ�±�����
		h.setX(150);
		h.setY(500);
		//���-����
		h.setW(60);
		h.setH(60);
		h.setFire(false);//������
		//2.��ȡͼ�����������һ��icon->image��	
		//������Ϸ����ͼ
		img=new ImageIcon("./image/hero.png").getImage();
		imgBg=new ImageIcon("./image/bg1.jpg").getImage();
		bullet=new ImageIcon("./image/fire.png").getImage();
		em=new ImageIcon("./image/ep15.png").getImage();
	}
	@Override
		public void paint(Graphics g) {
			// �ػ淽��������Ӣ�ۻ�
			super.paint(g);
		//3��,��Ҫͼ�����+��ȡͼ����Դ+������ͼ
			//����ͼ��(�ȱ�����ɻ�)				
			g.drawImage(imgBg, 0, 0, 500, 700, this);
			g.drawImage(img, h.getX(), h.getY(), null);
			g.drawImage(bullet, h.getX()+20, h.getY()-100, null);
			g.drawImage(em, h.getX()+8, h.getY()-300, null);
			//��󻭷������ؿ���Ϣ
			
			h.draw(g);
		}
}