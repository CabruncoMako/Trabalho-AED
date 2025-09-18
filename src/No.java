class No {
    Processo processo;
    No prox;
    public No(Processo p) { this.processo = p; }
}

// Nova classe ListaDeProcessos implementada dentro da classe No para evitar cluster de muitas classes ao mesmo tempo e poluição visual já que classe No só tem 5 linhas
// ListaDeProcessos = Lista encadeada feita manualmente pra ser usada afrente
class ListaDeProcessos {
    private No inicio, fim;

    public boolean vazia() { return inicio == null; }

    public void adicionar(Processo p) {
        No novo = new No(p);
        if (vazia()) {
            inicio = fim = novo;
        } else {
            fim.prox = novo;
            fim = novo;
        }
    }

    public Processo remover() {
        if (vazia()) return null;
        Processo p = inicio.processo;
        inicio = inicio.prox;
        if (inicio == null) fim = null;
        return p;
    }

    public void mostrar(String titulo) {
        System.out.println(titulo);
        if (vazia()) {
            System.out.println("   [vazia]");
            return;
        }
        No atual = inicio;
        while (atual != null) {
            System.out.println("   " + atual.processo);
            atual = atual.prox;
        }
    }
}
