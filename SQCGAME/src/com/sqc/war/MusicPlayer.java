package com.sqc.war;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;


//ͨ�����ֲ����������������ļ���ʶ�𡢶�ȡ�����š�ֹͣ��
public class MusicPlayer {
//��ǰ�������
	private InputStream ins;//������
	private AudioStream as;//��Ƶ��
	private AudioPlayer ap;//���ֲ�����
	
	public MusicPlayer(String name) {
		//׼��������Ƶ�ļ���·��url
		//��ȡ��.��ȡ��Դ.��ȡ·��
		String url=getClass().getResource(name).getPath();
		//׼��������url�ҵ�file�ļ�
		//����sun�İ�����java.io�İ�
		File file=new File(url);
		//������Ƶ�ļ� ins->as(Ҫ��������ת������Ƶ��)
		//Ҫ�����ļ������������������try...catch�����쳣
		try {
			ins=new FileInputStream(file);
			as=new AudioStream(ins);//���ļ���ɸ���
		} catch (FileNotFoundException e) {
			//�ļ��쳣
			e.printStackTrace();
		} catch (IOException e) {
			// ����������쳣
			e.printStackTrace();
		}
	}	
	
	public void play(){
		AudioPlayer.player.start(as);//��ʼ����-δ����
		//ap.start(as);//��ʼ����-����
	}
	public void stop(){
		ap.stop(as);//ֹͣ����
	}
}