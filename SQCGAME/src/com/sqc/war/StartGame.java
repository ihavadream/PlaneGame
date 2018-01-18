package com.sqc.war;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;

public class StartGame extends JFrame{
//1.��ɽ�����ƣ����塢�����أ�
//�̳д�����JFrame
	//�ɽ������װ��һ��������showWin()�����ڴ��븴��
	//1.�������ֶ���
	private MusicPlayer bgMusic;
	private GamePanel panel;
	
	//2.�ڹ��췽���г�ʼ������
	public StartGame(){
		bgMusic=new MusicPlayer("/game_music.wav");
	}
	
	public void showWin(){
		//�Զ�����ʾ���ڵķ���
		//���ñ���
		this.setTitle("�ɻ���ս");
		//���ô�С(���ȼ�3)
		this.setSize(500, 700);
		//���ó�ʼλ��(x,y)�ʹ�С(���ȼ�2)
		this.setBounds(400, 100, 500, 700);
		//���þ��ж���(���ȼ�1)
		this.setLocationRelativeTo(null);
		//����Ĭ�Ϲرղ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//����ȡ�����ڷŴ���
		this.setResizable(false);
		
		panel=new GamePanel();
		Thread t=new Thread(panel);
		t.start();
		this.add(panel);
		panel.setPanel(panel);
		this.addMouseListener(panel);
		this.addKeyListener(panel);
		this.addMouseMotionListener(panel);
		
//		//����������ഴ�����
//			NewPanel np=new NewPanel();	
//			this.add(np);		
			
//		//����Ӣ�۷ɻ�
//			TestPanel tPanel=new TestPanel();
//			this.add(tPanel);
			
		//3.��ʾ����ʱ��ʼ������
			this.bgMusic.play();
		
		//���ÿɼ��ԣ������ĳ�ʼ����Ҫ�����֮ǰ��
		this.setVisible(true);
					
	}
	
	//����Сͼ��ķ���
	public void addIcon() {
		//���Сͼ��·��
		String path="./image/GW.png";
		//���»�ȡ����ԴСͼƬ�滻��ԭ�е�Сͼ��
		//����һ��ͨ����ȡ��ͼƬ��Դ
//			Image image=ImageIO.read(this.getClass().getResource(path));
		
		//��������ͨ�����߼�ȡ��ͼ����Դ��
		Image img=Toolkit.getDefaultToolkit().getImage(path);
		this.setIconImage(img);
	}
		
	
	//2.����Ϸ�������������ӱ���ͼ
	//����ͼ��ͼ����ImageIcon��ͼ����Image
	//��д����ͼ��ķ���paint()��paintComponent()����
	
	public static void main(String[] args) {
		//���÷�װ�ķ�������ʾ���ڽ���
		StartGame sg=new StartGame();//�ù��췽��ʵ����
		sg.showWin();//��ʾ����
		sg.addIcon();//�ڴ���������Сͼ�꣨�û�ָ��ͼ�꣩
	}		
}