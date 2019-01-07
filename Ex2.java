/**

Esse programa calcula o seno, cosseno, tangente e cotangente utilizando metodos estaticos e 
tratando as excessoes necessarias

**/




import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ex2
{
	public static void main(String[] args){
		

		if(args.length==1)
		{
			
			try
			{
				double grau = Angulo.converteAngulo(Double.parseDouble(args[0]));
				System.out.println("Seno: " + String.format("%.2f", Angulo.funcaoSeno(grau)) + 
					               "\nCosseno: " + String.format("%.2f", Angulo.funcaoCosseno(grau)) + 
								   "\nTangente: " + String.format("%.2f", Angulo.funcaoTangente(grau)) + 
								   "\nCotangente: " + String.format("%.2f", Angulo.funcaoCotangente(grau)) +"\n");

			}
			catch(NumberFormatException ex)
			{
				System.out.println("\n"+args[0]+" nao pode ser convertido em double.");
			}

		}



		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String linha;
		System.out.println("Digite uma medida em graus do angulo:");


		try
		{
			while( (linha=reader.readLine()) !=null  && linha.length()!=0)
			{

				
				try
				{
					double grau = Angulo.converteAngulo(Double.parseDouble(linha));
					System.out.println("Seno: " + String.format("%.2f", Angulo.funcaoSeno(grau)) + 
						               "\nCosseno: " + String.format("%.2f", Angulo.funcaoCosseno(grau)) + 
									   "\nTangente: " + String.format("%.2f", Angulo.funcaoTangente(grau)) + 
									   "\nCotangente: " + String.format("%.2f", Angulo.funcaoCotangente(grau)) + "\n");				


				}
				catch(NumberFormatException ex)
				{
					System.out.println("\n"+linha+" nao pode ser convertido em double.");
				}

				System.out.println("Digite uma medida em graus do angulo:");	
			}
		}
		catch(IOException ex)
		{
			System.out.println("Ocorreu um erro de I/O durante a leitura");
		}


	}
}


class Angulo
{
	public static double converteAngulo(double graus)
	{
		double radianos = Math.toRadians(graus);
		return radianos;
	}

	public static double funcaoSeno(double radianos)
	{
		double seno = Math.sin(radianos);
		return seno;
	}

	public static double funcaoCosseno(double radianos)
	{
		double cosseno = Math.cos(radianos);
		return cosseno;
	}


	public static double funcaoTangente(double radianos)
	{
		double tangente = Math.tan(radianos);
		return tangente;
	}

	public static double funcaoCotangente(double radianos)
	{
		double cotangente = 1.0/(Angulo.funcaoTangente(radianos));
		return cotangente;
	}

}