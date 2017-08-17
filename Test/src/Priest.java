import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Priest extends Player {

	Image[][] PriestDefault;
	Image[][] PriestAttack;
	Image[] PriestAttackEffect;

	Heal heal;

	ArrayList healList = new ArrayList();
	ArrayList playerList = new ArrayList();
	ArrayList healEffectList = new ArrayList();

	Player p;
	HealEffect healeffect;

	public Priest(int x, int y) {
		super(x, y);
		maxHp = 500;
		hp = 500;
		barrier = 200;
		speedOfAttack = 25;
		speedOfPlayer = 5;
		power = 0.2;

		PriestDefault = new Image[4][9];
		for (int i = 0; i < PriestDefault.length; ++i)
			for (int j = 0; j < PriestDefault[i].length; ++j)
				PriestDefault[i][j] = new ImageIcon("프리스트 기본 " + i + "_" + j + ".png").getImage();

		PriestAttack = new Image[4][7];
		for (int i = 0; i < PriestAttack.length; ++i)
			for (int j = 0; j < PriestAttack[i].length; ++j)
				PriestAttack[i][j] = new ImageIcon("프리스트 기본공격 " + i + "_" + j + ".png").getImage();

		PriestAttackEffect = new Image[3];
		for (int i = 0; i < PriestAttackEffect.length; ++i)
			PriestAttackEffect[i] = new ImageIcon("힐 이펙트" + i + ".png").getImage();
	}

	public void Draw_human(Graphics g, ImageObserver frame) {
		if (playerMove) {
			if (Main.count / 5 % 9 == 0) {
				g.drawImage(PriestDefault[moveStatus][0], charX, charY, frame);
			} else if (Main.count / 5 % 9 == 1) {
				g.drawImage(PriestDefault[moveStatus][1], charX, charY, frame);
			} else if (Main.count / 5 % 9 == 2) {
				g.drawImage(PriestDefault[moveStatus][2], charX, charY, frame);
			} else if (Main.count / 5 % 9 == 3) {
				g.drawImage(PriestDefault[moveStatus][3], charX, charY, frame);
			} else if (Main.count / 5 % 9 == 4) {
				g.drawImage(PriestDefault[moveStatus][4], charX, charY, frame);
			} else if (Main.count / 5 % 9 == 5) {
				g.drawImage(PriestDefault[moveStatus][5], charX, charY, frame);
			} else if (Main.count / 5 % 9 == 6) {
				g.drawImage(PriestDefault[moveStatus][6], charX, charY, frame);
			} else if (Main.count / 5 % 9 == 7) {
				g.drawImage(PriestDefault[moveStatus][7], charX, charY, frame);
			} else {
				g.drawImage(PriestDefault[moveStatus][8], charX, charY, frame);
			}
		} else
			g.drawImage(PriestDefault[moveStatus][0], charX, charY, frame);
	}

	public void DrawHeal(Graphics g, Graphics g1, ImageObserver frame) {
		for (int i = 0; i < healList.size(); ++i) {
			heal = (Heal) healList.get(i);
			g.drawImage(heal.healImg, heal.x, heal.y, frame);
			for (int j = 0; j < Main.playerList.size(); ++j) {
				p = (Player) Main.playerList.get(j);
				if (Main.Crash(p.charX, p.charY, heal.x, heal.y, g1, heal.healImg)) {
					healList.remove(i);
					playerList.add(p);
					healeffect = new HealEffect();
					healEffectList.add(healeffect);
				}

				heal.move();
				if (heal.x > Main.f_width)
					healList.remove(i);
				if (heal.y > Main.f_height)
					healList.remove(i);
			}
		}

	}

	public void healEffect(Graphics g, ImageObserver frame) {
		for (int i = 0; i < playerList.size(); ++i) {
			p = (Player) playerList.get(i);
			healeffect = (HealEffect) healEffectList.get(i);
			if (healeffect.cnt >= 0 && healeffect.cnt < 1) {
				g.drawImage(PriestAttackEffect[0], p.charX+26, p.charY+14, frame);
			} else if (healeffect.cnt >= 1 && healeffect.cnt < 2) {
				g.drawImage(PriestAttackEffect[1], p.charX+26, p.charY+14, frame);
			} else if (healeffect.cnt >= 2 && healeffect.cnt < 3) {
				g.drawImage(PriestAttackEffect[2], p.charX+26, p.charY+14, frame);
			}
			
			if(healeffect.cnt > 3){
				healEffectList.remove(i);
				playerList.remove(i);
			}
			

		}
	}

	public void DrawAttack(Graphics g, ImageObserver frame) {
		attackOnOff = false;
		attackCount = 0;

		if (attackcnt >= 0 && attackcnt < 1) {
			g.drawImage(PriestAttack[moveStatus][0], charX, charY, frame);
		} else if (attackcnt >= 1 && attackcnt < 2) {
			g.drawImage(PriestAttack[moveStatus][1], charX, charY, frame);
		} else if (attackcnt >= 2 && attackcnt < 3) {
			g.drawImage(PriestAttack[moveStatus][2], charX, charY, frame);
		} else if (attackcnt >= 3 && attackcnt < 4) {
			g.drawImage(PriestAttack[moveStatus][3], charX, charY, frame);
		} else if (attackcnt >= 4 && attackcnt < 5) {
			g.drawImage(PriestAttack[moveStatus][4], charX, charY, frame);
		} else if (attackcnt >= 5 && attackcnt < 6) {
			g.drawImage(PriestAttack[moveStatus][5], charX, charY, frame);
		} else if (attackcnt >= 6 && attackcnt < 7) {
			g.drawImage(PriestAttack[moveStatus][6], charX, charY, frame);
		} else if (attackcnt >= 7 && attackcnt < 8) {
			g.drawImage(PriestAttack[moveStatus][7], charX, charY, frame);
		}

		if (attackcnt >= 5 && attackcnt < 5.2) {
			heal = new Heal(charX, charY, moveStatus);
			healList.add(heal);
		}
	}

	public void skill0() {

	}

	public void DrawSkill0(Graphics g, ImageObserver frame) {

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
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attackProcess(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		if (p.keySpace && p.attackOnOff) {
			p.attackOn = true;
			getAttack();
		}
		if (p.attackOn) {
			DrawAttack(g1, frame);
		} else if (skill0On == false && skill1On == false && skill2On == false && skill3On == false)
			Draw_human(g1, frame);

		DrawHeal(g, g1, frame);
		healEffect(g, frame);

	}

	@Override
	public void skill0Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		if (p.keyA && p.skill0OnOff) {
			p.skill0On = true;
			getSkill0();
		}
		if (p.skill0On) {
			DrawSkill0(g1, frame);
		}
		DrawSkill0(g, frame);
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

	@Override
	public void timer() {
		if (attackOn)
			attackcnt += 0.2;
		if (attackcnt > 7)
			attackOn = false;
		attackCount++;
		if (attackCount > 50) {
			attackOnOff = true;
			attackcnt = 0;
		}

		for (int j = 0; j < healEffectList.size(); ++j) {
			healeffect = (HealEffect) healEffectList.get(j);
			healeffect.cnt += 0.2;
		}
		
		if (skill0On)
			skill0cnt += 0.2;
		if (skill0cnt > 12)
			skill0On = false;
		skill0Count++;
		if (skill0Count > 50) {
			skill0OnOff = true;
			skill0cnt = 0;
		}

		if (skill1On)
			skill1cnt += 0.2;
		if (skill1cnt > 9) {
			skill1On = false;
			skilling = false;
		}
		skill1Count++;
		if (skill1Count > 50) {
			skill1OnOff = true;
			skill1cnt = 0;
		}

		if (skill2On)
			skill2cnt += 0.4;
		if (skill2cnt > 18) {
			skill2On = false;
			skilling = false;
		}
		skill2Count++;
		if (skill2Count > 50) {
			skill2OnOff = true;
			skill2cnt = 0;
		}

		if (skill3On)
			skill3cnt += 0.15;
		if (skill3cnt > 17) {
			skill3On = false;
			skilling = false;
		}
		skill3Count++;
		if (skill3Count > 50) {
			skill3OnOff = true;
			skill3cnt = 0;
		}

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

	class Heal {
		int x, y;
		int speed = 5;
		int direct;
		int plusX;
		int plusY;
		int heal;
		Image healImg;

		public Heal(int x, int y, int direct) {
			this.x = x;
			this.y = y;
			this.direct = direct;

			switch (direct) {
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

			healImg = new ImageIcon("힐.png").getImage();
		}

		public void move() {
			x += plusX;
			y += plusY;
		}
	}

	class HealEffect {
		double cnt;

		public HealEffect() {
			cnt = 0;
		}
	}
}
