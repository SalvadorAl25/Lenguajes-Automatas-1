package Odiceo;

import EDI.Datos;

public class Estados
{
	private Datos obd = new Datos();
	private String e, ef, est[][], cad, q = "q0";
	char aux;
	int ren, col, en, edo, f;

	public void Comienzo()
	{
		do
			e = obd.Cadena("Alfabeto");
		while (e.matches("[a-z]"));
		en = obd.Entero("Numero De Estados");
		do
			f = obd.Entero("Estado Final");
		while (f > en);
		ef = "q" + f;
		MatrizEstados();
	}

	private void MatrizEstados()
	{
		int c = e.length() + 1, r = en + 1;
		est = new String[r][c];
		est[0][0] = " ";
		for (col = 1; col < e.length() + 1; col++)
		{
			est[0][col] = e.substring(col - 1, col);
		}

		for (ren = 1; ren < en + 1; ren++)
		{
			est[ren][0] = "q" + (ren - 1);
		}

		for (ren = 1; ren < est.length; ren++)
		{
			for (col = 1; col < est[ren].length; col++)
			{
				do
					edo = obd.Entero("Posicion: [" + ren + "][" + col + "]" + "Núm. Estado:");
				while (edo > e.length() - 1);
				est[ren][col] = "q" + edo;
			}
		}
	}

	public void Matriz()
	{
		System.out.println();
		for (ren = 0; ren < est.length; ren++)
		{
			for (col = 0; col < est[ren].length; col++)
				System.out.print(est[ren][col] + "\t");
			System.out.println();
		}
	}

	public void val()
	{
		String v;
		int x = 0, y = 0, i;
		System.out.println();
		do
			cad = obd.Cadena("Cadena: ").toLowerCase();
		while (!cad.matches("[a-z]*"));

		for (i = 0; i < cad.length(); i++)
		{
			v = cad.substring(i, i + 1);
			for (ren = 0; ren < est.length; ren++) // estado
				if (q.equals(est[ren][0]))
					x = ren;
			for (col = 0; col < est[0].length; col++) // letra alfabeto
				if (v.equalsIgnoreCase(est[0][col]))
					y = col;
			q = est[x][y];
		}
		if (this.EstadoFinal())
		{
			System.out.println("-------------------------------------------------------");
			System.out.println("------------------¡Cadena Correcta!--------------------");
			System.out.println("-------------------------------------------------------");
		}
		else
		{
			System.out.println("-------------------------------------------------------");
			System.out.println("------------------¡Cadena Incorrecta!------------------");
			System.out.println("-------------------------------------------------------");
		}
	}

	private boolean EstadoFinal()
	{
		if (ef.indexOf(q) >= 0)
			return true;
		return false;
	}
}
