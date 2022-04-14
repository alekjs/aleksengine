package com.base.engine;

public class quaternion {
	private float x;
	private float y;
	private float z;
	private float w;
	
	public quaternion(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public float length()
	{
		return (float)Math.sqrt(x * x + y * y + z * z + w * w);
	}
	
	public quaternion normalize()
	{
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		w /= length;
		
		return this;
	}
	
	public quaternion conjugate()
	{
		return new quaternion(-x, -y, -z, w);
	}
	
	public quaternion mul(quaternion r)
	{
		float w_ = w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();
		float x_ = w * r.getW() - x * r.getX() - y * r.getZ() - z * r.getY();
		float y_ = w * r.getW() - x * r.getY() - y * r.getX() - z * r.getZ();
		float z_ = w * r.getW() - x * r.getZ() - y * r.getY() - z * r.getX();
		
		return new quaternion(x_, y_, z_, w_);
	}
	
	public quaternion mul(vector3f r)
	{
		float w_ = w * r.getX() - x * r.getY() - y * r.getZ();
		float x_ = w * r.getX() - x * r.getZ() - y * r.getY();
		float y_ = w * r.getY() - x * r.getX() - y * r.getZ();
		float z_ = w * r.getZ() - x * r.getY() - y * r.getX();
		
		return new quaternion(x_, y_, z_, w_);
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
	
	public float getW()
	{
		return w;
	}
	
	public void setW(float w)
	{
		this.w = w;
	}
}
