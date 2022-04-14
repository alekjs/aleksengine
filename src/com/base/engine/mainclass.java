package com.base.engine;

import org.lwjgl.opengl.Display;

public class mainclass {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "alekengine";
	public static final double FRAME_CAP = 60.0;
	
	private boolean isRunning;
	private basegame game;
	
	public mainclass()
	{
		System.out.println(renderutil.getOpenGLVersion());
		renderutil.initGraphics();
		isRunning = false;
		game = new basegame();
	}
	
	public void start()
	{
		if(isRunning)
			return;
		
		run();
	}
	
	public void stop()
	{
		if(!isRunning)
			return;
		
		isRunning = false;
	}

	private void run()
	{
		isRunning = true;
		
		int frames = 0;
		long frameCounter = 0;
		
		final double frameTime = 1.0 / FRAME_CAP;
		
		long lastTime = time.getTime();
		double unprocessedTime = 0;
		
		while(isRunning)
		{
			boolean render = false;
			
			long startTime = time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double)time.SECOND;
			frameCounter += passedTime;
			
			while(unprocessedTime > frameTime)
			{
				render = true;
				
				unprocessedTime -= frameTime;
				
				if(window.isCloseRequested())
					stop();
				
				time.setDelta(frameTime);
				input.update();
				
				game.input();
				game.update();
				
				if(frameCounter >= time.SECOND)
				{
					System.out.println(frames);
					Display.setTitle(TITLE + ", " + Integer.toString(frames) + " FPS");
					frames = 0;
					frameCounter = 0;
				}
			}
			if(render)
			{
				render();
				frames++;
			}
			else
			{
				try
				{
				Thread.sleep(1);
				}
				
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		cleanUp();
	}

	private void render()
	{
		renderutil.clearScreen();
		game.render();
		window.render();
	}

	private void cleanUp()
	{
		window.dispose();
	}
	
	public static void main(String[] args)
	{
		window.createWindow(WIDTH, HEIGHT, TITLE);
		
		mainclass game = new mainclass();
		
		game.start();
	}
}