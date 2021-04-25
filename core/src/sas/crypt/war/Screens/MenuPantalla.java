package sas.crypt.war.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldFilter;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import sas.crypt.war.CryptWar;
import sas.crypt.war.Util;
import sas.crypt.war.Interface.Boton;
import sas.crypt.war.Interface.Texto;

public class MenuPantalla extends Pantalla{

	public Boton bNormal, bPrivada, bUnirse, bEntrar;
	public Texto t, version;
	public TextField codigoSala;
	
	public String estado = "Menu principal";
	
	public MenuPantalla(CryptWar game) {
		
		super.game= game;
		
	}
	
	public void show() {
		
		prepararObjetos();
		listenersObjetos();
		
	}

	private void listenersObjetos() {
		
		bPrivada.addListener(new ClickListener() {
			
			public void clicked(InputEvent event, float x, float y) {
				
				game.setScreen(new LobbyPantalla(game, true));
				
			}
			
		});
		
		bEntrar.addListener(new ClickListener() {
			
			public void clicked(InputEvent event, float x, float y) {
				
				if (!codigoSala.getText().isEmpty() && codigoSala.getText().length() == 6) {
					
					
					
				}
				
			}
			
		});
		
		bUnirse.addListener(new ClickListener() {
			
			public void clicked(InputEvent event, float x, float y) {
				
				estado = "Unirse privada";
				
				bUnirse.setVisible(false);
				bNormal.setVisible(false);
				bPrivada.setVisible(false);
				
				bEntrar.setVisible(true);
				codigoSala.setVisible(true);
				
			}
			
		});
		
		bNormal.addListener(new ClickListener() {
			
			public void clicked(InputEvent event, float x, float y) {
				
				bNormal.setText("TROLEADO PUTO");
				Gdx.app.exit();
				
			}
			
		});
		
		stage.addListener(new InputListener(){

			public boolean keyDown(InputEvent event, int keycode) {
				
				switch (keycode) {
				
				case Keys.ESCAPE:
					
					if (estado.equals("Menu principal")) {
						
						Gdx.app.exit();
						
					}
					
					else if (estado.equals("Unirse privada")) {
						
						estado = "Menu principal";
						
						bUnirse.setVisible(true);
						bNormal.setVisible(true);
						bPrivada.setVisible(true);
						
						bEntrar.setVisible(false);
						codigoSala.setVisible(false);
						
					}
					
				break;
				
				}
				
				return false;
				
			}
			
		});
		
	}

	private void prepararObjetos() {
		
		CryptWar.discord.update("Menu principal", "Idle", null, null);
		
		t = new Texto("jaja como vas a jugar mi juego \n (BETA TESTERSSSSSSSS VERSION)", 500, 900, 2, Util.skin, "optional");
		stage.addActor(t);
		
		version = new Texto (Util.version, 5, 5, 1, Util.skin, "optional");
		stage.addActor(version);
		
		bNormal = new Boton("Buscar partida", 1);
		bNormal.setPosition(800, 700);
		stage.addActor(bNormal);
		
		bPrivada = new Boton("Crear partida privada", 1);
		bPrivada.setPosition(800, 650);
		stage.addActor(bPrivada);
		
		bUnirse = new Boton("Unirse a partida privada", 1);
		bUnirse.setPosition(800, 600);
		stage.addActor(bUnirse);
		
		bEntrar = new Boton("PUSIsTE MaL eL CODIGO? a VERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR", 1);
		bEntrar.setPosition(700, 600);
		bEntrar.setVisible(false);
		stage.addActor(bEntrar);
		
		codigoSala = new TextField("", Util.skin);
		codigoSala.setPosition(800, 650);
		codigoSala.getStyle().font.getData().setScale(2);
		codigoSala.setSize(200, 50);
		codigoSala.setAlignment(Align.center);
		codigoSala.setMaxLength(6);
		codigoSala.setVisible(false);
		stage.addActor(codigoSala);
		
	}
	
}
