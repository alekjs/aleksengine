package com.base.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class mesh {
	private int vbo;
	private int size;
	
	public mesh()
	{
		vbo = glGenBuffers();
		size = 0;
	}
	
	public void addVertices(vertex[] vertices)
	{
		size = vertices.length * vertex.SIZE;
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
	}
	
	public void draw()
	{
		glEnableVertexAttribArray(0);
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, vertex.SIZE * 4, 0);
		
		glDrawArrays(GL_TRIANGLES, 0, size);
		
		glDisableVertexAttribArray(0);
	}
}
