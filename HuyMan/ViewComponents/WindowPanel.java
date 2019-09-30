
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WindowPanel extends JPanel {
	
	private Color Color;
	private JFrame WindowPanel = new JFrame();
	private ImageIcon WindowPanelIcon = new ImageIcon("img//icon.png");
	private ImageIcon background = new ImageIcon("img//black.jpg");
		
	private boolean isPause = true;
	private ImageIcon pause;
	
	private boolean isGameOver;
	
	private Timer timer;
	private int delay = 100;
	
	private int moves = 0;
	
	private Huy Huy;
	private Food Food;
	private Wall.getWall Wall.getWall;
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	public WindowPanel() {
		
		Huy = new Huy();
		Food = new Food();
		Wall.getWall = new Wall.getWall();
		this.setFocusable(true);
		//this.addKeyListener(this);
		this.setFocusTraversalKeysEnabled(false);
		//timer = new Timer(delay,this);
		timer.start();
		WindowPanel.add(this);
		WindowPanel.setSize(395,420);
		WindowPanel.setLocationRelativeTo(null);
		WindowPanel.setBackground(Color.black);
		WindowPanel.setIconImage(WindowPanelIcon.getImage());
		WindowPanel.setTitle("Huy Săn Cứt");
		WindowPanel.setVisible(true);
		WindowPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {
		
		if(moves == 0) {
			isPause = false;
			Huy.getHuyLengthX()[2] = 20;
			Huy.getHuyLengthX()[1] = 40;
			Huy.getHuyLengthX()[0]= 60;
			
			Huy.getHuyLengthY()[2] = 40;
			Huy.getHuyLengthY()[1] = 40;
			Huy.getHuyLengthY()[0] = 40;
		}
			
		g.drawImage(background.getImage(), 0, 0, null);
		
		Huy.getHuyRight().paintIcon(this, g, Huy.getHuyLengthX()[0], Huy.getHuyLengthY()[0]);
			
		if(isPause) {		
			g.drawRect(100, 100, 300, 200);
			pause = new ImageIcon("img//pause.png");
			pause.paintIcon(this, g, 115, 110);
		}
		
		for(int i = 0; i< Huy.getHuyLength(); i++)
		{
			
			if(i==0 && right) {
				this.Huy.getHuyRight().paintIcon(this, g, Huy.getHuyLengthX()[i], Huy.getHuyLengthY()[i]); 
			}
			
			if(i==0 && left) {
				this.Huy.getHuyLeft().paintIcon(this, g, Huy.getHuyLengthX()[i], Huy.getHuyLengthY()[i]); 
			}
			
			if(i==0 && up) {
				this.Huy.getHuyUp().paintIcon(this, g, Huy.getHuyLengthX()[i], Huy.getHuyLengthY()[i]); 
			}
			
			if(i==0 && down) {
				this.Huy.getHuyDown().paintIcon(this, g, Huy.getHuyLengthX()[i], Huy.getHuyLengthY()[i]); 
			}
			
			if(i!=0) {
				this.Huy.getHuyRightS().paintIcon(this, g, Huy.getHuyLengthX()[i], Huy.getHuyLengthY()[i]);
			}
			
			if(i!=0 && right) {
					this.Huy.getHuyRightS().paintIcon(this, g, Huy.getHuyLengthX()[i], Huy.getHuyLengthY()[i]); 
				}
			if(i!=0 && left){
					this.Huy.getHuyLeftS().paintIcon(this, g, Huy.getHuyLengthX()[i], Huy.getHuyLengthY()[i]);
				}
			if(i!=0 && down) {
					this.Huy.getHuyDownS().paintIcon(this, g, Huy.getHuyLengthX()[i], Huy.getHuyLengthY()[i]);
				}
			if(i!=0 && up) {
					this.Huy.getHuyUpS().paintIcon(this, g, Huy.getHuyLengthX()[i], Huy.getHuyLengthY()[i]); 
				}
		}
		
		for(int i = 0; i < Wall.getWallCount(); i++)
		{
			Wall.getWall.paintIcon(this, g, Wall.getWall.getWallX()[0], Wall.getWallY()[i]);
			Wall.getWall.paintIcon(this, g, Wall.getWall.getWall.getWallX()[i], Wall.getWallY()[0]);		
			Wall.getWall.paintIcon(this, g, Wall.getWall.getWall.getWallX()[Wall.getWallCount()-1], Wall.getWallX()[i]);	
			Wall.getWall.paintIcon(this, g, Wall.getWall.getWall.getWallY()[i], Wall.getWallY()[Wall.getWallCount-1]);	
		}	
		
		for(int i = 1; i < Huy.getHuyLength; i++)
		{
			if(foodX[posX] == Huy.getHuyLengthX[0] && foodY[posY] == Huy.getHuyLengthY[0]) {
				Huy.getHuyLength++;
				posX = rd.nextInt(foodX.length);
				posY = rd.nextInt(foodY.length);
				break;
			}
			if(foodX[posX] == Huy.getHuyLengthX[i] && foodY[posY] == Huy.getHuyLengthY[i]) {	
				posX = rd.nextInt(foodX.length);
				posY = rd.nextInt(foodY.length);		
			}		
		}
		
		food.paintIcon(this, g, foodX[posX], foodY[posY]);
		
		if(!isGameOver) {
			for(int i = 1; i < Huy.getHuyLength(); i++)
			{
				if(Huy.getHuyLengthX()[0] == Huy.getHuyLengthX()[i] && Huy.getHuyLengthY()[0] == Huy.getHuyLengthY()[i] || 
					Huy.getHuyLengthX()[0] == 0 || Huy.getHuyLengthX()[0] > 360 || Huy.getHuyLengthY()[0] == 0 || Huy.getHuyLengthY()[0] == 360) {
					right = false; 
					left = false;
					up = false;
					down = false;	
					isGameOver = true;
					
					g.setColor(Color.white);
					g.setFont(new Font("arial", Font.BOLD,50));
					g.drawString("HUY NGU LOZ", 15, 180);
					
					g.setFont(new Font("arial", Font.BOLD,10));
					g.drawString("Huy đã ăn trúng cục cứt và chết như một thằng ngu", 65, 200);
				}
			}
		}
		
		g.dispose();
	}
}