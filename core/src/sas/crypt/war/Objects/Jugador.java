package sas.crypt.war.Objects;

import sas.crypt.war.Screens.MatchPantalla;

public class Jugador {

	public String username;
	public int vida;
	public int mana;
	public int dano;
	public int armadura;
	public int resistenciaMagica;
	
	public int numeroJugador;
	public int posX;
	public int posY;
	public int auxPosX;
	public int auxPosY;
	
	/*
	 * 0 = Arriba
	 * 1 = Derecha
	 * 2 = Abajo
	 * 3 = Izquierda
	 */
	public int direccion; 
	
	public Jugador(String username) {
		
		if (username == "TEST") {
			
			this.posX = 0;
			this.posY = 0;
			this.auxPosX = 0;
			this.auxPosY = 0;
			
			this.numeroJugador = 1;
			this.direccion = 0;
			
		}
		
	}

	public void moverAbajo(Mapa mapa) {

		if (mapa.mapa[auxPosX][auxPosY].abajo) {
			
			System.out.println("HAY UNA PARED ABAJO");
			
		}
		
		else {
			
			int direccionMapa = 0;
			
			switch(this.direccion) {
			
			case 0:
				
				direccionMapa = 2;
				direccion = 2;
				posY--;
				
				auxPosX = mapa.numCasillas - posX - 1;
				auxPosY =  mapa.numCasillas - posY - 1;
			
			break;
			
			case 1:
				
				direccionMapa = 1;
				direccion = 3;
				posX--;
				
				auxPosX = 0 + posY;
				auxPosY =  mapa.numCasillas - posX - 1;
			
			break;
			
			case 2:
				
				direccionMapa = 0;
				direccion = 0;
				posY++;
				
				auxPosX = 0 + posX;
				auxPosY = 0 + posY;
			
			break;
			
			case 3:
				
				direccionMapa = 3;
				direccion = 1;
				posX++;
				
				auxPosX = mapa.numCasillas - posY - 1;
				auxPosY = 0 + posX;
			
			break;
			
			}
			
			MatchPantalla.rotacionIndex = direccionMapa;
			MatchPantalla.mostrarMapa(MatchPantalla.mapaPrueba.mapasRotacion[direccionMapa]);
			
		}
		
	}

	public void moverArriba(Mapa mapa) {

		if (mapa.mapa[auxPosX][auxPosY].arriba) {
			
			System.out.println("HAY UNA PARED ARRIBA");
			
		}
		
		else {
			
			int direccionMapa = 0;
			
			switch(this.direccion) {
			
			case 0:
				
				direccionMapa = 0;
				direccion = 0;
				posY++;
				
				auxPosX = 0 + posX;
				auxPosY = 0 + posY;
			
			break;
			
			case 1:
				
				direccionMapa = 3;
				direccion = 1;
				posX++;
				
				auxPosX = mapa.numCasillas - posY - 1;
				auxPosY = 0 + posX;
				
			break;
			
			case 2:
				
				direccionMapa = 2;
				direccion = 2;
				posY--;
				
				auxPosX = mapa.numCasillas - posX - 1;
				auxPosY =  mapa.numCasillas - posY - 1;
			
			break;
			
			case 3:
				
				direccionMapa = 1;
				direccion = 3;
				posX--;

				auxPosX = 0 + posY;
				auxPosY =  mapa.numCasillas - posX - 1;
				
			break;
			
			}
			
			MatchPantalla.rotacionIndex = direccionMapa;
			MatchPantalla.mostrarMapa(MatchPantalla.mapaPrueba.mapasRotacion[direccionMapa]);
			
		}
		
	}

	public void moverDerecha(Mapa mapa) {

		if (mapa.mapa[auxPosX][auxPosY].derecha) {
			
			System.out.println("HAY UNA PARED DERECHA");
			
		}
		
		else {
			
			int direccionMapa = 0;
			
			switch(this.direccion) {
			
			case 0:
				
				direccionMapa = 3;
				direccion = 1;
				posX++;
			
				auxPosX = mapa.numCasillas - posY - 1;
				auxPosY = 0 + posX;
			
			break;
			
			case 1:
				
				direccionMapa = 2;
				direccion = 2;
				posY--;
				
				auxPosX = mapa.numCasillas - posX - 1;
				auxPosY =  mapa.numCasillas - posY - 1;
			
			break;
			
			case 2:
				
				direccionMapa = 1;
				direccion = 3;
				posX--;
				
				auxPosX = 0 + posY;
				auxPosY =  mapa.numCasillas - posX - 1;
				
			break;
			
			case 3:
			
				direccionMapa = 0;
				direccion = 0;
				posY++;
				
				auxPosX = 0 + posX;
				auxPosY = 0 + posY;
			
			break;
			
			}
			
			MatchPantalla.rotacionIndex = direccionMapa;
			MatchPantalla.mostrarMapa(MatchPantalla.mapaPrueba.mapasRotacion[direccionMapa]);
			
		}
		
	}

	public void moverIzquierda(Mapa mapa) {
		
		if (mapa.mapa[auxPosX][auxPosY].izquierda) {
			
			System.out.println("HAY UNA PARED IZQUIERDA");
			
		}
		
		else {
			
			int direccionMapa = 0;
			
			switch(this.direccion) {
			
			case 0:
				
				direccionMapa = 1;
				direccion = 3;
				posX--;

				auxPosX = 0 + posY;
				auxPosY =  mapa.numCasillas - posX - 1;
			
			break;
			
			case 1:
				
				direccionMapa = 0;
				direccion = 0;
				posY++;
				
				auxPosX = 0 + posX;
				auxPosY = 0 + posY;
			
			break;
			
			case 2:
				
				direccionMapa = 3;
				direccion = 1;
				posX++;
				
				auxPosX = mapa.numCasillas - posY - 1;
				auxPosY = 0 + posX;
			
			break;
			
			case 3:
			
				direccionMapa = 2;
				direccion = 2;
				posY--;
				
				auxPosX = mapa.numCasillas - posX - 1;
				auxPosY =  mapa.numCasillas - posY - 1;
			
			break;
			
			}
			
			MatchPantalla.rotacionIndex = direccionMapa;
			MatchPantalla.mostrarMapa(MatchPantalla.mapaPrueba.mapasRotacion[direccionMapa]);
			
		}
			
	}
	
}
