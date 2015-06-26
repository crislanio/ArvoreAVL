package ufc.eda.arvorerubronegra;

import java.util.Scanner;

public class Programa2 {

	public static void main(String[] agrs) {

		Arvore tree = new Arvore();

		int num = 0, op = 0;


		Scanner scanner = new Scanner(System.in);

		do {

			System.out.println("1 -> Inserir.");

			System.out.println("0 -> Sair.");

			op = scanner.nextInt();

			if (op == 1) {

				System.out.print("Digite a quantidade de Nodos:");

				num = scanner.nextInt();

				int nodo;

				for (int i = 0; i < num; i++) {

					System.out.print("Nodo: ");

					nodo = scanner.nextInt();

					tree.insere(tree.Raiz, nodo);

					System.out.println();

				}

				tree.Imprimir(tree.Raiz);

			}

		} while (op != 0);

	}

}
