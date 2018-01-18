package com.sqc.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;


//此类专门为飘雪服务的
public class SnowPanel extends JPanel{
//此类要先继承面板类
	//两个重要方法	
	
	//提前定义变量
	private int[] xx;//整数数组存储横向坐标值
	private int[] yy;//整数数组存储纵向坐标值
	//上述数组变量来控制雪花的位置（x,y）坐标组合
	
	private Font[] fs;//字体类型数组，目的是控制大小，雪花会变
	
	
	//1.构造方法-初始化(静态)-系统中就有的
	//作用：完成面板设计-通过此类类创建面板
	public SnowPanel(){
		xx=new int[300];//横向坐标数组宽度
		yy=new int[300];//纵向坐标数组宽度
		fs=new Font[30];//规定字体数组的宽度
		
		//循环300次，产生300组的随机数，保证雪花xx,yy组合定位
		for (int i = 0; i < xx.length; i++) {
			xx[i]=(int)(800*Math.random());
			yy[i]=(int)(600*Math.random());
			//根据窗体大小来设计面板大小，在指定相同区域
		}
		
		//循环30次，产生不同大小的字体，存在数组fs中
		for (int i = 0; i < fs.length; i++) {
			//调用字体类Font中的构造方法处理字体
			//让雪花在循环时，再循环时随着字体自动增大
			fs[i]=new Font("黑体", Font.BOLD, 9+i);
			
		}
		
	}
	
	//2.飘雪方法-动作(动态)
	//作用：实现雪花飞舞效果
	public void startDown(){
		//动作控制要依靠线程来处理，先创建一个线程对象
//		Thread t=new Thread();
		//线程的几个重要方法
//		t.start();
//		t.run();
//		t.stop();
//		t.destroy();
		
		new Thread(){
			//运行代码开始
			public void run() {
				//条件判断+循环-开始
				while (true) {
					for(int i=0;i<yy.length;i++){
						yy[i]++;//纵向坐标值累加，雪花下落
						
						//补充：防止纵向坐标值（越界）
						if(yy[i]>=600){
							yy[i]=0;//如果雪花越界，从零开始
						}//if条件
					}//for循环结束
					
					repaint();//重新画一次雪花组件
					
					//为避免动作太快，要控制速度
					//建议让线程停滞一会儿（不是停止）
					try {
						Thread.sleep(100);//休眠
					} catch (InterruptedException e) {
						// 捕获线程的中断异常
						e.printStackTrace();
					}
										
					
				}//while 结束
				
				
			};//运行代码结束			
		}.start();//线程创建、且运行、开始
		
		
		
	}//开始飘雪	
	
	  
	
	//3.重新绘制出雪花界面
	@Override
		public void paint(Graphics g) {
			// 重写方法，绘制新图像
			super.paint(g);//调用父类方法
			
			//设置背景色-面板的背景(后)
			this.setBackground(Color.BLACK);
			//把画笔设为白色(前)
			g.setColor(Color.WHITE);
			
			//循环绘制(循环次数由多少坐标决定)
			for (int i = 0; i < xx.length; i++) {
				g.setFont(fs[i%10]);//每10朵雪花变个大小
				//画雪花-循环画出所有雪花
				g.drawString("*", xx[i], yy[i]);		
			}
		}
}
