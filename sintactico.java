package Odiceo;

import java.util.Stack;
import EDI.Datos;

public class sintactico
{
	Datos obd = new Datos();
	String tab[][] = new String[19][33], edo, tran, comp, ord, a[] = new String[4];
	int ren, col, x, y, coma;
	Stack<String> pila = new Stack<String>();

	public void TablaTrans()
	{
		// Estado de Transicion
		tab[0][0] = " ";
		tab[1][0] = "EL";
		tab[2][0] = "EL1";
		tab[3][0] = "ER";
		tab[4][0] = "ER1";
		tab[5][0] = "E";
		tab[6][0] = "E1";
		tab[7][0] = "T";
		tab[8][0] = "T1";
		tab[9][0] = "F";
		tab[10][0]="prog";
		tab[11][0]="dec";
		tab[12][0]="tipo";
		tab[13][0]="bloque";
		tab[14][0]="sents";
		tab[15][0]="sent";
		tab[16][0]="asig";
		tab[17][0]="sigid";
		tab[18][0]="sigif";
		// Componentes
		tab[0][1] = "id";
		tab[0][2] = "num";
		tab[0][3] = "(";
		tab[0][4] = "literal";
		tab[0][5] = "car";
		tab[0][6] = "true";
		tab[0][7] = "false";
		tab[0][8] = "*";
		tab[0][9] = "/";
		tab[0][10] = "+";
		tab[0][11] = "-";
		tab[0][12] = "<";
		tab[0][13] = ">";
		tab[0][14] = "@";
		tab[0][15] = "#";
		tab[0][16] = "?";
		tab[0][17] = "¿";
		tab[0][18] = "and";
		tab[0][19] = "or";
		tab[0][20] = "not";
		tab[0][21] = ")";
		tab[0][22] = "$";
		tab[0][22] = "entero";
		tab[0][23] = "flotante";
		tab[0][24] = "cadena";
		tab[0][25] = "boolean";
		tab[0][26] = "if";
		tab[0][27] = "while";
		tab[0][28] = "do,while";
		tab[0][29] = "else";
		tab[0][30] = "=";
		tab[0][31] = "coma";
		// Transicion "El"
		tab[1][1] = "ER,EL1,";
		tab[1][2] = "ER,EL1,";
		tab[1][3] = "ER,EL1,";
		tab[1][4] = "ER,EL1,";
		tab[1][5] = "ER,EL1,";
		tab[1][6] = "ER,EL1,";
		tab[1][7] = "ER,EL1,";
		tab[1][21] = "not,EL,";
		// Transicion EL1
		tab[2][8] = "€";
		tab[2][9] = "€";
		tab[2][10] = "€";
		tab[2][11] = "€";
		tab[2][12] = "€";
		tab[2][13] = "€";
		tab[2][14] = "€";
		tab[2][15] = "€";
		tab[2][16] = "€";
		tab[2][17] = "€";
		tab[2][18] = "and,ER,EL1,";
		tab[2][19] = "or,ER,EL1,";
		tab[2][20] = "€";
		tab[2][21] = "€";
		tab[2][22] = "€";
		// Transicion ER
		tab[3][1] = "E,ER1,";
		tab[3][2] = "E,ER1,";
		tab[3][3] = "E,ER1,";
		tab[3][4] = "E,ER1,";
		tab[3][5] = "E,ER1,";
		tab[3][6] = "E,ER1,";
		tab[3][7] = "E,ER1,";
		// Transicion ER1
		tab[4][8] = "€";
		tab[4][9] = "€";
		tab[4][10] = "€";
		tab[4][11] = "€";
		tab[4][12] = "<,E,";
		tab[4][13] = ">,E,";
		tab[4][14] = "@,E,";
		tab[4][15] = "#,E,";
		tab[4][16] = "?,E,";
		tab[4][17] = "¿,E,";
		tab[4][18] = "€";
		tab[4][19] = "€";
		tab[4][20] = "€";
		tab[4][21] = "€";
		tab[4][22] = "€";
		// Transicion E
		tab[5][1] = "T,E1,";
		tab[5][2] = "T,E1,";
		tab[5][3] = "T,E1,";
		tab[5][4] = "T,E1,";
		tab[5][5] = "T,E1,";
		tab[5][6] = "T,E1,";
		tab[5][7] = "T,E1,";
		tab[5][21] = "sinc";
		tab[5][22] = "sinc";
		// Transicion E1
		tab[6][8] = "€";
		tab[6][9] = "€";
		tab[6][10] = "+,T,E1,";
		tab[6][11] = "-,T,E1,";
		tab[6][12] = "€";
		tab[6][13] = "€";
		tab[6][14] = "€";
		tab[6][15] = "€";
		tab[6][16] = "€";
		tab[6][17] = "€";
		tab[6][18] = "€";
		tab[6][19] = "€";
		tab[6][20] = "€";
		tab[6][21] = "€";
		tab[6][22] = "€";
		// Transicion T
		tab[7][1] = "F,T1,";
		tab[7][2] = "F,T1,";
		tab[7][3] = "F,T1,";
		tab[7][4] = "F,T1,";
		tab[7][5] = "F,T1,";
		tab[7][6] = "F,T1,";
		tab[7][7] = "F,T1,";
		tab[7][10] = "sinc";
		tab[7][11] = "sinc";
		// Transicion T1
		tab[8][8] = "*,F,T1,";
		tab[8][9] = "/,F,T1,";
		tab[8][10] = "€";
		tab[8][11] = "€";
		tab[8][12] = "€";
		tab[8][13] = "€";
		tab[8][14] = "€";
		tab[8][15] = "€";
		tab[8][16] = "€";
		tab[8][17] = "€";
		tab[8][18] = "€";
		tab[8][19] = "€";
		tab[8][20] = "€";
		tab[8][21] = "€";
		tab[8][22] = "€";
		// Transicion F
		tab[9][1] = "id";
		tab[9][2] = "num";
		tab[9][3] = "(EL)";
		tab[9][4] = "literal";
		tab[9][5] = "car";
		tab[9][6] = "true";
		tab[9][7] = "false";
		tab[9][8] = "sinc";
		tab[9][9] = "sinc";
		//Transicion Prog
		tab[10][23] = "prog,id,;,dec,bloque";
		tab[10][24] = "prog,id,;,dec,bloque";
		tab[10][25] = "prog,id,;,dec,bloque";
		tab[10][26] = "prog,id,;,dec,bloque";
		tab[10][27] = "prog,id,;,dec,bloque";
		tab[10][28] = "prog,id,;,dec,bloque";
		tab[10][29] = "prog,id,;,dec,bloque";
		tab[10][30] = "prog,id,;,dec,bloque";
		tab[10][31] = "prog,id,;,dec,bloque";
		tab[10][32] = "prog,id,;,dec,bloque";
		//transicion dec
		tab[11][23] = "tipo,id,sigid,dec";
		tab[11][24] = "tipo,id,sigid,dec";
		tab[11][25] = "tipo,id,sigid,dec";
		tab[11][26] = "tipo,id,sigid,dec";
		tab[11][27] = "€";
		tab[11][28] = "€";
		tab[11][29] = "€";
		tab[11][30] = "€";
		tab[11][31] = "€";
		tab[11][32] = "€";
		//Transicion tipo
		tab[12][23] = "entero";
		tab[12][24] = "flotante";
		tab[12][25] = "cadena";
		tab[12][26] = "boolean";
		//transicion bloque
		tab[13][23] = "€";
		tab[13][24] = "€";
		tab[13][25] = "€";
		tab[13][26] = "€";
		tab[13][27] = "inicio,sentencia,fin";
		tab[13][28] = "inicio,sentencia,fin";
		tab[13][29] = "inicio,sentencia,fin";
		tab[13][30] = "€";
		tab[13][31] = "€";
		tab[13][32] = "€";
		//transicion sents
		tab[14][23] = "€";
		tab[14][24] = "€";
		tab[14][25] = "€";
		tab[14][26] = "€";
		tab[14][27] = "sent,sents";
		tab[14][28] = "sent,sents";
		tab[14][29] = "sent,sents";
		tab[14][30] = "€";
		tab[14][31] = "€";
		tab[14][32] = "€";
		//transicion sent
		tab[15][23] = "€";
		tab[15][24] = "€";
		tab[15][25] = "€";
		tab[15][26] = "€";
		tab[15][27] = "if,(EL),sent,sents,sigif,endif";
		tab[15][28] = "if,(EL),sent,sents,sigif,endif";
		tab[15][29] = "if,(EL),sent,sents,sigif,endif";
		tab[15][30] = "€";
		tab[15][31] = "asig";
		tab[15][32] = "€";
		//transicion asig
		tab[15][23] = "€";
		tab[15][24] = "€";
		tab[15][25] = "€";
		tab[15][26] = "€";
		tab[15][27] = "€";
		tab[15][28] = "€";
		tab[15][29] = "€";
		tab[15][30] = "€";
		tab[15][31] = "id,=,EL";
		tab[15][32] = "€";
		//transicion sigid
		tab[15][23] = "€";
		tab[15][24] = "€";
		tab[15][25] = "€";
		tab[15][26] = "€";
		tab[15][27] = "€";
		tab[15][28] = "€";
		tab[15][29] = "€";
		tab[15][30] = "€";
		tab[15][31] = "€";
		tab[15][32] = "coma,id,sigid";
		//transicion sigif
		tab[15][23] = "€";
		tab[15][24] = "€";
		tab[15][25] = "€";
		tab[15][26] = "€";
		tab[15][27] = "€";
		tab[15][28] = "€";
		tab[15][29] = "€";
		tab[15][30] = "else,sents";
		tab[15][31] = "€";
		tab[15][32] = "€";
		edo = "EL";
		pila.add("$");
		pila.add("EL");
	}

	public void Transicion()
	{
		comp = obd.Cadena("Componente");
		tran=pila.peek();
		for (col = 0; col < tab[0].length; col++)
			if (comp.equals(tab[0][col]))
				y = col;

		for (ren = 0; ren < tab.length; ren++)
			if (tran.equals(tab[ren][0]))
				x = ren;
		ord = tab[x][y];
	}

	private void paraPila()
	{
		coma = ord.length();
		for (int ind = 0; ind < a.length; ind++)
		{
			if (coma != -1)
			{
				edo = ord.substring(coma - 1, ord.lastIndexOf(","));
				coma = ord.indexOf(",");
				a[ind] = edo;
			}
		}
	}
	
	public void apilar()
	{
		pila.pop();
		for (int ind = a.length; ind!=-1 ; ind--)
		{
			pila.push(a[ind]);
		}
	}
}
