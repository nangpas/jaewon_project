import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Missile {
	
	Image msImg;
	int startX, startY;
	int tarX, tarY;
	int msSpeed;
	double plusX, plusY;
	int direction = 5;

	public Missile(int x, int y, int tx, int ty, int speed, Image i) {
		startX = x;
		startY = y;
		tarX = tx;
		tarY = ty;
		msSpeed = speed;
		msImg = i;
		
		if (tarX >= startX && tarY < startY) {
			plusY = -1 * ((startY - tarY)
					/ Math.sqrt(((startY - tarY) * (startY - tarY)) + ((tarX - startX) * (tarX - startX))));
			plusX = ((tarX - startX)
					/ Math.sqrt(((startY - tarY) * (startY - tarY)) + ((tarX - startX) * (tarX - startX))));
		} else if (tarX >= startX && tarY >= startY) {
			plusY = ((tarY - startY)
					/ Math.sqrt(((tarY - startY) * (tarY - startY)) + ((tarX - startX) * (tarX - startX))));
			plusX = ((tarX - startX)
					/ Math.sqrt(((tarY - startY) * (tarY - startY)) + ((tarX - startX) * (tarX - startX))));
		} else if (tarX < startX && tarY < startY) {
			plusY = -1 * ((startY - tarY)
					/ Math.sqrt(((startY - tarY) * (startY - tarY)) + ((startX - tarX) * (startX - tarX))));
			plusX = -1 * ((startX - tarX)
					/ Math.sqrt(((startY - tarY) * (startY - tarY)) + ((startX - tarX) * (startX - tarX))));
		} else if (tarX < startX && tarY >= startY) {
			plusY = ((tarY - startY)
					/ Math.sqrt(((tarY - startY) * (tarY - startY)) + ((startX - tarX) * (startX - tarX))));
			plusX = -1 * ((startX - tarX)
					/ Math.sqrt(((tarY - startY) * (tarY - startY)) + ((startX - tarX) * (startX - tarX))));
		} else if (tarX == startX && tarY < startY)
			direction = 0;
		else if (tarX == startX && tarY > startY)
			direction = 2;
		else if (tarX > startX && tarY == startY)
			direction = 1;
		else if (tarX < startX && tarY == startY)
			direction = 3;
		else if (tarX == startX && tarY == startY)
			direction = 0;

	}
	
	
	public void drawMissile(Graphics g, ImageObserver frame){
		for (int i = 0; i < Main.missileList.size(); ++i) {
			Main.ms = (Missile) (Main.missileList.get(i));
			g.drawImage(Main.ms.msImg, Main.ms.startX, Main.ms.startY, frame);
			Main.ms.move();
			if (Main.ms.startX > Main.f_width + 100)
				Main.missileList.remove(i);
			if (Main.ms.startX < 0)
				Main.missileList.remove(i);
			if (Main.ms.startY >  Main.f_height + 100)
				Main.missileList.remove(i);
			if (Main.ms.startY < 0)
				Main.missileList.remove(i);
		}
	}
	
	
	public void move() {
		
		if (direction == 0) {
			startY -= 8 * msSpeed;
		} else if (direction == 1) {
			startX += 8 * msSpeed;
		} else if (direction == 2) {
			startY += 8 * msSpeed;
		} else if (direction == 3) {
			startX -= 8 * msSpeed;
		} else if (direction == 5) {
			startX += plusX * msSpeed;
			startY += plusY * msSpeed;
		}
	}
	
	public void guideMove(int x, int y){
		startX = x;
		startY = y;
		
		if (tarX >= startX && tarY < startY) {
			plusY = (int) (-1 * ((startY - tarY)
					/ Math.sqrt(((startY - tarY) * (startY - tarY)) + ((tarX - startX) * (tarX - startX)))));
			plusX = (int) (((tarX - startX)
					/ Math.sqrt(((startY - tarY) * (startY - tarY)) + ((tarX - startX) * (tarX - startX)))));
		} else if (tarX >= startX && tarY >= startY) {
			plusY = (int) (((tarY - startY)
					/ Math.sqrt(((tarY - startY) * (tarY - startY)) + ((tarX - startX) * (tarX - startX)))));
			plusX = (int) (((tarX - startX)
					/ Math.sqrt(((tarY - startY) * (tarY - startY)) + ((tarX - startX) * (tarX - startX)))));
		} else if (tarX < startX && tarY < startY) {
			plusY = (int) (-1 * ((startY - tarY)
					/ Math.sqrt(((startY - tarY) * (startY - tarY)) + ((startX - tarX) * (startX - tarX)))));
			plusX = (int) (-1 * ((startX - tarX)
					/ Math.sqrt(((startY - tarY) * (startY - tarY)) + ((startX - tarX) * (startX - tarX)))));
		} else if (tarX < startX && tarY >= startY) {
			plusY = (int) (((tarY - startY)
					/ Math.sqrt(((tarY - startY) * (tarY - startY)) + ((startX - tarX) * (startX - tarX)))));
			plusX = (int) (-1 * ((startX - tarX)
					/ Math.sqrt(((tarY - startY) * (tarY - startY)) + ((startX - tarX) * (startX - tarX)))));
		} else if (tarX == startX && tarY < startY)
			direction = 0;
		else if (tarX == startX && tarY > startY)
			direction = 2;
		else if (tarX > startX && tarY == startY)
			direction = 1;
		else if (tarX < startX && tarY == startY)
			direction = 3;
		else if (tarX == startX && tarY == startY)
			direction = 0;
		
		move();
	}
}
