import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

abstract class Player implements KeyListener {

	int charX, charY;

	int hp, power, speedOfAttack, speedOfPlayer, barrier;

	int moveStatus;

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

		g.setClip(charX, charY, Main.ImageWidthValue("캐릭터 기본.png") / 9, Main.ImageHeigthValue("캐릭터 기본.png") / 4);

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
	
	
	public abstract void skillProcess();
	
	public void keyProcess() {

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public abstract void attack();
	
	public abstract void DrawAttack(Graphics g, ImageObserver frame);
	public abstract void skill0(); // 기본기
	public abstract void DrawSkill0();
	
	public abstract void skill1(); // 스킬 123
	public abstract void DrawSkill1();
	
	public abstract void skill2();
	public abstract void DrawSkill2();
	
	public abstract void skill3();
	public abstract void DrawSkill3();
}