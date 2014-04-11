package utils;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;

public class RoundJPasswordField extends JPasswordField{

	private static final long serialVersionUID = 665562630564707606L;
	private Shape shape;
	
	public RoundJPasswordField(String text){
		super(text);
		setOpaque(false);
	}
	
	public RoundJPasswordField( String text, int size){
		super(text, size);
		setOpaque(false);
	}
	
	public RoundJPasswordField(int size){
		super(size);
		setOpaque(false);
	}
	
	protected void paintComponent(Graphics g){
		g.setColor(getBackground());
		g.fillRoundRect(0,0, getWidth()-1, getHeight()-1, 15, 15);
		super.paintComponent(g);
	}
	
	protected void paintBorder(Graphics g){
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	}
	
	public boolean contains(int x, int y){
		if( shape == null || !shape.getBounds().equals(getBounds())){
			shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
		}
		
		return shape.contains(x, y);
	}
}
