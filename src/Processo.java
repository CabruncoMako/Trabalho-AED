class Processo {
    int id;
    String nome;
    String prioridade;
    int ciclosNecessarios;
    boolean precisaDisco;
    boolean jaSolicitouDisco = false; // Controlar bloqueio da primeira vez

    public Processo(int id, String nome, String prioridade, int ciclosNecessarios, boolean precisaDisco) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade.toUpperCase();
        this.ciclosNecessarios = ciclosNecessarios;
        this.precisaDisco = precisaDisco;
    }

    @Override
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
