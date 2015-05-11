package principal;

public class No {
	
	public int num, altd, alte;
	No dir;
	No esq;

	public No() {

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public No getDir() {
		return dir;
	}

	public void setDir(No dir) {
		this.dir = dir;
	}

	public No getEsq() {
		return esq;
	}

	public void setEsq(No esq) {
		this.esq = esq;
	}

	public No(int num) {
		this.num = num;
	}

	public No(int num, No direita, No esquerda) {
		this.num = num;
		this.dir = direita;
		this.esq = esquerda;
	}

	@Override
	public String toString() {
		return Integer.toString(this.getNum());
	}

}
