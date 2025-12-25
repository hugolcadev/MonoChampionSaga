package app;
import java.util.List;
import java.util.Scanner;

import content.SobreProjeto;
import model.Campeao;
import model.NomeCampeao;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private int op = 0;
    public void iniciar(){
        System.out.println("Bem vindo ao MonoChampion SAGA!");
        System.out.println("1. Novo Main.");
        System.out.println("2. Carregar progresso existente.");
        System.out.println("3. Sobre o projeto.");
        System.out.println("4. Sair.");
        System.out.println("\nEscolha uma opção");
        op = sc.nextInt();
        interacoesMenu(op);
    }
    
    private void interacoesMenu(int op){
        switch (op){
        case 1:
            criarNovoCampeao();
            break;
        case 2:     
            //carregarProgressoExistente();
            //break;       
            //TODO
        case 3:
            mostrarSobreProjeto();
            break;
        case 4:
            //sair();
            //break;
        }
    }

    private void criarNovoCampeao(){
        System.out.println("Digite a letra inicial do campeão: ");
        char x = sc.next().charAt(0);
        exibeListaCampeoes(NomeCampeao.filtrarPorLetra(x));
        System.out.println("Digite o número correspondente ao seu campeão: ");
    }
    private void mostrarSobreProjeto(){
        System.out.println(SobreProjeto.TEXTO);
    }

    public void exibeListaCampeoes(List<NomeCampeao> lista){
        for (int i=0; i<lista.size(); i++){
            System.out.println((i+1) + " - " + lista.get(i).getNomeExibicao());
        }
    }
}
