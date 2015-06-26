package ufc.eda.arvorerubronegra;

import java.io.IOException;

import javax.naming.directory.InvalidAttributesException;

public class Programa {

	public static void main(String[] args) throws InterruptedException,
			IOException, InvalidAttributesException {
		Arvore a = new Arvore();
		FuncoesExtras fe = new FuncoesExtras();
		No no = new No(0);

		a.insere(a.Raiz,1);
		a.insere(a.Raiz,2);
		a.insere(a.Raiz,3);
		a.insere(a.Raiz,4);
		a.insere(a.Raiz,-5);
		a.insere(a.Raiz,-12);
		a.insere(a.Raiz,13);
		
		no = a.Raiz; // nó pega a raiz da árvore
		// letra a, ( c ) d, e, g, h, i, j, k  ja  foram
		
		// letra b imcompleta, , f nao 
		
		System.out.print("EM : ");
		a.emOrdem(a.Raiz);
		System.out.println();
		System.out.print("PRE : ");
		a.preOrdem(a.Raiz);
		System.out.println();
		System.out.print("POS : ");
		a.posOrdem(a.Raiz);
		System.out.println();
		System.out.print("NIVEL : ");
		a.porNivel(a.Raiz);

		System.out.println();
		System.out.println("Maior elemento: " + fe.MaiorElemento(a.Raiz));
		System.out.println("Menor elemento: " + fe.MenorElemento(a.Raiz));

		System.out.println("Maior elemento sub-árvore Esq: "
				+ fe.MaiorElemento(a.Raiz.esquerda)) ;
		System.out.println("Maior elemento sub-árvore Dir: "
				+ fe.MaiorElemento(a.Raiz.direita)) ;
		// corrigido
		System.out.println("Nivel: "
				+ a.nivel(a.Raiz.direita.direita  )) ;	
		System.out.println("\n-----------------------");
		System.out.println("\n-----------------------");
		
		System.out
				.println("Pesquisa: " + fe.consultar(a.Raiz, 4, false));
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
