package app;
import model.Campeao;
import java.util.Scanner;

public class MenuCampeao {

    private Campeao campeao;
    private Scanner sc;

    public MenuCampeao(Campeao campeao, Scanner sc){
        this.campeao = campeao;
        this.sc = sc;
    }

    public void iniciar(Campeao campeao){
        int op;
        do{
            imprimeMenu();
            op = sc.nextInt();
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
                //menuMatchups.iniciar();
                break;
            case 2:
                
        }
    }
}
