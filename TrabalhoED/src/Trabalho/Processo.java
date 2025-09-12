package Trabalho;

class Processo {
    int id;
    String nome;
    String prioridade;
    int ciclosNecessarios;
    boolean precisaDisco;

    public Processo(int id, String nome, String prioridade, int ciclosNecessarios, boolean precisaDisco) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.ciclosNecessarios = ciclosNecessarios;
        this.precisaDisco = precisaDisco;
    }
    public void executarUmCiclo() {
    	if(ciclosNecessarios>0) ciclosNecessarios--;
    }
    public boolean terminou() {
    	return ciclosNecessarios<= 0;
    }

    @Override
    //O println na main mostrará "Processo{id,nome,prioridade,ciclos,precisaDisco}
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", ciclosNecessarios=" + ciclosNecessarios +
                ", precisaDisco=" + precisaDisco +
                '}';
    }
}

