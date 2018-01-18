package com.sqc.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;


//����ר��ΪƮѩ�����
public class SnowPanel extends JPanel{
//����Ҫ�ȼ̳������
	//������Ҫ����	
	
	//��ǰ�������
	private int[] xx;//��������洢��������ֵ
	private int[] yy;//��������洢��������ֵ
	//�����������������ѩ����λ�ã�x,y���������
	
	private Font[] fs;//�����������飬Ŀ���ǿ��ƴ�С��ѩ�����
	
	
	//1.���췽��-��ʼ��(��̬)-ϵͳ�о��е�
	//���ã����������-ͨ�������ഴ�����
	public SnowPanel(){
		xx=new int[300];//���������������
		yy=new int[300];//���������������
		fs=new Font[30];//�涨��������Ŀ���
		
		//ѭ��300�Σ�����300������������֤ѩ��xx,yy��϶�λ
		for (int i = 0; i < xx.length; i++) {
			xx[i]=(int)(800*Math.random());
			yy[i]=(int)(600*Math.random());
			//���ݴ����С���������С����ָ����ͬ����
		}
		
		//ѭ��30�Σ�������ͬ��С�����壬��������fs��
		for (int i = 0; i < fs.length; i++) {
			//����������Font�еĹ��췽����������
			//��ѩ����ѭ��ʱ����ѭ��ʱ���������Զ�����
			fs[i]=new Font("����", Font.BOLD, 9+i);
			
		}
		
	}
	
	//2.Ʈѩ����-����(��̬)
	//���ã�ʵ��ѩ������Ч��
	public void startDown(){
		//��������Ҫ�����߳����������ȴ���һ���̶߳���
//		Thread t=new Thread();
		//�̵߳ļ�����Ҫ����
//		t.start();
//		t.run();
//		t.stop();
//		t.destroy();
		
		new Thread(){
			//���д��뿪ʼ
			public void run() {
				//�����ж�+ѭ��-��ʼ
				while (true) {
					for(int i=0;i<yy.length;i++){
						yy[i]++;//��������ֵ�ۼӣ�ѩ������
						
						//���䣺��ֹ��������ֵ��Խ�磩
						if(yy[i]>=600){
							yy[i]=0;//���ѩ��Խ�磬���㿪ʼ
						}//if����
					}//forѭ������
					
					repaint();//���»�һ��ѩ�����
					
					//Ϊ���⶯��̫�죬Ҫ�����ٶ�
					//�������߳�ͣ��һ���������ֹͣ��
					try {
						Thread.sleep(100);//����
					} catch (InterruptedException e) {
						// �����̵߳��ж��쳣
						e.printStackTrace();
					}
										
					
				}//while ����
				
				
			};//���д������			
		}.start();//�̴߳����������С���ʼ
		
		
		
	}//��ʼƮѩ	
	
	  
	
	//3.���»��Ƴ�ѩ������
	@Override
		public void paint(Graphics g) {
			// ��д������������ͼ��
			super.paint(g);//���ø��෽��
			
			//���ñ���ɫ-���ı���(��)
			this.setBackground(Color.BLACK);
			//�ѻ�����Ϊ��ɫ(ǰ)
			g.setColor(Color.WHITE);
			
			//ѭ������(ѭ�������ɶ����������)
			for (int i = 0; i < xx.length; i++) {
				g.setFont(fs[i%10]);//ÿ10��ѩ�������С
				//��ѩ��-ѭ����������ѩ��
				g.drawString("*", xx[i], yy[i]);		
			}
		}
}