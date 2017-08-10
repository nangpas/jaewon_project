import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Warrior extends Player {

	Skilltimer skilltimer;
	
	Image[][] WarriorDefault;
	Image[][] WarriorAttack;
	Image[] shieldBlock; 
	Image[] hpIncrease;
	
	public Warrior(int x, int y) {
		super(x, y);
		maxHp = 500;
		hp = 500;
		barrier = 200;
		speedOfAttack = 25;
		speedOfPlayer = 5;
		power = 0.2;


		shieldBlock = new Image[5];
		for (int i = 0; i < shieldBlock.length; ++i)
			shieldBlock[i] = new ImageIcon("보호막" + i + ".png").getImage();
		
		hpIncrease = new Image[7];
		for (int i = 0; i < hpIncrease.length; ++i)
			hpIncrease[i] =  new ImageIcon("체력 스킬 " + i + ".png").getImage();
		
		WarriorDefault = new Image[4][9];
		for (int i = 0; i < WarriorDefault.length; ++i)
			for (int j = 0; j < WarriorDefault[i].length; ++j)
				WarriorDefault[i][j] = new ImageIcon("전사 기본 " + i + "_" + j +".png").getImage();
		
		WarriorAttack = new Image[4][6];
		for (int i = 0; i < WarriorAttack.length; ++i)
			for (int j = 0; j < WarriorAttack[i].length; ++j)
				WarriorAttack[i][j] = new ImageIcon("전사 기본 공격 " + i + "_" + j +".png").getImage();
	}

	public Warrior() {
		super(0, 0);
		maxHp = 500;
		hp = 500;
		barrier = 5;
		speedOfAttack = 25;
		speedOfPlayer = 5;
		power = 0.2;

		shieldBlock = new Image[5];
		for (int i = 0; i < shieldBlock.length; ++i)
			shieldBlock[i] = new ImageIcon("보호막" + i + ".png").getImage();
		
		hpIncrease = new Image[7];
		for (int i = 0; i < hpIncrease.length; ++i)
			hpIncrease[i] =  new ImageIcon("체력 스킬 " + i + ".png").getImage();
		
		WarriorDefault = new Image[4][9];
		for (int i = 0; i < WarriorDefault.length; ++i)
			for (int j = 0; j < WarriorDefault[i].length; ++j)
				WarriorDefault[i][j] = new ImageIcon("전사 기본 " + i + "_" + j +".png").getImage();
		
		WarriorAttack = new Image[4][6];
		for (int i = 0; i < WarriorAttack.length; ++i)
			for (int j = 0; j < WarriorAttack[i].length; ++j)
				WarriorAttack[i][j] = new ImageIcon("전사 기본 공격 " + i + "_" + j +".png").getImage();
		
	}
	
	@Override
	public void Draw_human(Graphics g, ImageObserver frame) {
		
		if (playerMove) {
			if (Main.count / 5 % 9 == 0) {
				g.drawImage(WarriorDefault[moveStatus][0], charX ,charY, frame);
			} else if (Main.count / 5 % 9 == 1) {
				g.drawImage(WarriorDefault[moveStatus][1], charX ,charY, frame);
			} else if (Main.count / 5 % 9 == 2) {
				g.drawImage(WarriorDefault[moveStatus][2], charX ,charY, frame);
			} else if (Main.count / 5 % 9 == 3) {
				g.drawImage(WarriorDefault[moveStatus][3], charX ,charY, frame);
			} else if (Main.count / 5 % 9 == 4) {
				g.drawImage(WarriorDefault[moveStatus][4], charX ,charY, frame);
			} else if (Main.count / 5 % 9 == 5) {
				g.drawImage(WarriorDefault[moveStatus][5], charX ,charY, frame);
			} else if (Main.count / 5 % 9 == 6) {
				g.drawImage(WarriorDefault[moveStatus][6], charX ,charY, frame);
			} else if (Main.count / 5 % 9 == 7) {
				g.drawImage(WarriorDefault[moveStatus][7], charX ,charY, frame);
			} else {
				g.drawImage(WarriorDefault[moveStatus][8], charX ,charY, frame);
			}
		} else
			g.drawImage(WarriorDefault[moveStatus][0], charX ,charY, frame);
	
	}
	
	@Override
	public void attack() {
		Rectangle tmpRect;

		for (int i = 0; i < Main.monsterList.size(); i++) {
			Main.mon = (Monster) Main.monsterList.get(i);
			switch (moveStatus) {
			case 0:
				tmpRect = new Rectangle(charX + 8, charY - 13, 48, 25);
				if (Main.Crash(tmpRect, Main.mon.x, Main.mon.y, Main.monsterG[i]))
					Main.mon.hp -= power;
				if (Main.mon.hp <= 0)
					Main.monsterList.remove(i);
				break;
			case 2:
				tmpRect = new Rectangle(charX + 8, charY + 56, 48, 25);
				if (Main.Crash(tmpRect, Main.mon.x, Main.mon.y, Main.monsterG[i]))
					Main.mon.hp -= power;
				if (Main.mon.hp <= 0)
					Main.monsterList.remove(i);
				break;
			case 1:
				tmpRect = new Rectangle(charX - 15, charY + 8, 25, 48);
				if (Main.Crash(tmpRect, Main.mon.x, Main.mon.y, Main.monsterG[i]))
					Main.mon.hp -= power;
				if (Main.mon.hp <= 0)
					Main.monsterList.remove(i);
				break;
			case 3:
				tmpRect = new Rectangle(charX + 54, charY + 8, 25, 48);
				if (Main.Crash(tmpRect, Main.mon.x, Main.mon.y, Main.monsterG[i]))
					Main.mon.hp -= power;
				if (Main.mon.hp <= 0)
					Main.monsterList.remove(i);
				break;
			}
			System.out.println(Main.mon.hp);
		}
	}
	

	@Override
	public void DrawAttack(Graphics g, ImageObserver frame) {

		attatckOnOff = false;
		attackCount = 0;

		g.setClip(charX, charY, Main.ImageWidthValue("캐릭터 기본.png") / 9, Main.ImageHeigthValue("캐릭터 기본.png") / 4);

		if (attackcnt >= 0 && attackcnt < 1) {
			g.drawImage(WarriorAttack[moveStatus][0], charX, charY, frame);
		} else if (attackcnt >= 1 && attackcnt < 2) {
			g.drawImage(WarriorAttack[moveStatus][1], charX, charY, frame);
		} else if (attackcnt >= 2 && attackcnt < 3) {
			g.drawImage(WarriorAttack[moveStatus][2], charX, charY, frame);
		} else if (attackcnt >= 3 && attackcnt < 4) {
			g.drawImage(WarriorAttack[moveStatus][3], charX, charY, frame);
		} else if (attackcnt >= 4 && attackcnt < 5) {
			g.drawImage(WarriorAttack[moveStatus][4], charX, charY, frame);
		} else if (attackcnt >= 5 && attackcnt < 6) {
			g.drawImage(WarriorAttack[moveStatus][5], charX, charY, frame);
		}
		
	}

	@Override
	// 방패 막기 스킬 충돌
	public void skill0() {
		for(int i = 0; i < Main.missileList.size(); ++i){
			Main.ms = (Missile) Main.missileList.get(i);
			if(Main.Crash(Main.ms.startX , Main.ms.startY ,skill0X-111, skill0Y-111, Main.ms.msImg, shieldBlock[4], 0)){
				Main.missileList.remove(i);
				barrier--;
			}
		}
	}

	@Override
	public void DrawSkill0(Graphics g, ImageObserver frame) {
		
		skill0OnOff = false;
		skill0Count = 0;
		
		if (skill0cnt >= 0 && skill0cnt < 1)
			g.drawImage(shieldBlock[0], skill0X+20, skill0Y+20, frame);
		else if (skill0cnt >= 1 && skill0cnt < 2)
			g.drawImage(shieldBlock[1], skill0X, skill0Y, frame);
		else if (skill0cnt >= 2 && skill0cnt < 3)
			g.drawImage(shieldBlock[2], skill0X-33, skill0Y-33, frame);
		else if (skill0cnt >= 3 && skill0cnt < 4)
			g.drawImage(shieldBlock[3], skill0X-72, skill0Y-72, frame);
		else {
			g.drawImage(shieldBlock[4], skill0X-111, skill0Y-111, frame);
			skill0();
		}

	}

	@Override
	public void skill1() {
		maxHp += 500;
	}

	//전체 체력 증가 스킬
	@Override
	public void DrawSkill1(Graphics g, ImageObserver frame) {
		
		skill1OnOff = false;
		
		
		if (skill1cnt >= 0 && skill1cnt < 1)
			g.drawImage(hpIncrease[0], charX+8, charY-18, frame);
		else if (skill1cnt >= 1 && skill1cnt < 2)
			g.drawImage(hpIncrease[1], charX+8, charY-18, frame);
		else if (skill1cnt >= 2 && skill1cnt < 3)
			g.drawImage(hpIncrease[2], charX+8, charY-18, frame);
		else if (skill1cnt >= 3 && skill1cnt < 4)
			g.drawImage(hpIncrease[3], charX+8, charY-18, frame);
		else if(skill1cnt >= 4 && skill1cnt < 6){
			g.drawImage(hpIncrease[4], charX+8, charY-18, frame);
		}else if(skill1cnt >= 6 && skill1cnt < 9){
			g.drawImage(hpIncrease[5], charX+8, charY-18, frame);
		}else{
			g.drawImage(hpIncrease[6],  charX+8, charY-18, frame);
		}
	}

	@Override
	public void skill2() {

	}

	@Override
	public void DrawSkill2(Graphics g, ImageObserver frame) {

	}

	@Override
	public void skill3() {

	}


	@Override
	public void skillProcess() {
		// TODO Auto-generated method stub

	}

	@Override
	public void DrawSkill3(Graphics g, ImageObserver frame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
