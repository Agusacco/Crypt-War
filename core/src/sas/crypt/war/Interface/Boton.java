package sas.crypt.war.Interface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import sas.crypt.war.Util;


public class Boton extends TextButton {

	
	private ClickListener click;
	public Sound sonidoClick;
	public boolean press;
	
	public Boton (String texto, float tam) {
		
			super(texto, Util.skin);
	
			super.getLabel().setFontScale(tam);
			
			/*sonidoClick= Gdx.audio.newSound(Gdx.files.internal("assets/Sonidos/Juego/Jugar.mp3"));
			sonidoClick.setVolume(1, Util.volumenEfectos);
			
			this.eventos(this);*/
		
	
		}

	public void eventos(final Boton boton){

		click = new ClickListener() {
			
			public void clicked(InputEvent event, float x, float y) {
				
				long sonido= sonidoClick.play(Util.volumenEfectos);
				sonidoClick.setVolume(sonido,Util.volumenEfectos);
				
			}
			
		};
		
		boton.addListener(click);
		
}

}



