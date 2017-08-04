import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

class TestFrame extends JFrame implements KeyListener, Runnable {

	int charX;
	int charY;
	int count;
	int moveStatus;

	boolean keyUp = false;
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean keySpace = false;
	boolean playerMove = false;

	Image buffer;
	Image human_img;
	Image back_img;
	Image shield_img;
	
	Graphics humangc;
	Graphics backgc;
	Graphics shieldgc;
	
	Thread th;
	
	

	
	public TestFrame() {
		setTitle("테스트");
		setSize(1300, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		charX = 300;
		charY = 300;
		count = 0;
		moveStatus = 0;
		human_img = new ImageIcon("캐릭터.png").getImage();
		back_img = new ImageIcon("배경화면.png").getImage();
		shield_img = new ImageIcon("기본방패.png").getImage();
		
		this.addKeyListener(this);
		th = new Thread(this);
		th.start();
		
		setResizable(false);
		setVisible(true);
	}

	public void paint(Graphics g) {
		buffer = createImage(1300, 700);
		humangc = buffer.getGraphics();
		backgc = buffer.getGraphics();
		shieldgc = buffer.getGraphics();
		update(g);
	}
	
	
	public void update(Graphics g) {
		Draw_back();
		Draw_shield();
		g.drawImage(buffer, 0, 0, this);
	}
	
	
	
	public void Draw_back(){
		backgc.drawImage(back_img, 0, 0, this);
		backgc.setColor(Color.WHITE);
		backgc.drawString(charX+","+charY, 100, 100);
	}

	public void Draw_img() {
		MoveImage(human_img, charX, charY, 130 / 4, 195 / 4);
	}
	
	public void Draw_shield(){
		//shieldgc.setClip(charX,charY,101/3, 41);
		//shieldgc.drawImage(shield_img,charX, charY, this);
		
		if(moveStatus == 3){
			shieldgc.setClip(charX+5, charY-5, 36, 42);
			shieldgc.drawImage(shield_img, charX-31, charY-5, this);
		}
		else if(moveStatus == 0){
			shieldgc.setClip(charX-5, charY+10, 36, 42);
			shieldgc.drawImage(shield_img, charX-5, charY+10, this);
		}else if(moveStatus == 1){
			shieldgc.setClip(charX-5, charY+5, 10, 42 );
			shieldgc.drawImage(shield_img, charX-80, charY+5, this);
		}else{
			shieldgc.setClip(charX+28, charY+5, 10, 42 );
			shieldgc.drawImage(shield_img, charX-63, charY+5, this);
		}
		
	}

	
	public void MoveImage(Image img, int x, int y, int width, int height) {
		humangc.setClip(x, y, width, height); // 이미지 짜르기
		if (playerMove) {
			if (count / 10 % 4 == 3) {
				humangc.drawImage(img, x - (width * 0), y - (height * moveStatus), this);
			} else if (count / 10 % 4 == 2) {
				humangc.drawImage(img, x - (width * 1), y - (height * moveStatus), this);
			} else if (count / 10 % 4 == 0) {
				humangc.drawImage(img, x - (width * 2), y - (height * moveStatus), this);
			} else if (count / 10 % 4 == 1) {
				humangc.drawImage(img, x - (width * 1), y - (height * moveStatus), this);
			}
		} else {
			humangc.drawImage(img, x - (width * 1), y - (height * moveStatus), this);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				keyProcess();
				repaint();
				Thread.sleep(20);
				count++;
			} catch (Exception e) {}
		}
	}
	
	

	public void keyProcess() {
		playerMove = false;
		if (keyUp) {
			playerMove = true;
			if (charY > 25) {
				charY -= 5;
				moveStatus = 3;
			}
		}
		if (keyDown) {
			playerMove = true;
			if (charY < 700 - 50) {
				charY += 5;
				moveStatus = 0;
			}
		}
		if (keyLeft) {
			playerMove = true;
			if (charX > 0) {
				charX -= 5;
				moveStatus = 1;
			}
		}
		if (keyRight) {
			playerMove = true;
			if (charX < 1300 - 25) {
				charX += 5;
				moveStatus = 2;
			}
		}
	}

	

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			keyLeft = true;
			break;
		case KeyEvent.VK_RIGHT:
			keyRight = true;
			break;
		case KeyEvent.VK_UP:
			keyUp = true;
			break;
		case KeyEvent.VK_DOWN:
			keyDown = true;
			break;
		case KeyEvent.VK_SPACE:
			keySpace = true;
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
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
		case KeyEvent.VK_SPACE:
			keySpace = false;
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}

public class Test {

	public static void main(String[] args) {
		new TestFrame();
	}

}
