import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Warrior extends Player {

	Skilltimer skilltimer;

	Image[] shieldBlock;

	public Warrior(int x, int y) {
		super(x, y);
		hp = 500;
		barrier = 150;
		speedOfAttack = 25;
		speedOfPlayer = 5;
		power = 0.2;
		humanImg = new ImageIcon("전사 기본.png").getImage();
		attackImg = new ImageIcon("전사 기본공격.png").getImage();

		shieldBlock = new Image[5];
		for (int i = 0; i < shieldBlock.length; ++i)
			shieldBlock[i] = new ImageIcon("보호막" + i + ".png").getImage();
	}

	public Warrior() {
		super(0, 0);
		hp = 500;
		barrier = 150;
		speedOfAttack = 25;
		speedOfPlayer = 5;
		power = 0.2;
		humanImg = new ImageIcon("전사 기본").getImage();

		shieldBlock = new Image[5];
		for (int i = 0; i < shieldBlock.length; ++i)
			shieldBlock[i] = new ImageIcon("보호막" + i + ".png").getImage();

	}

	@Override
	public void attack() {
		Rectangle tmpRect;

		for (int i = 0; i < Main.monsterList.size(); i++) {
			ms = (Monster) Main.monsterList.get(i);
			switch (moveStatus) {
			case 0:
				tmpRect = new Rectangle(charX + 8, charY - 13, 48, 25);
				if (Main.Crash(tmpRect, ms.x, ms.y, Main.monsterG[i]))
					ms.hp -= power;
				if (ms.hp <= 0)
					Main.monsterList.remove(i);
				break;
			case 2:
				tmpRect = new Rectangle(charX + 8, charY + 56, 48, 25);
				if (Main.Crash(tmpRect, ms.x, ms.y, Main.monsterG[i]))
					ms.hp -= power;
				if (ms.hp <= 0)
					Main.monsterList.remove(i);
				break;
			case 1:
				tmpRect = new Rectangle(charX - 15, charY + 8, 25, 48);
				if (Main.Crash(tmpRect, ms.x, ms.y, Main.monsterG[i]))
					ms.hp -= power;
				if (ms.hp <= 0)
					Main.monsterList.remove(i);
				break;
			case 3:
				tmpRect = new Rectangle(charX + 54, charY + 8, 25, 48);
				if (Main.Crash(tmpRect, ms.x, ms.y, Main.monsterG[i]))
					ms.hp -= power;
				if (ms.hp <= 0)
					Main.monsterList.remove(i);
				break;
			}
			System.out.println(ms.hp);
		}
	}

	@Override
	public void DrawAttack(Graphics g, ImageObserver frame) {

		attatckOnOff = false;
		attackCount = 0;

		g.setClip(charX, charY, Main.ImageWidthValue("캐릭터 기본.png") / 9, Main.ImageHeigthValue("캐릭터 기본.png") / 4);

		if (attackcnt >= 0 && attackcnt < 1) {
			g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 0),
					charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
		} else if (attackcnt >= 1 && attackcnt < 2) {
			g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 1),
					charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
		} else if (attackcnt >= 2 && attackcnt < 3) {
			g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 2),
					charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
		} else if (attackcnt >= 3 && attackcnt < 4) {
			g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 3),
					charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
		} else if (attackcnt >= 4 && attackcnt < 5) {
			g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 4),
					charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
		} else if (attackcnt >= 5 && attackcnt < 6) {
			g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 5),
					charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
		}
	}

	@Override
	// 방패 막기 스킬 충돌
	public void skill0() {

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
		}

	}

	@Override
	public void skill1() {

	}

	@Override
	public void DrawSkill1() {

	}

	@Override
	public void skill2() {

	}

	@Override
	public void DrawSkill2() {

	}

	@Override
	public void skill3() {

	}


	@Override
	public void skillProcess() {
		// TODO Auto-generated method stub

	}

	@Override
	public void DrawSkill3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
