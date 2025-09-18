class Scheduler {
    // 4 listas encadeadas
    ListaDeProcessos listaAlta = new ListaDeProcessos();
    ListaDeProcessos listaMedia = new ListaDeProcessos();
    ListaDeProcessos listaBaixa = new ListaDeProcessos();
    ListaDeProcessos listaBloqueados = new ListaDeProcessos();

    int contadorCiclosAlta = 0;

    public void adicionarProcesso(Processo p) {
        switch (p.prioridade) {
            case "ALTA": listaAlta.adicionar(p); break;
            case "MEDIA": listaMedia.adicionar(p); break;
            case "BAIXA": listaBaixa.adicionar(p); break;
        }
    }

    public boolean haProcessos() {
        return !(listaAlta.vazia() && listaMedia.vazia() && listaBaixa.vazia() && listaBloqueados.vazia());
    }

    public void executarCiclo() {
        System.out.println("\n\n=================== NOVO CICLO ==================="); // Dividir cada ciclo entre si para evitar poluição visual

        // Desbloqueia processo mais antigo (se tiver)
        Processo desbloqueado = listaBloqueados.remover();
        if (desbloqueado != null) {
            System.out.println("Desbloqueando processo: " + desbloqueado.nome);
            adicionarProcesso(desbloqueado);
        }

        Processo emExecucao = null;

        // Verifica anti-inanição
        if (contadorCiclosAlta >= 5) {
            if (!listaMedia.vazia()) {
                emExecucao = listaMedia.remover();
            } else if (!listaBaixa.vazia()) {
                emExecucao = listaBaixa.remover();
            }
            contadorCiclosAlta = 0;
        }

        // Execução padrão se não houver anti-inanição
        if (emExecucao == null) {
            if (!listaAlta.vazia()) {
                emExecucao = listaAlta.remover();
                contadorCiclosAlta++;
            } else if (!listaMedia.vazia()) {
                emExecucao = listaMedia.remover();
                contadorCiclosAlta = 0;
            } else if (!listaBaixa.vazia()) {
                emExecucao = listaBaixa.remover();
                contadorCiclosAlta = 0;
            }
        }

        if (emExecucao == null) {
            System.out.println("Nenhum processo disponível para execução.");
        } else {
            // Bloqueio por recurso (DISCO)
            if (emExecucao.precisaDisco && !emExecucao.jaSolicitouDisco) {
                System.out.println("Processo " + emExecucao.nome + " solicitou DISCO e será bloqueado.");
                emExecucao.jaSolicitouDisco = true;
                listaBloqueados.adicionar(emExecucao);
            } else {
                // Executar processo
                System.out.println("Executando processo: " + emExecucao.nome);
                emExecucao.ciclosNecessarios--;

                if (emExecucao.ciclosNecessarios <= 0) {
                    System.out.println("Processo " + emExecucao.nome + " terminou!");
                } else {
                    // reinserir no fim da lista original
                    adicionarProcesso(emExecucao);
                }
            }
        }

        // Exibir estado das listas
        listaAlta.mostrar("Lista Alta Prioridade:");
        listaMedia.mostrar("Lista Media Prioridade:");
        listaBaixa.mostrar("Lista Baixa Prioridade:");
        listaBloqueados.mostrar("Lista Bloqueados:");
    }
}