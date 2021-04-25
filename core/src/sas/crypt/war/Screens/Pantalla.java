package sas.crypt.war.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;

import sas.crypt.war.CryptWar;
import sas.crypt.war.Util;


public class Pantalla implements Screen{

	public static Stage stage;
	private boolean debug;
	public CryptWar game;
	
	public Pantalla() {
		
		stage = new Stage(new FitViewport(Util.WIDTH, Util.HEIGHT)); 
		stage.getViewport().apply();
		Gdx.input.setInputProcessor(stage);
		
		stage.addListener(new InputListener(){

			public boolean keyDown(InputEvent event, int keycode) {
				
				switch (keycode) {
				
				case Keys.F1:
					
					if (debug) debug=false;
					else debug=true;

					stage.setDebugAll(debug);
					
					
				break;
					
				/*case Keys.ESCAPE:
					
					Gdx.app.exit();
				
				break;*/
		
				}
				
				return false;
				
			}
			
		});
		
	}

	public void render(float delta) {

		stage.act();
		stage.draw();
		
	}


	public void resize(int width, int height) {
		
		stage.getViewport().update(width, height);
		
	}


	public void pause() {
		
	}


	public void resume() {
		
	}


	public void hide() {
		
	}


	public void dispose() {
		
	}
	
	public void show() {	
		
	}
	
}
