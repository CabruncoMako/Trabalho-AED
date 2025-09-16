package Trabalho;

public class Node {
	Processo p;
	Node next;//
	public Node(Processo p) {
	this.p=p;
	this.next=null;
	
	}
	public Processo getProcesso() {
		return p;}
	public void setProcesso(Processo p) {
		this.p=p;
	}
	//
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next=next;
	}
	
	@Override
	public String toString() {
        return p == null ? "null" : p.toString();
    }
	
}
