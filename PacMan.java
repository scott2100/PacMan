class PacMan {

	private static int thisX=20; 
	private static int thisY=20;
	private static int posx=0;
	private static int posy=0;
	private static boolean up, down, left, right = false;
	private static Maze pacMaze = new Maze();
	String direction;
	String queuedDir;

	public int getPacManX(){
		return thisX;
	}

	public int getPacManY(){
		return thisY;
	}

	public void setPacManX(int myPacManX){
		this.thisX = myPacManX;
	}

	public void setPacManY(int myPacManY){
		this.thisY = myPacManY;
	}

	public void setUp(boolean myUp){
		this.up = myUp;
	}
	
	public void setDown(boolean myDown){
		this.down = myDown;
	}

	public void setRight(boolean myRight){
		this.right = myRight;
	}

	public void setLeft(boolean myLeft){
		this.left = myLeft;
	}

	public boolean getUp(){
		return up;
	}

	public boolean getDown(){
		return down;
	}

	public boolean getLeft(){
		return left;
	}

	public boolean getRight(){
		return right;
	}


	public void changeDirection(){
		if(direction.equals("up")){
			setUp(true);
			setDown(false);
			setRight(false);
			setLeft(false);
		}
		if(direction.equals("down")){
			setUp(false);
			setDown(true);
			setRight(false);
			setLeft(false);
		}
		if(direction.equals("left")){
			setUp(false);
			setDown(false);
			setRight(false);
			setLeft(true);
		}
		if(direction.equals("right")){
			setUp(false);
			setDown(false);
			setRight(true);
			setLeft(false);
		}
		
	}

	public void move()
	{	

		posx = ((this.getPacManX() ) /20);
		posy = ((this.getPacManY() ) /20);

		System.out.println("direction: " + direction);
		System.out.println("queuedDir: " + queuedDir);

		//System.out.println("PosX: " + this.getPacManX());
		//System.out.println("PosY: " + this.getPacManY());
		
		if( this.getUp()){
			if(getPacManY() % 20 ==0){
				if(pacMaze.getMaze()[posy-1][posx]!=1  ){
					if(getPacManX() % 20 !=0){
						if(pacMaze.getMaze()[posy-1][posx+1]!=1){
							direction = "up";
							this.setPacManY(this.getPacManY()-2);
						}
						else{
							if(!direction.equals("up")){
								changeDirection();
								queuedDir = "up";
							}
							else if(queuedDir!=null && !queuedDir.equals("up")){
								direction = queuedDir;
								System.out.println("Setting direction to queuedDir");
								changeDirection();
							}
						}
					}
					else
					{
							this.setPacManY(this.getPacManY()-2);
							direction = "up";
					}
				}
							if(!direction.equals("up")){
								queuedDir = "up";
								changeDirection();
							}
							else if(queuedDir!=null && !queuedDir.equals("up")) {
								direction = queuedDir;
								System.out.println("Setting direction to queuedDir");
								changeDirection();
							}
			}
			else{
							this.setPacManY(this.getPacManY()-2);
							direction = "up";
			}
		}
		if( this.getDown()){
			if(getPacManY() % 20 ==0){
				if(pacMaze.getMaze()[posy+1][posx]!=1){
					if(getPacManX() % 20 != 0){
						if(pacMaze.getMaze()[posy+1][posx+1]!=1){
							this.setPacManY(this.getPacManY()+2);
							direction="down";
						}
						else{
							if(!direction.equals("down")){
								System.out.println("direction is not down and cant go down");
								queuedDir = "down";
								changeDirection();
							}
							else if(queuedDir!=null && !queuedDir.equals("down")){
								direction = queuedDir;
								System.out.println("Setting direction to queuedDir");
								changeDirection();
							}	
						}
					}
					else{	
							this.setPacManY(this.getPacManY()+2);
							direction="down";
					}
				}
				else
				{	
					if(!direction.equals("down")){
								System.out.println("direction is not down and cant go down");
						queuedDir = "down";
						changeDirection();
					}
					else if(queuedDir!=null && !queuedDir.equals("down")){
						direction = queuedDir;
						System.out.println("Setting direction to queuedDir");							changeDirection();
					}
				}
					
			}
			else{
				this.setPacManY(this.getPacManY()+2);
				direction="down";
			}
		}
		if( this.getRight()){
			if(getPacManX() % 20 ==0){
				if(pacMaze.getMaze()[posy][posx+1]!=1){
					if(getPacManY() % 20 !=0){
						if(pacMaze.getMaze()[posy+1][posx+1]!=1){
							this.setPacManX(this.getPacManX()+2);
							direction="right";
						}
						else{
							System.out.println("cant go right");
							if(!direction.equals("right")){
								System.out.println("direction is not right");
								queuedDir = "right";
								changeDirection();
							}
							else if(queuedDir!=null && !queuedDir.equals("right")){
								direction = queuedDir;
								System.out.println("Setting direction to queuedDir");
								changeDirection();
							}
						}
					}
					else{
							this.setPacManX(this.getPacManX()+2);
							direction="right";
					}	
				}
				else{
					System.out.println("cant go right");
					if(!direction.equals("right")){
								queuedDir = "right";
								changeDirection();
					}
					else if(queuedDir!=null && !queuedDir.equals("right")){
								direction = queuedDir;
								System.out.println("Setting direction to queuedDir");
								changeDirection();
					}	
					
				}
			}
			else{
				this.setPacManX(this.getPacManX()+2);
				direction="right";
			}
		}
		if( this.getLeft()){
			if(getPacManX() % 20 ==0){
				if(pacMaze.getMaze()[posy][posx-1]!=1){
					if(getPacManY() % 20 !=0){
						if(pacMaze.getMaze()[posy+1][posx-1]!=1){
							this.setPacManX(this.getPacManX()-2);
							direction = "left";
						} else {
							if(!direction.equals("left")){
								queuedDir = "left";
								changeDirection();
							}
							else if(queuedDir!=null && !queuedDir.equals("left")){
						System.out.println("This should not have run");
								direction = queuedDir;
								System.out.println("Setting direction to queuedDir");
								changeDirection();
							}
						}
		
					}
					else{
						this.setPacManX(this.getPacManX()-2);
						direction = "left";
					}
				}
				else {
					if(!direction.equals("left")){
						queuedDir = "left";
						changeDirection();
					}
					else if(queuedDir!=null && !queuedDir.equals("left")){
						System.out.println("This should not have run");
						direction = queuedDir;
						System.out.println("Setting direction to queuedDir");
						changeDirection();
					}
				}

			}
			else{
				this.setPacManX(this.getPacManX()-2);
				direction = "left";
			}
		}
	}
}

