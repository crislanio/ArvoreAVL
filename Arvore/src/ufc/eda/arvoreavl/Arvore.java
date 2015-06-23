package ufc.eda.arvoreavl;

import java.util.ArrayList;
import java.util.LinkedList;

public class Arvore {

	protected No raiz;
	public No raiz1 = raiz;

	public Arvore() {
		this.setRaiz(null);
	}

	/**
	 * @return the raiz
	 */
	public No getRaiz() {
		return raiz;
	}

	/**
	 * @param raiz
	 * 
	 */
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	/**
	 * Recebe um nó e retorna a altura
	 */
	public int altura(No atual) {
		if (atual == null) {
			return -1;
		}
 
		if (atual.getfilhoEsquerda() == null && atual.getfilhoDireita() == null) {
			return 0;
		
		} else if (atual.getfilhoEsquerda() == null) {
			return 1 + altura(atual.getfilhoDireita());
		
		} else if (atual.getfilhoDireita() == null) {
			return 1 + altura(atual.getfilhoEsquerda());
		
		} else {
			return 1 + Math.max(altura(atual.getfilhoEsquerda()), altura(atual.getfilhoDireita()));
		}
	}

	public int alturaNodeValue(No atual, int i) {

		if (atual == null) {
			return -1;
		}

		if (atual.getfilhoEsquerda() == null && atual.getfilhoDireita() == null) {
			return 0;

		} else if (atual.getfilhoEsquerda() == null) {
			if (atual.getValor() == i)
				return 1 + alturaNodeValue(atual.getfilhoDireita(), i);
			else {

			}
		} else if (atual.getfilhoDireita() == null) {
			if (atual.getValor() == i)
				return 1 + alturaNodeValue(atual.getfilhoEsquerda(), i);

		}
		return 1 + max(alturaNodeValue(atual.getfilhoEsquerda(), i),
				alturaNodeValue(atual.getfilhoDireita(), i));
	}

	private int max(int a, int b) {
		if (a >= b) {
			return a;
		} else {
			return b;
		}
	}

	/**
	 * Metodo completar de inserçao de um no na arvore
	 * 
	 * @param no
	 * @param valor
	 */
	public void insere(No no, int valor) {
		// testa se o valor existe na arvore
		if (no.getValor() == valor) {
			System.out.println("O no com esse valor ja existe na arvore");
		} else {
			// testa se o valor a ser inserido e menor que a raiz
			if (valor < no.getValor()) {
				if (no.getfilhoEsquerda() == null) {
					No novo = new No(valor);
					no.setfilhoEsquerda(novo);
				} else {
					insere(no.getfilhoEsquerda(), valor);
				}
			} else {
				// testa se o valor a ser inserido e maior que a raiz
				if (no.getfilhoDireita() == null) {
					No novo = new No(valor);
					no.setfilhoDireita(novo);
				} else {
					insere(no.getfilhoDireita(), valor);
				}
			}

		}
	}

	/**
	 * Metodo para inserir um valor na arvore
	 * 
	 * @param valor
	 */
	public void insere(int valor) {
		// testa se nao existe nenhum no entao insere o valor
		if (this.getRaiz() == null) {
			this.raiz = new No(valor);
			raiz1 = this.raiz; // dando acesso a raiz1

		} else {
			// Senao usa o metodo de inserçao complementar
			insere(this.raiz, valor);
		}
	}

	/**
	 * metodo para remover um no avaliando todos os casos necessarios
	 * 
	 * @param no
	 * @param pai
	 * @param valor
	 */
	public void remove(No no, No pai, int valor) {
		// se o no em questao nao possui o valor a ser removido
		if (no.getValor() != valor) {
			if (valor < no.getValor()) {
				if (no.getfilhoEsquerda() != null) {
					remove(no.getfilhoEsquerda(), no, valor);
				} else {
					System.out.println("O valor " + valor
							+ " nao esta na arvore");
				}
			} else {
				if (no.getfilhoDireita() != null) {
					remove(no.getfilhoDireita(), no, valor);
				} else {
					System.out.println("O valor " + valor
							+ " nao esta na arvore");
				}
			}

		}
		// se o no em questao possui o valor a ser removido
		else {
			No aux;
			// caso de remocao de folha
			if (no.getfilhoDireita() == null && no.getfilhoEsquerda() == null) {

				// se o no a ser removido for filho direito do pai
				if (pai.getfilhoDireita() == no) {
					pai.setfilhoDireita(null);
				} else {
					pai.setfilhoEsquerda(null);
				}
			}
			// caso onde o no possui 1 filho
			else if (no.getfilhoDireita() == null
					|| no.getfilhoEsquerda() == null) {

				// se nao houver subarvore a direita, pegue o antecessor
				if (no.getfilhoEsquerda() != null) {
					if (no == this.raiz) {
						this.raiz = no.getfilhoEsquerda();
					} else {
						// faltou ver se o nó era filho da esquerda ou direita
						if (no.getfilhoEsquerda() != null) {
							if (pai.getfilhoDireita() == no) {
								pai.setfilhoDireita(no.getfilhoEsquerda());
							} else {
								pai.setfilhoEsquerda(no.getfilhoEsquerda());
							}
						} else {
							if (pai.getfilhoDireita() == no) {
								pai.setfilhoDireita(no.getfilhoDireita());
							} else {
								pai.setfilhoEsquerda(no.getfilhoDireita());
							}
						}

					}
				}
				// se nao houver subArvore a esquerda, pegue o sucessor
				else {
					if (no == this.raiz)
						this.raiz = no.getfilhoDireita();
					else {
						if (no.getfilhoDireita() != null) {
							// faltou ver se o nó era filho da esquerda ou
							// direita
							if (pai.getfilhoDireita() == no) {
								pai.setfilhoDireita(no.getfilhoDireita());
							} else {
								pai.setfilhoEsquerda(no.getfilhoDireita());
							}
						} else {
							if (pai.getfilhoDireita() == no) {
								pai.setfilhoDireita(no.getfilhoEsquerda());
							} else {
								pai.setfilhoEsquerda(no.getfilhoEsquerda());
							}
						}
					}
				}
			}
			/*
			 * caso de remocao de no com dois filhos: copie o sucessor para o no
			 * a ser removido e remova o sucessor
			 */
			else {
				aux = no.sucessor(no);
				no.setValor(aux.getValor());
				remove(no.getfilhoDireita(), no, aux.getValor());
			}
		}
	}

	/**
	 * Metodo para remocao de no
	 * 
	 * @param valor
	 */
	public void remove(int valor) {
		// caso em que a arvore esta vazia
		if (this.getRaiz() == null)
			;
		// caso em que haja apenas a raiz
		else if (this.getRaiz().getValor() == valor
				&& this.getRaiz().getfilhoEsquerda() == null
				&& this.getRaiz().getfilhoDireita() == null) {
			this.raiz = null;
		} else {
			remove(this.getRaiz(), null, valor);
		}
	}

	/**
	 * Metodo densevolvido para pesquisar um determinado valor em um No usando
	 * recursao para fazer a pesquisa
	 * 
	 * @param valor
	 * @param atual
	 * @return
	 */
	public No pesquisar(int valor, No atual) {
		if (valor == atual.getValor())
			return atual;
		else if (atual == null)
			return null;
		else if (valor < atual.getValor())
			return pesquisar(valor, atual.getfilhoEsquerda());
		else
			return pesquisar(valor, atual.getfilhoDireita());
	}

	/**
	 * Metodo densevolvido para dizer se um determinado valor em um No existe
	 * 
	 * @param aux
	 * @param num
	 * @param loc
	 * @return loc
	 */
	public boolean consultar(No aux, int num, boolean loc) {
		if (aux != null && loc == false) {
			if (aux.getValor() == num) {
				loc = true;
			} else if (num < aux.getValor()) {
				loc = consultar(aux.getfilhoEsquerda(), num, loc);
			} else {
				loc = consultar(aux.getfilhoDireita(), num, loc);
			}
		}
		return loc;
	}

	/**
	 * Metodo densevolvido para dizer se um determinado valor em um No existe
	 * 
	 * @param aux
	 * @param num
	 * @param loc
	 * @return num
	 */
	public int consultar2(No aux, int num, boolean loc) {
		if (aux != null && loc == false) {
			if (aux.getValor() == num) {
				loc = true;
			} else if (num < aux.getValor()) {
				loc = consultar(aux.getfilhoEsquerda(), num, loc);
			} else {
				loc = consultar(aux.getfilhoDireita(), num, loc);
			}
		}
		return num;
	}

	/**
	 * Imprime a arvore de forma PreFixada de acordo com o caminho percorrido
	 * Metodo em Recursao
	 * 
	 * @param no
	 */
	public void preOrdem(No no) {
		if (no != null) {
			System.out.print(no.getValor() + ", ");
			preOrdem(no.getfilhoEsquerda());
			preOrdem(no.getfilhoDireita());
		}
	}

	/**
	 * Imprime a arvore de forma PosFixada de acordo com o caminho percorrido
	 * Metodo em Recursao
	 * 
	 * @param no
	 */
	public void posOrdem(No no) {
		if (no != null) {

			posOrdem(no.getfilhoEsquerda());
			posOrdem(no.getfilhoDireita());
			System.out.print(no.getValor() + ", ");
		}
	}

	/**
	 * Imprime a arvore EmOrdem de acordo com o caminho percorrido Metodo em
	 * Recursao
	 * 
	 * @param no
	 */
	public void emOrdem(No no) {

		if (no != null) {
			emOrdem(no.getfilhoEsquerda());
			System.out.print(no.getValor() + ", ");
			emOrdem(no.getfilhoDireita());
		}
	}

	ArrayList<Integer> sequencia = new ArrayList<Integer>();

	public void porNivel(No no) {
		if (no == null)
			return;
		LinkedList<No> fila = new LinkedList<No>();
		fila.add(no);
		while (!fila.isEmpty()) {
			No q = fila.element();
			sequencia.add(q.getValor());
			System.out.print(q.getValor() + ", ");
			if (q.getfilhoEsquerda() != null) {
				fila.add(q.getfilhoEsquerda());
			}
			if (q.getfilhoDireita() != null) {
				fila.add(q.getfilhoDireita());
			}
			fila.pop();
		}
	}

	// OBS ?
	/**
	 * Retorna o arvore EmOrdem de acordo com o caminho percorrido Metodo em
	 * Recursao
	 * 
	 * @param no
	 * @param p
	 */
	public int nivel(No p) {
		No no;
		no = this.getRaiz(); // recebe a raiz da Arvore
		int nivel = 0;
		while (no != null) {
			if (no.getValor() == p.getValor()) {
				return nivel;
			} else if (p.getValor() < no.getValor()) {
				no = no.getfilhoEsquerda();
				nivel += 1;
			} else {
				no = no.getfilhoDireita();
				nivel += 1;
			}
		}
		return nivel;
	}

	public int nivelDoisNos(No no, int p) {
		;
		no = this.getRaiz(); // recebe a raiz da Arvore
		int nivel = 0;
		while (no != null) {
			if (no.getValor() == p) {
				return nivel;
			} else if (p < no.getValor()) {
				no = no.getfilhoEsquerda();
				nivel += 1;
			} else {
				no = no.getfilhoDireita();
				nivel += 1;
			}
		}
		return nivel;
	}

	/**
	 * Metodo que calcula o nivel de um No em uma arvore
	 * 
	 * @param k
	 */

	public int calcularNivelNo(int k) {
		No aux = raiz;
		int nivel = 0;
		while (aux != null && aux.getValor() != k) {
			if (k < aux.getValor()) {
				aux = aux.getfilhoEsquerda();
			} else {
				aux = aux.getfilhoDireita();
			}
			nivel++;
		}
		return nivel;
	}

}