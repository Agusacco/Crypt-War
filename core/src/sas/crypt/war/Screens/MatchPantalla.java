package sas.crypt.war.Screens;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import sas.crypt.war.CryptWar;
import sas.crypt.war.Util;
import sas.crypt.war.Objects.Jugador;
import sas.crypt.war.Objects.Mapa;

public class MatchPantalla extends Pantalla{

	public static Mapa mapaPrueba;
	public static Jugador jugadorPrueba;
	public static Image imagenJugador;
	public static int rotacionIndex = 0;
	public int numeroCasillas, cantJugadores;
	
	public static Image bordeAbajo, bordeIzquierda, bordeArriba, bordeDerecha, hud;
	
	public MatchPantalla(CryptWar game, int cantJugadores, int numCasillas) {
		
		super.game=game;
		this.numeroCasillas = numCasillas;
		this.cantJugadores = cantJugadores;
		
	}
	
	public void show(){
		
		prepararObjetos();
		listenersObjetos();
		
	}

	private void listenersObjetos() {
		
		stage.addListener(new InputListener(){

			public boolean keyDown(InputEvent event, int keycode) {
				
				switch (keycode) {
					
				/*case Keys.ESCAPE:
					
					Gdx.app.exit();
				
				break;*/
		
				//Moverse a la izquierda
				
				case Keys.LEFT:
					
					jugadorPrueba.moverIzquierda(mapaPrueba.mapasRotacion[rotacionIndex]);
					
				break;
				
				case Keys.A:
					
					jugadorPrueba.moverIzquierda(mapaPrueba.mapasRotacion[rotacionIndex]);
					
				break;
				
				
				//Moverse a la derecha
				
				case Keys.RIGHT:
					
					jugadorPrueba.moverDerecha(mapaPrueba.mapasRotacion[rotacionIndex]);
					
				break;
				
				case Keys.D:
					
					jugadorPrueba.moverDerecha(mapaPrueba.mapasRotacion[rotacionIndex]);
					
				break;
				
				
				//Moverse a la arriba
				
				case Keys.UP:
					
					jugadorPrueba.moverArriba(mapaPrueba.mapasRotacion[rotacionIndex]);
					
				break;
				
				case Keys.W:
					
					jugadorPrueba.moverArriba(mapaPrueba.mapasRotacion[rotacionIndex]);
					
				break;
				
				
				//Moverse a la abajo
				
				case Keys.DOWN:
					
					jugadorPrueba.moverAbajo(mapaPrueba.mapasRotacion[rotacionIndex]);
					
				break;
				
				case Keys.S:
					
					jugadorPrueba.moverAbajo(mapaPrueba.mapasRotacion[rotacionIndex]);
					
				break;
				
				
				
				}
				
				return false;
				
			}
			
		});
		
	}

	private void prepararObjetos() {
		
		/*stage.getRoot().getColor().a=0;
		stage.addAction(Actions.fadeIn(2));*/
		
		CryptWar.discord.update("En partida", "Partida privada", null, "");
		
		bordeAbajo = new Image(new Sprite(new Texture("Bordes/bordesMapa.png")));
		bordeDerecha = new Image(new Sprite(new Texture("Bordes/bordesMapa.png")));
		bordeIzquierda = new Image(new Sprite(new Texture("Bordes/bordeIzquierda.png")));
		bordeArriba = new Image(new Sprite(new Texture("Bordes/bordesMapa.png")));
		hud = new Image(new Sprite(new Texture("HUD/hud.png")));
		
		bordeAbajo.setBounds(0, -370, 2000, 1000);
		bordeAbajo.setZIndex(1);
		//bordeAbajo.debug();
		
		bordeDerecha.setBounds(2840, 270, 800, 1000);
		bordeDerecha.addAction(Actions.rotateBy(90));
		bordeDerecha.setZIndex(1);
		//bordeAbajo.debug();
		
		bordeIzquierda.setBounds(0, 270, 1440, 1720);
		bordeIzquierda.setZIndex(1);
		//bordeIzquierda.debug();
		
		bordeArriba.setBounds(1940, 1240, 2000, 200);
		bordeArriba.addAction(Actions.rotateBy(180));
		bordeArriba.setZIndex(1);
		//bordeArriba.debug();
		
		hud.setPosition(0, -100);
		
		jugadorPrueba = new Jugador("TEST");
		
		mapaPrueba = new Mapa (numeroCasillas, cantJugadores, true);
		
		mostrarMapa(mapaPrueba);
		
	}
	
	public static void mostrarMapa(Mapa mapa) {
		
		int contaY = 0, contaX = 0;
		
		for (int k = 0; k <= 3; k++) {
			
			for (int i = 0; i < mapa.numCasillas; i++) { 
				
				for (int j = 0; j < mapa.numCasillas; j++) {
					
					mapaPrueba.mapasRotacion[k].mapa[i][j].imagenCasilla.remove();
					
				}
				
			}
			
		}
		
	
		for (int j = mapa.numCasillas-1; j >= 0; j--) {  
			
			for (int i = 0; i < mapa.numCasillas; i++) {
				
				Image imagenCasilla = null;
				imagenCasilla = mapa.mapa[i][j].imagenCasilla;
				
				//imagenCasilla.setBounds((((((Util.WIDTH)-1850)+(contaX*((1000/mapa.numCasillas))))+mapa.mapa[i][j].auxX)), (((((Util.HEIGHT)/2)+400-((1000.0f/mapa.numCasillas)-100)/*+((mapa.numCasillas-15f)*10)*/)-(contaY*(1000/mapa.numCasillas)))+mapa.mapa[i][j].auxY), 1000.0f/mapa.numCasillas, 1000.0f/mapa.numCasillas); //ESPECTADOR (10x10 Fundamental)
				
				imagenCasilla.setScale(.4f);
				
				if (mapa.numCasillas <= 10) {
					
					imagenCasilla.setBounds((((((Util.WIDTH)+1700)+(contaX*((1000.0f/mapa.numCasillas))))+mapa.mapa[i][j].auxX))*.4f, (((((Util.HEIGHT)/2)+1970-((1000.0f/mapa.numCasillas)-100))-(contaY*(1000.0f/mapa.numCasillas)))+mapa.mapa[i][j].auxY)*.4f, 1000.0f/mapa.numCasillas, 1000.0f/mapa.numCasillas); //MINIMAPA (10x10)
					
				}
				
				else {
						
					imagenCasilla.setBounds(((((4020-(jugadorPrueba.auxPosX*100))+(contaX*((100))))+mapa.mapa[i][j].auxX))*.4f, (((3910-(jugadorPrueba.auxPosY*100))-(contaY*(100)))+mapa.mapa[i][j].auxY)*.4f, 100, 100); //MINIMAPA (10x10)
						
				}
				
				stage.addActor(imagenCasilla);
					
				contaX++;
					
			}
			
			contaX = 0;
			contaY++;
			
		}
		
		if (imagenJugador != null) {
			
			imagenJugador.remove();
			
		}
		
		imagenJugador = new Image(new Sprite(new Texture("Jugador/jugador2.png")));
		
		imagenJugador.setPosition(1610, 805); 
		imagenJugador.setZIndex(400);
	
		stage.addActor(imagenJugador);
		System.out.println("("+ jugadorPrueba.posX + ";" + jugadorPrueba.posY + ") (CODIGO: " + mapaPrueba.mapasRotacion[rotacionIndex].mapa[jugadorPrueba.auxPosX][jugadorPrueba.auxPosY].codigoCasilla + ") (" + rotacionIndex + ")");
		
		bordeAbajo.remove();
		bordeIzquierda.remove();
		bordeDerecha.remove();
		bordeArriba.remove();
		hud.remove();
		
		stage.addActor(bordeAbajo);
		stage.addActor(bordeDerecha);
		stage.addActor(bordeIzquierda);
		stage.addActor(bordeArriba);
		stage.addActor(hud);
		
	}
	
	
}
