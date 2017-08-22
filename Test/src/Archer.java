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
	Image[][] ArcherSkill3;

	Arrow ar;

	ArrayList arrowList = new ArrayList();

	public Archer(int x, int y) {
		super(x, y);
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
		for (int i = 0; i < Arrow.length; i++)
			Arrow[i] = new ImageIcon("화살" + i + ".png").getImage();

		ArcherSkill3 = new Image[4][7];
		for (int i = 0; i < ArcherSkill3.length; ++i)
			for (int j = 0; j < ArcherSkill3[i].length; ++j)
				ArcherSkill3[i][j] = new ImageIcon("궁수 스킬 " + i + "_" + j + ".png").getImage();
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

	public void DrawArrow(Graphics g, ImageObserver frame) {
		for (int i = 0; i < arrowList.size(); ++i) {
			ar = (Arrow) arrowList.get(i);
			g.drawImage(ar.arrowImg, ar.x, ar.y, frame);
			ar.move();
			if (ar.x > Main.f_width)
				arrowList.remove(i);
			if (ar.y > Main.f_height)
				arrowList.remove(i);
		}
	}

	public void DrawAttack(Graphics g, ImageObserver frame) {

		attackOnOff = false;
		attackCount = 0;

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
		} else if (attackcnt >= 8 && attackcnt < 9) {
			g.drawImage(ArcherAttack[moveStatus][8], charX, charY, frame);
		} else if (attackcnt >= 9 && attackcnt < 10) {
			g.drawImage(ArcherAttack[moveStatus][9], charX, charY, frame);
		} else if (attackcnt >= 10 && attackcnt < 11) {
			g.drawImage(ArcherAttack[moveStatus][10], charX, charY, frame);
		} else
			g.drawImage(ArcherAttack[moveStatus][11], charX, charY, frame);

		if (attackcnt == 9) {
			ar = new Arrow(charX, charY, moveStatus);
			arrowList.add(ar);
		}

	}

	public void skill0() {

	}

	public void DrawSkill0(Graphics g, ImageObserver frame) {
		for (int i = 0; i < arrowList.size(); ++i) {
			ar = (Arrow) arrowList.get(i);
			g.drawImage(ar.arrowImg, ar.x, ar.y, frame);
			ar.move();
			if (ar.x > Main.f_width)
				arrowList.remove(i);
			if (ar.y > Main.f_height)
				arrowList.remove(i);
		}
	}

	public void DrawSkill0Montion(Graphics g, ImageObserver frame) {

		skill0OnOff = false;
		skill0Count = 0;

		if (skill0cnt >= 0 && skill0cnt < 1) {
			g.drawImage(ArcherAttack[moveStatus][0], charX, charY, frame);
		} else if (skill0cnt >= 1 && skill0cnt < 2) {
			g.drawImage(ArcherAttack[moveStatus][1], charX, charY, frame);
		} else if (skill0cnt >= 2 && skill0cnt < 3) {
			g.drawImage(ArcherAttack[moveStatus][2], charX, charY, frame);
		} else if (skill0cnt >= 3 && skill0cnt < 4) {
			g.drawImage(ArcherAttack[moveStatus][3], charX, charY, frame);
		} else if (skill0cnt >= 4 && skill0cnt < 5) {
			g.drawImage(ArcherAttack[moveStatus][4], charX, charY, frame);
		} else if (skill0cnt >= 5 && skill0cnt < 6) {
			g.drawImage(ArcherAttack[moveStatus][5], charX, charY, frame);
		} else if (skill0cnt >= 6 && skill0cnt < 7) {
			g.drawImage(ArcherAttack[moveStatus][6], charX, charY, frame);
		} else if (skill0cnt >= 7 && skill0cnt < 8) {
			g.drawImage(ArcherAttack[moveStatus][7], charX, charY, frame);
		} else if (skill0cnt >= 8 && skill0cnt < 9) {
			g.drawImage(ArcherAttack[moveStatus][8], charX, charY, frame);
		} else if (skill0cnt >= 9 && skill0cnt < 10) {
			g.drawImage(ArcherAttack[moveStatus][9], charX, charY, frame);
		} else if (skill0cnt >= 10 && skill0cnt < 11) {
			g.drawImage(ArcherAttack[moveStatus][10], charX, charY, frame);
		} else
			g.drawImage(ArcherAttack[moveStatus][11], charX, charY, frame);

		if (skill0cnt == 9)
			for (int i = 0; i < 3; i++) {
				ar = new Arrow(charX, charY, moveStatus, i);
				arrowList.add(ar);
			}
	}

	public void skill1() {

	}

	public void DrawSkill1(Graphics g, ImageObserver frame) {

		skill1OnOff = false;
		skill1Count = 0;

		switch (skill1direct) {
		case 0:

			if (skill1cnt >= 0 && skill1cnt < 1) {

				g.drawImage(ArcherDefault[skill1direct][0], charX, charY, frame);
			} else if (skill1cnt >= 1 && skill1cnt < 2) {

				g.drawImage(ArcherDefault[skill1direct][1], charX, charY, frame);
			} else if (skill1cnt >= 2 && skill1cnt < 3) {

				g.drawImage(ArcherDefault[skill1direct][2], charX, charY, frame);
			} else if (skill1cnt >= 3 && skill1cnt < 4) {

				g.drawImage(ArcherDefault[skill1direct][3], charX, charY, frame);
			} else if (skill1cnt >= 4 && skill1cnt < 5) {

				g.drawImage(ArcherDefault[skill1direct][4], charX, charY, frame);
			} else if (skill1cnt >= 5 && skill1cnt < 6) {

				g.drawImage(ArcherDefault[skill1direct][5], charX, charY, frame);
			} else if (skill1cnt >= 6 && skill1cnt < 7) {

				g.drawImage(ArcherDefault[skill1direct][6], charX, charY, frame);
			} else if (skill1cnt >= 7 && skill1cnt < 8) {

				g.drawImage(ArcherDefault[skill1direct][7], charX, charY, frame);
			} else if (skill1cnt >= 8 && skill1cnt < 9) {

				g.drawImage(ArcherDefault[skill1direct][8], charX, charY, frame);
			} else
				g.drawImage(ArcherDefault[skill1direct][8], charX, charY, frame);

			if (skill1cnt >= 0 && skill1cnt < 3) {
				g.drawImage(ArcherDefault[skill1direct][0], skill1X, skill1Y, frame);
			}

			if (skill1cnt >= 1 && skill1cnt < 4) {
				g.drawImage(ArcherDefault[skill1direct][1], skill1X, skill1Y - 50, frame);
			}

			if (skill1cnt >= 2 && skill1cnt < 5) {
				g.drawImage(ArcherDefault[skill1direct][2], skill1X, skill1Y - 100, frame);
			}

			if (skill1cnt >= 3 && skill1cnt < 6) {
				g.drawImage(ArcherDefault[skill1direct][3], skill1X, skill1Y - 150, frame);
			}
			if (skill1cnt >= 4 && skill1cnt < 7) {
				g.drawImage(ArcherDefault[skill1direct][4], skill1X, skill1Y - 200, frame);
			}
			if (skill1cnt >= 5 && skill1cnt < 8) {
				g.drawImage(ArcherDefault[skill1direct][5], skill1X, skill1Y - 250, frame);
			}
			if (skill1cnt >= 6 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][6], skill1X, skill1Y - 300, frame);
			}
			if (skill1cnt >= 7 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][7], skill1X, skill1Y - 350, frame);
			}
			if (skill1cnt >= 8 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][8], skill1X, skill1Y - 400, frame);
			}
			charY -= 10;
			break;
		case 1:

			if (skill1cnt >= 0 && skill1cnt < 1) {

				g.drawImage(ArcherDefault[skill1direct][0], charX, charY, frame);
			} else if (skill1cnt >= 1 && skill1cnt < 2) {

				g.drawImage(ArcherDefault[skill1direct][1], charX, charY, frame);
			} else if (skill1cnt >= 2 && skill1cnt < 3) {

				g.drawImage(ArcherDefault[skill1direct][2], charX, charY, frame);
			} else if (skill1cnt >= 3 && skill1cnt < 4) {

				g.drawImage(ArcherDefault[skill1direct][3], charX, charY, frame);
			} else if (skill1cnt >= 4 && skill1cnt < 5) {

				g.drawImage(ArcherDefault[skill1direct][4], charX, charY, frame);
			} else if (skill1cnt >= 5 && skill1cnt < 6) {

				g.drawImage(ArcherDefault[skill1direct][5], charX, charY, frame);
			} else if (skill1cnt >= 6 && skill1cnt < 7) {

				g.drawImage(ArcherDefault[skill1direct][6], charX, charY, frame);
			} else if (skill1cnt >= 7 && skill1cnt < 8) {

				g.drawImage(ArcherDefault[skill1direct][7], charX, charY, frame);
			} else if (skill1cnt >= 8 && skill1cnt < 9) {

				g.drawImage(ArcherDefault[skill1direct][8], charX, charY, frame);
			} else
				g.drawImage(ArcherDefault[skill1direct][8], charX, charY, frame);

			if (skill1cnt >= 0 && skill1cnt < 3) {
				g.drawImage(ArcherDefault[skill1direct][0], skill1X, skill1Y, frame);
			}

			if (skill1cnt >= 1 && skill1cnt < 4) {
				g.drawImage(ArcherDefault[skill1direct][1], skill1X - 50, skill1Y, frame);
			}

			if (skill1cnt >= 2 && skill1cnt < 5) {
				g.drawImage(ArcherDefault[skill1direct][2], skill1X - 100, skill1Y, frame);
			}

			if (skill1cnt >= 3 && skill1cnt < 6) {
				g.drawImage(ArcherDefault[skill1direct][3], skill1X - 150, skill1Y, frame);
			}
			if (skill1cnt >= 4 && skill1cnt < 7) {
				g.drawImage(ArcherDefault[skill1direct][4], skill1X - 200, skill1Y, frame);
			}
			if (skill1cnt >= 5 && skill1cnt < 8) {
				g.drawImage(ArcherDefault[skill1direct][5], skill1X - 250, skill1Y, frame);
			}
			if (skill1cnt >= 6 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][6], skill1X - 300, skill1Y, frame);
			}
			if (skill1cnt >= 7 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][7], skill1X - 350, skill1Y, frame);
			}
			if (skill1cnt >= 8 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][8], skill1X - 400, skill1Y, frame);
			}
			charX -= 10;
			break;

		case 2:

			if (skill1cnt >= 0 && skill1cnt < 1) {

				g.drawImage(ArcherDefault[skill1direct][0], charX, charY, frame);
			} else if (skill1cnt >= 1 && skill1cnt < 2) {

				g.drawImage(ArcherDefault[skill1direct][1], charX, charY, frame);
			} else if (skill1cnt >= 2 && skill1cnt < 3) {

				g.drawImage(ArcherDefault[skill1direct][2], charX, charY, frame);
			} else if (skill1cnt >= 3 && skill1cnt < 4) {

				g.drawImage(ArcherDefault[skill1direct][3], charX, charY, frame);
			} else if (skill1cnt >= 4 && skill1cnt < 5) {

				g.drawImage(ArcherDefault[skill1direct][4], charX, charY, frame);
			} else if (skill1cnt >= 5 && skill1cnt < 6) {

				g.drawImage(ArcherDefault[skill1direct][5], charX, charY, frame);
			} else if (skill1cnt >= 6 && skill1cnt < 7) {

				g.drawImage(ArcherDefault[skill1direct][6], charX, charY, frame);
			} else if (skill1cnt >= 7 && skill1cnt < 8) {

				g.drawImage(ArcherDefault[skill1direct][7], charX, charY, frame);
			} else if (skill1cnt >= 8 && skill1cnt < 9) {

				g.drawImage(ArcherDefault[skill1direct][8], charX, charY, frame);
			} else
				g.drawImage(ArcherDefault[skill1direct][8], charX, charY, frame);

			if (skill1cnt >= 0 && skill1cnt < 3) {
				g.drawImage(ArcherDefault[skill1direct][0], skill1X, skill1Y, frame);
			}

			if (skill1cnt >= 1 && skill1cnt < 4) {
				g.drawImage(ArcherDefault[skill1direct][1], skill1X, skill1Y + 50, frame);
			}

			if (skill1cnt >= 2 && skill1cnt < 5) {
				g.drawImage(ArcherDefault[skill1direct][2], skill1X, skill1Y + 100, frame);
			}

			if (skill1cnt >= 3 && skill1cnt < 6) {
				g.drawImage(ArcherDefault[skill1direct][3], skill1X, skill1Y + 150, frame);
			}
			if (skill1cnt >= 4 && skill1cnt < 7) {
				g.drawImage(ArcherDefault[skill1direct][4], skill1X, skill1Y + 200, frame);
			}
			if (skill1cnt >= 5 && skill1cnt < 8) {
				g.drawImage(ArcherDefault[skill1direct][5], skill1X, skill1Y + 250, frame);
			}
			if (skill1cnt >= 6 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][6], skill1X, skill1Y + 300, frame);
			}
			if (skill1cnt >= 7 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][7], skill1X, skill1Y + 350, frame);
			}
			if (skill1cnt >= 8 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][8], skill1X, skill1Y + 400, frame);
			}
			charY += 10;
			break;
		case 3:

			if (skill1cnt >= 0 && skill1cnt < 1) {

				g.drawImage(ArcherDefault[skill1direct][0], charX, charY, frame);
			} else if (skill1cnt >= 1 && skill1cnt < 2) {

				g.drawImage(ArcherDefault[skill1direct][1], charX, charY, frame);
			} else if (skill1cnt >= 2 && skill1cnt < 3) {

				g.drawImage(ArcherDefault[skill1direct][2], charX, charY, frame);
			} else if (skill1cnt >= 3 && skill1cnt < 4) {

				g.drawImage(ArcherDefault[skill1direct][3], charX, charY, frame);
			} else if (skill1cnt >= 4 && skill1cnt < 5) {

				g.drawImage(ArcherDefault[skill1direct][4], charX, charY, frame);
			} else if (skill1cnt >= 5 && skill1cnt < 6) {

				g.drawImage(ArcherDefault[skill1direct][5], charX, charY, frame);
			} else if (skill1cnt >= 6 && skill1cnt < 7) {

				g.drawImage(ArcherDefault[skill1direct][6], charX, charY, frame);
			} else if (skill1cnt >= 7 && skill1cnt < 8) {

				g.drawImage(ArcherDefault[skill1direct][7], charX, charY, frame);
			} else if (skill1cnt >= 8 && skill1cnt < 9) {

				g.drawImage(ArcherDefault[skill1direct][8], charX, charY, frame);
			} else
				g.drawImage(ArcherDefault[skill1direct][8], charX, charY, frame);

			if (skill1cnt >= 0 && skill1cnt < 3) {
				g.drawImage(ArcherDefault[skill1direct][0], skill1X, skill1Y, frame);
			}

			if (skill1cnt >= 1 && skill1cnt < 4) {
				g.drawImage(ArcherDefault[skill1direct][1], skill1X + 50, skill1Y, frame);
			}

			if (skill1cnt >= 2 && skill1cnt < 5) {
				g.drawImage(ArcherDefault[skill1direct][2], skill1X + 100, skill1Y, frame);
			}

			if (skill1cnt >= 3 && skill1cnt < 6) {
				g.drawImage(ArcherDefault[skill1direct][3], skill1X + 150, skill1Y, frame);
			}
			if (skill1cnt >= 4 && skill1cnt < 7) {
				g.drawImage(ArcherDefault[skill1direct][4], skill1X + 200, skill1Y, frame);
			}
			if (skill1cnt >= 5 && skill1cnt < 8) {
				g.drawImage(ArcherDefault[skill1direct][5], skill1X + 250, skill1Y, frame);
			}
			if (skill1cnt >= 6 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][6], skill1X + 300, skill1Y, frame);
			}
			if (skill1cnt >= 7 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][7], skill1X + 350, skill1Y, frame);
			}
			if (skill1cnt >= 8 && skill1cnt < 9) {
				g.drawImage(ArcherDefault[skill1direct][8], skill1X + 400, skill1Y, frame);
			}
			charX += 10;
			break;

		}

	}

	public void skill2() {

	}

	public void DrawSkill2(Graphics g, ImageObserver frame) {
		skill2OnOff = false;
		skill2Count = 0;

		switch (skill2direct) {
		case 0:
			if (skill2cnt >= 0 && skill2cnt < 3) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y, frame);
			}
			if (skill2cnt >= 1 && skill2cnt < 4) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y + 25, frame);
			}
			if (skill2cnt >= 2 && skill2cnt < 5) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y + 65, frame);
			}
			if (skill2cnt >= 3 && skill2cnt < 6) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y + 95, frame);
			}
			if (skill2cnt >= 4 && skill2cnt < 7) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y + 110, frame);
			}
			if (skill2cnt >= 5 && skill2cnt < 8) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y + 145, frame);
			}
			if (skill2cnt < 8)
				charY += 10;
			break;

		case 1:
			if (skill2cnt >= 0 && skill2cnt < 3) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y, frame);
			}
			if (skill2cnt >= 1 && skill2cnt < 4) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X + 25, skill2Y, frame);
			}
			if (skill2cnt >= 2 && skill2cnt < 5) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X + 65, skill2Y, frame);
			}
			if (skill2cnt >= 3 && skill2cnt < 6) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X + 95, skill2Y, frame);
			}
			if (skill2cnt >= 4 && skill2cnt < 7) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X + 110, skill2Y, frame);
			}
			if (skill2cnt >= 5 && skill2cnt < 8) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X + 145, skill2Y, frame);
			}

			if (skill2cnt < 8)
				charX += 10;
			break;

		case 2:
			if (skill2cnt >= 0 && skill2cnt < 3) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y, frame);
			}
			if (skill2cnt >= 1 && skill2cnt < 4) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y - 25, frame);
			}
			if (skill2cnt >= 2 && skill2cnt < 5) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y - 65, frame);
			}
			if (skill2cnt >= 3 && skill2cnt < 6) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y - 95, frame);
			}
			if (skill2cnt >= 4 && skill2cnt < 7) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y - 110, frame);
			}
			if (skill2cnt >= 5 && skill2cnt < 8) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y - 145, frame);
			}

			if (skill2cnt < 8)
				charY -= 10;
			break;

		case 3:
			if (skill2cnt >= 0 && skill2cnt < 3) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X, skill2Y, frame);
			}
			if (skill2cnt >= 1 && skill2cnt < 4) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X - 25, skill2Y, frame);
			}
			if (skill2cnt >= 2 && skill2cnt < 5) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X - 65, skill2Y, frame);
			}
			if (skill2cnt >= 3 && skill2cnt < 6) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X - 95, skill2Y, frame);
			}
			if (skill2cnt >= 4 && skill2cnt < 7) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X - 110, skill2Y, frame);
			}
			if (skill2cnt >= 5 && skill2cnt < 8) {
				g.drawImage(ArcherDefault[skill2direct][0], skill2X - 145, skill2Y, frame);
			}

			if (skill2cnt < 8)
				charX -= 10;
			break;
		}

		if (skill2cnt >= 0 && skill2cnt < 8)
			g.drawImage(ArcherDefault[skill2direct][0], charX, charY, frame);
		if (skill2cnt >= 8 && skill2cnt < 8.5)
			g.drawImage(ArcherAttack[skill2direct][3], charX, charY, frame);
		if (skill2cnt >= 8.5 && skill2cnt < 9)
			g.drawImage(ArcherAttack[skill2direct][4], charX, charY, frame);
		if (skill2cnt >= 9 && skill2cnt < 9.5)
			g.drawImage(ArcherAttack[skill2direct][5], charX, charY, frame);
		if (skill2cnt >= 9.5 && skill2cnt < 10)
			g.drawImage(ArcherAttack[skill2direct][6], charX, charY, frame);
		if (skill2cnt >= 10 && skill2cnt < 10.5)
			g.drawImage(ArcherAttack[skill2direct][7], charX, charY, frame);
		if (skill2cnt >= 10.5 && skill2cnt < 11) {
			g.drawImage(ArcherAttack[skill2direct][8], charX, charY, frame);
			ar = new Arrow(charX, charY, moveStatus);
			arrowList.add(ar);
		}
		if (skill2cnt >= 11 && skill2cnt < 11.5)
			g.drawImage(ArcherAttack[skill2direct][9], charX, charY, frame);
		if (skill2cnt >= 11.5 && skill2cnt < 12)
			g.drawImage(ArcherAttack[skill2direct][10], charX, charY, frame);
		if (skill2cnt >= 12 && skill2cnt < 12.5)
			g.drawImage(ArcherAttack[skill2direct][11], charX, charY, frame);
		if (skill2cnt >= 12.5 && skill2cnt < 13) {
			g.drawImage(ArcherAttack[skill2direct][7], charX, charY, frame);
			ar = new Arrow(charX, charY, moveStatus);
			arrowList.add(ar);
		}
		if (skill2cnt >= 13 && skill2cnt < 13.5)
			g.drawImage(ArcherAttack[skill2direct][8], charX, charY, frame);
		if (skill2cnt >= 13.5 && skill2cnt < 14)
			g.drawImage(ArcherAttack[skill2direct][9], charX, charY, frame);
		if (skill2cnt >= 14 && skill2cnt < 14.5)
			g.drawImage(ArcherAttack[skill2direct][10], charX, charY, frame);
		if (skill2cnt >= 14.5 && skill2cnt < 15)
			g.drawImage(ArcherAttack[skill2direct][11], charX, charY, frame);
		if (skill2cnt >= 15 && skill2cnt < 15.5) {
			g.drawImage(ArcherAttack[skill2direct][7], charX, charY, frame);
			ar = new Arrow(charX, charY, moveStatus);
			arrowList.add(ar);
		}
		if (skill2cnt >= 15.5 && skill2cnt < 16)
			g.drawImage(ArcherAttack[skill2direct][8], charX, charY, frame);
		if (skill2cnt >= 16 && skill2cnt < 16.5)
			g.drawImage(ArcherAttack[skill2direct][9], charX, charY, frame);
		if (skill2cnt >= 16.5 && skill2cnt < 17)
			g.drawImage(ArcherAttack[skill2direct][10], charX, charY, frame);
		if (skill2cnt >= 17 && skill2cnt <= 18)
			g.drawImage(ArcherAttack[skill2direct][11], charX, charY, frame);
	}

	public void skill3() {

	}

	public void DrawSkill3(Graphics g, ImageObserver frame) {
		skill3OnOff = false;
		skill3Count = 0;

		switch (skill3direct) {
		case 0:
			if (skill3cnt >= 4.5 && skill3cnt < 6.5) {
				g.drawImage(ArcherSkill3[skill3direct][0], skill3X - 28, skill3Y - 20, frame);
			} else if (skill3cnt >= 6.5 && skill3cnt < 7.5) {
				g.drawImage(ArcherSkill3[skill3direct][1], skill3X - 28, skill3Y - 20, frame);
			} else if (skill3cnt >= 7.5 && skill3cnt < 9) {
				g.drawImage(ArcherSkill3[skill3direct][2], skill3X - 28, skill3Y - 20, frame);
			} else if (skill3cnt >= 9 && skill3cnt < 10) {
				g.drawImage(ArcherSkill3[skill3direct][3], skill3X - 28, skill3Y - 20, frame);
			} else if (skill3cnt >= 10 && skill3cnt < 11) {
				g.drawImage(ArcherSkill3[skill3direct][4], skill3X - 28, skill3Y - 20, frame);
			} else if (skill3cnt >= 11 && skill3cnt < 12.5) {
				g.drawImage(ArcherSkill3[skill3direct][5], skill3X - 28, skill3Y - 20, frame);
			} else if (skill3cnt >= 12.5 && skill3cnt < 14) {
				g.drawImage(ArcherSkill3[skill3direct][6], skill3X - 28, skill3Y - 20, frame);
			}
			break;
		case 1:
			if (skill3cnt >= 4.5 && skill3cnt < 6.5) {
				g.drawImage(ArcherSkill3[skill3direct][0], skill3X - 66, skill3Y - 22, frame);
			} else if (skill3cnt >= 6.5 && skill3cnt < 7.5) {
				g.drawImage(ArcherSkill3[skill3direct][1], skill3X - 66, skill3Y - 22, frame);
			} else if (skill3cnt >= 7.5 && skill3cnt < 9) {
				g.drawImage(ArcherSkill3[skill3direct][2], skill3X - 66, skill3Y - 22, frame);
			} else if (skill3cnt >= 9 && skill3cnt < 10) {
				g.drawImage(ArcherSkill3[skill3direct][3], skill3X - 66, skill3Y - 22, frame);
			} else if (skill3cnt >= 10 && skill3cnt < 11) {
				g.drawImage(ArcherSkill3[skill3direct][4], skill3X - 66, skill3Y - 22, frame);
			} else if (skill3cnt >= 11 && skill3cnt < 12.5) {
				g.drawImage(ArcherSkill3[skill3direct][5], skill3X - 66, skill3Y - 22, frame);
			} else if (skill3cnt >= 12.5 && skill3cnt < 14) {
				g.drawImage(ArcherSkill3[skill3direct][6], skill3X - 66, skill3Y - 22, frame);
			}
			break;
		case 2:
			if (skill3cnt >= 4.5 && skill3cnt < 6.5) {
				g.drawImage(ArcherSkill3[skill3direct][0], skill3X - 30, skill3Y - 12, frame);
			} else if (skill3cnt >= 6.5 && skill3cnt < 7.5) {
				g.drawImage(ArcherSkill3[skill3direct][1], skill3X - 30, skill3Y - 12, frame);
			} else if (skill3cnt >= 7.5 && skill3cnt < 9) {
				g.drawImage(ArcherSkill3[skill3direct][2], skill3X - 30, skill3Y - 12, frame);
			} else if (skill3cnt >= 9 && skill3cnt < 10) {
				g.drawImage(ArcherSkill3[skill3direct][3], skill3X - 30, skill3Y - 12, frame);
			} else if (skill3cnt >= 10 && skill3cnt < 11) {
				g.drawImage(ArcherSkill3[skill3direct][4], skill3X - 30, skill3Y - 12, frame);
			} else if (skill3cnt >= 11 && skill3cnt < 12.5) {
				g.drawImage(ArcherSkill3[skill3direct][5], skill3X - 30, skill3Y - 12, frame);
			} else if (skill3cnt >= 12.5 && skill3cnt < 14) {
				g.drawImage(ArcherSkill3[skill3direct][6], skill3X - 30, skill3Y - 12, frame);
			}
			break;
		case 3:
			if (skill3cnt >= 4.5 && skill3cnt < 6.5) {
				g.drawImage(ArcherSkill3[skill3direct][0], skill3X + 5, skill3Y - 22, frame);
			} else if (skill3cnt >= 6.5 && skill3cnt < 7.5) {
				g.drawImage(ArcherSkill3[skill3direct][1], skill3X + 5, skill3Y - 22, frame);
			} else if (skill3cnt >= 7.5 && skill3cnt < 9) {
				g.drawImage(ArcherSkill3[skill3direct][2], skill3X + 5, skill3Y - 22, frame);
			} else if (skill3cnt >= 9 && skill3cnt < 10) {
				g.drawImage(ArcherSkill3[skill3direct][3], skill3X + 5, skill3Y - 22, frame);
			} else if (skill3cnt >= 10 && skill3cnt < 11) {
				g.drawImage(ArcherSkill3[skill3direct][4], skill3X + 5, skill3Y - 22, frame);
			} else if (skill3cnt >= 11 && skill3cnt < 12.5) {
				g.drawImage(ArcherSkill3[skill3direct][5], skill3X + 5, skill3Y - 22, frame);
			} else if (skill3cnt >= 12.5 && skill3cnt < 14) {
				g.drawImage(ArcherSkill3[skill3direct][6], skill3X + 5, skill3Y - 22, frame);
			}

			break;
		}

	}

	public void DrawSkill3Montion(Graphics g, ImageObserver frame) {
		if (skill3cnt >= 0 && skill3cnt < 0.5)
			g.drawImage(ArcherAttack[skill3direct][0], skill3X, skill3Y, frame);
		if (skill3cnt >= 0.5 && skill3cnt < 1)
			g.drawImage(ArcherAttack[skill3direct][1], skill3X, skill3Y, frame);
		if (skill3cnt >= 1 && skill3cnt < 1.5)
			g.drawImage(ArcherAttack[skill3direct][2], skill3X, skill3Y, frame);
		if (skill3cnt >= 1.5 && skill3cnt < 2)
			g.drawImage(ArcherAttack[skill3direct][3], skill3X, skill3Y, frame);
		if (skill3cnt >= 2.0 && skill3cnt < 2.5)
			g.drawImage(ArcherAttack[skill3direct][4], skill3X, skill3Y, frame);
		if (skill3cnt >= 2.5 && skill3cnt < 3)
			g.drawImage(ArcherAttack[skill3direct][5], skill3X, skill3Y, frame);
		if (skill3cnt >= 3 && skill3cnt < 3.5)
			g.drawImage(ArcherAttack[skill3direct][6], skill3X, skill3Y, frame);
		if (skill3cnt >= 3.5 && skill3cnt < 4)
			g.drawImage(ArcherAttack[skill3direct][7], skill3X, skill3Y, frame);
		if (skill3cnt >= 4 && skill3cnt < 4.5)
			g.drawImage(ArcherAttack[skill3direct][8], skill3X, skill3Y, frame);
		if (skill3cnt >= 4.5 && skill3cnt < 14)
			g.drawImage(ArcherAttack[skill3direct][8], skill3X, skill3Y, frame);
		if (skill3cnt >= 14 && skill3cnt < 15) {
			ar = new Arrow(skill3X, skill3Y, skill3direct, true);
			arrowList.add(ar);
			g.drawImage(ArcherAttack[skill3direct][9], skill3X, skill3Y, frame);
		}
		if (skill3cnt >= 15 && skill3cnt < 16)
			g.drawImage(ArcherAttack[skill3direct][10], skill3X, skill3Y, frame);
		if (skill3cnt >= 16 && skill3cnt < 17)
			g.drawImage(ArcherAttack[skill3direct][11], skill3X, skill3Y, frame);
	}

	@Override
	public void keyTyped(KeyEvent e) {

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
		DrawArrow(g, frame);
	}

	@Override
	public void skill0Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		if (p.keyA && p.skill0OnOff) {
			p.skill0On = true;
			getSkill0();
		}
		if (p.skill0On) {
			DrawSkill0Montion(g1, frame);
		}
		DrawSkill0(g, frame);
	}

	@Override
	public void skill1Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		if (p.keyS && p.skill1OnOff) {
			p.skill1On = true;
			getSkill1();
			skilling = true;
		}
		if (p.skill1On) {
			DrawSkill1(g1, frame);
		}
	}

	@Override
	public void skill2Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		if (p.keyD && p.skill2OnOff) {
			p.skill2On = true;
			getSkill2();
			skilling = true;
		}
		if (p.skill2On) {
			DrawSkill2(g1, frame);
		}

	}

	@Override
	public void skill3Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		if (p.keyF && p.skill3OnOff) {
			p.skill3On = true;
			getSkill3();
			skilling = true;
		}
		if (p.skill3On) {
			DrawSkill3Montion(g1, frame);
			DrawSkill3(g, frame);
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

	@Override
	public void timer() {
		if (attackOn)
			attackcnt += 0.2;
		if (attackcnt > 12)
			attackOn = false;
		attackCount++;
		if (attackCount > 50) {
			attackOnOff = true;
			attackcnt = 0;
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

	class Arrow {

		int x, y;
		int speed = 5;
		int direct;
		int plusX;
		int plusY;
		Image arrowImg;

		public Arrow(int x, int y, int direct) {
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
				this.y += 35;
				this.plusX = -speed;
				this.plusY = 0;
				break;
			case 2:
				this.x += 35;
				this.y += 60;
				this.plusX = 0;
				this.plusY = speed;
				break;
			case 3:
				this.y += 35;
				this.x += 30;
				this.plusX = speed;
				this.plusY = 0;
				break;
			}

			arrowImg = new ImageIcon("화살" + direct + ".png").getImage();
		}

		public Arrow(int x, int y, int direct, boolean t) {
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

			arrowImg = new ImageIcon("스킬 화살" + direct + ".png").getImage();
		}

		public Arrow(int x, int y, int direct, int skill) {
			this.x = x;
			this.y = y;
			this.direct = direct;

			switch (direct) {
			case 0:
				this.x += 35;
				this.plusX = 0;
				this.plusY = -speed;

				switch (skill) {
				case 0:
					this.y -= 15;
					break;
				case 1:
					this.x -= 10;
					this.y -= 10;
					break;
				case 2:
					this.x += 10;
					break;
				}
				break;
			case 1:
				this.y += 30;
				this.plusX = -speed;
				this.plusY = 0;

				switch (skill) {
				case 0:
					this.x -= 15;
					break;
				case 1:
					this.x -= 10;
					this.y -= 10;
					break;
				case 2:
					this.y += 10;
					break;
				}
				break;
			case 2:
				this.x += 35;
				this.y += 60;
				this.plusX = 0;
				this.plusY = speed;

				switch (skill) {
				case 0:
					this.y += 15;
					break;
				case 1:
					this.x -= 10;
					this.y += 10;
					break;
				case 2:
					this.x += 10;
					break;
				}
				break;
			case 3:
				this.y += 30;
				this.x += 30;
				this.plusX = speed;
				this.plusY = 0;

				switch (skill) {
				case 0:
					this.x += 15;
					break;
				case 1:
					this.x += 10;
					this.y -= 10;
					break;
				case 2:
					this.y += 10;
					break;
				}
				break;
			}

			arrowImg = new ImageIcon("화살" + direct + ".png").getImage();
		}

		public void move() {
			x += plusX;
			y += plusY;
		}

	}

}
