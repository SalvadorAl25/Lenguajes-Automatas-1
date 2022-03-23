package Odiceo;
import EDI.Datos;
import java.util.regex.*;

public class Union
{
	private Datos obd = new Datos();
	private String cad;
	private char ca[];
	private boolean ban = true;
	private int ind, con;

	public void ValidacionCadena()
	{
		do
			cad = obd.Cadena("Exprecion Regular a validar");
		while (cad.isEmpty());
		
		if (cad.equals("+") || cad.equals("*"))
		{
			System.out.println("Cadena Incorrecta, No es valido un exponente sin un operando\n");
			this.ValidacionCadena();
		}
		else
		{
			ca = cad.toCharArray();
			this.ValidacionAlfabeto();
			this.ValidacionCaracteres();
			this.Resultado();
		}
	}

	private void ValidacionAlfabeto()
	{
		do
		{
			Pattern p = Pattern.compile("[^a-z)(*+U @]+");
			Matcher m = p.matcher(cad);
			StringBuffer sb = new StringBuffer();
			boolean resultado = m.find();
			boolean caracteresIlegales = false;

			while (resultado)
			{
				caracteresIlegales = true;
				m.appendReplacement(sb, "");
				resultado = m.find();
			}

			if (caracteresIlegales)
			{
				System.out.println(
						"La Expresion no contine Caracteres del alfabeto o estan en Mayusculas... Tienen que ser en minusculas Excepto la 'U' \n");
				ban = false;
				break;
			}

			p = Pattern.compile("uu");
			m = p.matcher(cad);
			if (m.find())
			{
				System.out.println("No puede haber uu\n");
				ban = false;
				break;
			}
			if (!ban)
				this.ValidacionCadena();
		}
		while (!ban);
	}

	private void ValidacionCaracteres()
	{
		if (ban)
		{
			con = 0;
			for (ind = 0; ind < ca.length; ind++)
			{
				if (ca[ind] == '(')
					con++;
				if (ca[ind] == ')')
					con--;
				do
					switch (ca[ind]) {
						case '(':
							if (ca[ind + 1] == '*' || ca[ind + 1] == '+' || ca[ind + 1] == 'u' || ca[ind + 1] == ')')
							{
								System.out.println(
										"Despues del ' ( ' no puede haber un simbolo, otro ' ) ' junto o caracter diferente al del alfabeto o al operando...\n");
								ban = false;
								this.ValidacionCadena();
							}
							break;
						case ')':
							if (ca[ind - 1] == 'u')
							{
								System.out.println(
										"antes del ) no puede haber caracter diferente al del alfabeto, a los exponentes o al operando...\n");
								ban = false;
								this.ValidacionCadena();
							}
							break;
						case 'u':
							if (ca[ind + 1] == '+' || ca[ind + 1] == '*')
							{
								System.out.println("no puede haber exponentes en un operador\n");
								ban = false;
								this.ValidacionCadena();
							}
							break;
						case '*':
							if (ca[ind] <= cad.length())
							{
								if (ca[ind + 1] == '*' || ca[ind + 1] == '+')
								{
									System.out.println("los caracteres exactamente **, o *+ son incorrectos\n");
									ban = false;
									this.ValidacionCadena();
								}
							}
							else if (ca[ind - 1] == '*' || ca[ind - 1] == '+')
							{
								System.out.println("los caracteres exactamente **, o *+ son incorrectos\n");
								ban = false;
								this.ValidacionCadena();
							}
							break;
						case '+':
							if (ca[ind] <= cad.length())
							{
								if (ca[ind + 1] == '+' || ca[ind + 1] == '*')
								{
									System.out.println("los caracteres exactamente ++, o +* son incorrectos\n");
									ban = false;
									this.ValidacionCadena();
								}
							}
							else if (ca[ind - 1] == '+' || ca[ind - 1] == '*')
							{
								System.out.println("los caracteres exactamente **, o *+ son incorrectos\n");
								ban = false;
								this.ValidacionCadena();
							}
							break;
					}
				while (!ban);
			}
		}
	}

	public void Resultado()
	{
		if (con == 0)
			System.out.println("----Cadena Correcta----");
		else
			System.out.println("\n--Hace Falta cerrar un parentesis--\n");
		this.ValidacionCadena();
	}
}