package model;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PacMan {

	private int life;
	private int x;
	private int y;
	private String imagePath;
	private boolean isAlive;
	
	public PacMan(int life, int x, int y, String imagePath, boolean isAlive) {
		super();
		this.setlife(life);
		this.setX(x);
		this.setY(y);
		this.setimagePath(imagePath);
		this.setAlive(isAlive);
	}
	public int getlife() {
		return life;
	}
	public void setlife(int life) {
		this.life = life;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getimagePath() {
		return imagePath;
	}
	public void setimagePath(String imagePath) {
		if (imagePath == null) {
			JOptionPane.showMessageDialog(null, "Invalid");
		}
		else if (imagePath.length() == 0) {
			JOptionPane.showMessageDialog(null, "Empty");
		}
		else
		this.imagePath = imagePath;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public void draw(Graphics g) {
		ImageIcon img = new ImageIcon(imagePath);
		g.drawImage(img.getImage() ,x ,y ,null);
	}
	
}
