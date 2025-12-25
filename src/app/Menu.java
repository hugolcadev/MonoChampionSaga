package app;
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
            //TODO
        case 2:            
            //TODO
        case 3:
            System.out.println(SobreProjeto.TEXTO);
        
        case 4:
            return;
        }
    }

    private void criarNovoCampeao(){
        NomeCampeao nome;
        String anotacoes;
        System.out.println();
        
    }
}
