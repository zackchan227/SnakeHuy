
import javax.swing.*;

public class Huy {
	
	

	private int[] huyLengthX;
	private int[] huyLengthY;
	
	private int huyLength;	

	private ImageIcon huyLeft;
	private ImageIcon huyRight;
	private ImageIcon huyUp;
	private ImageIcon huyDown;
	
	private ImageIcon huyLeftS;
	private ImageIcon huyRightS;
	private ImageIcon huyUpS;
	private ImageIcon huyDownS;
		
	public Huy() {
		
		this.huyLength = 3;
		this.setHuyLengthX(new int[750]);
		this.setHuyLengthY(new int[750]);
		
		this.huyRight = new ImageIcon("img//huyRight.jpg");
		this.huyLeft = new ImageIcon("img//huyLeft.jpg");
		this.huyUp = new ImageIcon("img//huyUp.jpg");
		this.huyDown = new ImageIcon("img//huyDown.jpg");
		
		this.huyRightS = new ImageIcon("img//huyRightS.jpg");
		this.huyLeftS = new ImageIcon("img//huyLeftS.jpg");
		this.huyDownS = new ImageIcon("img//huyDownS.jpg");
		this.huyUpS = new ImageIcon("img//huyUpS.jpg");
	}

	public int[] getHuyLengthX() {
		return huyLengthX;
	}

	public void setHuyLengthX(int[] huyLengthX) {
		this.huyLengthX = huyLengthX;
	}
	
	public int[] getHuyLengthY() {
		return huyLengthY;
	}

	public void setHuyLengthY(int[] huyLengthY) {
		this.huyLengthY = huyLengthY;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public int getHuyLength() {
		return huyLength;
	}

	public void setHuyLength(int huyLength) {
		this.huyLength = huyLength;
	}

	public ImageIcon getHuyLeft() {
		return huyLeft;
	}

	public void setHuyLeft(ImageIcon huyLeft) {
		this.huyLeft = huyLeft;
	}

	public ImageIcon getHuyRight() {
		return huyRight;
	}

	public void setHuyRight(ImageIcon huyRight) {
		this.huyRight = huyRight;
	}

	public ImageIcon getHuyUp() {
		return huyUp;
	}

	public void setHuyUp(ImageIcon huyUp) {
		this.huyUp = huyUp;
	}

	public ImageIcon getHuyDown() {
		return huyDown;
	}

	public void setHuyDown(ImageIcon huyDown) {
		this.huyDown = huyDown;
	}

	public ImageIcon getHuyLeftS() {
		return huyLeftS;
	}

	public void setHuyLeftS(ImageIcon huyLeftS) {
		this.huyLeftS = huyLeftS;
	}

	public ImageIcon getHuyRightS() {
		return huyRightS;
	}

	public void setHuyRightS(ImageIcon huyRightS) {
		this.huyRightS = huyRightS;
	}

	public ImageIcon getHuyUpS() {
		return huyUpS;
	}

	public void setHuyUpS(ImageIcon huyUpS) {
		this.huyUpS = huyUpS;
	}

	public ImageIcon getHuyDownS() {
		return huyDownS;
	}

	public void setHuyDownS(ImageIcon huyDownS) {
		this.huyDownS = huyDownS;
	}

}

	