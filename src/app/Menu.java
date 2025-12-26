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
            criaNovoCampeao();
            break;
        case 2:     
            //carregarProgressoExistente();
            //break;       
            //TODO
        case 3:
            mostraSobreProjeto();
            break;
        case 4:
            //sair();
            //break;
        }
    }

    private void criaNovoCampeao(){
        NomeCampeao nome = selecionarCampeaoPorLetra();

        if (nome == null){
            return;
        }

        sc.nextLine();
        System.out.println("Anotações iniciais: ");
        String anotacoes = sc.nextLine();

        Campeao campeaoPrincipal = new Campeao(nome, anotacoes);

        System.out.println("Main criado com sucesso: " + campeaoPrincipal.getNome().getNomeExibicao());
    }
    private void mostraSobreProjeto(){
        System.out.println(SobreProjeto.TEXTO);
    }

    public void exibeListaCampeoes(List<NomeCampeao> lista){
        for (int i=0; i<lista.size(); i++){
            System.out.println((i+1) + " - " + lista.get(i).getNomeExibicao());
        }
    }

    private NomeCampeao selecionarCampeaoPorLetra(){

        System.out.println("Digite a letra inicial do campeão: ");
        char x = sc.next().charAt(0);

        List <NomeCampeao> lista = NomeCampeao.filtrarPorLetra(x);

        if (lista.isEmpty()){
            System.out.println("Nenhum campeão encontrado.");
            return null;
        }

        exibeListaCampeoes(lista);

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

    