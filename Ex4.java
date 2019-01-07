/**

Esse programa calcula o valor do salario dos funcionarios de uma empresa apos aplicacao do desconto de Imposto de Renda.
No caso de funcionarios com dependentes, o salario-base eh a soma do salario com o salario familia.


Exemplos de entradas e saida:

> Digite o numero de funcionarios: 2
Nome do Empregado: Lucas Abreu
Codigo: 122
Salario: 1200
Numero de Dependentes: 2

Nome do Empregado: Ana lima
Codigo: 444
Salario: 1400
Numero de Dependentes: 3

Nome: Lucas Abreu
Codigo: 122
Salario-Base: 1219,16
Salario-Liquido: 1036,29

Nome: Ana lima
Codigo: 444
Salario-Base: 1428,74
Salario-Liquido: 1214,43


**/



import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ex4
{
	int qtd_objetos;

	public Ex4(int qtd_objetos)
	{
		this.qtd_objetos=qtd_objetos;
	}

	public void calculaSalarios()
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		FuncionarioContratado[] arrray_func = new FuncionarioContratado[this.qtd_objetos];
		String linha=null;
		for(int i=0; i<qtd_objetos; i++)
		{

			try
			{

				String nome;
				String codigo;
				float salario;
				int numeroDependentes;

				System.out.print("Nome do Empregado: ");
				nome = reader.readLine();
				System.out.print("Codigo: ");
				codigo = reader.readLine();
				System.out.print("Salario: ");
				salario = Float.parseFloat(reader.readLine());
				System.out.print("Numero de Dependentes: ");
				numeroDependentes = Integer.parseInt(reader.readLine());
			
				arrray_func[i] = new FuncionarioContratado(nome, codigo, salario, numeroDependentes);
				System.out.println("");

			}
			catch(NumberFormatException ex)
			{
				System.out.println("Erro ao realizar conversao");
				return;
			}
			catch(IOException ex)
			{

			}

				
		}

		for(FuncionarioContratado fc : arrray_func)
		{
			if(fc.numeroDependentes == 0)
			{
				fc.calculaSalario();
				System.out.println(fc);
			}
			else
			{
				fc.calculaSalario(fc.numeroDependentes);
				System.out.println(fc);
			}

		}
	}


	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String linha = null;

		try
		{
			System.out.print("--- Cadastro de Funcionarios --- \nDigite o numero de funcionarios: ");			
			linha = reader.readLine();
			int qtd_objetos = Integer.parseInt(linha);
			Ex4 ex = new Ex4(qtd_objetos);
			ex.calculaSalarios();

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


class Funcionario
{
	String nome;
	String codigo;
	float salarioBase;
	float salarioLiquido;


	public Funcionario(String nome, String codigo, float valor)
	{
		this.nome = nome;
		this.codigo = codigo;
		this.salarioBase = valor;
		this.salarioLiquido = valor;
	}

	public double calculaSalario(double desconto)
	{
		this.salarioLiquido = (float)(this.salarioBase*(1-desconto));
		return salarioLiquido;
	}

	public String toString()
	{
		return "Nome: " + this.nome + "\n" + 
			   "Codigo: " + this.codigo + "\n" +
			   "Salario-Base: " + this.salarioBase + "\n"; 

	}

}


class Pai
{
	static String lala;
}

class FuncionarioContratado extends Funcionario
{
	int numeroDependentes;
	float salarioFamilia;
	final float valorPorDep = 9.58f;
	final float aliquotaIR = 0.15f;


	public FuncionarioContratado(String nome, String codigo, float salario, int numeroDependentes)
	{
		super(nome, codigo, salario);
		this.numeroDependentes = numeroDependentes;
	}


	public void calculaSalario()
	{
		super.calculaSalario(this.aliquotaIR);
	}

	public void calculaSalario(int numeroDependentes)
	{
		this.salarioBase = this.salarioBase + this.numeroDependentes*this.valorPorDep;
		this.calculaSalario();
		
	}

	public String toString()
	{
		return "Nome: " + this.nome + "\n" + 
			   "Codigo: " + this.codigo + "\n" +
			   "Salario-Base: " + String.format("%.2f" ,this.salarioBase) + "\n" + 
			   "Salario-Liquido: " + String.format("%.2f" ,this.salarioLiquido) + "\n"; 
	}

}