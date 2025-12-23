package app;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    int op = 0;
    public void iniciar(){
        System.out.println("Bem vindo ao MonoChampion SAGA!");
        System.out.println("1. Novo Main");
        System.out.println("4. Sobre o projeto.");
        System.out.println("\nEscolha uma opção");
        sc.nextInt(op);
    }
    public void sobreProjeto(){
        
    }
}
