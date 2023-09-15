package candidatura;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MetodosProcessoSeletivo {
    public static void ligarCandidato() {
        System.out.println("Ligando para o candidato...");
    }
    public static void ligarContraProposta() {
        System.out.println("Ligando para o candidado com contra proposta...");
    }
    public static void aguardarCandidatos() {
        System.out.println("Aguardando demais candidaturas...");
    }

    public static boolean atender() {
        return new Random().nextInt(3) == 1;
    }
    public static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        do {
            boolean atendeu = atender();
            if (atendeu) {
                System.out.println("Conseguimos contato com "+candidato+" após "+tentativasRealizadas+" tentativas.");
                continuarTentando = false;
            } else if (tentativasRealizadas == 3){
                System.out.println("Não conseguimos contato com "+candidato+" após "+tentativasRealizadas+" tentativas.");
            }
            tentativasRealizadas++;
        } while ((continuarTentando == false)&&(tentativasRealizadas <= 3));

    }
    public static void analisarCandidato(double salarioPretendido){
        if (ProcessoSeletivo.proSel.salarioBase > salarioPretendido) {
            MetodosProcessoSeletivo.ligarCandidato();
        } else if (ProcessoSeletivo.proSel.salarioBase == salarioPretendido){
            MetodosProcessoSeletivo.ligarContraProposta();
        } else {
            MetodosProcessoSeletivo.aguardarCandidatos();
        }
    }
    public static void selecionarCandidatos() {
        int candidatos = 0;
        for (int c = 0; c < ProcessoSeletivo.proSel.candidatos.length; c++) {
            double valorSalarioPretendido = valorPretendido();
            if ((valorSalarioPretendido <= ProcessoSeletivo.proSel.salarioBase) && (candidatos <= 5)) {
                ProcessoSeletivo.proSel.candidatosSelecionados[candidatos] = ProcessoSeletivo.proSel.candidatos[c];
                ProcessoSeletivo.proSel.salarioPretendidoSelecionados[candidatos] = valorSalarioPretendido;
                candidatos++;
            }
        }
    }
    public static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2000);
    }
    public static void imprimirSelecao() {
        for (String candidato : ProcessoSeletivo.proSel.candidatosSelecionados) {
            System.out.println(candidato);
        }
    }

    public static void main(String[] args) {

    }
}
