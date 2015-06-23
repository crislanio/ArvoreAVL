package ufc.eda.arvoreavl;

import java.util.ArrayList;

public class FuncoesExtras extends Arvore {
	public ArrayList<Integer> numeros = new ArrayList<Integer>();

	public int numeroNosArvore(No no) {
		if (no != null) {
			numeroNosArvore(no.getfilhoEsquerda());
			numeros.add(no.getValor());
			numeroNosArvore(no.getfilhoDireita());
		}
		return numeros.size();
	}
// n nos arv
	public int Contagem(No n) {
		if (n == null)
			return 0;
		else
			return 1 + Contagem(n.getfilhoEsquerda())
					+ Contagem(n.getfilhoDireita());
	}

	public int SomaElementos(No raiz) {
		if (raiz != null) {
			int soma = this.SomaElementos(raiz.getfilhoEsquerda())
					+ this.SomaElementos(raiz.getfilhoDireita())
					+ raiz.getValor();
			return soma;
		} else
			return 0;
	}

	/**
	 * Metodo que retorna o menor valor na arvore
	 * 
	 * @param raiz
	 */
	public int MenorElemento(No raiz) {
		No menor = raiz;
		while (menor.getfilhoEsquerda() != null) {
			menor = menor.getfilhoEsquerda();
		}
		return menor.getValor();

	}

	/**
	 * Metodo que retorna o maior valor na arvore
	 * 
	 * @param raiz
	 */
	public int MaiorElemento(No raiz) {
		No maior = raiz;
		while (maior.getfilhoDireita() != null) {
			maior = maior.getfilhoDireita();
		}
		return maior.getValor();
	}

	// imcompleto
	public int MaiorElementoSubArvore(No raiz, int num, boolean loc) {
		No maior = raiz;
		Arvore a = new Arvore();
		if (raiz != null && loc == false) {
			if (raiz.getValor() == num) {
				loc = true;
				No n = a.getRaiz();
				n = raiz;
				maior = n;

				while (maior.getfilhoDireita() != null) {
					maior = maior.getfilhoDireita();
				}
			} else if (num < raiz.getValor()) {
				loc = consultar(raiz.getfilhoEsquerda(), num, loc);
			} else {
				loc = consultar(raiz.getfilhoDireita(), num, loc);
			}
		}
		return maior.getValor();
	}

	public No percursoAntecessor(No n, int valor) {
		if (n != null) {
			pesquisar(valor, n);
			if (n.getValor() == valor) {
				return n.antecessor(n);
			}
		}

		return n.antecessor(n);
	}
}
