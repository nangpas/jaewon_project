import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

abstract class Player implements KeyListener {

	int charX, charY;

	double maxHp, hp, power, speedOfAttack, speedOfPlayer, barrier;

	int moveStatus;
	boolean skilling = false;
	// 기본공격 관련 값들
	boolean attackOn = false; // 공격을 했다는 표시
	boolean attackOnOff = true; // 공격 가능 여부 (카운터 값으로 일정 시간이 되면 공격이 가능) 쿨타임 같은거
	double attackcnt = 0;
	int attackX;
	int attackY;
	int attackdirect;
	int attackCount = 0;
	
	// 스킬 0 관련 값들
	
	boolean skill0On = false;
	boolean skill0OnOff = true;
	double skill0cnt = 0;
	int skill0X;
	int skill0Y;
	int skill0direct;
	int skill0Count = 0;
	// 스킬 1 관련 값들
	
	boolean skill1On = false;
	boolean skill1OnOff = true;
	double skill1cnt = 0;
	int skill1X;
	int skill1Y;
	int skill1direct;
	int skill1Count = 0;
	// 스킬 2 관련 값들
	
	boolean skill2On = false;
	boolean skill2OnOff = true;
	double skill2cnt = 0;
	int skill2X;
	int skill2Y;
	int skill2direct;
	int skill2Count = 0;
	
	boolean skill3On = false;
	boolean skill3OnOff = true;
	double skill3cnt = 0;
	int skill3X;
	int skill3Y;
	int skill3direct;
	int skill3Count = 0;

	Image humanImg;
	Image attackImg;
	Image skill0Img;
	Image skill1Img;
	Image skill2Img;
	Image skill3Img;

	boolean keyUp = false;
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean keySpace = false;
	boolean keyA = false;
	boolean keyS = false;
	boolean keyD = false;
	boolean keyF = false;

	boolean playerMove = false;

	public Player() {
		charX = 50;
		charY = 50;
		moveStatus = 0;
	}

	public Player(int x, int y) {
		charX = x;
		charY = y;
		moveStatus = 0;
	}

	public void Draw_human(Graphics g, ImageObserver frame) {

		g.setClip(charX, charY, 64, 64);

		if (playerMove) {
			if (Main.count / 5 % 9 == 0) {
				g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 0),
						charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
			} else if (Main.count / 5 % 9 == 1) {
				g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 1),
						charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
			} else if (Main.count / 5 % 9 == 2) {
				g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 2),
						charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
			} else if (Main.count / 5 % 9 == 3) {
				g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 3),
						charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
			} else if (Main.count / 5 % 9 == 4) {
				g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 4),
						charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
			} else if (Main.count / 5 % 9 == 5) {
				g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 5),
						charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
			} else if (Main.count / 5 % 9 == 6) {
				g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 6),
						charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
			} else if (Main.count / 5 % 9 == 7) {
				g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 7),
						charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
			} else {
				g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 8),
						charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
			}
		} else
			g.drawImage(humanImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 8),
					charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
	}

	public void DrawHp(Graphics g, ImageObserver frame) {
		g.setColor(Color.white);
		g.fill3DRect(charX, charY, (int) maxHp / 10, 5, true);
		g.setColor(Color.red);
		g.fill3DRect(charX, charY, (int) hp / 10, 5, true);
	}


	public void keyProcess() {
		playerMove = false;

		if (skilling == false) {

			if (keyUp) {
				playerMove = true;
				if (charY > 25) {
					charY -= speedOfPlayer;
					moveStatus = 0;
				}
			}
			if (keyDown) {
				playerMove = true;
				if (charY < Main.f_height - 50) {
					charY += speedOfPlayer;
					moveStatus = 2;
				}
			}
			if (keyLeft) {
				playerMove = true;
				if (charX > 0) {
					charX -= speedOfPlayer;
					moveStatus = 1;
				}
			}
			if (keyRight) {
				playerMove = true;
				if (charX < Main.f_width - 25) {
					charX += speedOfPlayer;
					moveStatus = 3;
				}
			}

			if (keyS) {
				/*Image img = new ImageIcon("star.png").getImage();
				Main.ms = new Missile(Main.mon.x, Main.mon.y, charX, charY, 2, img);
				Main.missileList.add(Main.ms);*/
				
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			keyLeft = true;
			keyUp = false;
			keyDown = false;
			break;
		case KeyEvent.VK_RIGHT:
			keyRight = true;
			keyUp = false;
			keyDown = false;
			break;
		case KeyEvent.VK_UP:
			keyUp = true;
			keyRight = false;
			keyLeft = false;
			break;
		case KeyEvent.VK_DOWN:
			keyDown = true;
			keyRight = false;
			keyLeft = false;
			break;
		case KeyEvent.VK_A:
			keyA = true;
			break;
		case KeyEvent.VK_S:
			keyS = true;
			break;
		case KeyEvent.VK_D:
			keyD = true;
			break;
		case KeyEvent.VK_F:
			keyF = true;
			break;
		case KeyEvent.VK_SPACE:
			keySpace = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			keyLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
			keyRight = false;
			break;
		case KeyEvent.VK_UP:
			keyUp = false;
			break;
		case KeyEvent.VK_DOWN:
			keyDown = false;
			break;
		case KeyEvent.VK_A:
			keyA = false;
			break;
		case KeyEvent.VK_S:
			keyS = false;
			break;
		case KeyEvent.VK_D:
			keyD = false;
			break;
		case KeyEvent.VK_F:
			keyF = false;
			break;
		case KeyEvent.VK_SPACE:
			keySpace = false;
			break;
		}

	}
	
	public abstract void attackProcess(Player p,Graphics g,Graphics g1,ImageObserver frame);
	public abstract void skill0Process(Player p,Graphics g,Graphics g1,ImageObserver frame);
	public abstract void skill1Process(Player p,Graphics g,Graphics g1,ImageObserver frame);
	public abstract void skill2Process(Player p,Graphics g,Graphics g1,ImageObserver frame);
	public abstract void skill3Process(Player p,Graphics g,Graphics g1,ImageObserver frame);

	
	public abstract void timer();
}