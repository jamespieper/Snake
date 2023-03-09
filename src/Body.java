
public class Body {
	
	private int sideLength, x, y;
	private int direction = 0;
	private final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

	public Body(int sideLength, int x, int y) {
		this.sideLength = sideLength;
		this.x = x;
		this.y = y;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
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
	
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/*
	public void setCoords(Body other) {
		if(other.getDirection() == UP) {
			this.y = other.y + 20;
		}
		else if(other.getDirection() == RIGHT) {
			this.x = other.x - 20;
		}
		else if(other.getDirection() == DOWN) {
			this.y = other.y - 20;
		}
		else if(other.getDirection() == LEFT) {
			this.x = other.x - 20;
		}
		
	}
	*/
	
	
	public void setDirection(int direction) {
		
		this.direction = direction;
			
	}
	
	public int getDirection() {
		return direction;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	
}
