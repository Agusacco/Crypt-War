package sas.crypt.war;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import sas.crypt.war.Screens.MatchPantalla;
import sas.crypt.war.Screens.MenuPantalla;
import sas.crypt.war.Screens.Pantalla;


public class CryptWar extends Game {
	
	public Pantalla menuPantalla;
	public static final Discord discord = new Discord();
	
	public void create () {
	
		discord.start();
		this.setScreen(new MenuPantalla(this));
		
	}

	public void render () {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		
	}
	
	public void dispose () {
		
		discord.shutdown();
		System.out.println("El juego se cerro");
		
	}
}
