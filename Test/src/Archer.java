import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Archer extends Player {
	
	
	Image[][] ArcherDefault;
	
	
	public Archer(int x, int y){
		super(x,y);
		maxHp = 500;
		hp = 500;
		barrier = 200;
		speedOfAttack = 25;
		speedOfPlayer = 5;
		power = 0.2;
		
		ArcherDefault = new Image[4][9];
		for (int i = 0; i < ArcherDefault.length; ++i)
			for (int j = 0; j < ArcherDefault[i].length; ++j)
				ArcherDefault[i][j] = new ImageIcon("±Ã¼ö ±âº» " + i + "_" + j + ".png").getImage();
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
	

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void skillProcess() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attackProcess(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		Draw_human(g1, frame);
	}

	@Override
	public void skill0Process(Player p, Graphics g, Graphics g1, ImageObserver frame) {
		// TODO Auto-generated method stub
		
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
		
		
	}

}
