package com.sqc.war;
//����Ӣ�۲���ʼ��

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Hero extends JPanel{
//��һ���֣���̬������-��Ա����
	//1.��λ(�������λ��)
	private int x;
	private int y;
	
	//2.���(����)
	private int w;
	private int h;
	
	//3.Ӣ�ۻ���Ѫ����������
	public static final int ALL_BLOOD=100;
	
	//4.����
	private int score=0;//��Ϸ�ܷ���
	private int oneEnomyScore;//һ���л��ķ���
	
	//5.ʣ���Ѫ��
	private int blood;
	
	//6.���л����м��ٵ�ѪҺ����
	private int hitBlood;
	
	//7.�Ƿ񿪻�
	private boolean isFire;
	
	//8.Ӣ�ۻ�ͼ��
	private Image img;
	
	//9.����ͼ��
	private Image scoreImage;
	
	//10.����
	private Font font=null;
	
	//11.���
	private JPanel panel;
	
	//12.�ؿ�
	private int level=1;
	
	//���䳣����Ӣ�ۻ���ʡ�ԣ�
	public static final int UP=0;
	public static final int DOWN=1;
	
//�ڶ����֣���̬����-��Ա����
	//----------1.���췽������ɳ�ʼ��----------
		public Hero(){
			//��������������ۡ�ֵ������������
			//��������
			font=new Font("����",Font.BOLD,20);
		}
	
	//----------2.���Ʒ���������ʣ��Ѫ���ͷ���----------
		public void draw(Graphics g){
			//���ú���ɫ
			g.setColor(Color.red);
			//�����ַ�����������x,y����ʼд�֣�
			g.drawString("����", 1, 18);
			//��ʣ���Ѫ��д��ָ��λ��(���һ��������)
			g.fillRect(38, 10, this.getBlood(), 10);
			//д���÷���-1.������ʾ��Ϣ
			g.setFont(font);
			g.drawImage(scoreImage,5,20,15,18,panel);
			
			//д���÷���-2.��̬��ʾ
			g.drawString(String.valueOf(this.getScore()), 38, 35);
			
			//д���ڼ�����ʾ��Ϣ
			g.drawString("��ǰ�Ĺؿ�Ϊ��"+this.getLevel(), 260, 22);
			
			//Ҫ��ָ��λ����ʾ��Ӣ�ۻ�ͼ��
			g.drawImage(img, x, y, w, h, panel);
			//6��������ͼƬ���������ꡢ�������ꡢ�����ߡ���ʾ���λ��
		}

		
		//��15��������ֵ��ȡֵsetxxx()��getxxx()
		//ͨ��SourceԴ�����Զ�����set/get����-30��
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