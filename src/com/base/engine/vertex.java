package com.base.engine;

public class vertex {
	public static final int SIZE = 3;
	
	private vector3f pos;
	
	public vertex(vector3f pos)
	{
		this.pos = pos;
	}
	
	public vector3f getPos()
	{
		return pos;
	}
	
	public void setPos(vector3f pos)
	{
		this.pos = pos;
	}
}
