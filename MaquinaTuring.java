package Odiceo;

import EDI.Datos;

public class MaquinaTuring
{
	private String cad, cadf, mat[][] = new String[4][8], inst = "", q = "0", estins = "";
	private char pila[], caf[];
	private int ren, col, ind, ind2 = -1, in = -1, tam, c, x, y;
	private Datos obd = new Datos();

	public void Cadena()
	{
		do
			cad = obd.Cadena("Ingrese cadena con caracteres (abc): ").toLowerCase();
		while (!cad.matches("[abc]*"));
		cadf = 'z' + cad + '$';
		tam = cadf.length();
		pila = new char[tam];
		this.Matriz_de_Estados();
		this.Izquierda();
	}

	private void Matriz_de_Estados()
	{
		mat[0][0] = mat[1][1] = mat[1][5] = mat[1][6] = mat[1][7] = mat[2][1] = mat[2][2] = mat[2][3] = mat[2][4] = mat[3][2] = mat[3][3] = mat[3][4] = mat[3][5] = "--"; // Espacios
		// Casos Posibles
		mat[0][1] = "z$";
		mat[0][2] = "za";
		mat[0][3] = "aa";
		mat[0][4] = "ab";
		mat[0][5] = "bb";
		mat[0][6] = "bc";
		mat[0][7] = "ac";
		// Estado Final
		mat[3][1] = "30";
		// Estados
		mat[1][0] = "0";
		mat[2][0] = "1";
		mat[3][0] = "2";
		// Instrucciones
		mat[1][2] = "01";
		mat[1][3] = "01";
		mat[2][5] = "11";
		mat[1][4] = "11";
		mat[2][6] = "22";
		mat[2][7] = "22";
		mat[3][6] = "22";
		mat[3][7] = "22";

		/*
		 * for (ren = 0; ren < mat.length; ren++) { for (col = 0; col <
		 * mat[ren].length; col++) System.out.print(mat[ren][col] + "\t");
		 * System.out.println(); }
		 */
	}

	private void Izquierda()
	{
		int a = 0, b = 0, ct = 0;
		caf = cadf.toCharArray();
		if (cadf.indexOf("ac") != -1)
		{
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println("------------------¡Cadena Invalida!--------------------");
			System.out.println("-------------------------------------------------------");
			System.out.println();
			this.Cadena();
		}
		for (ind = 0; ind < caf.length; ind++)
		{
			if (caf[ind] == 'c')
				ct++;
			if (caf[ind] == 'a')
				a++;
			if (caf[ind] == 'b')
				b++;
		}
		if (a == 0 && b == 0)
		{
			System.out.println();
			System.err.println("La cadena contiene solo c's, por lo tanto es Invalida");
			this.Cadena();
		}
		if (a < 2)
		{
			System.out.println();
			System.err.println("La cadena debe tener igual o mas de 2 'a'.");
			this.Cadena();
		}
		if (b < 2)
		{
			System.out.println();
			System.err.println("La cadena debe tener igual o mas de 2 'b'.");
			this.Cadena();
		}
		for (ind = 0; ind < cadf.length() && !inst.equals("cc"); ind++)
		{
			inst = cadf.substring(ind, ind + 2);
			for (col = 0; col < mat[0].length; col++)
				if (inst.equals(mat[0][col]))
					y = col;

			for (ren = 0; ren < mat.length; ren++)
				if (q.equals(mat[ren][0]))
					x = ren;
			estins = mat[x][y];
			q = mat[x][y].substring(0, 1);
			this.Vali();
		}
		this.Derecha();
		this.Resultado(ct);
	}

	private void Derecha()
	{
		for (; ind2 != -1;)
		{
			ind = ind2 + 1;
			String c = String.valueOf(pila);
			inst = c.substring(ind, ind + 2);
			for (col = 0; col < mat[0].length; col++)
				if (inst.equals(mat[0][col]))
					y = col;
			for (ren = 0; ren < mat.length; ren++)
				if (q.equals(mat[ren][0]))
					x = ren;
			estins = mat[x][y];
			q = mat[x][y].substring(0, 1);
			in++;
			this.Vali();
		}
	}

	private void Vali()
	{
		if (estins.substring(1).equalsIgnoreCase("1"))
			this.Apilar();
		else
			if (estins.substring(1).equalsIgnoreCase("2"))
			{
				++ind2;
				this.Desapilar();
			}
	}

	private void Apilar()
	{
		in++;
		if (in < caf.length)
		{
			if (caf[in] == 'a' || caf[in] == 'b' || caf[in] == 'z' || caf[in] == '$')
				pila[++ind2] = caf[in];
		}
	}

	private char Desapilar()
	{
		char car = 'c';
		in--;
		if (caf[in] == 'a' || caf[in] == 'b' && in != -1)
		{
			pila[ind2--] = car;
			ind2--;
		}
		return car;
	}

	public void Resultado(int ct)
	{
		for (int i = 0; i < pila.length; i++)
			if (pila[i] == 'c')
				c++;
		if (c == (ct / 2))
		{
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println("--------------------¡Cadena Valida!--------------------");
			System.out.println("-------------------------------------------------------");
			System.out.println();
		}
		else
		{
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println("------------------¡Cadena Invalida!--------------------");
			System.out.println("-------------------------------------------------------");
			System.out.println();
		}
		this.Cadena();
	}
}

class MaquinaTuringP
{
	public static void main(String[] args)
	{
		MaquinaTuring obt=new MaquinaTuring();
		obt.Cadena();
	}
}