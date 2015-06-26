package ufc.eda.arvorerubronegra;

import java.util.ArrayList;
import java.util.LinkedList;
class Arvore {

    public No Raiz;

    public Arvore(){

        this.Raiz = null;
    }
    /**
	 * Retorna o arvore EmOrdem de acordo com o caminho percorrido Metodo em
	 * Recursao
	 * 
	 * @param no
	 * @param p
	 */
	public int nivel(No p) {
		No no;
		no = this.Raiz; // recebe a raiz da Arvore
		int nivel = 0;
		while (no != null) {
			if (no.info == p.info) {
				return nivel;
			} else if (p.info < no.info) {
				no = no.esquerda;
				nivel += 1;
			} else {
				no = no.direita;
				nivel += 1;
			}
		}
		return nivel;
	}

	public int nivelDoisNos(No no, int p) {
		;
		no = this.Raiz; // recebe a raiz da Arvore
		int nivel = 0;
		while (no != null) {
			if (no.info == p) {
				return nivel;
			} else if (p < no.info) {
				no = no.esquerda;
				nivel += 1;
			} else {
				no = no.direita;
				nivel += 1;
			}
		}
		return nivel;
	}
	/**
	 * Imprime a arvore de forma PreFixada de acordo com o caminho percorrido
	 * Metodo em Recursao
	 * 
	 * @param no
	 */
	public void preOrdem(No no) {
		if (no != null) {
			System.out.print(no.info + ", ");
			preOrdem(no.esquerda);
			preOrdem(no.direita);
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

			posOrdem(no.esquerda);
			posOrdem(no.direita);
			System.out.print(no.info + ", ");
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
			emOrdem(no.esquerda);
			System.out.print(no.info + ", ");
			emOrdem(no.direita);
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
			sequencia.add(q.info);
			System.out.print(q.info + ", ");
			if (q.esquerda != null) {
				fila.add(q.esquerda);
			}
			if (q.direita != null) {
				fila.add(q.direita);
			}
			fila.pop();
		}
	}
    public void insere(No N, int k) {

        No Novo = new No(k);
        if(this.Raiz == null){
            this.Raiz = Novo;
            Novo.pai = Novo;
            Caso1(Novo);
        } else if ( k > N.info ) {
            if( N.direita == null ){
                N.direita = Novo;
                Novo.pai = N;
                Caso1(Novo);
            } else {
                insere(N.direita,k);
            }
        } else {
            if( N.esquerda == null ){
                N.esquerda = Novo;
                Novo.pai = N;
                Caso1(Novo);
            } else {
                insere(N.esquerda,k);
            }
        }

    }

    public void Caso1(No N){

        if(N == Raiz){
            N.cor = "preto";
        } else {
            Caso2(N);
        }

    }

    public void Caso2(No N){

        if( !N.pai.cor.equals("preto") ){
            Caso3(N);
        }

    }

    public void Caso3(No N){

        No tio = tio(N);
        No avo = avo(N);
        No pai = N.pai;
        if( tio != null && tio.cor.equals("vermelho") ){
            pai.cor = "preto";
            tio.cor = "preto";
            avo.cor = "vermelho";
            Caso1(avo);
        } else {
            Caso4(N);
        }

    }

    public void Caso4(No N){

        No tio = tio(N);
        No pai = N.pai;
        No avo = avo(N);
        if ( N == pai.direita && pai == avo.esquerda ){
            RotEsquerda(N);
        } else if ( N == pai.esquerda && pai == avo.direita ) {
            RotDireita(N);
        }
        Caso5(N);

    }

    public void Caso5(No N){

        No pai = N.pai;
        N.cor = "preto";
        pai.cor = "vermelho";
        if ( N == pai.esquerda){
            if ( pai.direita != null ) pai.direita.cor = "preto";
            RotDireita(N);
        } else {
            if ( pai.esquerda != null ) pai.esquerda.cor = "preto";
            RotEsquerda(N);
        }

    }

    public void Imprimir(No N){

    		if (N == null) return;
            Imprimir(N.esquerda);
            if (N == Raiz) System.out.println("pai [ RAIZ ], nodo : " + N.info + "-" + N.cor);
            else System.out.println("pai [ " + N.pai.info + " ], nodo : " + N.info + "-" + N.cor);
    		Imprimir(N.direita);
    		return;

    }

    public void RotEsquerda(No N){

        No pai = N.pai;
        No avo = avo(N);
        if ( avo.esquerda == pai ) avo.esquerda = N;
        else avo.direita = N;
        pai.direita = N.esquerda;
        if (N.esquerda != null) N.esquerda.pai =  pai;
        N.esquerda = pai;
        N.pai = avo;
        pai.pai = N;

    }

    public void RotDireita(No N){

        No pai = N.pai;
        No avo = avo(N);
        if ( avo.esquerda == pai ) avo.esquerda = N;
        else avo.direita = N;
        pai.esquerda = N.direita;
        if (N.direita != null) N.direita.pai =  pai;
        N.direita = pai;
        N.pai = avo;
        pai.pai = N;

    }

	public No avo(No Nodo){

		if (Nodo.pai.pai != null){
			return Nodo.pai.pai;
		}
		return null;

    }

	public No tio(No Nodo){

        No avo = avo(Nodo);
        if(avo == null){
            return null;
        } else if (Nodo.pai == avo.esquerda){
        	return avo.direita;
        } else {
        	return avo.esquerda;
        }

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
			if (aux.info == num) {
				loc = true;
			} else if (num < aux.info) {
				loc = consultar(aux.esquerda, num, loc);
			} else {
				loc = consultar(aux.direita, num, loc);
			}
		}
		return loc;
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
		if (valor == atual.info)
			return atual;
		else if (atual == null)
			return null;
		else if (valor < atual.info)
			return pesquisar(valor, atual.esquerda);
		else
			return pesquisar(valor, atual.direita);
	}
	/**
	 * Recebe um nó e retorna a altura
	 */
	public int altura(No atual) {
		if (atual == null) {
			return -1;
		}
 
		if (atual.esquerda == null && atual.direita== null) {
			return 0;
		
		} else if (atual.esquerda == null) {
			return 1 + altura(atual.direita);
		
		} else if (atual.direita == null) {
			return 1 + altura(atual.esquerda);
		
		} else {
			return 1 + Math.max(altura(atual.esquerda), altura(atual.direita));
		}
	}

	public int alturaNodeValue(No atual, int i) {

		if (atual == null) {
			return -1;
		}

		if (atual.esquerda == null && atual.direita == null) {
			return 0;

		} else if (atual.esquerda == null) {
			if (atual.info == i)
				return 1 + alturaNodeValue(atual.direita, i);
			else {

			}
		} else if (atual.direita== null) {
			if (atual.info == i)
				return 1 + alturaNodeValue(atual.esquerda, i);

		}
		return 1 + max(alturaNodeValue(atual.esquerda, i),
				alturaNodeValue(atual.direita, i));
	}

	private int max(int a, int b) {
		if (a >= b) {
			return a;
		} else {
			return b;
		}
	}

}
