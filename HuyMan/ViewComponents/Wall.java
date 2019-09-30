
import javax.swing.ImageIcon;

public class Wall{

	private int[] wallX = {0,20,40,60,80,100,120,140,160,180,200,220,240,260,280,300,320,340,360};
	private int[] wallY = {0,20,40,60,80,100,120,140,160,180,200,220,240,260,280,300,320,340,360};
	private ImageIcon wall;
	private int wallCount;

	public Wall() {
		
		this.wallX = new int[wallX.length];
		this.wallY = new int[wallY.length];
		this.wall = new ImageIcon("img//poop1.jpg");
		this.wallCount = wallX.length;
		
	}

	public int[] getWallX() {
		return wallX;
	}

	public void setWallX(int[] wallX) {
		this.wallX = wallX;
	}

	public ImageIcon getWall() {
		return wall;
	}

	public void setWall(ImageIcon wall) {
		this.wall = wall;
	}

	public static int getWallCount() {
		return wallCount;
	}

	public void setWallCount(int wallCount) {
		this.wallCount = wallCount;
	}
	
}