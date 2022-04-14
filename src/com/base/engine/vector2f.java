package com.base.engine;

public class vector2f {
	private float x;
	private float y;
	public vector2f(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public float length()
	{
		return (float)Math.sqrt(x * x + y * y);
	}
	
	public float dot(vector2f r)
	{
		return x * r.getX() + y * r.getY();
	}
	
	public vector2f normalize()
	{
		float length = length();
		x /= length;
		y /= length;
		
		return this;
	}
	
	public vector2f rotate(float angle)
	{
		double rad = Math.toRadians(angle);
		double cos = Math.cos(rad);
		double sin = Math.sin(rad);
		
		return new vector2f((float)(x * cos - y * sin),(float)(x * sin + y * cos));
	}
	
	public vector2f add(vector2f r)
	{
		return new vector2f(x + r.getX(), y + r.getY());
	}
	
	public vector2f add(float r)
	{
		return new vector2f(x + r, y + r);
	}
	
	public vector2f sub(vector2f r)
	{
		return new vector2f(x - r.getX(), y - r.getY());
	}
	
	public vector2f sub(float r)
	{
		return new vector2f(x - r, y - r);
	}
	
	public vector2f mul(vector2f r)
	{
		return new vector2f(x * r.getX(), y * r.getY());
	}
	
	public vector2f mul(float r)
	{
		return new vector2f(x * r, y * r);
	}
	
	public vector2f div(vector2f r)
	{
		return new vector2f(x / r.getX(), y / r.getY());
	}
	
	public vector2f div(float r)
	{
		return new vector2f(x / r, y / r);
	}
	
	public String toString()
	{
		return "(" + x + " " + y + ")";
	}
	
	public float getX()
	{
		return x;
	}
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public float getY()
	{
		return y;
	}
}
