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
		a.insere(-12);
		a.insere(13);
		
		no = a.getRaiz(); // nó pega a raiz da árvore
		// letra a, ( c ) d, e, g, h, i, j, k  ja  foram
		
		// letra b imcompleta, , f nao 
		
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

		System.out.println("Maior elemento sub-árvore Esq: "
				+ fe.MaiorElemento(a.getRaiz().getfilhoEsquerda())) ;
		System.out.println("Maior elemento sub-árvore Dir: "
				+ fe.MaiorElemento(a.getRaiz().getfilhoDireita())) ;
		// corrigido
		System.out.println("Nivel: "
				+ a.nivel(a.getRaiz().getfilhoDireita().getfilhoDireita()  )) ;	
		System.out.println("\n-----------------------");
		System.out.println("\n-----------------------");
		
		System.out
				.println("Pesquisa: " + fe.consultar2(a.getRaiz(), 4, false));
		System.out.println("-----------------------");
		System.out.println("N° Nós Arv> "+fe.numeroNosArvore(no));
		System.out.println("\n-----------------------");
		
/*		System.out.println("N° Nós Sub-Arv Dir> "+fe.numeroNosArvore(no.getfilhoDireita()));
		System.out.println("N° Nós Sub-Arv Esq> "+fe.numeroNosArvore(no.getfilhoEsquerda()));
*/
		System.out.println("\n-----------------------");
		System.out.println("Altura do No > "+fe.altura(no) );
	}

}
