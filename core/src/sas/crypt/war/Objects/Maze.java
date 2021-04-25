package sas.crypt.war.Objects;

import sas.crypt.war.Util;

public class Maze {
	
	public int numCasillas;
	public boolean visitados[][];
	public boolean north[][];
	public boolean east[][];
	public boolean south[][];
	public boolean west[][];
	
	public Maze(int numCasillas) {
		
		this.numCasillas = numCasillas;
		
		int x = Util.r.nextInt(numCasillas);
		int y = Util.r.nextInt(numCasillas);
		int restantes = numCasillas*numCasillas - 1;
		
		visitados = new boolean[numCasillas][numCasillas];
		north = new boolean[numCasillas][numCasillas];
		east = new boolean[numCasillas][numCasillas];
		south = new boolean[numCasillas][numCasillas];
		west = new boolean[numCasillas][numCasillas];
		
		for (int i = 0; i < numCasillas; i++) {
			
			for (int j = 0; j < numCasillas; j++) {
				
				north[i][j]= true;
				east[i][j]= true;
				south[i][j]= true;
				west[i][j]= true;
				
			}
			
		}
		
		visitados[x][y] = true;
		
		System.out.println("Comienza en: " + x + ";" + y);
		
		boolean dead0 = false, dead1 = false, dead2 = false, dead3 = false;
		int ciclosRealizados = 0;
		
		while (restantes > 0) {
			
			ciclosRealizados++;
			
			int random = Util.r.nextInt(4);
			
			if (random == 0) {
				
				if (x+1 <= numCasillas-1) {
					
					if (visitados[x+1][y] == false) {
							
						visitados[x+1][y] = true;
						west[x+1][y] = false;
						east[x][y] = false;
						x = x+1;
						restantes--;
							
					}
					
					else {
						
						x = x+1;
						
					}
					
				}
				
			}
			
			else if (random == 1) {
				
				if(y+1 <= numCasillas-1) {
					
					if (visitados[x][y+1] == false) {
						
						visitados[x][y+1] = true;
						south[x][y+1] = false;
						north[x][y] = false;
						y = y+1;
							
						restantes--;
							
					}
					
					else {
						
						y = y+1;
						
					}
					
				}
				
			}
			
			else if (random == 2) {
				
				if(x-1 >= 0) {
					
					if (visitados[x-1][y] == false) {
						
						visitados[x-1][y] = true;
						east[x-1][y] = false;
						west[x][y] = false;
						x = x-1;
						
						restantes--;
							
					}
					
					else {
						
						x = x-1;
						
					}
					
				}
				
			}
			
			
			else if (random == 3) {
				
				if(y-1 >= 0) {
					
					if (visitados[x][y-1] == false) {
						
						visitados[x][y-1] = true;
						north[x][y-1] = false;
						south[x][y] = false;
						y = y-1;	
							
						restantes--;
							
					}
					
					else {
						
						y = y-1;
						
					}
					
				}
				
			}
		
		}
		
		System.out.println("Ciclos realizados: " + ciclosRealizados);
		
	}

}
   
