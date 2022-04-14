package com.base.engine;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class util
{
	public static FloatBuffer createFloatBuffer(int size)
	{
		return BufferUtils.createFloatBuffer(size);
	}
	public static FloatBuffer createFlippedBuffer(vertex[] vertices)
	{
		FloatBuffer buffer = createFloatBuffer(vertices.length * vertex.SIZE);
		
		for(int i = 0; i < vertices.length; i++)
		{
			buffer.put(vertices[i].getPos().getX());
			buffer.put(vertices[i].getPos().getY());
			buffer.put(vertices[i].getPos().getZ());
		}
		
		buffer.flip();
		
		return buffer;
	}
	
	public static FloatBuffer createFlippedBuffer(matrix4f value)
	{
		FloatBuffer buffer = createFloatBuffer(4 * 4);
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				buffer.put(value.get(i, j));
		
		buffer.flip();
		
		return buffer;
	}
}