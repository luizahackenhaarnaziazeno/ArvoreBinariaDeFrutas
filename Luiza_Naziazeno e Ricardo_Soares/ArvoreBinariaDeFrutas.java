

public class ArvoreBinariaDeFrutas {

    private class Nodo {
        private String chave;
        private Nodo esquerda;
        private Nodo direita;

        public Nodo(String chave) {
            this.chave = chave;
        }
    }

    private Nodo raiz;
    private String ordemCentral;

    public String getOrdemCentral() {
        return this.ordemCentral;
    }

    public ArvoreBinariaDeFrutas() {
        raiz = null;
    }

    public void adicionar(String chave) {
        Nodo n = new Nodo(chave);
        if (raiz==null) {
            raiz = n;
        }
        else {
            adicionarRecursivo(n, raiz);
        }
    }

    private void adicionarRecursivo(Nodo n, Nodo pai) {
        if (n.chave.compareTo(pai.chave) > 0) {
            if(pai.direita==null) pai.direita = n;
            else adicionarRecursivo(n, pai.direita);
        }
        else if (n.chave.compareTo(pai.chave) < 0) {
            if (pai.esquerda==null) pai.esquerda = n;
            else adicionarRecursivo(n, pai.esquerda);
        }
    }

    public void percorrerEmProfundidade() {
        percorrerEmProfundidade(raiz);
    }

    private void percorrerEmProfundidade(Nodo n) {
        if(n==null) return;
        if(n.esquerda!=null) percorrerEmProfundidade(n.esquerda);
        this.ordemCentral = this.ordemCentral + ", " + n.chave;
        if(n.direita!=null) percorrerEmProfundidade(n.direita);
        
    }

    public String ordemCentral() {
        percorrerEmProfundidade();
        return this.ordemCentral;
    }

    public void limpar() {
        raiz = null;
    }

    public boolean estaVazia() {
        return (raiz == null);
    }

    public String obterRaiz() {
        if(!estaVazia()) return raiz.chave;
        else return "";
    }

    public String obterAltura() {
        return String.valueOf(obterAlturaRecursivo(raiz));
    }

    private int obterAlturaRecursivo(Nodo n) {
        if (n == null) {
            return -1; 
        }
        int alturaEsquerda = obterAlturaRecursivo(n.esquerda);
        int alturaDireita = obterAlturaRecursivo(n.direita);
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    public int obterTamanho() {
        return obterTamanhoRecursivo(raiz);
    }

    private  int obterTamanhoRecursivo(Nodo n) {
        if (n == null) {
            return 0;
        }
        return 1 + obterTamanhoRecursivo(n.esquerda) + obterTamanhoRecursivo(n.direita);
    }

    public void imprimirArvore() {
        imprimirArvoreRecusivamente(this.raiz, 0);
    }

    private void imprimirArvoreRecusivamente(Nodo raiz, int nivel) {
        if (raiz == null) return;
        nivel += 5;
        imprimirArvoreRecusivamente(raiz.direita, nivel);
        System.out.print("\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        System.out.print(raiz.chave + "\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        imprimirArvoreRecusivamente(raiz.esquerda, nivel);
    }
}