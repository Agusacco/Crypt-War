package sas.crypt.war.Screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldFilter;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.Align;

import sas.crypt.war.CryptWar;
import sas.crypt.war.Util;
import sas.crypt.war.Interface.Boton;
import sas.crypt.war.Interface.Texto;

public class LobbyPantalla extends Pantalla{

	private int cantJugadores, numCasillas;
	private int jugadoresMax = 4;
	
	public static String code = "";
	private String codeAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public boolean crearLobby = false;
	
	private Texto tCodigo;
	private Boton bVolver, bEmpezar;
	
	private TextField numeroJugadores, numeroCasillas;
	private Texto tJugadores, tCasillas;

	public LobbyPantalla(CryptWar game, boolean crearLobby) {
		
		super.game= game;
		this.crearLobby = crearLobby;
	}
	
	public void show() {
		
		prepararObjetos();
		listenersObjetos();
		
	}

	private void listenersObjetos() {
		
		bVolver.addListener(new ClickListener() {
			
			public void clicked(InputEvent event, float x, float y) {
				
				code = "";
				game.setScreen(new MenuPantalla(game));
				
			}
			
		});
		
		bEmpezar.addListener(new ClickListener() {
			
			public void clicked(InputEvent event, float x, float y) {
				
				numCasillas = Integer.parseInt(numeroCasillas.getText());
				cantJugadores = 1;//Integer.parseInt(numeroJugadores.getText());
				game.setScreen(new MatchPantalla(game, cantJugadores, numCasillas));
				
			}
			
		});
		
		numeroJugadores.addListener(new FocusListener() {
			
			 public void keyboardFocusChanged(FocusListener.FocusEvent event, Actor actor, boolean focused) {
				 
				 if (focused) {
					 
					 
					 
				 }
				 
				 else {
					 
					 System.out.println(numeroJugadores.getText());
					 
					 if (numeroJugadores.getText().isEmpty() || Integer.parseInt(numeroJugadores.getText()) <= 1){
						 
						 numeroJugadores.setText("2");
						 
					 }
					 
					 System.out.println(numeroJugadores.getText());
					 
					jugadoresMax = Integer.parseInt(numeroJugadores.getText());
					CryptWar.discord.update("Sala privada", "Esperando jugadores (" + cantJugadores + "/" + jugadoresMax + ")", "", null); 
					 
				 }
				 
			 }
			
		});
		
		numeroCasillas.addListener(new FocusListener() {
			
			 public void keyboardFocusChanged(FocusListener.FocusEvent event, Actor actor, boolean focused) {
				 
				 if (focused) {
					 
					 
					 
				 }
				 
				 else {
					 
					 if (numeroCasillas.getText().isEmpty() || Integer.parseInt(numeroCasillas.getText()) <= 9){
						 
						 numeroCasillas.setText("10");
						 
					 }
					 
				 }
				 
			 }
			
		});
		
	}

	private void prepararObjetos() {
		
		CryptWar.discord.update("Sala privada", "Esperando jugadores (" + cantJugadores + "/" + jugadoresMax + ")", "", null);
		
		System.out.println(crearLobby);
		
		bVolver = new Boton("Salir", 1);
		bVolver.setPosition(50, 50);
		stage.addActor(bVolver);
		
		numeroJugadores = new TextField("4", Util.skin);
		numeroJugadores.setPosition(800, 500);
		numeroJugadores.getStyle().font.getData().setScale(2);
		numeroJugadores.setSize(70, 50);
		numeroJugadores.setAlignment(Align.center);
		numeroJugadores.setMaxLength(2);
		numeroJugadores.setTextFieldFilter(new TextFieldFilter.DigitsOnlyFilter());
		stage.addActor(numeroJugadores);
		tJugadores = new Texto("Numero de jugadores: ", 100, 500, 2, Util.skin, "optional");
		stage.addActor(tJugadores);
		
		numeroCasillas = new TextField("20", Util.skin);
		numeroCasillas.setPosition(800, 400);
		numeroCasillas.getStyle().font.getData().setScale(2);
		numeroCasillas.setSize(70, 50);
		numeroCasillas.setAlignment(Align.center);
		numeroCasillas.setMaxLength(3);
		numeroCasillas.setTextFieldFilter(new TextFieldFilter.DigitsOnlyFilter());
		stage.addActor(numeroCasillas);
		tCasillas = new Texto("Numero de casillas: ", 100, 400, 2, Util.skin, "optional");
		stage.addActor(tCasillas);

		bEmpezar = new Boton("ARRANCA O NO ARRANCA", 4);
		bEmpezar.setPosition(1000, 50);
		stage.addActor(bEmpezar);
		
		numeroCasillas.setDisabled(true);
		numeroJugadores.setDisabled(true);
		bEmpezar.setDisabled(true);
		
		if (crearLobby) {
			
			for (int i = 0; i < 6; i++) {
				
				code = code + codeAlphabet.charAt(Util.r.nextInt(codeAlphabet.length()));
				
			}
			
			numeroCasillas.setDisabled(false);
			numeroJugadores.setDisabled(false);
			bEmpezar.setDisabled(false);
			
		}
		
		tCodigo = new Texto("CODIGO: " + code, 100, 1000, 3, Util.skin, "optional");
		stage.addActor(tCodigo);
		
	}
	
}
