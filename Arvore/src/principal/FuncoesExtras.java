package principal;

import java.util.ArrayList;

public class FuncoesExtras {
	public static ArrayList<Integer> numeros = new ArrayList<Integer>();

	public static int numeroNosArvore(No no) {
		if (no != null) {
			numeroNosArvore(no.esq);
			numeros.add(no.num);
			numeroNosArvore(no.dir);
		}
		return numeros.size();
	}

	public static int numeroNosSubArvore(No no, int num) {

		return 0;
	}

	public int Contagem(No n) {
		if (n == null)
			return 0;
		else
			return 1 + Contagem(n.esq) + Contagem(n.dir);
	}

	public int SomaElementos(No raiz) {
		if (raiz != null) {
			int soma = this.SomaElementos(raiz.esq)
					+ this.SomaElementos(raiz.dir) + raiz.num;
			return soma;
		} else
			return 0;
	}

	// imcompleto
	public int MenorElemento(No no) {
		No menor;
		menor = no;
		if (menor != null) {
			while (menor.esq != null) {
				menor = menor.esq;
				return menor.num;
			}
		} else
			return -1;
		return menor.num;
	}

	// imcompleto
	public int MaiorElemento(No raiz) {
		No maior;
		maior = raiz;
		if (maior != null) {
			if (maior.num < raiz.num)
				maior.num = raiz.num;
			this.MaiorElemento(raiz.esq);
			this.MaiorElemento(raiz.dir);
			return maior.num;
		} else
			return 0;
	}
}
