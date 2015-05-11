package principal;

import java.util.ArrayList;
import java.util.LinkedList;

public class ExibirArvore {

	public static ArrayList<Integer> sequencia = new ArrayList<Integer>();

	public static void exibirpreOrdem(No no) {
		if (no != null) {
			sequencia.add(no.num);
			System.out.print(no.num + ", ");
			exibirpreOrdem(no.getEsq());
			exibirpreOrdem(no.getDir());
		}
	}

	public static void exibirOrdemSimetrica(No no) {
		if (no != null) {

			exibirOrdemSimetrica(no.getEsq());
			sequencia.add(no.num);
			System.out.print(no.num + ", ");
			exibirOrdemSimetrica(no.getDir());
		}
	}

	public static void exibirpposOrdem(No no) {
		if (no != null) {
			exibirpposOrdem(no.getEsq());
			exibirpposOrdem(no.getDir());
			sequencia.add(no.num);
			System.out.print(no.num + ", ");
		}
	}

	public static void exibirNossaOrdem(No no) {
		if (no == null)
			return;
		LinkedList<No> fila = new LinkedList<No>();
		fila.add(no);
		while (!fila.isEmpty()) {
			No q = fila.element();
			sequencia.add(q.num);
			if (q.getEsq() != null) {
				fila.add(q.getEsq());
			}
			if (q.getDir() != null) {
				fila.add(q.getDir());
				/*
				 * System.out.print(fila + ", ");
				 */
			}
			fila.pop();
		}
	}

}
