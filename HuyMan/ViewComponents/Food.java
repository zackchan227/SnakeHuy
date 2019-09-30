import java.util.Random;
import javax.swing.ImageIcon;

public class Food{

	public class java {

	}

	private int[] foodX = {20,40,60,80,100,120,140,160,180,200,220,240,260,280,300,320,340};
	private int[] foodY = {20,40,60,80,100,120,140,160,180,200,220,240,260,280,300,320,340};
	private ImageIcon food;

	private Random rd = new Random();
	private int posX = rd.nextInt(foodX.length);
	private int posY = rd.nextInt(foodY.length);

	public Food() {
		
		this.foodX = new int[posX];
		this.foodY = new int[posY];
		this.food = new ImageIcon("img//poop.jpg");
		
	}
	
	
}