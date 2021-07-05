package principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entites.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		boolean continuar=true;
		Scanner teclado = new Scanner(System.in);
		List<Post> postagem = new ArrayList<>();
		DateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
		while(continuar){
			Menu();
			int opcao = teclado.nextInt();
			teclado.nextLine();
			switch(opcao) {
			case 1://add post
				System.out.println("\n____________________________________");
				System.out.print("Data:");
				String data1= teclado.nextLine();
				Date data = formato.parse(data1);
				
				System.out.print("Titulo:");
				String titulo = teclado.nextLine();
				System.out.print("Legenda:");
				String legenda = teclado.nextLine();
				postagem.add(new Post(data,titulo,legenda));
				break;
			case 2://remove post
				System.out.println("\n________________________________");
				System.out.print("Remover por Titulo ou Posição? ");
				String removePost = teclado.nextLine().toUpperCase();
				switch(removePost) {
				case "TITULO":
					System.out.print("Qual Titulo:");
					String excluirTitulo = teclado.nextLine();
					postagem.removeIf(x-> excluirTitulo.equals(x.getTitulo()));
					break;
				case "POSIÇÃO":
					System.out.println("Qual Posição:");
					int excluirPosicao = teclado.nextInt();
					if(excluirPosicao>0 && excluirPosicao<postagem.size()) {
						postagem.remove(excluirPosicao);
					}
					break;
				default: System.out.println("\nOpção invalida\n");
				}
				break;
			case 3://add comentario
				
				break;
			case 4://remove comentario
				break;
			case 5://imprimir
				for(Post x : postagem) {
					System.out.println(x);
				}
				break;
			case 6://exit
				continuar=false;
				break;
			default: System.out.println("\nOpção invalida\n");
			}
			
		}
	}
	public static void Menu() {
		System.out.print("\n1)Criar Post"
				+ "\n2)Excluir Post"
				+ "\n3)Adicionar comentario em Post"
				+ "\n4)Remover comentario de Post"
				+ "\n5)Imprimir"
				+ "\n6)Sair"
				+ "\nOpção:");
		
	}

}
