package principal;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;

import javax.naming.directory.InvalidAttributesException;

public class ArvoreAVL {
	
	static No raiz;

	public static No getRaiz() {
		return raiz;
	}


	public ArvoreAVL() {
		this.setRaiz(null);
	}


	public static void setRaiz(No raiz) {
		raiz = raiz;
	}

	public static ArrayList<Integer> numeros = new ArrayList<Integer>();

	public static No inserir(No aux, int num) throws InvalidAttributesException {
		No novo;

		if (consultar(aux, num, false))
			throw new InvalidAttributesException();

		if (aux == null) {
			novo = new No();
			novo.num = num;
			novo.altd = 0;
			novo.alte = 0;
			novo.esq = null;
			novo.dir = null;
			aux = novo;
		} else if (num < aux.num) {
			aux.esq = inserir(aux.esq, num);
			if (aux.esq.altd > aux.esq.alte) {
				aux.alte = aux.esq.altd + 1;
			} else {
				aux.alte = aux.esq.alte + 1;
			}
			aux = balanceamento(aux);

		} else {
			aux.dir = inserir(aux.dir, num);
			if (aux.dir.altd > aux.dir.alte) {
				aux.altd = aux.dir.altd + 1;
			} else {
				aux.altd = aux.dir.alte + 1;
			}

			aux = balanceamento(aux);

		}
		return aux;
	}

	public static No balanceamento(No aux) {
		int d, df;
		d = aux.altd - aux.alte;

		if (d == 2) {
			df = aux.dir.altd - aux.dir.alte;
			if (df >= 0) {
				aux = rotacao_esquerda(aux);
			} else {
				aux.dir = rotacao_direita(aux.dir);
				aux = rotacao_esquerda(aux);
			}

		} else if (d == -2) {
			df = aux.esq.altd - aux.esq.alte;

			if (df <= 0) {
				aux = rotacao_direita(aux);
			} else {
				aux.esq = rotacao_esquerda(aux.esq);
				aux = rotacao_direita(aux);
			}
		}

		return aux;
	}

	public static No rotacao_esquerda(No aux) {

		No aux1, aux2;
		aux1 = aux.dir;
		aux2 = aux1.esq;
		aux.dir = aux2;
		aux1.esq = aux;

		if (aux.dir == null) {
			aux.altd = 0;
		} else if (aux.dir.alte > aux.dir.altd) {
			aux.altd = aux.dir.alte + 1;
		} else {
			aux.altd = aux.dir.altd + 1;
		}

		if (aux1.esq.alte > aux1.esq.altd) {
			aux1.alte = aux1.esq.alte + 1;
		} else {
			aux1.alte = aux1.esq.altd + 1;
		}
		return aux1;
	}

	public static No rotacao_direita(No aux) {

		No aux1, aux2;
		aux1 = aux.esq;
		aux2 = aux1.dir;
		aux.esq = aux2;
		aux1.dir = aux;

		if (aux.esq == null) {
			aux.alte = 0;
		} else if (aux.esq.alte > aux.esq.altd) {
			aux.alte = aux.esq.alte + 1;
		} else {
			aux.alte = aux.esq.altd + 1;
		}

		if (aux1.dir.alte > aux1.dir.altd) {
			aux1.altd = aux1.dir.alte + 1;
		} else {
			aux1.altd = aux1.dir.altd + 1;
		}
		return aux1;
	}

	/*
	 * Pega todos os valores da arvore e colocar no arraylist numeros
	 */
	public static void pegarValores(No no) {
		if (no != null) {
			pegarValores(no.getEsq());
			numeros.add(no.num);
			pegarValores(no.getDir());
		}
	}

	public static No excluir(No aux, int num)
			throws InvalidDnDOperationException {

		if (aux == null)
			throw new InvalidDnDOperationException();

		No p, p2;
		if (aux.num == num) {
			if (aux.esq == aux.dir) {
				return null;
			} else if (aux.esq == null) {
				return aux.dir;
			} else if (aux.dir == null) {
				return aux.esq;
			} else {
				p2 = aux.dir;
				p = aux.dir;
				while (p.esq != null) {
					p = p.esq;
				}
				p.esq = aux.esq;
				return p2;
			}
		} else if (aux.num < num) {
			aux.dir = excluir(aux.dir, num);
		} else {
			aux.esq = excluir(aux.esq, num);
		}
		return aux;
	}

	public static No atualizar(No aux) {
		if (aux != null) {
			aux.esq = atualizar(aux.esq);
			if (aux.esq == null) {
				aux.alte = 0;
			} else if (aux.esq.alte > aux.esq.altd) {
				aux.alte = aux.esq.alte + 1;
			} else {
				aux.alte = aux.esq.altd + 1;
			}
			aux.dir = atualizar(aux.dir);
			if (aux.dir == null) {
				aux.alte = 0;
			} else if (aux.dir.alte > aux.dir.altd) {
				aux.altd = aux.dir.alte + 1;
			} else {
				aux.altd = aux.dir.altd + 1;
			}
			aux = balanceamento(aux);
		}
		return aux;
	}

	public static boolean consultar(No aux, int num, boolean loc) {
		if (aux != null && loc == false) {
			if (aux.num == num) {
				loc = true;
			} else if (num < aux.num) {
				loc = consultar(aux.esq, num, loc);
			} else {
				loc = consultar(aux.dir, num, loc);
			}
		}
		return loc;
	}

	
	// por que está dando sempre 0?
	public static int nivel(No a, int p) {
		No no;
		no = getRaiz(); // recebe a raiz da Arvore
		int nivel = 0;
		while (no != null) {
			if (no.num == p) {
				return nivel;
			} else if (p < no.num) {
				no = no.getEsq();
				nivel += 1;
			} else {
				no = no.getDir();
				nivel += 1;
			}
		}
		return nivel;
	}
	// imcompleta
	/*
	 * public static No sucessor(No x) { if (x.dir != null) { No y = x.dir;
	 * while (y.esq != null) { y = y.esq; return y; } } while (x.pai != null &&
	 * x.pai.dir == x) x = x.pai; System.out.println("No seguinte " + x.pai);
	 * return x.pai;
	 * 
	 * }
	 */
}
