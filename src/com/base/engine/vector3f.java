package com.base.engine;

public class vector3f {
	private float x;
	private float y;
	private float z;
	
	public vector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float length()
	{
		return (float)Math.sqrt(x * x + y * y + z * z);
	}
	
	public float dot(vector3f r)
	{
		return x * r.getX() + y * r.getY() + z * r.getZ();
	}
	
	public vector3f cross(vector3f r)
	{
		float x_ = y * r.getZ() - z * r.getY();
		float y_ = z * r.getX() - x * r.getZ();
		float z_ = z * r.getY() - x * r.getX();
		
		return new vector3f(x_, y_, z_);
	}
	
	public vector3f normalize()
	{
		float length = length();
		x /= length;
		y /= length;
		z /= length;
		
		return this;
	}
	
	public vector3f rotate()
	{
		return null;
	}
	
	public vector3f add(vector3f r)
	{
		return new vector3f(x + r.getX(), y + r.getY(), z + r.getZ());
	}
	
	public vector3f add(float r)
	{
		return new vector3f(x + r, y + r, z + r);
	}
	
	public vector3f sub(vector3f r)
	{
		return new vector3f(x - r.getX(), y - r.getY(), z - r.getZ());
	}
	
	public vector3f sub(float r)
	{
		return new vector3f(x - r, y - r, z - r);
	}
	
	public vector3f mul(vector3f r)
	{
		return new vector3f(x * r.getX(), y * r.getY(), z * r.getZ());
	}
	
	public vector3f mul(float r)
	{
		return new vector3f(x * r, y * r, z * r);
	}
	
	public vector3f div(vector3f r)
	{
		return new vector3f(x / r.getX(), y / r.getY(), z / r.getZ());
	}
	
	public vector3f div(float r)
	{
		return new vector3f(x / r, y / r, z / r);
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
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	public float getZ()
	{
		return z;
	}
	
	public void setZ(float z)
	{
		this.z = z;
	}
}
