package Trabalho;
public class ListaDeProcessos {
    private Node primeiro;
    private Node ultimo;
    private int tamanho;

    public ListaDeProcessos() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void adicionar(Processo processo) {
        Node novoNo = new Node(processo);
        if (estaVazia()) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            this.ultimo.next = novoNo;
            this.ultimo = novoNo;
        }
        tamanho++;
    }

    public Processo removerPrimeiro() {
        if (estaVazia()) {
            return null;
        }
        Processo processoRemovido = this.primeiro.getProcesso();
        this.primeiro = this.primeiro.next;
        tamanho--;

        if (estaVazia()){
            ultimo = null;
        }
        return processoRemovido;
    }

    public Processo pegarPrimeiro() {
        if (estaVazia()) {
            return null;
        }
        return this.primeiro.getProcesso();
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node noAtual = this.primeiro;
        while (noAtual != null) {
            sb.append(noAtual.getProcesso().getNome());
            if (noAtual.next != null) {
                sb.append(", ");
            }
            noAtual = noAtual.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
