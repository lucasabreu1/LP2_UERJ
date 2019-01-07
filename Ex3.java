/**

Esse programa calcula o seno, cosseno, tangente e cotangente. Pergunta ao usuario quantos angulos ele quer digitar,
em seguida armazena instancias de classe AnguloObj em um array, preenchido pelo usuário por meio do
teclado.
tratando as excessoes necessarias


Exemplos de entradas e saida:


> Digite a medida em graus do 1Âº angulo:
30
> Digite a medida em graus do 2Âº angulo:
45

Resultado =====================
Arco: 0,52
Seno: 0,50
Cosseno: 0,87
Tangente: 0,58
Cotangente: 1,73

Arco: 0,79
Seno: 0,71
Cosseno: 0,71
Tangente: 1,00
Cotangente: 1,00


**/


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ex3
{
	public static void main(String[] args) {
		
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 String linha=null;

		 try
		 {
		 	System.out.println("Digite o numero de angulos:");
		 	linha = reader.readLine();

		 	int qtd_angulos = Integer.parseInt(linha);
		 	AnguloObj[] angulos =  new AnguloObj[qtd_angulos];
		 	System.out.println("\n");

		 	for(int i=0; i < angulos.length; i++)
		 	{
		 		String linha_grau=null;
		 		try
		 		{
		 			System.out.println("Digite a medida em graus do "+ (i+1) + "º angulo:");
		 			linha_grau = reader.readLine();
		 			double grau = Double.parseDouble(linha_grau);
		 			angulos[i] = new AnguloObj(grau);

		 		}
		 		catch(NumberFormatException ex)
		 		{
		 			System.out.println("\n"+linha_grau+" nao pode ser convertido em double.");
		 			return;
		 		}

		 	}

			System.out.println("\nResultado =====================");
	 		for(AnguloObj angulo: angulos)
 			{
 				System.out.println(angulo);
 			} 

		 }
		 catch(NumberFormatException ex)
		 {
		 	System.out.println("\n"+linha+" nao pode ser convertido em inteiro.");
		 	return;
		 		
		 }
		 catch(IOException ex)
		 {
		 	System.out.println("Ocorreu um erro de I/O durante a leitura");
		 }

	}


}


class AnguloObj
{
	private double arcoRad;

	public AnguloObj(double graus)
	{
		this.arcoRad = Math.toRadians(graus);
	
	}

	public double funcaoSeno()
	{
		return Math.sin(arcoRad);
	}

	public double funcaoCosseno()
	{
		return Math.cos(arcoRad);
	}


	public double funcaoTangente()
	{
		return Math.tan(arcoRad);
	}

	public double funcaoCotangente()
	{
		return 1.0/(funcaoTangente());
	}

	public String toString()
	{

		return "Arco: " + String.format("%.2f", arcoRad) + "\n" +
			   "Seno: " + String.format("%.2f", funcaoSeno()) + "\n" +		
			   "Cosseno: " + String.format("%.2f", funcaoCosseno()) + "\n" +
			   "Tangente: " + String.format("%.2f", funcaoTangente()) + "\n" +
			   "Cotangente: " + String.format("%.2f", funcaoCotangente()) + "\n";
	}

}