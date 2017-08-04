import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Warrior extends Player {
	
	Graphics skillG;
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
				tmpRect = new Rectangle(charX + 8, charY - 13 , 48, 25);
				if (Main.Crash(tmpRect, ms.x, ms.y, Main.monsterG[i]))
					ms.hp -= power;
				if(ms.hp <= 0)
					 Main.monsterList.remove(i);
				break;
			case 2:
				tmpRect = new Rectangle(charX + 8, charY + 56, 48, 25);
				if (Main.Crash(tmpRect, ms.x, ms.y, Main.monsterG[i]))
					ms.hp -= power;
				if(ms.hp <= 0)
					 Main.monsterList.remove(i);
				break;
			case 1:
				tmpRect = new Rectangle(charX - 15, charY + 8, 25, 48);
				if (Main.Crash(tmpRect, ms.x, ms.y, Main.monsterG[i]))
					ms.hp -= power;
				if(ms.hp <= 0)
					 Main.monsterList.remove(i);
				break;
			case 3:
				tmpRect = new Rectangle(charX + 54, charY + 8, 25, 48);
				if (Main.Crash(tmpRect, ms.x, ms.y, Main.monsterG[i]))
					ms.hp -= power;
				if(ms.hp <= 0)
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

}

