public class Ex1
{
	public static void main(String args[])
	{
		

		if(args.length == 0){
			System.out.println("Número de argumentos insuficiente.");
		}


		else if (args.length == 1)
		{

			try
			{
				double raio = Double.parseDouble(args[0]);
				double area = Ex1.calcula(raio);
				System.out.println("A area do circulo e: "+ String.format("%.2f",area) +" unidades de area.");

			}
			catch(NumberFormatException e)
			{
				System.out.println("O raio deve ser um numero real.");
			}
			
		}
		else if (args.length == 2) {

			try
			{
				double base = Double.parseDouble(args[0]);
				double altura = Double.parseDouble(args[1]);
				double area = Ex1.calcula(base, altura);
				System.out.println("A area do retangulo e: "+ String.format("%.2f",area) +" unidades de area.");
			

			}
			catch(NumberFormatException e)
			{
				
				System.out.println("Os lados do retangulo devem ser números reais.");
				
			}
			
		}
		else if (args.length == 3) {
			try
			{

				double lado1 = Double.parseDouble(args[0]);
				double lado2 = Double.parseDouble(args[1]);
				double lado3 = Double.parseDouble(args[2]);
				double area = calcula(lado1, lado2, lado3);
				System.out.println(Ex1.classifica_triangulo(lado1, lado2, lado3));


			}
			catch(NumberFormatException e)
			{

				System.out.println("Os lados do triangulo devem ser números reais.");

			}
			
		}
		else{

			System.out.println("Número de argumentos excessivo.");

		}


	}

	public static String classifica_triangulo(double l1, double l2, double l3)
	{
		if(! (l1 < (l2+l3) &&  l2 < (l1+l3) && l3 < (l1+l2) )){

			return "Nao e triangulo."; 
		}
		else
		{

			double area = Ex1.calcula(l1, l2, l3);

			if(l1 == l2 && l2 == l3)
			{
				return "A area do triangulo e: "+ String.format("%.2f",area) +" unidades de area.\nO triangulo e equilatero.";
			}
			else if(l1==l2 || l1==l3 || l2==l3)
			{
				return "A area do triangulo e: "+ String.format("%.2f",area) +" unidades de area.\nO triangulo e isosceles.";
			}
			else
			{
				return "A area do triangulo e: "+ String.format("%.2f",area) +" unidades de area.\nO triangulo e escaleno.";
			}
		}

	}

	public static double calcula(double r)
	{
		double area = Math.PI*r*r;
		return (double)area;
	}


	public static double calcula(double b, double a)
	{
		double area = (double)(b*a);
		return area;
	}


	public static double calcula(double l1, double l2, double l3)
	{
		double p = (l1+l2+l3)/2;
		double area = Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
		return area;
	}
}
