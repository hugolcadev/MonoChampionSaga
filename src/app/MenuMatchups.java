package app;
import java.util.Scanner;

import model.Matchup;
import model.NomeCampeao;
import service.ExibicaoUtils;
import model.Campeao;
import model.NomeCampeao;
import app.MenuInicial;
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
            op = sc.nextInt();
            interacoes(op);
        }while(op!=4);
    }

    private void imprimeMenu(){
        System.out.println("1. Nova matchup");
        System.out.println("2. Listar matchups");
        System.out.println("3. Editar matchups");
        System.out.println("4. Sair");
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
                //listaMatchups();
                break;
            case 3:
                //editaMatchup();
                break;
        }
    }

    private Matchup criaMatchup(){
        System.out.println("Criando nova matchup..");
        NomeCampeao nome = selecionaCampeaoPorLetra();
        if (nome == null){
            return null;
        }
        sc.nextLine();
        System.out.println("Anotações da matchup: ");
        String anotacoes = sc.nextLine();
        System.out.println("Matchup criada com sucesso: " + nome.getNomeExibicao());
        return new Matchup(nome, anotacoes);
    }

    private NomeCampeao selecionaCampeaoPorLetra(){
        System.out.println("Insira a letra inicial do campeão inimigo: ");
        char x = sc.next().charAt(0);

        List <NomeCampeao> lista = NomeCampeao.filtrarPorLetra(x);

        ExibicaoUtils.exibeListaCampeoes(lista);

        System.out.println("Digite o número correspondente ao campeão: ");
        int escolha = sc.nextInt();

        if (escolha < 1 || escolha > lista.size()){
            System.out.println("Opção inválida.");
            return null;
        }else{
            return lista.get(escolha-1);
        }
    }
}
