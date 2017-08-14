import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Archer extends Player {
	
	
	Image[][] ArcherDefault;
	Image[][] ArcherAttack;
	Image[] Arrow;
	
	
	Arrow ar;
	
	ArrayList arrowList =  new ArrayList();
	
 	
	public Archer(int x, int y){
		super(x,y);
		maxHp = 500;
		hp = 500;
		barrier = 200;
		speedOfAttack = 25;
		speedOfPlayer = 5;
		power = 0.2;
		
		ArcherDefault = new Image[4][9];
		for (int i = 0; i < ArcherDefault.length; ++i)
			for (int j = 0; j < ArcherDefault[i].length; ++j)
				ArcherDefault[i][j] = new ImageIcon("궁수 기본 " + i + "_" + j + ".png").getImage();
		
		ArcherAttack = new Image[4][12];
		for (int i = 0; i < ArcherAttack.length; ++i)
			for (int j = 0; j < ArcherAttack[i].length; ++j)
				ArcherAttack[i][j] = new ImageIcon("궁수 기본공격 " + i + "_" + j + ".png").getImage();
		
		Arrow = new Image[4];
		for(int i = 0; i < Arrow.length; i++)
			Arrow[i] = new ImageIcon("화살"+i+".png").getImage();	
	}
	
	public void Draw_human(Graphics g, ImageObserver frame) {
			if (playerMove) {
				if (Main.count / 5 % 9 == 0) {
					g.drawImage(ArcherDefault[moveStatus][0], charX, charY, frame);
				} else if (Main.count / 5 % 9 == 1) {
					g.drawImage(ArcherDefault[moveStatus][1], charX, charY, frame);
				} else if (Main.count / 5 % 9 == 2) {
					g.drawImage(ArcherDefault[moveStatus][2], charX, charY, frame);
				} else if (Main.count / 5 % 9 == 3) {
					g.drawImage(ArcherDefault[moveStatus][3], charX, charY, frame);
				} else if (Main.count / 5 % 9 == 4) {
					g.drawImage(ArcherDefault[moveStatus][4], charX, charY, frame);
				} else if (Main.count / 5 % 9 == 5) {
					g.drawImage(ArcherDefault[moveStatus][5], charX, charY, frame);
				} else if (Main.count / 5 % 9 == 6) {
					g.drawImage(ArcherDefault[moveStatus][6], charX, charY, frame);
				} else if (Main.count / 5 % 9 == 7) {
					g.drawImage(ArcherDefault[moveStatus][7], charX, charY, frame);
				} else { 
					g.drawImage(ArcherDefault[moveStatus][8], charX, charY, frame);
				}
			} else
				g.drawImage(ArcherDefault[moveStatus][0], charX, charY, frame);
	}
	
	
	public void attack() {
		
	}
	
	public void DrawAttack(Graphics g, ImageObserver frame){
		for(int i = 0;i < arrowList.size(); ++i){
			ar = (Arrow) arrowList.get(i);
			g.drawImage(ar.arrowImg, ar.x, ar.y, frame);
			ar.move();
			if(ar.x > Main.f_width)
				arrowList.remove(i);
			if(ar.y > Main.f_height)
				arrowList.remove(i);
		}
	}
	
	public void DrawAttackMontion(Graphics g, ImageObserver frame) {

		attackOnOff = false;
		attackCount = 0;

		g.setClip(charX, charY, Main.ImageWidthValue("캐릭터 기본.png") / 9, Main.ImageHeigthValue("캐릭터 기본.png") / 4);

		if (attackcnt >= 0 && attackcnt < 1) {
			g.drawImage(ArcherAttack[moveStatus][0], charX, charY, frame);
		} else if (attackcnt >= 1 && attackcnt < 2) {
			g.drawImage(ArcherAttack[moveStatus][1], charX, charY, frame);
		} else if (attackcnt >= 2 && attackcnt < 3) {
			g.drawImage(ArcherAttack[moveStatus][2], charX, charY, frame);
		} else if (attackcnt >= 3 && attackcnt < 4) {
			g.drawImage(ArcherAttack[moveStatus][3], charX, charY, frame);
		} else if (attackcnt >= 4 && attackcnt < 5) {
			g.drawImage(ArcherAttack[moveStatus][4], charX, charY, frame);
		} else if (attackcnt >= 5 && attackcnt < 6) {
			g.drawImage(ArcherAttack[moveStatus][5], charX, charY, frame);
		} else if (attackcnt >= 6 && attackcnt < 7) {
			g.drawImage(ArcherAttack[moveStatus][6], charX, charY, frame);
		} else if (attackcnt >= 7 && attackcnt < 8) {
			g.drawImage(ArcherAttack[moveStatus][7], charX, charY, frame);
		}else if (attackcnt >= 8 && attackcnt < 9) {
			g.drawImage(ArcherAttack[moveStatus][8], charX, charY, frame);
		}else if (attackcnt >= 9 && attackcnt < 10) {
			g.drawImage(ArcherAttack[moveStatus][9], charX, charY, frame);
		}else if (attackcnt >= 10 && attackcnt < 11) {
			g.drawImage(ArcherAttack[moveStatus][10], charX, charY, frame);
		}else 
			g.drawImage(ArcherAttack[moveStatus][11], charX, charY, frame);
		
		if (attackcnt == 9){
			ar = new Arrow(charX, charY, moveStatus);
			arrowList.add(ar);
		}

	}
	
	
	
	public void skill0() {

	}
	
	public void DrawSkill0(Graphics g, ImageObserver frame) {
		for(int i = 0;i < arrowList.size(); ++i){
			
		}
	}
	
	public void skill1() {

	}
	
	public void DrawSkill1(Graphics g, ImageObserver frame) {
		
	}
	
	public void skill2() {

	}
	
	public void DrawSkill2(Graphics g, ImageObserver frame) {
		
	}
	public void skill3() {

	}
	
	public void DrawSkill3(Graphics g, ImageObserver frame) {
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void skillProcess() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attackProcess(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		if(p.keySpace && p.attackOnOff){
			p.attackOn = true;
			getAttack();
		}
		if(p.attackOn)
			DrawAttackMontion(g1, frame);
		else
			Draw_human(g1, frame);
		
		DrawAttack(g, frame);
		
	}

	@Override
	public void skill0Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skill1Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skill2Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skill3Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		// TODO Auto-generated method stub
		
	}
	
	public void getAttack() {
		attackdirect = moveStatus;
		attackX = charX;
		attackY = charY;
	}

	public void getSkill0() {
		skill0direct = moveStatus;
		skill0X = charX;
		skill0Y = charY;
	}

	
	public void getSkill1() {
		skill1direct = moveStatus;
		skill1X = charX;
		skill1Y = charY;
		
	}

	
	public void getSkill2() {
		skill2direct = moveStatus;
		skill2X = charX;
		skill2Y = charY;
		
	}

	
	public void getSkill3() {
		skill3direct = moveStatus;
		skill3X = charX;
		skill3Y = charY;
		
	}

	@Override
	public void timer() {
		if(attackOn)
			attackcnt += 0.2;
		if(attackcnt > 12)
			attackOn = false;
		attackCount++;
		if(attackCount > 50){
			attackOnOff = true;
			attackcnt = 0;
		}
	}
	

	class Arrow{
		
		int x,y;
		int speed = 20;
		int direct;
		int plusX;
		int plusY;
		Image arrowImg;
		
		public Arrow(int x, int y, int direct){
			this.x = x;
			this.y = y;
			this.direct = direct;
			
			switch(direct){
			case 0:
				this.x += 30;
				this.plusX = 0;
				this.plusY = -speed;
				break;
			case 1:
				this.y += 30;
				this.plusX = -speed;
				this.plusY = 0;
				break;
			case 2:
				this.x += 30;
				this.y += 60;
				this.plusX = 0;
				this.plusY = speed;
				break;
			case 3:
				this.y += 30;
				this.x += 30;
				this.plusX = speed;
				this.plusY = 0;
				break;
			}
			
			arrowImg = new ImageIcon("화살"+direct+".png").getImage();
		}
		
		public Arrow(int x, int y, int direct, int skill){
			this.x = x;
			this.y = y;
			this.direct = direct;
			
			switch(direct){
			case 0:
				this.x += 30;
				break;
			case 1:
				this.y += 30;
				break;
			case 2:
				this.x += 30;
				this.y += 60;
				break;
			case 3:
				this.y += 30;
				this.x += 30;
				break;
			}
			
			switch(skill){
			case 0:
				break;

				
			}
			
			arrowImg = new ImageIcon("화살"+direct+".png").getImage();
		}
		
		public void move(){
			x += plusX;
			y += plusY;
			
		}
		
	}
	
}
