package ufc.eda.arvoreavl;

import java.io.IOException;

import javax.naming.directory.InvalidAttributesException;

public class Controlador {

	public static void main(String[] args) throws InterruptedException,
			IOException, InvalidAttributesException {
		Arvore a = new Arvore();
		FuncoesExtras fe = new FuncoesExtras();
		No no = new No();

		a.insere(1);
		a.insere(2);
		a.insere(3);
		a.insere(4);
		a.insere(-5);
		no = a.getRaiz(); // nó pega a raiz da árvore

		System.out.print("EM : ");
		a.emOrdem(a.getRaiz());
		System.out.println();
		System.out.print("PRE : ");
		a.preOrdem(a.getRaiz());
		System.out.println();
		System.out.print("POS : ");
		a.posOrdem(a.getRaiz());
		System.out.println();
		System.out.print("NIVEL : ");
		a.porNivel(a.getRaiz());

		System.out.println();
		System.out.println("Maior elemento: " + fe.MaiorElemento(a.getRaiz()));
		System.out.println("Menor elemento: " + fe.MenorElemento(a.getRaiz()));

		No r = a.raiz1;
		System.out.println("Maior elemento sub-árvore: "
				+ fe.MaiorElementoSubArvore(a.getRaiz(), 4, false));
		System.out
				.println("Pesquisa: " + fe.consultar2(a.getRaiz(), 4, false));

	}

}
