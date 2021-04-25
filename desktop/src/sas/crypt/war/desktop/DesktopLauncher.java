package sas.crypt.war.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import sas.crypt.war.CryptWar;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		CryptWar core = new CryptWar();
		
		config.width=1366;
		config.height=768;
		config.title="Crypt War";
		config.fullscreen=false;
		config.resizable = true;
		config.forceExit = true;
		
		/*config.width=1920;
		config.height=1080;
		config.fullscreen=true;*/
		
		
		new LwjglApplication(core, config);
		
		/*System.out.println("Resolucion de lanzamiento: "+ config.width + "x" + config.height);
		System.out.println("Resolucion del monitor actual: "+ Gdx.graphics.getDisplayMode().width + "x" + Gdx.graphics.getDisplayMode().height);*/
		
	}
}
