import java.util.Scanner;

public class diario_de_classe {
	
	static Scanner console = new Scanner (System.in);
	
	static final int TOTAL_AVALIACOES = 4;
	
	static final String [] NOME_AVALIACOES = {"A1l", "A2", "A3","AI"};
	static final double [] NOTA_MAX_AVALIACOES = {30.00,30.00,40.00,30.00};
	
	static double [] notas = new double [TOTAL_AVALIACOES];


	static void atualizarNota (int indiceNota) {
		notas[indiceNota] = lerNota(NOME_AVALIACOES[indiceNota], NOTA_MAX_AVALIACOES[indiceNota]);
	}
	
	static double lerNota(String mensagem, double notaMaxima) {
		double nota = 0.0;
		do {
			System.out.printf("%s = ",mensagem);
			nota = console.nextDouble();
		} while (nota < 0.00 || nota> notaMaxima);
		return nota;
	}
	
		static void mostrarNotas() {
			double notaFinal = 0.0;
			System.out.println("\n\tNOTAS");
			System.out.println();
		
			for (int i = 0; i < (TOTAL_AVALIACOES-1); i++) {
			
				System.out.printf("Avaliação %s= %.2f pts",NOME_AVALIACOES[i], notas[i]);
				System.out.println();
			
				notaFinal += notas[i];	
		}
			System.out.printf("\n Nota Final = %.2f pts", notaFinal);
			System.out.printf("\n   Situção = %s",avaliarSituacao(notaFinal)+"\n");
	
			System.out.println(" A média das notas é: "+calcularMedia(notas,notaFinal));
			System.out.println(maiorNota(notas));	
	}
		
	static double calcularMedia(double[] notas,double notaFinal) {
		double media = notaFinal/(notas.length-1);
		return media ;
	}
	static String maiorNota (double [] notas) {
		
		if (notas[0] > notas[1] && notas[0] > notas[2])
			return " A maior nota foi da avaliação: "+NOME_AVALIACOES[0];
		else if (notas[1] > notas[0] && notas[1] > notas[2])
			return " A maior nota foi da avaliação: "+NOME_AVALIACOES[1];
		else if (notas[2] > notas[0] && notas[2] > notas[1])
			return " A maior nota foi da avaliação: "+NOME_AVALIACOES[2];
		else
			return " Todas as notas informadas são iguais!";
		}
	
		static String avaliarSituacao (double notaFinal) {
			if (notaFinal < 30)
				return "REPROVADO";
			else if (notas[3] != 0 && (notas[3] < notas [0] && notas[3]< notas[1]))
				return "REPROVADO";
			else if (notaFinal < 70) { 
				return "EM RECUPERAÇÃO"+"\n  INFORME NOTA AI";		
			}
			else
				return "APROVADO"; 
		}
		
		static void avaliacaoAI () {
				if (notas[0] <= notas[1] || notas[1] <= notas[0]) 
						atualizarNota(3);
				if(notas[0] < notas[1])
						notas[0] = notas[3];
				else 
					notas[1] = notas[3];
				
		}
	static void mostrarMenu() {
		
		System.out.println("\n\n");
		System.out.println("\t   MENU");
		System.out.println();
		
		System.out.println("[1] Cadastrar Notas da A1");
		System.out.println("[2] Cadastrar Notas da A2");
		System.out.println("[3] Cadastrar Notas da A3");
		System.out.println("[4] Mostrar Notas");
		System.out.println("[5] Cadastrar Notas da AI");
		System.out.println("[0] SAIR");
		
		System.out.print("\nDigite uma opção: ");
		byte opcao = console.nextByte();
	

		switch (opcao) {
		case 0:
			System.exit(0);
			break;
		case 1: 
			atualizarNota(0); //A1
			break;
		case 2: 
			atualizarNota(1); //A2
			break;
		case 3: 
			atualizarNota(2); //A3
			break;
		case 5: 
			avaliacaoAI(); //AI
			break;
		case 4:
			mostrarNotas();
			break;
		 default: 
			 mostrarMenu();
			break;
			
		}
		mostrarMenu();
	}
	
	public static void main(String[] args) {
		
		mostrarMenu();
		
	}

}
