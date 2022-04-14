package com.base.engine;

public class transform
{
	private vector3f translation;
	
	public transform()
	{
		translation = new vector3f(0, 0, 0);
	}
	
	
	public matrix4f getTransformation()
	{
		matrix4f translationMatrix = new matrix4f().initTranslation(translation.getX(), translation.getY(), translation.getZ());
		
		return translationMatrix;
	}
	
	public vector3f getTranslation()
	{
		return translation;
	}
	
	public void setTranslation(vector3f translation)
	{
		this.translation = translation;
	}
	
	public void setTranslation(float x, float y, float z)
	{
		this.translation = new vector3f(x, y, z);
	}
}
