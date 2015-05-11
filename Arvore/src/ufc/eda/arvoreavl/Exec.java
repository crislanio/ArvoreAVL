package ufc.eda.arvoreavl;

public class Exec {

	public static void main(String[] args) {
		Arvore a = new Arvore();

		a.insere(3);
		a.insere(4);
		a.insere(2);

		a.insere(5);
		a.insere(6);
		a.insere(10);
		a.emOrdem(a.getRaiz());
		System.out.println(" ");
		a.posOrdem(a.getRaiz());
		System.out.println(" ");
		a.preOrdem(a.getRaiz());
		System.out.println(" ");

	}
}
