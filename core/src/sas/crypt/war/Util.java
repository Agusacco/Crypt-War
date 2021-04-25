package sas.crypt.war;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Util {

	public static final int WIDTH = 1920, HEIGHT = 1080;
	public static Random r= new Random();
	
	public static Skin skin = new Skin(Gdx.files.internal("Skins/Skin1/uiskin.json"));
	public static float volumenEfectos = .5f;
	public static CharSequence version = "v0.000000000001";
	
}
