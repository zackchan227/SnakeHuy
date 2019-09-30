
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Frame extends JPanel implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;

	private int BLANK = 0;
	private int WALL = 1;
	private int SNAKE = 2;
	private int VISITED = 3;

	private Queue<Node> open = new Queue<Node>();
	private Queue<Node> path = new Queue<Node>();
	private Queue<Node> q = new Queue<Node>();

	private JFrame window = new JFrame();
	private ImageIcon windowIcon = new ImageIcon("img//icon1.jpg");
	private ImageIcon background = new ImageIcon("img//black.jpg");
	// private PacMan huy = new PacMan(3,10,10,"img//huyRight.jpg",true);

	private int[] huyLengthX = new int[750];
	private int[] huyLengthY = new int[750];

	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	private int huyLength = 3;

	private ImageIcon huyLeft;
	private ImageIcon huyRight;
	private ImageIcon huyUp;
	private ImageIcon huyDown;

	private ImageIcon huyLeftS;
	private ImageIcon huyRightS;
	private ImageIcon huyUpS;
	private ImageIcon huyDownS;

	private int[] foodX = { 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220,
							240, 260, 280, 300, 320, 340 };
	private int[] foodY = { 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220,
							240, 260, 280, 300, 320, 340 };
	private ImageIcon food;

	private int[] wallX = { 0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 
							240, 260, 280, 300, 320, 340, 360,380 };
	private int[] wallY = { 0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 
							240, 260, 280, 300, 320, 340, 360,380 };
	private int wallCount = wallX.length;
	private ImageIcon wall;
	
	private Random rd = new Random();
	private int posX = rd.nextInt(foodX.length);
	private int posY = rd.nextInt(foodY.length);
	
	private int moves = 0;
	private boolean isPause = true;
	private ImageIcon pause;
	
	private boolean isGameOver;
	
	private Timer timer;
	private int delay = 100;
	//private ImageIcon huyImg;
	
	private int step;
	
	public Frame() {
		
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		window.add(this);
		window.setSize(410,480);
		window.setLocationRelativeTo(null);
		window.setBackground(Color.black);
		window.setIconImage(windowIcon.getImage());
		window.setTitle("Snake The Game");
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
	
	public void paint(Graphics g) {
		
		initial(g);				
		autoRedirection(g);				
		randomFoodSpawn(g);	
		drawScore(g,huyLength-3);
		drawWall(g);
		drawPause(g);
		drawGameOver(g);
		
		g.dispose();
	}
	
	public void keyPressed(KeyEvent key) {
		
		if(!isGameOver) {
		  if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
			  isPause = true;
			  right = false; 
			  left = false;
			  up = false;
			  down = false;	
			  repaint();
		  }
		  
		  if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
			  isPause = false;
			  moves++;
			  right = true;
			  if(!left) {
				  right = true;
			  }
			  else {
				  right = false;
				  left = true;					  
			  }
			  up = false;
			  down = false;
		  }
		  
		  if (key.getKeyCode() == KeyEvent.VK_LEFT) {
			  isPause = false;
			  moves++;
			  left = true;
			  if(!right) {
				  left = true;
			  }
			  else {
				  right = true;
				  left = false;					  
			  }
			  up = false;
			  down = false;
		  }
		  
		  if (key.getKeyCode() == KeyEvent.VK_UP) {
			  isPause = false;
			  moves++;
			  up = true;
			  if(!down) {
				  up = true;
			  }
			  else {
				  up = false;
				  down = true;					  
			  }
			  right = false;
			  left = false;
		  }
		  
		  if (key.getKeyCode() == KeyEvent.VK_DOWN) {
			  isPause = false;
			  moves++;
			  down = true;
			  if(!up) {
				  down = true;
			  }
			  else {
				  up = true;
				  down = false;					  
			  }
			  right = false;
			  left = false;
		  }
		}
		else {
			if (key.getKeyCode() == KeyEvent.VK_SPACE) {
				  moves = 0;
				  right = true;
				  left = up = down = false;
				  isGameOver = false;
				  huyLength = 3;
				  posX = rd.nextInt(foodX.length);
				  posY = rd.nextInt(foodY.length);	
				  repaint();
			}
		}
		  
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent a) {
		timer.start();
		if(right) {
			
			for(int i = huyLength-1; i>=0;i--) {
				huyLengthY[i+1] = huyLengthY[i];
				
			}
			
			for(int i = huyLength;i>=0;i--) {
				if(i==0) {
					huyLengthX[i] = huyLengthX[i] + 20;
				}
				else {
					huyLengthX[i] = huyLengthX[i-1];
				}
				/*
				 * if(huyLengthX[i] > 420) { isGameOver = true; //huyLengthX[i] = 20; }
				 */
			}
			
			repaint();
			
		}
		
		if(left) {
			
			for(int i = huyLength-1; i>=0;i--) {
				huyLengthY[i+1] = huyLengthY[i];
			}
			
			for(int i = huyLength;i>=0;i--) {
				if(i==0) {
					huyLengthX[i] = huyLengthX[i] - 20;
				}
				else {
					huyLengthX[i] = huyLengthX[i-1];
				}
				/*
				 * if(huyLengthX[i] < 20) { huyLengthX[i] = 420; }
				 */
			}
			
			repaint();
			
		}
		
		if(up) {
			
			for(int i = huyLength-1; i>=0;i--) {
				huyLengthX[i+1] = huyLengthX[i];
			}
			
			for(int i = huyLength;i>=0;i--) {
				if(i==0) {
					huyLengthY[i] = huyLengthY[i] - 20;
				}
				else {
					huyLengthY[i] = huyLengthY[i-1];
				}
				/*
				 * if(huyLengthY[i] < 10) { huyLengthY[i] = 350; }
				 */
			}
			
			repaint();
			
		}
		
		if(down) {
			
			for(int i = huyLength-1; i>=0;i--) {
				huyLengthX[i+1] = huyLengthX[i];
			}
			
			for(int i = huyLength;i>=0;i--) {
				if(i==0) {
					huyLengthY[i] = huyLengthY[i] + 20;
				}
				else {
					huyLengthY[i] = huyLengthY[i-1];
				}
				/*
				 * if(huyLengthY[i] > 350) { huyLengthY[i] = 10; }
				 */
			}
			
			repaint();
			
		}
	}
	
	public void initial(Graphics g) {
		
		g.drawImage(background.getImage(), 0, 0, null);
		
		huyRight = new ImageIcon("img//huyRight.jpg");
		
		food = new ImageIcon("img//poop.png");
		wall = new ImageIcon("img//poop1.png");
			
		if(moves == 0) {
			isPause = false;
			huyLengthX[2] = 20;
			huyLengthX[1] = 40;
			huyLengthX[0] = 60;
			
			huyLengthY[2] = 40;
			huyLengthY[1] = 40;
			huyLengthY[0] = 40;
		}
		huyRight.paintIcon(this, g, huyLengthX[0], huyLengthY[0]);
		
	}
	
	public void drawScore(Graphics g, int count) {
			
			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD,30));
			g.drawString("Troll face count: "+ count, 30, 430);	
			
	}
	
	public void autoRedirection(Graphics g) {
		
		for(int i = 0; i < huyLength; i++)
		{
			
			if(i==0 && right) {
				huyRight = new ImageIcon("img//huyRight.jpg");
				huyRight.paintIcon(this, g, huyLengthX[i], huyLengthY[i]); 
			}
			
			if(i==0 && left) {
				huyLeft = new ImageIcon("img//huyLeft.jpg");
				huyLeft.paintIcon(this, g, huyLengthX[i], huyLengthY[i]); 
			}
			
			if(i==0 && up) {
				huyUp = new ImageIcon("img//huyUp.jpg");
				huyUp.paintIcon(this, g, huyLengthX[i], huyLengthY[i]); 
			}
			
			if(i==0 && down) {
				huyDown = new ImageIcon("img//huyDown.jpg");
				huyDown.paintIcon(this, g, huyLengthX[i], huyLengthY[i]); 
			}
			
			if(i!=0) {
				huyRightS = new ImageIcon("img//huyRightS.jpg");
				huyRightS.paintIcon(this, g, huyLengthX[i], huyLengthY[i]);
			}
			
			if(i!=0 && right) {
					huyRightS = new ImageIcon("img//huyRightS.jpg");
					huyRightS.paintIcon(this, g, huyLengthX[i], huyLengthY[i]); 
				}
			if(i!=0 && left){
					huyLeftS = new ImageIcon("img//huyLeftS.jpg");
					huyLeftS.paintIcon(this, g, huyLengthX[i], huyLengthY[i]);
				}
			if(i!=0 && down) {
					huyDownS = new ImageIcon("img//huyDownS.jpg");
					huyDownS.paintIcon(this, g, huyLengthX[i], huyLengthY[i]);
				}
			if(i!=0 && up) {
					huyUpS = new ImageIcon("img//huyUpS.jpg");
					huyUpS.paintIcon(this, g, huyLengthX[i], huyLengthY[i]); 
				}
		}
		
	}
	
	public void randomFoodSpawn(Graphics g) {
		
		for(int i = 1; i < huyLength; i++)
		{
			if(foodX[posX] == huyLengthX[0] && foodY[posY] == huyLengthY[0]) {
				huyLength++;
				posX = rd.nextInt(foodX.length);
				posY = rd.nextInt(foodY.length);
				break;
			}
			if(foodX[posX] == huyLengthX[i] && foodY[posY] == huyLengthY[i]) {	
				posX = rd.nextInt(foodX.length);
				posY = rd.nextInt(foodY.length);		
			}
				
		}
		food.paintIcon(this, g, foodX[posX], foodY[posY]);
		
	}
	
	public void drawWall(Graphics g) {
		
		for(int i = 0; i < wallCount; i++)
		{
			wall.paintIcon(this, g, wallX[0], wallY[i]);
			wall.paintIcon(this, g, wallX[i], wallY[0]);		
			wall.paintIcon(this, g, wallX[wallCount-1], wallX[i]);	
			wall.paintIcon(this, g, wallY[i], wallY[wallCount-1]);	
		}
	}
	
	public void drawPause(Graphics g) {
		
		if(isPause) {		
			//g.drawRect(100, 100, 200, 200);
			pause = new ImageIcon("img//pause.jpg");
			pause.paintIcon(this, g, 100, 150);
		}
		
	}
	
	public void drawGameOver(Graphics g) {
		
		for(int i = 1; i < huyLength; i++)
		{
			if(huyLengthX[0] == huyLengthX[i] && huyLengthY[0] == huyLengthY[i] || 
				huyLengthX[0] == 0 || huyLengthX[0] > 360 || huyLengthY[0] == 0 || huyLengthY[0] == 360) {
				right = false; 
				left = false;
				up = false;
				down = false;	
				isGameOver = true;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD,50));
				g.drawString("GAME OVER", 50, 180);
				
				g.setFont(new Font("arial", Font.BOLD,10));
				g.drawString("PRESS SPACE TO RESTART", 130, 200);
			}
		}
		
	}
	
	public class Node {
		
		private int x;
		private int y;
		private int value;
		private Node previous;
		private Node next;
		
		
		public Node(int x,int y, int value) {
			
			this.x = x;
			this.y = y;
			this.value = value;
			this.previous = null;
			this.next = null;
		}

		
		public Node() {
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public void addToOpen(int x ,int y ,Node previous) {
		Node temp = previous;
		 
	    if (temp.value==BLANK)
	    {
	        // mark this node as visited to avoid adding it multiple times
	        temp.value = VISITED;
	        // store the previous node
	        // so that we can backtrack to find the optimum path
	        // (by using the getSolution() method)
	        temp.previous = previous;
	        open.enqueue(temp);
	    }
	}
		
	public void genMove(Node n) {
		
		if (n.x <= 340)
	        addToOpen(n.x + 20, n.y, n);
	    if (n.y <= 345)
	        addToOpen(n.x, n.y + 20, n);
	    if (n.x >= 20)
	        addToOpen(n.x - 20, n.y, n);
	    if (n.y >= 20)
	        addToOpen(n.x, n.y - 20, n);
		
	}
	
	public Queue<Node> getSolution(Node n) {
		
		Queue<Node> q = new Queue<Node>();
	    q.enqueue(n);
	    while (n.previous != null)
	    {
	        q.enqueue(n.previous);
	        n = n.previous;
	    }
	    return q;
		
	}
	
	public void setPath(Queue<Node> q) {
		path = q;
		if(path!=null) {
			step = path.size()-1;
		}
		else step = 0;
		
	}
	
	public void autoMove(int step) {
		if(step>0)
	    {
	        step--;
	        Node newPos = q.dequeue();
	        if(newPos.x<this.huyLengthX[0]) {
	        	if(!right) {
					  left = true;
				  }
				  else {
					  right = true;
					  left = false;					  
				  }
				  up = false;
				  down = false;
	        	
	        	//huyLeft.paintIcon(this, g, huyLengthX[i], huyLengthY[i]); 
	        }
	        else if(newPos.x>this.huyLengthX[0]) {
	        	if(!left) {
					  right = true;
				  }
				  else {
					  right = false;
					  left = true;					  
				  }
				  up = false;
				  down = false;
	        }
	        else if(newPos.y<this.huyLengthY[0]) {
	        	if(!down) {
					  up = true;
				  }
				  else {
					  up = false;
					  down = true;					  
				  }
				  right = false;
				  left = false;
	        }
	        else if(newPos.y>this.huyLengthY[0]) {
	        	if(!up) {
					  down = true;
				  }
				  else {
					  up = true;
					  down = false;					  
				  }
				  right = false;
				  left = false;
	        }
		}
		
	}
	
	// public void findPath(Queue<Node> q, Node start, Node goal) {
		
	// 	Node n;
	// 	if(q!=null) {
	// 		q.
	// 	}
		
	// }
	
	// public Queue<Node> bfs(Node start, Node goal) {
		
	// 		open.enqueue(start);
	// 		// the main loop
			 
	// 		while(!open.isEmpty())
	// 		{
	// 		    node = open.dequeue();
	// 		    if(node != null)
	// 		    {
	// 		        if(node.x==goal.x && node.y==goal.y)
	// 		        {
	// 		            return getSolution(node);
	// 		        }
	// 		        genMove(node);
	// 		    }
	// 		    else
	// 		        break;
	// 		}
	// 		return null;
			
	// 	}
}

