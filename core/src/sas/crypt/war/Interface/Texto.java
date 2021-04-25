package sas.crypt.war.Interface;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Texto extends Label {
	
	public Texto(CharSequence texto, float xPos,float yPos, float tamano, Skin skin, String tipo) {
		
		super(texto, skin, tipo);
		super.setPosition(xPos, yPos);
		super.setFontScale(tamano);

	}

}
