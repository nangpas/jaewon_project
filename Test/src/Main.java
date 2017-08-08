import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame implements Runnable {

	public static int playercount = 2;

	public static int f_width = 1300;
	public static int f_height = 700;
	public static int count = 0;
	public static int warrior = 0;
	public static int thief = 1;
	public static int prist = 2;
	public static int magication = 3;

	Image buffimg;

	public static Graphics humanG[] = new Graphics[playercount];
	public static Graphics monsterG[] = new Graphics[playercount];
	public static Graphics skillG[] = new Graphics[4];

	
	public static ArrayList playerList = new ArrayList();
	public static ArrayList monsterList = new ArrayList();

	public static Player p;
	public static Monster ms;
	

	
	Thread th;

	public Main() {
		setTitle("�׽�Ʈ");
		setSize(f_width, f_height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new Warrior(300, 300);
		playerList.add(p);
		
		for (int i = 0; i < playerList.size(); i++) {
			p = (Player) playerList.get(i);
			addKeyListener(p);
		}
		

		for (int i = 0; i < playercount; i++) {
			ms = new Monster(600, 250);
			monsterList.add(ms);
		}

		th = new Thread(this);
		th.start();
		setVisible(true);

	}

	@Override
	public void paint(Graphics g) {
		buffimg = createImage(f_width, f_height);
		for (int i = 0; i < humanG.length; i++)
			humanG[i] = buffimg.getGraphics();
		for (int i = 0; i < monsterG.length; i++)
			monsterG[i] = buffimg.getGraphics();
		for (int i = 0; i < skillG.length; i++)
			skillG[i] = buffimg.getGraphics();

		update(g);
	}

	@Override
	public void update(Graphics g) {
		
		
		
		for (int i = 0; i < monsterList.size(); i++) {
			ms = (Monster) monsterList.get(i);
			ms.Draw_monster(monsterG[i], this);
			ms.monsterMove();
		}
		
		
		
		for (int i = 0; i < playerList.size(); i++) {
			p = (Player) playerList.get(i);
			if (p.keySpace && p.attatckOnOff)
				p.attatckOn = true;
			if(p.attatckOn){
				p.DrawAttack(humanG[i], this);
				p.attackcnt += 0.48;
				p.attack();
				if (p.attackcnt > 6) {
					p.attackcnt = 0;
					p.attatckOn = false;
				}
			} else
				p.Draw_human(humanG[i], this);
			
			if(p.keyA && p.skill0OnOff){
				p.skill0On = true;
				p.skill0X = p.charX;
				p.skill0Y = p.charY;
			}
			
			if(p.skill0On){
				p.DrawSkill0(skillG[0], this);
				p.skill0cnt += 0.4;
				if (p.skill0cnt > 6) {
					p.skill0time -= 0.2;
					if(p.skill0time < 0){
						p.skill0cnt = 0;
						p.skill0On = false;
						p.skill0time = 50;
					}
				}
			}
			
		}

		g.drawImage(buffimg, 0, 0, this);
	}
	
	
	

	@Override
	public void run() {
		while (true) {
			try {
				for (int i = 0; i < playerList.size(); i++) {
					p = (Player) playerList.get(i);
					p.keyProcess();
					p.attackCount++;
					p.skill0Count++;
					if (p.attackCount > p.speedOfAttack) 
						p.attatckOnOff = true;
					if(p.skill0Count > 20)
						p.skill0OnOff = true;

				}
				repaint();
				Thread.sleep(20);
				count++;

			} catch (Exception e) {
			}
		}
	}

	public static int ImageWidthValue(String file) {
		int x = 0;
		try {
			File f = new File(file);
			BufferedImage bi = ImageIO.read(f);

			x = bi.getWidth();
		} catch (Exception e) {
		}
		return x;

	}

	public static int ImageHeigthValue(String file) {
		int y = 0;
		try {
			File f = new File(file);
			BufferedImage bi = ImageIO.read(f);
			y = bi.getHeight();
		} catch (Exception e) {
		}
		return y;
	}

	public static boolean Crash(Rectangle r, int x2, int y2, Graphics img2) {
		boolean check = false;
		int x1 = r.x;
		int y1 = r.y;

		Rectangle h = img2.getClipBounds();

		if (Math.abs((x1 + r.width / 2) - (x2 + h.width / 2)) < (h.width / 2 + r.width / 2)
				&& Math.abs((y1 + r.height / 2) - (y2 + h.height / 2)) < (h.height / 2 + r.height / 2)) {
			check = true;
		} else {
			check = false;
		}

		return check;
	}

	public static boolean Crash(int x1, int y1, int x2, int y2, Graphics img1, Graphics img2) {

		boolean check = false;
		Rectangle r = img1.getClipBounds();
		Rectangle h = img2.getClipBounds();

		if (Math.abs((x1 + r.width / 2) - (x2 + h.width / 2)) < (h.width / 2 + r.width / 2)
				&& Math.abs((y1 + r.height / 2) - (y2 + h.height / 2)) < (h.height / 2 + r.height / 2)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public static boolean Crash(int x1, int y1, int x2, int y2, Image img1, Image img2) {

		boolean check = false;

		Rectangle r = new Rectangle(x1, y1, img1.getHeight(null), img1.getHeight(null));
		Rectangle h = new Rectangle(x2, y2, img2.getHeight(null), img2.getHeight(null));

		if (Math.abs((x1 + r.width / 2) - (x2 + h.width / 2)) < (h.width / 2 + r.width / 2)
				&& Math.abs((y1 + r.height / 2) - (y2 + h.height / 2)) < (h.height / 2 + r.height / 2)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public static void main(String[] args) {
		new Main();
	}
}