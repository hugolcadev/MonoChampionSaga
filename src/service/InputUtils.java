package service;

import java.util.Scanner;

public class InputUtils {
    
    public static int lerInteiro(Scanner sc, String mensagem){
        while(true) {
            System.out.println(mensagem);
            String entrada = sc.nextLine();

            try{
                return Integer.parseInt(entrada);
            }catch(NumberFormatException e){
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }

    public static char letLetra(Scanner sc, String mensagem){
        while (true){
            System.out.println(mensagem);
            String entrada = sc.nextLine().trim();

            if (entrada.length() == 1 && Character.isLetter(entrada.charAt(0))){
                return Character.toUpperCase(entrada.charAt(0));
            }

            System.out.println("Digite apenas uma letra.");
        }
    }
}


