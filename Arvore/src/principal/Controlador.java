package principal;

import java.io.IOException;

import javax.naming.directory.InvalidAttributesException;

public class Controlador {

	public static void main(String[] args) throws InterruptedException,
			IOException, InvalidAttributesException {
		No a = null;
		int cont, maior, menor;
		FuncoesExtras funcExtra = new FuncoesExtras();

		a = ArvoreAVL.inserir(a, 1);
		// a = ArvoreAVL.inserir(a, 2);
		// a = ArvoreAVL.inserir(a, 3);
		a = ArvoreAVL.inserir(a, 4);
		a = ArvoreAVL.inserir(a, 5);
		a = ArvoreAVL.inserir(a, 6);
		a = ArvoreAVL.inserir(a, 7);
		a = ArvoreAVL.inserir(a, 8);
		a = ArvoreAVL.inserir(a, 9);
		a = ArvoreAVL.inserir(a, 10);
		a = ArvoreAVL.inserir(a, -3);
		
		System.out.print("EM : ");
		ExibirArvore.exibirOrdemSimetrica(a);
		System.out.println();
		System.out.print("PRE : ");
		ExibirArvore.exibirpreOrdem(a);
		System.out.println();
		System.out.print("POS : ");
		ExibirArvore.exibirpposOrdem(a);
		System.out.println();
		System.out.print("NIVEL : ");
		ExibirArvore.exibirNossaOrdem(a);
		System.out.println();
		// -----------------------------------------------------------------------
		System.out.println("-----------------------------------");
		cont = FuncoesExtras.numeroNosArvore(a);
		System.out.println("Número de nós na Árvore AVL: ");
		System.out.println(cont);
		System.out.println();
		// -----------------------------------------------------------------------
		System.out.println("+++++++++++++++++++++++++++++++++++");

		maior = funcExtra.MaiorElemento(a);
		menor = funcExtra.MenorElemento(a);

		System.out.println("Maior valor da Árvore AVL: ");
		System.out.println(maior);
		System.out.println();
		System.out.println("Menor valor da Árvore AVL: ");
		System.out.println(menor);
		System.out.println();
		System.out.println("No seguinte da Árvore AVL: ");
		// ArvoreAVL.seguinte(a);

		System.out.println();
		// nivel de um nó da arvore
		System.out.println("Nível de um Nó da Árvore AVL: ");
		System.out.println(ArvoreAVL.nivel(a, 1));
		System.out.println();
	}

}
