package com.base.engine;

import org.lwjgl.input.Keyboard;

public class basegame
{
	private mesh mesh;
	private shader shader;
	private transform transform;

	public basegame()
	{
		mesh = new mesh();
		shader = new shader();
		
		vertex[] data = new vertex[] {new vertex(new vector3f(-1,-1,0)),
									    new vertex(new vector3f(0,1,0)),
									  new vertex(new vector3f(1,-1,0))};
		
		mesh.addVertices(data);
		
		transform = new transform();
		
		shader.addVertexShader(resourceloader.loadShader("basicVertex.vs"));
		shader.addFragmentShader(resourceloader.loadShader("basicFragment.fs"));
		shader.compileShader();
		
		shader.addUniform("transform");
	}
	
	public void input()
	{
		if(input.getKeyDown(Keyboard.KEY_B))
			System.out.println("you pressed B");
		if(input.getKeyUp(Keyboard.KEY_B))
			System.out.println("you released B");
		
		if(input.getMouseDown(0))
			System.out.println("you pressed mousebutton " + input.getMousePos().toString());
		if(input.getMouseUp(0))
			System.out.println("you released mousebutton " + input.getMousePos().toString());
	}
	
	float temp = 0.0f;
	
	public void update()
	{
		temp += time.getDelta();
		
		transform.setTranslation((float)Math.sin(temp), 0, 0);
	}
	
	public void render()
	{
		shader.bind();
		shader.setUniform("transform", transform.getTransformation());
		mesh.draw();
	}
}
