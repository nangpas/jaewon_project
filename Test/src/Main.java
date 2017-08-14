import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
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
	public static Graphics skillG[] = new Graphics[5];

	public static Graphics missileG;
	public static Graphics hpG;

	public static ArrayList playerList = new ArrayList();
	public static ArrayList monsterList = new ArrayList();
	public static ArrayList missileList = new ArrayList();

	public static Player p;
	public static Monster mon;
	public static Missile ms;

	Thread th;

	public Main() {
		setTitle("Å×½ºÆ®");
		setSize(f_width, f_height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new Archer(300, 300);
		playerList.add(p);
		p = new Warrior(200, 200);
		playerList.add(p);
		for (int i = 0; i < playerList.size(); i++) {
			p = (Player) playerList.get(i);
			addKeyListener(p);
		}

		for (int i = 0; i < playercount; i++) {
			mon = new Monster(600, 250);
			monsterList.add(mon);
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
		missileG = buffimg.getGraphics();
		hpG = buffimg.getGraphics();
		update(g);
	}

	@Override
	public void update(Graphics g) {

		for (int i = 0; i < monsterList.size(); i++) {
			mon = (Monster) monsterList.get(i);
			mon.Draw_monster(monsterG[i], this);
			mon.monsterMove();
		}

		for (int i = 0; i < playerList.size(); i++) {
			p = (Player) playerList.get(i);
			p.attackProcess(p, skillG[i], humanG[i], this);
			p.skill0Process(p, skillG[i], humanG[i], this);
			p.skill1Process(p, skillG[i], humanG[i], this);
			p.skill2Process(p, skillG[i], humanG[i], this);
			p.skill3Process(p, skillG[i], humanG[i], this);
		}

		if (missileList.size() != 0) {
			ms.drawMissile(missileG, this);
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
					p.timer();
					
				}
				repaint();
				Thread.sleep(10);
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

	public static boolean Crash(int x1, int y1, int x2, int y2, Image img1, Image img2, int x) {

		boolean check = false;
		double a;

		Rectangle r = new Rectangle(x1, y1, img1.getHeight(null), img1.getHeight(null));
		Rectangle h = new Rectangle(x2, y2, img2.getHeight(null), img2.getHeight(null));

		if (x == 1) {
			if (Math.abs((x1 + r.width / 2) - (x2 + h.width / 2)) < (h.width / 2 + r.width / 2)
					&& Math.abs((y1 + r.height / 2) - (y2 + h.height / 2)) < (h.height / 2 + r.height / 2)) {
				check = true;
			} else {
				check = false;
			}
		} else {

			a = Math.sqrt(((x1 + 12) - (x2 + 140)) * ((x1 + 12) - (x2 + 140))
					+ ((y1 + 12) - (y2 + 140)) * ((y1 + 12) - (y2 + 140)));

			if ((r.width / 2 + h.width / 2) > a) {
				check = true;
			} else {
				check = false;
			}
		}
		return check;
	}

	public static void main(String[] args) {
		new Main();
	}
}