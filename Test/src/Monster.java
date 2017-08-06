import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Monster {
	int x,y; //ÁÂÇ¥
	double hp; 
	
	Image monsterImg;
	
	
	public Monster(int x, int y){
		this.x = x;
		this.y = y;
		hp = 50;
		monsterImg = new ImageIcon("star.png").getImage();
	}
	
	public void Draw_monster(Graphics g, ImageObserver frame){
		g.setClip(x,y,Main.ImageWidthValue("star.png"), Main.ImageHeigthValue("star.png"));
		g.drawImage(monsterImg, x, y, frame);
	}
	
	public void monsterMove(){
		
	}
}
