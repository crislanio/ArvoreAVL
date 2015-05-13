package ufc.eda.arvoreavl;

public class No {
    private int valor;
    private No filhoDireita;
    private No filhoEsquerda;
 
    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor
     *  valor do set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the direita
     */
    public No getfilhoDireita() {
        return filhoDireita;
    }

    /**
     * @param direita
     *           
     */
    public void setfilhoDireita(No direita) {
        this.filhoDireita = direita;
    }

    /**
     * @return the esquerda
     */
    public No getfilhoEsquerda() {
        return filhoEsquerda;
    }

    /**
     * @param esquerda
     *            
     */
    public void setfilhoEsquerda(No esquerda) {
        this.filhoEsquerda = esquerda;
    }

    public No() {

    }

    public No(int valor) {
        this.valor = valor;
    }

    public No(int valor, No direita, No esquerda) {
        this.valor = valor;
        this.filhoDireita = direita;
        this.filhoEsquerda = esquerda;
    }

    @Override
    public String toString() {
        return Integer.toString(this.getValor());
    }
/**
 * metodo feito para pegar o no sucessor 
 * @param no
 * @return
 */
    public No sucessor(No no) {
        No sucessor = no;

        sucessor = sucessor.getfilhoDireita();

        while (sucessor.getfilhoEsquerda() != null)
            sucessor = sucessor.getfilhoEsquerda();

        return sucessor;
    }
/**
 * metodo feito para pegar o no antecessor
 * @param no
 * @return
 */
    public No antecessor(No no) {
        No antecessor = no;

        antecessor = antecessor.getfilhoEsquerda();

        while (antecessor.getfilhoDireita() != null) {
            antecessor = antecessor.getfilhoDireita();
        }

        return antecessor;
    }







}