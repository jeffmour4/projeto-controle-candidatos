package candidatura;

public class ProcessoSeletivo {
    double salarioBase = 2000;
    String[] candidatos = {"Felipe, Márcia, Julia, Paulo, Augusto, Mônica, Fabŕicio, Mirela, Daniela, Jorge"};
    String[] candidatosSelecionados = new String[5];
    double[] salarioPretendidoSelecionados = new double[5];
    static ProcessoSeletivo proSel = new ProcessoSeletivo();
    public static void main(String[] args) {
        try {
            System.out.println("Processo Seletivo - Candidaturas");
            System.out.println();
            System.out.println("Candidato 1 - salário pretendido:");
            double salarioCandidato1 = 0;
            MetodosProcessoSeletivo.analisarCandidato(salarioCandidato1);
            System.out.println("Candidato 2 - salário pretendido:");
            double salarioCandidato2 = 0;
            MetodosProcessoSeletivo.analisarCandidato(salarioCandidato2);
            System.out.println("Candidato 3 - salário pretendido:");
            double salarioCandidato3 = 0;
            MetodosProcessoSeletivo.analisarCandidato(salarioCandidato3);
        } catch (Exception e) {
            System.out.println("Ops, algo deu errado.");
            System.out.println("O salário deve ser numérico, com centavos separados por ponto.");
        } finally {
            System.out.println("Operação finalizada.");
        }
    }
}
