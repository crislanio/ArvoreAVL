package ufc.eda.arvorerubronegra;

class No{

    No esquerda;

	No direita;

	No pai;

    int info;

	String cor;

    public No(int chave){

		this.esquerda = null;

        this.direita = null;

        this.pai = null;

        this.info = chave;

		this.cor = "vermelho";

    }  
    public No antecessor(No no) {
        No antecessor = no;

        antecessor = antecessor.esquerda;

        while (antecessor.direita != null) {
            antecessor = antecessor.direita;
        }

        return antecessor;
    }
    public No sucessor(No no) {
        No sucessor = no;

        sucessor = sucessor.direita;

        while (sucessor.esquerda != null)
            sucessor = sucessor.esquerda;

        return sucessor;
    }
}
