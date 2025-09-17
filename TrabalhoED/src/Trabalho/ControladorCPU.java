package Trabalho;

public class ControladorCPU {
	private ListaDeProcessos Alta;
	private ListaDeProcessos Media;
	private ListaDeProcessos Baixa;
	private ListaCircular Bloqueados;
	
	private int contadorAlta;
	
	public ContadorCPU() {
		Alta = new ListaDeProcessos();
		Media = new ListaDeProcessos();
		Baixa = new ListaDeProcessos();
		Bloqueados = new ListaCircular();
		contadorAlta=0;
	}
	public void AdicionarProcessos(Processo p) {
		String prio = p.prioridade.toLowerCase();
		if (prio.equals("alta")) {
            Alta.adicionar(p);
        } else if (prio.equals("media") || prio.equals("média")) {
            Media.adicionar(p);
        } else {
            Baixa.adicionar(p);
        }
			}
	public boolean hasWork{
		return !Alta.estaVazia() || !Media.estaVazia() || !Baixa.estaVazia() || !Bloqueados.estaVazia();
	}
	public void CicloDaCPU( cicloNumero) {
		System.out.println("/n   CICLO   "+cicloNumero);
	}
	if(bloqueados.estaVazia()) {
		processo desbloqueado = bloqueados.rremover();
		adicionarProcesso(desbloqueado);
        System.out.println("Desbloqueado do DISCO: " + desbloqueado);
	}
	Processo p = escolherProcesso();
	
	if (p == null) {
        System.out.println("Nenhum processo escalonado neste ciclo.");
        return;
    }
	System.out.println("Escalonado: " + p);
	
	 if (p.precisaDisco) {
         bloqueados.adicionar(p);
         System.out.println("Processo " + p.id + " bloqueado (precisa de DISCO).");
         return;
     }
	 p.executarCiclo();
     if (p.terminou()) {
         System.out.println("Processo " + p.id + " terminou!");
     } else {
         adicionarProcesso(p);
         System.out.println("Processo " + p.id + " executou 1 ciclo. Restam " + p.ciclosNecessarios);
     }
}
     private Processo escolherprocesso() {
    	 Processo escolhido = null;
    	 
    	 if (contadorAlta >= 5) {
             if (!Media.estaVazia()) {
                 escolhido = Media.removerPrimeiro();
                 contadorAlta = 0;
                 return escolhido;
             } else if (!Baixa.estaVazia()) {
                 escolhido = Baixa.removerPrimeiro();
                 contadorAlta = 0;
                 return escolhido;
             }
         }
    	 if (!Alta.estaVazia()) {
             escolhido = Alta.removerPrimeiro();
             contadorAlta++;
         } else if (!Media.estaVazia()) {
             escolhido = Media.removerPrimeiro();
             contadorAlta = 0;
         } else if (!Baixa.estaVazia()) {
             escolhido = Baixa.removerPrimeiro();
             contadorAlta = 0;
         }

         return escolhido;
     }

     // Exibe o estado atual das filas
     public void mostrarFilas() {
         System.out.println("Alta: " + Alta);
         System.out.println("Média: " + Media);
         System.out.println("Baixa: " + Baixa);
         System.out.println("Bloqueados: " + Bloqueados);
     }
     }
     


