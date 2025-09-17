package Trabalho;

public class ListaCircular {
    private Node tail;
    private int size;

    public ListaCircular() {
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void adicionar(Processo p) {
        Node novo = new Node(p);
        if (isEmpty()) {
            tail = novo;
            tail.setNext(tail);
        } else {
            novo.setNext(tail.getNext());
            tail.setNext(novo);
            tail = novo;
        }
        size++;
    }

    public Processo remover() {
        if (isEmpty()) {
            return null;
        }

        Node head = tail.getNext();
        Processo removido = head.getProcesso();

        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }
        size--;
        return removido;
    }

    public Processo pegarprimeiro() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getProcesso();
    }

    public int tamanho() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node atual = tail.getNext();
        for (int i = 0; i < this.size; i++) {
            sb.append(atual.getProcesso().getNome());
            if (i < this.size - 1) {
                sb.append(", ");
            }
            atual = atual.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
