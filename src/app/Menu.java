package app;
import java.util.Scanner;

import content.SobreProjeto;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private int op = 0;
    public void iniciar(){
        System.out.println("Bem vindo ao MonoChampion SAGA!");
        System.out.println("1. Novo Main");
        System.out.println("4. Sobre o projeto.");
        System.out.println("\nEscolha uma opção");
        op = sc.nextInt();
        interacoesMenu(op);
    }
    
    private void interacoesMenu(int op){
        switch (op){
        case 1:
            
        
        case 4:
            System.out.println(SobreProjeto.TEXTO);
        }
    }
}
