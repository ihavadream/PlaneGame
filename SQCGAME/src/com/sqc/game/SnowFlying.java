package com.sqc.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
//�˽�������
public class SnowFlying extends JFrame{
//1.ȷ����Ľ��������֣�JFrame/JPanel/JDialog��
//2.��ȡ��Ӧ�ļ̳��ࣿ����ѡ���йء�

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		JFrame jf=new JFrame();//�����µĴ������
		//�����¶�����ò�ͬ�����������ͬ����
		
		//1.���ô����С
		jf.setSize(400, 600);
		
		//2.���ô���ı���
		jf.setTitle("��ѩ");
		
		//3.���ô���ı���
		//����ɫ������ɫ��Color�����Ƶ�
		//Ϊʲô������ɫ����ʾ������ֻ���µ������Ч������ı䵱ǰ���壬ֻҪ���¾Ϳ�����
		//jf.setBackground(Color.BLACK);
		
		//4.����λ�ü���ʼ��С(�����ֱ��������ĳ�ʼλ�ã��������С)
		//Ĭ���Ǵ�0,0ԭ�㿪ʼ��-��Ļ���Ͻ�
		jf.setBounds(500, 100, 400, 600);
		
		//5.�رմ���(Ĭ�Ϲرչ���)
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//6.������ʾ�����ö�λ��Զ���Ϊ�գ�
		jf.setLocationRelativeTo(null);
		
		
		//������ͼ��������봰����
		MyPanel mp=new MyPanel();//ͨ�������Ĺ��췽��
		mp.setBackground(Color.BLACK);		
		jf.add(mp);//����jf���������mp
		
		//���ô���ɼ��ԣ�Ĭ���ǲ�����ʾ��-false��
		jf.setVisible(true);
		
	}
}
	
	class MyPanel extends JPanel{

		private static final long serialVersionUID = 1L;
		@Override
		protected void paintComponent(Graphics g) {
			// ��д��������ķ���
			super.paintComponent(g);//���ø��෽��
			
//=================��һ��������ǻ�ѩ��=================		
			//����λ�ã����꣩
			int placex;//���ƺ�������
			int placey;//������������
			int size;//��������С,�������ǻ�ѩ����С
			//ѭ������ѩ��������
			for(int i=0;i<500;i++){
				//ʹ��Math���е��������random()
				//random()�������صĽ����0-1֮���С��
				double d=Math.random();
			//�ݺ�����ȫ����������
			//���ȡֵ��С���������ؾ���
				
				//1.�������random()����ȡֵ��С
				//2.���������С�ĳ���100�ı���
				placex=(int)(400*Math.random());//ǿ�Ʊ����꣨��С����������
				placey=(int)(500*Math.random());//��֤x,y��ȫΪ0
				
			//�����СҲ�����������
				size=(int)(10*Math.random());
				
			//����ѩ�����涨��ɫ-ͨ��Ĭ�ϵ�ͼ�����g
				g.setColor(Color.WHITE);
				g.drawString("*",placex,placey);
				this.setVisible(true);
				
		}
//=================�ڶ����������==================		
			//�ò�ͬ�ķ���������:drawOval()-��   fillOval()-��
			//w,h����Բ����Բ(������ͬ��Բ���ò�ͬ����ɫ��һ�����ɫ��ͬ����������и������)
				//x,y����λ��     w,h���ư��᳤
			placex=(int)(400*Math.random());
			g.setColor(Color.WHITE);
			g.fillOval(placex, 60, 80, 80);
			g.setColor(Color.BLACK);
			g.fillOval(placex+15, 55, 80, 80);
			g.setColor(Color.RED);
			g.fillOval(-50, -50, 100, 100);

//=================������������==================	
			//����˼·���ǹ��������
			//���ƴ�������Դ�������w,h(����)�����
			//x,�Ǹ�������
			g.setColor(Color.GRAY);
			g.fillOval(-50,400,1000,400);
						
//=================���������ͼƬ�����ػ��ػ棩==================	
			//����Ҫ��֪ʶ�㣺��Ϸ�г���
			//���ͼ��icon
			ImageIcon icon=new ImageIcon("./image/bg1.jpg");
			//���ͼ��img����ͼƬ����仯������
			Image img=icon.getImage();
			//���Ƴ�ͼ����ͼƬ����Graphics g��
			g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), this);
			//img-ͼ��, x, y-��������0,0, width, height-ͼ�����, observer-�۲�λ��
			this.setVisible(true);
	}
}