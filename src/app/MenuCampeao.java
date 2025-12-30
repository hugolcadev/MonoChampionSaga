package app;
import java.util.Scanner;

import model.Campeao;
import service.PersistenciaService;



public class MenuCampeao {

    private Campeao campeao;
    private Scanner sc;

    public MenuCampeao(Campeao campeao, Scanner sc){
        this.campeao = campeao;
        this.sc = sc;
    }

    public void iniciar(){
        int op;
        do{
            imprimeMenu();
            op = sc.nextInt();
            interacoes(op);
        }while(op != 4);
    }
    

    private void imprimeMenu(){
        System.out.println("Menu do campeão: " + campeao.getNome().getNomeExibicao());
        System.out.println("1. Matchups");
        System.out.println("2. Editar anotações");
        System.out.println("3. Salvar campeão");
        System.out.println("4. Voltar ao menu principal");
        System.out.println("Escolha uma opção: ");
    }

    private void interacoes(int op){
        switch(op){
            case 1:
                MenuMatchups menuMatchups = new MenuMatchups(campeao, sc); 
                menuMatchups.iniciar();
                break;
            case 2:
                editaAnotacoes();
                break;
            case 3:
                salvaCampeao();
                break;
            case 4: 
                System.out.println("Voltando ao menu principal..");
                break;
        }
    }

    private void editaAnotacoes(){
        sc.nextLine();
        System.out.println("Novas anotações: ");
        String novasAnotacoes = sc.nextLine();
        campeao.setAnotacoes(novasAnotacoes);
        System.out.println("Anotações atualizadas.");
    }

    private void salvaCampeao(){
        PersistenciaService.salvarCampeao(campeao);
    }
}
