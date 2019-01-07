/**

Esse programa realiza o calculo do IMC de uma lista de pessoas e analisa uma escala, para determinar se a pessoa
esta acima, na media ou abaixo do peso.

Alem disso, diversas opcoes de ordenacoes estao disponiveis para ordenar esse conjunto de pessoas:
	Por nome(A-Z), nome(Z-A), menor peso, maior peso e menor altura.

**/


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;



public class Ex5
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		MinhaListaOrdenavel lista = new MinhaListaOrdenavel();

		lista.add(new Mulher("Maria Joaquina", "01/01/1995", 60.0, 1.69));
		lista.add(new Mulher("Juliana Santos", "10/12/1975", 85.2, 1.80));
		lista.add(new Mulher("Aline Ferreira", "03/12/2001", 87.95, 1.73));
		lista.add(new Mulher("Carolina Paiva", "05/12/1993", 74.0, 1.81));
		lista.add(new Mulher("Monica Alves", "03/11/1994", 74.0, 1.81));

		lista.add(new Homem("Joao Prado", "01/01/1996", 81.0, 1.80));
		lista.add(new Homem("Gabriel Freitas", "10/05/1991", 73.6, 1.75));
		lista.add(new Homem("Bernando Silva", "13/05/1969", 85.3, 1.89));
		lista.add(new Homem("Tadeu Viana", "10/09/2004", 69.5, 1.65));
		lista.add(new Homem("Paulo Vieira", "20/03/1969", 70, 1.71));


		while(true)
		{
			BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
			System.out.print("\n\n\t1.Imprimir Lista\n\t2.Sair\nDigite sua opcao: ");

			try
			{

				String conteudo = in.readLine();
				int opcao = Integer.parseInt(conteudo);
				
				if (opcao==1)
				{

					System.out.print("\t\tEscolha seu modo de ordenacao\n"+
									   "\t1.Alfabetica (A-Z)\n"+
									   "\t2.Alfabetica (Z-A)\n"+
									   "\t3.Menor Peso\n"+
									   "\t4.Maior Peso\n"+
									   "\t5.Menor Altura\n"+
									   "Digite sua opcao: ");

					conteudo = in.readLine();
					int criterio = Integer.parseInt(conteudo);

					ArrayList<PessoaIMC>  arrayOrdenado= lista.ordena(criterio);
					
					System.out.println("\n");
					for(PessoaIMC pessoa : arrayOrdenado)
					{
						System.out.println(pessoa+"\n\n");
					}

				}
				else if(opcao==2)
				{
					break;
				}

			}
			catch(IOException ex){}
			catch(NumberFormatException ex){ System.out.println("Numero de pessoas deve ser um inteiro. "); }

		}
	}
}



class MinhaListaOrdenavel
{

	ArrayList<PessoaIMC> arrayPessoas;

	public static final int NOME=1;
	public static final int NOME_REVERSO=2;
	public static final int PESO=3;
	public static final int PESO_REVERSO=4;
	public static final int ALTURA=5;



	Comparator nomeComparator;
	Comparator pesoComparator;
	Comparator alturaComparator;


	public MinhaListaOrdenavel()
	{
		arrayPessoas = new ArrayList<PessoaIMC>();


		nomeComparator = new Comparator(){

		public int compare(Object p1, Object p2)
		{
			PessoaIMC pessoa1 = (PessoaIMC)p1;
			PessoaIMC pessoa2 = (PessoaIMC)p2;
			return pessoa1.nome.compareTo(pessoa2.nome);	
		}
		};


		pesoComparator = new Comparator(){

		public int compare(Object p1, Object p2)
		{
			PessoaIMC pessoa1 = (PessoaIMC)p1;
			PessoaIMC pessoa2 = (PessoaIMC)p2;

			Double peso1 = new Double(pessoa1.getPeso());
			Double peso2 = new Double(pessoa2.getPeso());
			return peso1.compareTo(peso2);

		}
		};


		alturaComparator = new Comparator(){

		public int compare(Object p1, Object p2)
		{
			PessoaIMC pessoa1 = (PessoaIMC)p1;
			PessoaIMC pessoa2 = (PessoaIMC)p2;

			Double altura1 = new Double(pessoa1.getAltura());
			Double altura2 = new Double(pessoa2.getAltura());
			return altura1.compareTo(altura2);

		}
		};

	}


	@SuppressWarnings("unchecked")
	public ArrayList<PessoaIMC> ordena(int criterio)
	{

		switch (criterio) 
		{

		case NOME:
			Collections.sort(this.arrayPessoas, nomeComparator);
			break;

		case NOME_REVERSO:
			Collections.sort(this.arrayPessoas, nomeComparator.reversed());
			break;

		case PESO:
			Collections.sort(this.arrayPessoas, pesoComparator);
			break;

		case PESO_REVERSO:
			Collections.sort(this.arrayPessoas, pesoComparator.reversed());
			break;

		case ALTURA:
			Collections.sort(this.arrayPessoas, alturaComparator);
			break;
					
		}

		return this.arrayPessoas;

	}


	public void add(PessoaIMC p)
	{
		this.arrayPessoas.add(p);
	}


}

class Pessoa
{
	protected String nome;
	protected String dataNascimento;


	public Pessoa(String nome, String dataNascimento)
	{
		this.nome=nome;
		this.dataNascimento=dataNascimento;
	}

	public String toString()
	{
		return "Nome: "+this.nome+"\nData de nascimento: "+this.dataNascimento;
	}

}


abstract class PessoaIMC extends Pessoa
{
	protected double peso;
	protected double altura;

	public PessoaIMC(String nome, String dataNascimento, double peso, double altura)
	{
		super(nome, dataNascimento);
		this.peso=peso;
		this.altura=altura;
	}

	public double getPeso()
	{
		return this.peso;
	}

	public double getAltura()
	{
		return this.altura;
	}

	public double calculaIMC(double altura, double peso)
	{
		return peso/(altura*altura);
	}

	abstract String resultIMC();


	public String toString()
	{
		return super.toString() +"\nPeso: " + String.format("%.2f", this.peso) + "\nAltura: " + String.format("%.2f", this.altura);
	}
}


class Homem extends PessoaIMC
{

	public Homem(String nome, String dataNascimento, double peso, double altura)
	{
		super(nome, dataNascimento, peso, altura);
	}


	public String resultIMC()
	{
	
		double imc = calculaIMC(this.altura, this.peso);
		String situacao="IMC: " + String.format("%.2f", imc);
		
		if(imc < 20.7)
		{
			situacao=situacao + " Abaixo do peso ideal";
		}
		else if(imc >= 20.7 && imc <= 26.4)
		{
			situacao=situacao + " Peso ideal";
		}
		else
		{
			situacao=situacao + " Acima do peso ideal";
		}

		return situacao;
	}

	public String toString()
	{
		return super.toString() + "\n" + resultIMC();
	}
}




class Mulher extends PessoaIMC
{

	public Mulher(String nome, String dataNascimento, double peso, double altura)
	{
		super(nome, dataNascimento, peso, altura);
	}


	public String resultIMC()
	{
	
		double imc = calculaIMC(this.altura, this.peso);
		String situacao="IMC: " + String.format("%.2f", imc);

		if(imc < 19)
		{
			situacao=situacao + " Abaixo do peso ideal";
		}
		else if(imc >= 19 && imc <= 25.8)
		{
			situacao=situacao + " Peso ideal";
		}
		else
		{
			situacao=situacao + " Acima do peso ideal";
		}

		return situacao;
	}

	public String toString()
	{
		return super.toString() + "\n" + resultIMC();
	}
}
