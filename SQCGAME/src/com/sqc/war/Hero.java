package com.sqc.war;
//创建英雄并初始化

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Hero extends JPanel{
//第一部分：静态的属性-成员变量
	//1.定位(坐标控制位置)
	private int x;
	private int y;
	
	//2.规格(宽高)
	private int w;
	private int h;
	
	//3.英雄机总血量（常量）
	public static final int ALL_BLOOD=100;
	
	//4.分数
	private int score=0;//游戏总分数
	private int oneEnomyScore;//一个敌机的分数
	
	//5.剩余的血量
	private int blood;
	
	//6.被敌机击中减少的血液滴数
	private int hitBlood;
	
	//7.是否开火
	private boolean isFire;
	
	//8.英雄机图像
	private Image img;
	
	//9.分数图像
	private Image scoreImage;
	
	//10.字体
	private Font font=null;
	
	//11.面板
	private JPanel panel;
	
	//12.关卡
	private int level=1;
	
	//补充常量（英雄机可省略）
	public static final int UP=0;
	public static final int DOWN=1;
	
//第二部分：动态处理-成员方法
	//----------1.构造方法，完成初始化----------
		public Hero(){
			//定义对象最初的外观、值和其他参数等
			//定义字体
			font=new Font("宋体",Font.BOLD,20);
		}
	
	//----------2.绘制方法，绘制剩余血量和分数----------
		public void draw(Graphics g){
			//设置红颜色
			g.setColor(Color.red);
			//绘制字符串（从坐标x,y处开始写字）
			g.drawString("生命", 1, 18);
			//将剩余的血量写在指定位置(填充一个长方形)
			g.fillRect(38, 10, this.getBlood(), 10);
			//写出得分数-1.分数提示信息
			g.setFont(font);
			g.drawImage(scoreImage,5,20,15,18,panel);
			
			//写出得分数-2.动态显示
			g.drawString(String.valueOf(this.getScore()), 38, 35);
			
			//写出第几关提示信息
			g.drawString("当前的关卡为："+this.getLevel(), 260, 22);
			
			//要在指定位置显示出英雄机图像
			g.drawImage(img, x, y, w, h, panel);
			//6个参数：图片、横向坐标、纵向坐标、宽、高、显示面板位置
		}

		
		//对15个变量设值或取值setxxx()或getxxx()
		//通过Source源代码自动创建set/get方法-30个
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

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public int getOneEnomyScore() {
			return oneEnomyScore;
		}

		public void setOneEnomyScore(int oneEnomyScore) {
			this.oneEnomyScore = oneEnomyScore;
		}

		public int getBlood() {
			return blood;
		}

		public void setBlood(int blood) {
			this.blood = blood;
		}

		public int getHitBlood() {
			return hitBlood;
		}

		public void setHitBlood(int hitBlood) {
			this.hitBlood = hitBlood;
		}

		public boolean isFire() {
			return isFire;
		}

		public void setFire(boolean isFire) {
			this.isFire = isFire;
		}

		public Image getImg() {
			return img;
		}

		public void setImg(Image img) {
			this.img = img;
		}

		public Image getScoreImage() {
			return scoreImage;
		}

		public void setScoreImage(Image scoreImage) {
			this.scoreImage = scoreImage;
		}

		public static int getAllBlood() {
			return ALL_BLOOD;
		}

		public Font getFont() {
			return font;
		}

		public void setFont(Font font) {
			this.font = font;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public JPanel getPanel() {
			return panel;
		}

		public void setPanel(JPanel panel) {
			this.panel = panel;
		}
		
}
