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
	Image[] PriestShield;
	Image[] PreistHeal;

	ArrayList healList = new ArrayList();
	ArrayList playerList = new ArrayList();
	ArrayList healEffectList = new ArrayList();

	Player p;
	HealEffect healeffect;
	Heal heal;

	Player shieldP = null;
	Heal shiledHeal = null;
	Shield sd = null;

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

		PriestShield = new Image[8];
		for (int i = 0; i < PriestShield.length; ++i)
			PriestShield[i] = new ImageIcon("프리스트 보호막 " + i + ".png").getImage();

		PreistHeal = new Image[19];
		for (int i = 0; i < PreistHeal.length; ++i){
			PreistHeal[i] = new ImageIcon("장판힐" + i + ".png").getImage();
			
		}
		
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
			if (heal.shield) {
				for (int j = 0; j < Main.playerList.size(); ++j) {
					p = (Player) Main.playerList.get(j);
					if (Main.Crash(p.charX, p.charY, heal.x, heal.y, g1, heal.healImg)) {
						healList.remove(i);
						shieldP = p;
						sd = new Shield();
					}
				}
			} else {
				for (int j = 0; j < Main.playerList.size(); ++j) {
					p = (Player) Main.playerList.get(j);
					if (Main.Crash(p.charX, p.charY, heal.x, heal.y, g1, heal.healImg)) {
						healList.remove(i);
						playerList.add(p);
						healeffect = new HealEffect();
						healEffectList.add(healeffect);
					}
				}
			}

			heal.move();
			if (heal.x > Main.f_width)
				healList.remove(i);
			if (heal.y > Main.f_height)
				healList.remove(i);

		}
	}

	public void healEffect(Graphics g, ImageObserver frame) {
		for (int i = 0; i < playerList.size(); ++i) {
			p = (Player) playerList.get(i);
			healeffect = (HealEffect) healEffectList.get(i);
			if (healeffect.cnt >= 0 && healeffect.cnt < 1) {
				g.drawImage(PriestAttackEffect[0], p.charX + 23, p.charY + 12, frame);
			} else if (healeffect.cnt >= 1 && healeffect.cnt < 2) {
				g.drawImage(PriestAttackEffect[1], p.charX + 23, p.charY + 12, frame);
			} else if (healeffect.cnt >= 2 && healeffect.cnt < 3) {
				g.drawImage(PriestAttackEffect[2], p.charX + 23, p.charY + 12, frame);
			}
			if (healeffect.cnt > 3) {
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
		}

		if (attackcnt >= 5 && attackcnt < 5.2) {
			heal = new Heal(charX, charY, moveStatus);
			healList.add(heal);
		}
	}

	// 쉴드 스킬
	public void skill0() {

	}

	public void DrawShied(Graphics g, ImageObserver frame) {
		if (sd != null) {
			if (sd.cnt >= 0 && sd.cnt < 1) {
				g.drawImage(PriestShield[0], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 1 && sd.cnt < 2) {
				g.drawImage(PriestShield[1], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 2 && sd.cnt < 3) {
				g.drawImage(PriestShield[2], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 3 && sd.cnt < 4) {
				g.drawImage(PriestShield[3], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 4 && sd.cnt < 5) {
				g.drawImage(PriestShield[4], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 5 && sd.cnt < 6) {
				g.drawImage(PriestShield[5], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 6 && sd.cnt < 7) {
				g.drawImage(PriestShield[6], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 7 && sd.cnt < 8) {
				g.drawImage(PriestShield[7], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 8 && sd.cnt < 9) {
				g.drawImage(PriestShield[0], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 9 && sd.cnt < 10) {
				g.drawImage(PriestShield[1], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 10 && sd.cnt < 11) {
				g.drawImage(PriestShield[2], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 11 && sd.cnt < 12) {
				g.drawImage(PriestShield[3], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 12 && sd.cnt < 13) {
				g.drawImage(PriestShield[4], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 13 && sd.cnt < 14) {
				g.drawImage(PriestShield[5], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 14 && sd.cnt < 15) {
				g.drawImage(PriestShield[6], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 15 && sd.cnt < 16) {
				g.drawImage(PriestShield[7], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 16 && sd.cnt < 17) {
				g.drawImage(PriestShield[0], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 17 && sd.cnt < 18) {
				g.drawImage(PriestShield[1], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 18 && sd.cnt < 19) {
				g.drawImage(PriestShield[2], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 19 && sd.cnt < 20) {
				g.drawImage(PriestShield[3], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 20 && sd.cnt < 21) {
				g.drawImage(PriestShield[4], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 21 && sd.cnt < 22) {
				g.drawImage(PriestShield[5], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 22 && sd.cnt < 23) {
				g.drawImage(PriestShield[6], shieldP.charX + 7, shieldP.charY + 3, frame);
			} else if (sd.cnt >= 23 && sd.cnt < 24) {
				g.drawImage(PriestShield[7], shieldP.charX + 7, shieldP.charY + 3, frame);
			}

			if (sd.cnt < 0) {
				sd = null;
				shieldP = null;
			}
		}
	}

	public void DrawSkill0(Graphics g, ImageObserver frame) {
		skill0OnOff = false;
		skill0Count = 0;

		if (skill0cnt >= 0 && skill0cnt < 1) {
			g.drawImage(PriestAttack[moveStatus][0], charX, charY, frame);
		} else if (skill0cnt >= 1 && skill0cnt < 2) {
			g.drawImage(PriestAttack[moveStatus][1], charX, charY, frame);
		} else if (skill0cnt >= 2 && skill0cnt < 3) {
			g.drawImage(PriestAttack[moveStatus][2], charX, charY, frame);
		} else if (skill0cnt >= 3 && skill0cnt < 4) {
			g.drawImage(PriestAttack[moveStatus][3], charX, charY, frame);
		} else if (skill0cnt >= 4 && skill0cnt < 5) {
			g.drawImage(PriestAttack[moveStatus][4], charX, charY, frame);
		} else if (skill0cnt >= 5 && skill0cnt < 6) {
			g.drawImage(PriestAttack[moveStatus][5], charX, charY, frame);
		} else if (skill0cnt >= 6 && skill0cnt < 7) {
			g.drawImage(PriestAttack[moveStatus][6], charX, charY, frame);
		}

		if (skill0cnt >= 5 && skill0cnt < 5.2) {
			shiledHeal = new Heal(charX, charY, moveStatus, true);
			healList.add(shiledHeal);
		}
	}

	public void skill1() {

	}

	public void DrawSkill1(Graphics g, ImageObserver frame) {
		skill1OnOff = false;
		skill1Count = 0;

		if (skill1cnt >= 0 && skill1cnt < 1) {
			g.drawImage(PriestAttack[moveStatus][1], charX, charY, frame);
		} else if (skill1cnt >= 1 && skill1cnt < 2) {
			g.drawImage(PriestAttack[moveStatus][2], charX, charY, frame);
		} else if (skill1cnt >= 2 && skill1cnt < 3) {
			g.drawImage(PriestAttack[moveStatus][3], charX, charY, frame);
		} else if (skill1cnt >= 3 && skill1cnt < 4) {
			g.drawImage(PriestAttack[moveStatus][4], charX, charY, frame);
		}

		if (skill1cnt >= 1 && skill1cnt < 1.2) {
			playerList.add(this);
			healeffect = new HealEffect();
			healEffectList.add(healeffect);
		}
	}

	public void skill2() {

	}

	public void DrawSkill2Motion(Graphics g, ImageObserver frame) {
		skill2OnOff = false;
		skill2Count = 0;

		if (skill2cnt >= 0 && skill2cnt < 1) {
			g.drawImage(PriestAttack[skill2direct][0], charX, charY, frame);
		} else if (skill2cnt >= 1 && skill1cnt < 2) {
			g.drawImage(PriestAttack[skill2direct][5], charX, charY, frame);
		} else if (skill2cnt >= 2 && skill1cnt < 50) {
			g.drawImage(PriestAttack[skill2direct][6], charX, charY, frame);
		}

	}

	public void DrawSkill2(Graphics g, ImageObserver frame) {
		skill2OnOff = false;
		skill2Count = 0;
		
		if (skill2cnt >= 3 && skill2cnt < 5) {
			g.drawImage(PreistHeal[0], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 5 && skill2cnt < 7){
			g.drawImage(PreistHeal[1], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 7 && skill2cnt < 9){
			g.drawImage(PreistHeal[2], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 9 && skill2cnt < 11){
			g.drawImage(PreistHeal[3], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 11 && skill2cnt < 13){
			g.drawImage(PreistHeal[4], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 13 && skill2cnt < 15){
			g.drawImage(PreistHeal[5], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 15 && skill2cnt < 17){
			g.drawImage(PreistHeal[6], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 17 && skill2cnt < 19){
			g.drawImage(PreistHeal[7], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 19 && skill2cnt < 21){
			g.drawImage(PreistHeal[8], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 21 && skill2cnt < 23){
			g.drawImage(PreistHeal[9], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 23 && skill2cnt < 25){
			g.drawImage(PreistHeal[10], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 25 && skill2cnt < 27){
			g.drawImage(PreistHeal[11], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 27 && skill2cnt < 29){
			g.drawImage(PreistHeal[12], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 29 && skill2cnt < 31){
			g.drawImage(PreistHeal[13], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 31 && skill2cnt < 33){
			g.drawImage(PreistHeal[14], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 33 && skill2cnt < 35){
			g.drawImage(PreistHeal[15], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 35 && skill2cnt < 37){
			g.drawImage(PreistHeal[16], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 37 && skill2cnt < 39){
			g.drawImage(PreistHeal[17], skill2X-170, skill2Y-85, frame);
		}else if(skill2cnt >= 39 && skill2cnt < 50){
			g.drawImage(PreistHeal[18], skill2X-170, skill2Y-85, frame);
		}
		
		
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
		DrawShied(g, frame);
	}

	@Override
	public void skill1Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		if (p.keyS && p.skill1OnOff) {
			p.skill1On = true;
			getSkill1();
		}
		if (p.skill1On) {
			DrawSkill1(g1, frame);
		}

	}

	@Override
	public void skill2Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		if (p.keyD && p.skill1OnOff) {
			p.skill2On = true;
			getSkill2();
			skilling = true;
		}
		if (p.skill2On) {
			DrawSkill2(g, frame);
			DrawSkill2Motion(g1, frame);
		}

	}

	@Override
	public void skill3Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		// TODO Auto-generated method stub
		DrawHeal(g, g1, frame);
		healEffect(g, frame);
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
		if (skill0cnt > 7)
			skill0On = false;
		skill0Count++;
		if (skill0Count > 50) {
			skill0OnOff = true;
			skill0cnt = 0;
		}

		if (sd != null)
			sd.cnt -= 0.2;

		if (skill1On)
			skill1cnt += 0.2;
		if (skill1cnt > 4) {
			skill1On = false;

		}
		skill1Count++;
		if (skill1Count > 50) {
			skill1OnOff = true;
			skill1cnt = 0;
		}

		if (skill2On)
			skill2cnt += 0.2;
		if (skill2cnt > 50) {
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
		boolean shield = false;
		Image healImg;

		public Heal(int x, int y, int direct) {
			this.x = x;
			this.y = y;
			this.direct = direct;

			switch (direct) {
			case 0:
				this.x += 35;
				this.plusX = 0;
				this.plusY = -speed;
				break;
			case 1:
				this.y += 30;
				this.plusX = -speed;
				this.plusY = 0;
				break;
			case 2:
				this.x += 35;
				this.y += 65;
				this.plusX = 0;
				this.plusY = speed;
				break;
			case 3:
				this.y += 30;
				this.x += 60;
				this.plusX = speed;
				this.plusY = 0;
				break;
			}

			healImg = new ImageIcon("힐.png").getImage();
		}

		public Heal(int x, int y, int direct, boolean z) {
			this.x = x;
			this.y = y;
			this.direct = direct;
			this.speed = 2;
			this.shield = true;

			switch (direct) {
			case 0:
				this.x += 35;
				this.plusX = 0;
				this.plusY = -speed;
				break;
			case 1:
				this.y += 30;
				this.plusX = -speed;
				this.plusY = 0;
				break;
			case 2:
				this.x += 35;
				this.y += 65;
				this.plusX = 0;
				this.plusY = speed;
				break;
			case 3:
				this.y += 30;
				this.x += 60;
				this.plusX = speed;
				this.plusY = 0;
				break;

			}

			healImg = new ImageIcon("쉴드 구체.png").getImage();
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

	class Shield {
		double cnt;
		int shiedlBarrier;

		public Shield() {
			cnt = 24;
			shiedlBarrier = 50;
		}
	}

}
