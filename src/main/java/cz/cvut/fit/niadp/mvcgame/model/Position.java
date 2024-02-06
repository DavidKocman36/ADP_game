package cz.cvut.fit.niadp.mvcgame.model;

public class Position {
    private float dimX = 0;
	private float dimY = 0;

	public Position(float posX, float posY) {
		this.dimX = posX;
		this.dimY = posY;
	}

	public float getX() {
		return dimX;
	}
    
    public float getY() {
		return dimY;
	}
    
    public void setY(float y) {
		this.dimY = y;
	}
    
    public void setX(float x) {
		this.dimX = x;
	}

	public void add(Vector vector) {
		this.setX(this.getX() + vector.getX());
		this.setY(this.getY() + vector.getY());
	}
}