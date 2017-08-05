import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Warrior extends Player {

	Skilltimer skilltimer;
	Monster ms;

	public Warrior(int x, int y) {
		super(x, y);
		hp = 500;
		barrier = 150;
		speedOfAttack = 20;
		speedOfPlayer = 5;
		power = 2;
		humanImg = new ImageIcon("캐릭터 기본.png").getImage();
		attackImg = new ImageIcon("캐릭터 공격.png").getImage();
	}

	public Warrior() {
		super(0, 0);
		hp = 500;
		barrier = 150;
		speedOfAttack = 20;
		speedOfPlayer = 5;
		power = 2;
		humanImg = new ImageIcon("캐릭터 기본").getImage();
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
	public void skill0() {

	}

	@Override
	public void DrawSkill0() {

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
	public void DrawSkill3() {

	}

	public void keyProcess() {
		playerMove = false;

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
		// TODO Auto-generated method stub

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

	@Override
	public void skillProcess() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void DrawAttack(Graphics g, ImageObserver frame) {
		Main.tmpB = false;
		int x = 0;
		attatckOnOff = false;
		attackCount = 0;
		skilltimer = new Skilltimer();
		skilltimer.start();
		
		while (true) {
			System.out.println(skilltimer.i);
			g.setClip(charX, charY, Main.ImageWidthValue("캐릭터 기본.png") / 9, Main.ImageHeigthValue("캐릭터 기본.png") / 4);
			//g.setClip(300,300,500,500);
			switch (moveStatus) {
			case 0:
				
				if (skilltimer.i  % 6 == 0) {
					Main.humanG[0].drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 0),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i  % 6 == 1) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 1),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i  % 6 == 2) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 2),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i  % 6 == 3) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 3),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i  % 6 == 4) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 4),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i  % 6 == 5) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 5),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 8),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				}
				
			//	g.drawRect(300, 300, 300, 300);
				break;
			case 2:
				if (skilltimer.i / 5 % 6 == 0) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 0),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 1) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 1),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 2) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 2),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 3) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 3),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 4) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 4),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 5) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 5),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 8),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				}
				break;
			case 1:
				if (skilltimer.i / 5 % 6 == 0) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 0),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 1) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 1),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 2) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 2),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 3) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 3),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 4) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 4),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 5) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 5),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 8),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				}
				break;
			case 3:
				if (skilltimer.i / 5 % 6 == 0) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 0),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 1) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 1),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 2) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 2),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 3) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 3),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 4) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 4),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else if (skilltimer.i / 5 % 6 == 5) {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 5),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				} else {
					g.drawImage(attackImg, charX - (Main.ImageWidthValue("캐릭터 기본.png") / 9 * 8),
							charY - (Main.ImageHeigthValue("캐릭터 기본.png") / 4 * moveStatus), frame);
				}
				break;
			}
			
			x++;
			if(x == 7){
				Main.tmpB = false;
				break;
			}
				
			
			
		}
	}

}
