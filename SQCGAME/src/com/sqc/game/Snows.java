package com.sqc.game;

import javax.swing.JFrame;

//����ѩ������ɶ���-Ʈѩ
public class Snows extends JFrame{
//�����������������addPanel()����ʾ����showMe()
//�̳д���,������
	
	//��һ���������������-�ڴ�����������������***
	public void addPanel(){		
		
		//����һ��������-�ο���׼��ϵͳ�Դ��������
		//JPanel panel=new JPanel();//���������panel
		
		//����һ��������-�ο��ֹ������������
		SnowPanel panel=new SnowPanel();//���������panel
		
		//���������뵽������
		this.add(panel);
		
		//��������һ����Ҫ������ѩ�ķ���:startDown()
		panel.startDown();
	}
	
	//�ڶ�����������ʾ����
	public void showMe(){
		this.setAlwaysOnTop(true);//��ʾ����ǰ
		this.setSize(800, 600);//��ʼ�������С
		this.setTitle("ѩ������");//���ñ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//����Ĭ�Ϲر�
		this.setLocationRelativeTo(null);//��Զ�λ����
		this.setVisible(true);//���ÿɼ���
	}
	
	//�ڳ�������ڵ���������������
	public static void main(String[] args) {
		//ʹ����Ĺ��췽�����ʵ��������������
		Snows s=new Snows();
		
		//���ö��󣬵������з���
		s.addPanel();//���������***
		s.showMe();//��ʾ����
	}
}