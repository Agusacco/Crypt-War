package sas.crypt.war.Interface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import sas.crypt.war.Util;


public class ComboBox extends SelectBox {

	private ClickListener click;
	private Sound sonidoClick;
	
	public ComboBox() {
		
		super(Util.skin);
		
		/*sonidoClick= Gdx.audio.newSound(Gdx.files.internal("assets/Sonidos/Juego/Jugar.mp3"));
		
		this.eventos(this);*/
		
	}
	
	public void eventos(final ComboBox comboBox){

		click = new ClickListener() {
			
			public void clicked(InputEvent event, float x, float y) {
				
				comboBox.sonidoClick.play();
					
			}
			
		};
		
		comboBox.addListener(click);
		
}

}
