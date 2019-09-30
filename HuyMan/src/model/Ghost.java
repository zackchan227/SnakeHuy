package model;

public class Ghost {

	private int x;
	private int y;
	private String imagePath;
	private boolean isAlive;
	
	public Ghost(int x, int y, String imagePath, boolean isAlive) {
		super();
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
		this.isAlive = isAlive;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public boolean isAlive() {
		return isAlive;
	}	
}
