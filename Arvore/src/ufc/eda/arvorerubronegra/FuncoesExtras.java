package ufc.eda.arvorerubronegra;

import java.util.ArrayList;

public class FuncoesExtras extends Arvore {
	public ArrayList<Integer> numeros = new ArrayList<Integer>();

	public int numeroNosArvore(No no) {
		if (no != null) {
			numeroNosArvore(no.esquerda);
			numeros.add(no.info);
			numeroNosArvore(no.direita);
		}
		return numeros.size();
	}
// n nos arv
	public int Contagem(No n) {
		if (n == null)
			return 0;
		else
			return 1 + Contagem(n.esquerda)
					+ Contagem(n.direita);
	}

	public int SomaElementos(No raiz) {
		if (raiz != null) {
			int soma = this.SomaElementos(raiz.esquerda)
					+ this.SomaElementos(raiz.direita)
					+ raiz.info;
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
		while (menor.esquerda != null) {
			menor = menor.esquerda;
		}
		return menor.info;

	}

	/**
	 * Metodo que retorna o maior valor na arvore
	 * 
	 * @param raiz
	 */
	public int MaiorElemento(No raiz) {
		No maior = raiz;
		while (maior.direita != null) {
			maior = maior.direita;
		}
		return maior.info;
	}

	// imcompleto
	public int MaiorElementoSubArvore(No raiz, int num, boolean loc) {
		No maior = raiz;
		Arvore a = new Arvore();
		if (raiz != null && loc == false) {
			if (raiz.info == num) {
				loc = true;
				No n = a.Raiz;
				n = raiz;
				maior = n;

				while (maior.direita != null) {
					maior = maior.direita;
				}
			} else if (num < raiz.info) {
				loc = consultar(raiz.esquerda, num, loc);
			} else {
				loc = consultar(raiz.direita, num, loc);
			}
		}
		return maior.info;
	}

	public No percursoAntecessor(No n, int valor) {
		if (n != null) {
			pesquisar(valor, n);
			if (n.info == valor) {
				return n.antecessor(n);
			}
		}

		return n.antecessor(n);
	}
}
