package sas.crypt.war.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Casilla implements Cloneable{

	/* 0 = Vacio
	 * 
	 * Paredes
	 * 1 = Arriba
	 * 2 = Derecha
	 * 3 = Abajo
	 * 4 = Izquierda
	 * 
	 * Esquinas
	 * 5 = Arriba/Derecha
	 * 6 = Derecha/Abajo
	 * 7 = Abajo/Izquierda
	 * 8 = Izquierda/Arriba
	 * 
	 * Pasillo
	 * 9 = Horizontal
	 * 10 = Vertical
	 * 
	 * Caja
	 * 11 = Sin Abajo
	 * 12 = Sin Izquierda
	 * 13 = Sin Arriba
	 * 14 = Sin Derecha 
	 * */
	
	public int codigoCasilla; 
	public int tipoCasilla;
	public Image imagenCasilla;
	public int auxX = 0;
	public int auxY = 0;
	
	public boolean arriba;
	public boolean derecha;
	public boolean abajo;
	public boolean izquierda;
	
	public Casilla (int codigoCasilla, int numCasillas) {
		
		this.codigoCasilla = codigoCasilla;
		
		if (codigoCasilla == 0) {
			
			this.tipoCasilla = 0;
			
		}
		
		else if (codigoCasilla >= 1 && codigoCasilla <= 4) {
			
			this.tipoCasilla = 1;
			
		}
		
		else if (codigoCasilla >= 5 && codigoCasilla <= 8) {
			
			this.tipoCasilla = 2;
			
		}
		
		else if (codigoCasilla == 9 && codigoCasilla == 10) {
			
			this.tipoCasilla = 3;
			
		}
		
		else if (codigoCasilla >= 11 && codigoCasilla <= 14) {
			
			this.tipoCasilla = 4;
			
		}
		
		else {
			
			this.tipoCasilla = 5;
			
		}
		
		
		switch(this.codigoCasilla) {
		
			//Vacio
			case 0: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/0.png")));
				this.arriba = false;
				this.derecha = false;
				this.abajo = false;
				this.izquierda = false;
				
			break;
			
			
			//Paredes
			case 1: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/1.png")));
				this.arriba = true;
				this.derecha = false;
				this.abajo = false;
				this.izquierda = false;
				
			break;
			
			case 2: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/1.png")));
				imagenCasilla.addAction(Actions.rotateBy(-90)); //+100 Y
				this.arriba = false;
				this.derecha = true;
				this.abajo = false;
				this.izquierda = false;
				
				if (numCasillas <= 10) {
					
					this.auxY = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxY = 100;
					
				}
				
			break;
			
			case 3: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/1.png")));
				imagenCasilla.addAction(Actions.rotateBy(-180)); //+100 Y +100 X
				this.arriba = false;
				this.derecha = false;
				this.abajo = true;
				this.izquierda = false;
				
				if (numCasillas <= 10) {
					
					this.auxY = 1000/numCasillas;
					this.auxX = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxY = 100;
					this.auxX = 100;
					
				}
				
				
			
			break;
			
			case 4: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/1.png")));
				imagenCasilla.addAction(Actions.rotateBy(-270)); //+100 X
				this.arriba = false;
				this.derecha = false;
				this.abajo = false;
				this.izquierda = true;
				
				if (numCasillas <= 10) {
					
					this.auxX = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxX = 100;
					
				}
			
			break;
			
			
			//Esquinas
			
			case 5: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/2.png")));
				this.arriba = true;
				this.derecha = true;
				this.abajo = false;
				this.izquierda = false;
				
			break;
				
			case 6: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/2.png")));
				imagenCasilla.addAction(Actions.rotateBy(-90));
				this.arriba = false;
				this.derecha = true;
				this.abajo = true;
				this.izquierda = false;
				
				if (numCasillas <= 10) {
					
					this.auxY = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxY = 100;
					
				}
			
			break;
			
			case 7: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/2.png")));
				imagenCasilla.addAction(Actions.rotateBy(-180));
				this.arriba = false;
				this.derecha = false;
				this.abajo = true;
				this.izquierda = true;
				
				if (numCasillas <= 10) {
					
					this.auxY = 1000/numCasillas;
					this.auxX = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxY = 100;
					this.auxX = 100;
					
				}
				
			break;
			
			case 8: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/2.png")));
				imagenCasilla.addAction(Actions.rotateBy(-270));
				this.arriba = true;
				this.derecha = false;
				this.abajo = false;
				this.izquierda = true;
				
				if (numCasillas <= 10) {
					
					this.auxX = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxX = 100;
					
				}
				
			break;
			
			
			//Pasillos
			
			case 9: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/3.png")));
				this.arriba = true;
				this.derecha = false;
				this.abajo = true;
				this.izquierda = false;
				
			break;
			
			case 10: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/3.png")));
				imagenCasilla.addAction(Actions.rotateBy(-90));
				this.arriba = false;
				this.derecha = true;
				this.abajo = false;
				this.izquierda = true;
				
				if (numCasillas <= 10) {
					
					this.auxY = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxY = 100;
					
				}
				
			break;
			
			
			//Cajas
			
			case 11: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/4.png")));
				this.arriba = true;
				this.derecha = true;
				this.abajo = false;
				this.izquierda = true;
				
			break;
			
			
			case 12: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/4.png")));
				imagenCasilla.addAction(Actions.rotateBy(-90));
				this.arriba = true;
				this.derecha = true;
				this.abajo = true;
				this.izquierda = false;
				
				if (numCasillas <= 10) {
					
					this.auxY = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxY = 100;
					
				}
				
			break;
			
			
			case 13: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/4.png")));
				imagenCasilla.addAction(Actions.rotateBy(-180));
				this.arriba = false;
				this.derecha = true;
				this.abajo = true;
				this.izquierda = true;
				
				if (numCasillas <= 10) {
					
					this.auxY = 1000/numCasillas;
					this.auxX = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxY = 100;
					this.auxX = 100;
					
				}
				
			break;
			
			case 14: 
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/4.png")));
				imagenCasilla.addAction(Actions.rotateBy(-270));
				this.arriba = true;
				this.derecha = false;
				this.abajo = true;
				this.izquierda = true;
				
				if (numCasillas <= 10) {
					
					this.auxX = 1000/numCasillas;
					
				}
				
				else {
					
					this.auxX = 100;
					
				}
				
			break;
			
			case 15:
				
				imagenCasilla = new Image(new Sprite(new Texture("Casillas/5.png")));
				this.arriba = true;
				this.derecha = true;
				this.abajo = true;
				this.izquierda = true;
				
			break;
			
		}
		
	}
	
}
