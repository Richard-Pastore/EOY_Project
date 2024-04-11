import java.awt.Color;

import javax.swing.ImageIcon;

public class CS {
	
	private int x,y,width,height;
	private ImageIcon pic;
	
	public CS()
	{
		x=0;
		y=0;
		pic = new ImageIcon();
		width = 100;
		height = 100;
	}
	public Ship (int xV, int yV, ImageIcon p, int w, int h)
	{
		x=xV;
		y=yV;
		pic=p;
		width=w;
		height=h;
	}
	//add getters and setters
	public int getW() {
		return width;
	}
	public int getH() {
		return height;
	}
	
	public int getY() {
		return y;
	}
	//public Color getC() {
		//return col;
	//}
public void setX(int xV) {
		x+=xV;
	}
	public void setY(int yV) {
		y+=yV;
	}
	public void setH(int h) {
		height=h;
	}
	public void setW(int w) {
		width=w;
	}
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public ImageIcon getPic() {
		return pic;
		}
	}

