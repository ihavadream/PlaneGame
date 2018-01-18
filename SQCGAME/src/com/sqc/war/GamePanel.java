package com.sqc.war;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//����������࣬��ɽ�����ƣ�������䣨�ػ棩
public class GamePanel extends JPanel implements MouseListener,
MouseMotionListener,KeyListener,Runnable{

	private static final long serialVersionUID = 1L;
	//Ӣ�����һ������
	private Hero hero;
	//Ӣ�۷�����ӵ�����
	private ArrayList<Bullet> heroBullets;
	//Ӣ�۷����ӵ���ͼƬ
	private Image heroBulletImage;
	//����һ�����ϣ�������������ĵл�
	private ArrayList<Enemy> enemys;
	private ArrayList<Enemy> deadEnemys;
	//��������л�������
	private int num;
	private Random ran = new Random();
	//���屳��ͼ
		private Image imgBg;
		//���屳��ͼ���Ͻ�Y�������
		private int bgY;
		
		//�Ƿ�ͨ��
		private boolean pass;
		private Image[] enemyImages;
		private Image scoreImage;
		private GamePanel panel;
		
		public GamePanel(){
			hero = new Hero();			
			hero.setX(100);
			hero.setY(500);
			hero.setW(60);
			hero.setH(60);
			hero.setFire(false);
			hero.setBlood(Hero.ALL_BLOOD);
			hero.setHitBlood(5);
			hero.setOneEnomyScore(1000);
			hero.setPanel(this);
			hero.setImg(new ImageIcon(getClass().getResource("/hero.png")).getImage());
			scoreImage = new ImageIcon(getClass().getResource("/score.png")).getImage();
			hero.setScoreImage(scoreImage);
			
			//���ùؿ�
			hero.setLevel(1);
			heroBullets = new ArrayList<Bullet>();
			heroBulletImage = new ImageIcon(getClass().getResource("/fire.png")).getImage();
			enemys = new ArrayList<Enemy>();
			deadEnemys = new ArrayList<Enemy>();
			num = 6;
			enemyImages = new Image[15];
			for(int i = 1;i<=enemyImages.length;i++){
				if(i<10){
					enemyImages[i-1] = new ImageIcon(getClass().getResource("/ep"+i+".png")).getImage();
				}else{
					enemyImages[i-1] = new ImageIcon(getClass().getResource("/ep"+i+".png")).getImage();
				}
			}
			for (int j = 0; j < num; j++) {
				Enemy b2 = new Enemy();
				b2.setImg(enemyImages[ran.nextInt(100)%15]);
				b2.setW(b2.getImg().getWidth(null));
				b2.setH(b2.getImg().getHeight(null));
				b2.setX(ran.nextInt(400-b2.getImg().getWidth(null))+5);//+5ʹֵ�Ϸ�
				b2.setY(-ran.nextInt(700));
				b2.setDirection(Enemy.DOWN);
				b2.setType("L");
				b2.setSpeed(2);
				b2.setPanel(this);
				enemys.add(b2);
			}
			imgBg =new ImageIcon(getClass().getResource("/bg1.jpg")).getImage();
			bgY = -700;
		}
		public void restart(){
			hero.setX(100);
			hero.setY(500);
			hero.setFire(false);
			hero.setScore(0);
			hero.setBlood(Hero.ALL_BLOOD);
			hero.setScoreImage(scoreImage);
			enemys.clear();
			deadEnemys.clear();
			Image image = new ImageIcon(getClass().getResource("image/bomb.png")).getImage();
			for (int j = 0; j < num; j++) {
				Enemy b2 = new Enemy();
				b2.setW(50);
				b2.setH(50);
				b2.setX(ran.nextInt(400)+5);//+5ʹֵ�Ϸ�
				b2.setY(-ran.nextInt(700));
				b2.setDirection(Enemy.DOWN);
				b2.setType("L");
				b2.setSpeed(4);
				b2.setImg(image);
				//�����ǲ��ǿ���ִ��
				b2.setPanel(this);
				enemys.add(b2);
			}
			repaint();
		}
		public void paint(Graphics g){
			super.paint(g);
			g.drawImage(imgBg, 0, bgY,500,1400,this);
			//����Ӣ�ۻ����ӵ�
			for (int i = 0; i < heroBullets.size(); i++) {
				heroBullets.get(i).draw(g);
			}
			//���������ĵл�
			for (int j = 0; j < enemys.size(); j++) {
				enemys.get(j).draw(g);
			}
			//���Ʊ�ը�ĵл�
			for (int k = 0; k < deadEnemys.size(); k++) {
				deadEnemys.get(k).draw(g);
			}
			//����Ӣ�ۻ����÷֡�Ѫ�������ؿ�
			hero.draw(g);
			if(hero.getBlood()<=0){
				hero.setFire(false);
				Font font = new Font("����",Font.BOLD,36);
				g.setFont(font);
				g.drawString("Game Over!", 150, 300);
			}
			if(pass){
				Font font = new Font("����",Font.BOLD,36);
				g.setFont(font);
				g.drawString("��ϲͨ��!", 120, 300);
			}
		}
		
		
		public boolean  isHit(Enemy em,Bullet bt){
			boolean isHit = false;
	    	//�ӵ�����������
	    	int btx = bt.getX()+bt.getW()/2;
	    	int bty = bt.getY()+bt.getH()/2;
	    	//�ӵ��뾶
	    	int btr = bt.getW()/2;
	    	//�л���������
	    	int emx = em.getX()+em.getW()/2;
	    	int emy = em.getY()+em.getH()/2;
	    	//�л��뾶
	    	int emr = em.getW()<=em.getH()?em.getW()/3:em.getH()/3;
	    	//�������ľ����ƽ��
	    	int bes = (btx-emx)*(btx-emx)+(bty-emy)*(bty-emy);
	    	//�뾶�͵�ƽ��
	    	int berr = (btr+emr)*(btr+emr);
	    	//���ɵл������ģ����ࣩ�����ӵ�����ʾ�л�������
	    	if(berr>=bes){
	    		isHit = true;
	    	}
	    	return isHit;
		}
		//�ж�Ӣ�ۻ��͵л��Ƿ�����ײ
		public boolean  isHit(Enemy e,Hero h){
			boolean isHit = false;
	    	//Ӣ�ۻ�����������
	    	int hx1 = h.getX()+h.getW()/2;
	    	int hy1 = h.getY()+h.getH()/2;
	    	//���ɵл������ģ����ࣩ�����ӵ�����ʾ�л�������
	    	if(hx1>e.getX()&&hx1<e.getX()+e.getW()
	    			&&hy1>e.getY()&&hy1<e.getY()+e.getH()){
	    		isHit = true;
	    	}
	    	return isHit;
		}
		
	
	public void mouseClicked(MouseEvent e) {
		// ��굥��
		hero.setFire(true);
	}

	public void mousePressed(MouseEvent e) {
		//��갴��
		hero.setFire(true);
	}

	public void mouseReleased(MouseEvent e) {
		// ����ͷ�
		hero.setFire(false);
	}

	public void mouseEntered(MouseEvent e) {
		//���ȷ��
		
	}

	public void mouseExited(MouseEvent e) {
		//����˳�
		hero.setFire(false);
	}
	
	public void mouseDragged(MouseEvent e) {
		// �����ק
		if(hero.getBlood()>0&&!pass){
			hero.setFire(true);
			hero.setX((int) (e.getPoint().getX()-hero.getW()/2.0));
			hero.setY((int) (e.getPoint().getY()-hero.getH()/2.0));
			repaint();
		}
	}

	public void mouseMoved(MouseEvent e) {
		// ����ƶ�
		if(hero.getBlood()>0&&!pass){
			hero.setFire(true);
			hero.setX((int) (e.getPoint().getX()-hero.getW()/2.0));
			hero.setY((int) (e.getPoint().getY()-hero.getH()/2.0));
			repaint();
		}
	}

	public void keyTyped(KeyEvent e) {
		//����¼��
		
	}

	public void keyPressed(KeyEvent e) {
		// �����û�
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_F1){
			//���¿�ʼ
			hero.setBlood(Hero.ALL_BLOOD);
			hero.setScore(0);
			hero.setLevel(1);
			//��ʼ���л�
			for (int j = 0; j < num; j++) {
				Enemy b2 = enemys.get(j);
				b2.setX(ran.nextInt(425)+5);
				b2.setY(-ran.nextInt(640));
				b2.setSpeed(4);
			}
			//�����ӵ�
			new Thread(panel).start();
		}else if(e.getKeyCode()==KeyEvent.VK_UP){
			hero.setY(hero.getY()-3);
			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			hero.setX(hero.getX()+3);
			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			hero.setY(hero.getY()+3);
			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			hero.setX(hero.getX()-3);
			repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
		// �����ͷ�
		
	}
	
	public void run() {
		// ����
		int count = 0;
		int bgCount = 0;
		while(hero.getBlood()>0&&!pass){
			for (int i = 0; i < deadEnemys.size(); i++) {
				deadEnemys.remove(i);
			}
			//deadEnemys.removeAll(deadEnemys);
			if(hero.isFire()&&count%25==0){
				Bullet bullet = new Bullet();
				//bullet.setColor(Color.RED);
				bullet.setImg(heroBulletImage);
				bullet.setW(bullet.getImg().getWidth(null)/2);
				bullet.setH(bullet.getImg().getHeight(null)/2);
				bullet.setX(hero.getX()+hero.getW()/2-bullet.getW()/2);
				bullet.setY(hero.getY());
				bullet.setSpeed(20);
				bullet.setPanel(this);
				bullet.setDirection(Bullet.UP);
				heroBullets.add(bullet);
			}
			
			//�ƶ�Ӣ�۷�����ӵ�,����ɾ���ƶ����������
			for (int i = 0; i < heroBullets.size(); i++) {
				Bullet b1 = heroBullets.get(i);
				if(b1.getY()<=-b1.getH()){
					heroBullets.remove(i);
				}else{
					b1.move();
				}
			}
			for (int m = 0; m < enemys.size(); m++) {
				Enemy enemy = enemys.get(m);
				if(enemy.getY()>=640){
					enemy.setY(-enemy.getH());
					enemy.setX(ran.nextInt(395)+5);
					
				}else{
					enemy.move();
				}
			}
			//������ײ����
			for (int k = 0; k < enemys.size(); k++) {
				Enemy enemy = enemys.get(k);
				//�л���Ӣ�ۻ���ײ����
				if(isHit(enemy, hero)){
					hero.setBlood(hero.getBlood()-hero.getHitBlood());
					Enemy deadEnemy = new Enemy();
					deadEnemy.setType("D");
					deadEnemy.setX(enemy.getX());
					deadEnemy.setY(enemy.getY());
					deadEnemy.setW(enemy.getW());
					deadEnemy.setH(enemy.getH());
					deadEnemys.add(deadEnemy);
					
					enemy.setY(-enemy.getH());
					enemy.setX(ran.nextInt(425)+5);
				}
				//�л����ӵ���ײ����
				for (int n = 0; n < heroBullets.size(); n++) {
					if(isHit(enemy, heroBullets.get(n))){
						heroBullets.remove(n);
						Enemy deadEnemy = new Enemy();
						deadEnemy.setType("D");
						deadEnemy.setX(enemy.getX());
						deadEnemy.setY(enemy.getY());
						deadEnemy.setW(enemy.getW());
						deadEnemy.setH(enemy.getH());
						deadEnemys.add(deadEnemy);
						
						enemy.setY(-enemy.getH());
						enemy.setX(ran.nextInt(425)+5);
						enemy.setImg(enemyImages[ran.nextInt(100)%15]);
						enemy.setW(enemy.getImg().getWidth(null));
						enemy.setH(enemy.getImg().getHeight(null));
						hero.setScore(hero.getScore()+hero.getOneEnomyScore());
					}
				}
			}
			//����ͼ�����ƶ�
			if(bgY<0){
				if(bgCount%5==0){
					bgY++;
				}
			}else{
				hero.setLevel(hero.getLevel()+1);
				//�л��ٶ���ԭ���Ļ����ϼ�1
				for (int i = 0; i < enemys.size(); i++) {
					enemys.get(i).setSpeed(enemys.get(i).getSpeed()+1);
				}
				bgY=-720;
				if(hero.getLevel()==2){
					imgBg = new ImageIcon(getClass().getResource("/bg2.jpg")).getImage();
				}else if(hero.getLevel()==3){
					imgBg = new ImageIcon(getClass().getResource("/bg3.jpg")).getImage();
				}else{
					//ͨ��
					pass = true;
				}
			}
			bgCount++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			repaint();
		}
	}
	
	public GamePanel getPanel() {
		return panel;
	}
	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}
}
