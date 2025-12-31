package app;
import java.util.Scanner;

import model.Matchup;
import model.NomeCampeao;
import service.ExibicaoUtils;
import service.InputUtils;
import model.Campeao;
import java.util.List;

public class MenuMatchups {
    private Campeao campeao;
    private Scanner sc;

    public MenuMatchups(Campeao campeao, Scanner sc){
        this.campeao = campeao;
        this.sc = sc;
    }

    public void iniciar(){
        int op;
        do{
            imprimeMenu();
            op = InputUtils.lerInteiro(sc, "\nEscolha uma opção: ");
            interacoes(op);
        }while(op!=4);
    }

    private void imprimeMenu(){
        System.out.println("1. Nova matchup");
        System.out.println("2. Consultar matchups");
        System.out.println("3. Editar matchups");
        System.out.println("4. Voltar");
    }


    private void interacoes(int op){
        switch(op){
            case 1:
                Matchup m = criaMatchup();
                if (m != null){
                    campeao.adicionarMachup(m);
                }
                break;
            case 2:
                Matchup matchup = escolheMatchup("consultar");
                if (matchup!=null){
                    consultaMatchups(matchup);
                }
                break;
            case 3:
                editaMatchup();
                break;
        }
    }

    private Matchup criaMatchup(){
        System.out.println("Criando nova matchup..");
        NomeCampeao nome = selecionaCampeaoPorLetra();
        if (nome == null){
            return null;
        }
        System.out.println("Anotações da matchup: ");
        String anotacoes = sc.nextLine();
        System.out.println("Matchup criada com sucesso: " + nome.getNomeExibicao());
        return new Matchup(nome, anotacoes);
    }

    private void consultaMatchups(Matchup matchup){
        System.out.println("Matchup: " + matchup.getNome().getNomeExibicao());
        System.out.println("Anotações: " + matchup.getAnotacoes());
    }

    private void editaMatchup(){
        Matchup matchupEditada = escolheMatchup("editar");
        System.out.println("Novas anotações: ");
        String novasAnotacoes = sc.nextLine();
        matchupEditada.setAnotacoes(novasAnotacoes);
    }

    private Matchup escolheMatchup(String mensagem){
        List <Matchup> matchups = campeao.getMatchups();

        if (matchups.isEmpty()){
            System.out.println("Não há nenhuma matchup registrada ainda.");
            return null;
        }
        
        for (int i = 0; i < matchups.size(); i++){
            System.out.println((i+1) + " - " + matchups.get(i).getNome().getNomeExibicao());
        }

        int escolha = InputUtils.lerInteiro(sc, "Digite o número correspondente à matchup que deseja " + mensagem + ": ");

        if (escolha < 1 || escolha >matchups.size()){
            System.out.println("Opção inválida.");
            return null;
        }
        return matchups.get(escolha-1);
    }


    private NomeCampeao selecionaCampeaoPorLetra(){
        char x = InputUtils.letLetra(sc, "Insira a letra inicial do campeão inimigo: ");

        List <NomeCampeao> lista = NomeCampeao.filtrarPorLetra(x);

        ExibicaoUtils.exibeListaCampeoes(lista);

        int escolha = InputUtils.lerInteiro(sc, "Digite o número correspondente ao campeão: ");

        if (escolha < 1 || escolha > lista.size()){
            System.out.println("Opção inválida.");
            return null;
        }else{
            return lista.get(escolha-1);
        }
    }
}
