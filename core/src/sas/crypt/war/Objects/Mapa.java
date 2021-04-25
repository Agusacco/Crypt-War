package sas.crypt.war.Objects;

import java.util.HashSet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import sas.crypt.war.Util;
import sas.crypt.war.Screens.MatchPantalla;

public class Mapa implements Cloneable{

	public int numCasillas;
	public int numJugadores;
	public Casilla mapa[][];
	public Maze laberinto;
	
	public int rotacionIndex;
	public Mapa mapasRotacion[];
	
	public int maxX; //Minimo: 3620. El maximo tiene que ser menor.
	public int maxY; //Minimo: 2510. El maximo tiene que ser mayor.
	
	static int[][] rotar90(int[][] matrizCodigos, int numCasillas) 
	{ 
		
		
	    for (int i = 0; i < numCasillas / 2; i++) 
	    { 
	        for (int j = i; j < numCasillas - i - 1; j++) 
	        { 
	  
	            int temp = matrizCodigos[i][j]; 
	            matrizCodigos[i][j] = matrizCodigos[numCasillas - 1 - j][i]; 
	            matrizCodigos[numCasillas - 1 - j][i] = matrizCodigos[numCasillas - 1 - i][numCasillas - 1 - j]; 
	            matrizCodigos[numCasillas - 1 - i][numCasillas - 1 - j] = matrizCodigos[j][numCasillas - 1 - i]; 
	            matrizCodigos[j][numCasillas - 1 - i] = temp; 
	        } 
	    }
	    
		return matrizCodigos; 
	}
	
	public Mapa(int numCasillas, int numJugadores, boolean original) {
		
		this.numCasillas = numCasillas;
		this.numJugadores = numJugadores;
		this.mapa = new Casilla[numCasillas][numCasillas]; 
		
		if (numCasillas > 10) {
			
			this.maxX = 3650-((numCasillas-10)*100);
			this.maxY = 2510+((numCasillas-10)*100);
			
		}
		
		
		
		if (original) {
			
			this.laberinto = new Maze(numCasillas);
			
			for (int i = 0; i < numCasillas; i++) {
				
				for (int j = 0; j < numCasillas; j++) {
					
					if (this.laberinto.north[i][j] == false && 
						this.laberinto.east[i][j] == false &&
						this.laberinto.west[i][j] == false &&
						this.laberinto.south[i][j] == false) {
						
						this.mapa[i][j] = new Casilla(0, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == true && 
							this.laberinto.east[i][j] == false &&
							this.laberinto.west[i][j] == false &&
							this.laberinto.south[i][j] == false) {
						
						this.mapa[i][j] = new Casilla(1, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == false && 
							this.laberinto.east[i][j] == true &&
							this.laberinto.west[i][j] == false &&
							this.laberinto.south[i][j] == false) {
						
						this.mapa[i][j] = new Casilla(2, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == false && 
							this.laberinto.east[i][j] == false &&
							this.laberinto.west[i][j] == false &&
							this.laberinto.south[i][j] == true) {
						
						this.mapa[i][j] = new Casilla(3, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == false && 
							this.laberinto.east[i][j] == false &&
							this.laberinto.west[i][j] == true &&
							this.laberinto.south[i][j] == false) {
						
						this.mapa[i][j] = new Casilla(4, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == true && 
							this.laberinto.east[i][j] == true &&
							this.laberinto.west[i][j] == false &&
							this.laberinto.south[i][j] == false) {
						
						this.mapa[i][j] = new Casilla(5, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == false && 
							this.laberinto.east[i][j] == true &&
							this.laberinto.west[i][j] == false &&
							this.laberinto.south[i][j] == true) {
						
						this.mapa[i][j] = new Casilla(6, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == false && 
							this.laberinto.east[i][j] == false &&
							this.laberinto.west[i][j] == true &&
							this.laberinto.south[i][j] == true) {
						
						this.mapa[i][j] = new Casilla(7, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == true && 
							this.laberinto.east[i][j] == false &&
							this.laberinto.west[i][j] == true &&
							this.laberinto.south[i][j] == false) {
						
						this.mapa[i][j] = new Casilla(8, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == true && 
							this.laberinto.east[i][j] == false &&
							this.laberinto.west[i][j] == false &&
							this.laberinto.south[i][j] == true) {
						
						this.mapa[i][j] = new Casilla(9, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == false && 
							this.laberinto.east[i][j] == true &&
							this.laberinto.west[i][j] == true &&
							this.laberinto.south[i][j] == false) {
						
						this.mapa[i][j] = new Casilla(10, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == true && 
							this.laberinto.east[i][j] == true &&
							this.laberinto.west[i][j] == true &&
							this.laberinto.south[i][j] == false) {
						
						this.mapa[i][j] = new Casilla(11, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == true && 
							this.laberinto.east[i][j] == true &&
							this.laberinto.west[i][j] == false &&
							this.laberinto.south[i][j] == true) {
						
						this.mapa[i][j] = new Casilla(12, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == false && 
							this.laberinto.east[i][j] == true &&
							this.laberinto.west[i][j] == true &&
							this.laberinto.south[i][j] == true) {
						
						this.mapa[i][j] = new Casilla(13, numCasillas);
						
					}
					
					else if (this.laberinto.north[i][j] == true && 
							this.laberinto.east[i][j] == false &&
							this.laberinto.west[i][j] == true &&
							this.laberinto.south[i][j] == true) {
						
						this.mapa[i][j] = new Casilla(14, numCasillas);
						
					}
					
					else {
						
						this.mapa[i][j] = new Casilla(15, numCasillas);
						
					}
					
				}
				
			}
			
			for (int i = 0; i < mapa.length; i++) {
				
				for (int j = 0; j < mapa.length; j++) {
					
					System.out.println("-----------------------------");
					System.out.println("("+ i + ";" + j + ")");
					System.out.println("CODIGO: " + this.mapa[i][j].codigoCasilla);
					System.out.println("ARRIBA: " + this.laberinto.north[i][j]);
					System.out.println("DERECHA: " + this.laberinto.east[i][j]);
					System.out.println("IZQUIERDA: " + this.laberinto.west[i][j]);
					System.out.println("SUR: " + this.laberinto.south[i][j]);
					System.out.println("-----------------------------");
					
				}
				
			}
			
			rotarMapa(this, this.numCasillas, this.numJugadores);
		
		}
		
	}
	
	public void rotarMapa(Mapa mapa, int numCasillas, int numJugadores) {
		
		mapasRotacion = new Mapa[4];
		mapasRotacion[0] = mapa;
		
		System.out.println("ORIGINAL: " + mapa);
		
		for (int k = 0; k < 3; k++) {
			
			Mapa mapaRotacion = new Mapa(numCasillas, numJugadores, false);
			
			int[][] matrizCodigos = new int[numCasillas][numCasillas];
			
			for (int i = 0; i < matrizCodigos.length; i++) {
				
				for (int j = 0; j < matrizCodigos.length; j++) {
					
					matrizCodigos[i][j] = mapasRotacion[k].mapa[i][j].codigoCasilla;
					
				}
				
			}
			
			int[][] matrizRotada = new int[numCasillas][numCasillas];
			
			matrizRotada = rotar90(matrizCodigos, numCasillas);
			
			for (int i = 0; i < numCasillas; i++) {
				
				for (int j = 0; j < numCasillas; j++) {
					
					int codigoNuevo = 0;
					
					switch (matrizRotada[i][j]) {
					
						case 0: 
							
							codigoNuevo = 0;
							mapaRotacion.mapa[i][j] = new Casilla(0, numCasillas);
							
						break;
						
						
						//Paredes
						case 1: 
							
							codigoNuevo = 2;
							mapaRotacion.mapa[i][j] = new Casilla(2, numCasillas);
							
						break;
						
						case 2: 
							
							codigoNuevo = 3;
							mapaRotacion.mapa[i][j] = new Casilla(3, numCasillas);
						
						break;
						
						case 3: 
							
							codigoNuevo = 4;
							mapaRotacion.mapa[i][j] = new Casilla(4, numCasillas);
						
						break;
						
						case 4: 
							
							codigoNuevo = 1;
							mapaRotacion.mapa[i][j] = new Casilla(1, numCasillas);
						
						break;
						
						
						//Esquinas
						
						case 5: 
							
							codigoNuevo = 6;
							mapaRotacion.mapa[i][j] = new Casilla(6, numCasillas);
							
						break;
							
						case 6: 
							
							codigoNuevo = 7;
							mapaRotacion.mapa[i][j] = new Casilla(7, numCasillas);
						
						break;
						
						case 7: 
							
							codigoNuevo = 8;
							mapaRotacion.mapa[i][j] = new Casilla(8, numCasillas);
							
						break;
						
						case 8: 
							
							codigoNuevo = 5;
							mapaRotacion.mapa[i][j] = new Casilla(5, numCasillas);
							
						break;
						
						
						//Pasillos
						
						case 9: 
							
							codigoNuevo = 10;
							mapaRotacion.mapa[i][j] = new Casilla(10, numCasillas);
							
						break;
						
						case 10: 
							
							codigoNuevo = 9;
							mapaRotacion.mapa[i][j] = new Casilla(9, numCasillas);
							
						break;
						
						
						//Cajas
						
						case 11: 
							
							codigoNuevo = 12;
							mapaRotacion.mapa[i][j] = new Casilla(12, numCasillas);
							
						break;
						
						
						case 12: 
							
							codigoNuevo = 13;
							mapaRotacion.mapa[i][j] = new Casilla(13, numCasillas);
							
						break;
						
						
						case 13: 
							
							codigoNuevo = 14;
							mapaRotacion.mapa[i][j] = new Casilla(14, numCasillas);
							
						break;
						
						case 14: 
							
							codigoNuevo = 11;
							mapaRotacion.mapa[i][j] = new Casilla(11, numCasillas);
							
						break;
						
						case 15:
							
							codigoNuevo = 15;
							mapaRotacion.mapa[i][j] = new Casilla(15, numCasillas);
							
						break;
					
					}
					
				}
				
			}
			
			mapasRotacion[k+1] = mapaRotacion;
			
		}
		
		
	}

	public void impedirMovimiento() {
		
		System.out.println("No te puedes mover a esta posicion");
		
	}
	
	
}
