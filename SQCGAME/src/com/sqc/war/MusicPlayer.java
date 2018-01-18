package com.sqc.war;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;


//通过音乐播放器类王超音乐文件的识别、读取、播放、停止等
public class MusicPlayer {
//提前定义对象
	private InputStream ins;//输入流
	private AudioStream as;//音频流
	private AudioPlayer ap;//音乐播放器
	
	public MusicPlayer(String name) {
		//准备：找音频文件的路径url
		//获取类.获取资源.获取路径
		String url=getClass().getResource(name).getPath();
		//准备：根据url找到file文件
		//不用sun的包，用java.io的包
		File file=new File(url);
		//处理音频文件 ins->as(要将输入流转换成音频流)
		//要导入文件输入输出流包，放在try...catch处理异常
		try {
			ins=new FileInputStream(file);
			as=new AudioStream(ins);//将文件变成歌曲
		} catch (FileNotFoundException e) {
			//文件异常
			e.printStackTrace();
		} catch (IOException e) {
			// 输入输出流异常
			e.printStackTrace();
		}
	}	
	
	public void play(){
		AudioPlayer.player.start(as);//开始播放-未定义
		//ap.start(as);//开始播放-定义
	}
	public void stop(){
		ap.stop(as);//停止播放
	}
}
