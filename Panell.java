
public class Panell {
	//Atributs
	private char[][] panell;
	private static int numFiles = 5, numColumnes = 5;
		
		
	//Constructors
	public Panell() {
		panell = new char[numFiles][numColumnes];
	}
	
	public Panell(int resultat) {
		panell = new char[numFiles][numColumnes];
		
		if(resultat == 0) {
			for(int i = 0; i < numFiles; i++) {
				panell[i][i] = '*';
				panell[numFiles - (i + 1)][i] = '*';
			}
		} else if(resultat == 1) {
			panell[1][1] = '*';
			for(int i = 0; i < numFiles; i++) {
				panell[i][2] = '*';
			}
		} else {
			for(int i = 0; i < numFiles; i++) {
				for(int j = 1; j < numColumnes - 1; j++) {
					panell[1][3] = '*';
					panell[3][1] = '*';
					if(i % 2 == 0) {
						panell[i][j] = '*';
					}
				}
			}
		}
		for(int i = 0; i < numFiles; i++) {
			for(int j = 0; j < numColumnes; j++) {
				if(panell[i][j] != '*') {
					panell[i][j] = ' ';
				}
			}
		}
	}
	
	public Panell(Panell p) {
		this.panell = p.getPanell();
	}
	

	//Mètodes
	public char[][] canvi(int resultat) {
		Panell nouResultat = new Panell(resultat);
		char[][] nouPanell = new char[numFiles][numColumnes];
		
		if((resultat <= 2) && (resultat >= 0)) {
			for(int i = 0; i < numFiles; i++) {
				for(int j = 0; j < numColumnes; j++) {
					if(this.panell[i][j] == nouResultat.getPos(i, j)) {
						nouPanell[i][j] = '-';
					} else if(this.panell[i][j] == ' ') {
						nouPanell[i][j] = 'E';
					} else if(this.panell[i][j] == '*') {
						nouPanell[i][j] = 'A';
					}
					this.panell[i][j] = nouResultat.getPos(i, j);
				}
			}
			return nouPanell;
		}
		return null;
	}
	
		
	//Getters i setters
	public char[][] getPanell() {
		return panell;
	}
	
	public char getPos(int i, int j) {
		return panell[i][j];
	}
	
	public char setPos(int i, int j, char q) {
		return this.panell[i][j] = q;
	}

	public static int getNumFiles() {
		return numFiles;
	}

	public static void setNumFiles(int numFiles) {
		Panell.numFiles = numFiles;
	}

	public static int getNumColumnes() {
		return numColumnes;
	}

	public static void setNumColumnes(int numColumnes) {
		Panell.numColumnes = numColumnes;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < numFiles; i++) {
			for(int j = 0; j < numColumnes; j++) {
				if(this.panell[i][j] == '-') {
					s += "-";
				}
				s += this.panell[i][j];
			}
			s += "\n";
		}
		
		return s;
	}
}
