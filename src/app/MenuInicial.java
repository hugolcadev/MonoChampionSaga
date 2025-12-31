package app;
import java.util.List;
import java.util.Scanner;

import content.SobreProjeto;
import model.Campeao;
import model.NomeCampeao;
import service.ExibicaoUtils;
import service.InputUtils;
import service.PersistenciaService;



public class MenuInicial {
    private Scanner sc = new Scanner(System.in);
    private int op = 0;
    Boolean menuAtivo = true;
    public void iniciar(){
        
        do{
        imprimeMenu();
        op = InputUtils.lerInteiro(sc, "\nEscolha uma opção: ");
        interacoes(op);
        }while(menuAtivo);
    }
    
    private void interacoes(int op){
        switch (op){
        case 1:
            Campeao campeaoPrincipal = criaNovoCampeao();
            MenuCampeao menuCampeao = new MenuCampeao(campeaoPrincipal, sc);
            menuCampeao.iniciar();
            break;
        case 2:
            Campeao campeaoCarregado = carregaCampeao();
            MenuCampeao menuCampeaoCarregado = new MenuCampeao(campeaoCarregado, sc);
            menuCampeaoCarregado.iniciar();
            break;       
        case 3:
            mostraSobreProjeto();
            break;
        case 4:
            sair();
            break;
        }
    }
    
    void imprimeMenu(){
        System.out.println("Bem vindo ao MonoChampion SAGA!\n");
        System.out.println("1. Novo Main.");
        System.out.println("2. Carregar progresso existente.");
        System.out.println("3. Sobre o projeto.");
        System.out.println("4. Sair.");
    }

    private Campeao criaNovoCampeao(){
        NomeCampeao nome = selecionaCampeaoPorLetra();

        if (nome == null){
            return null;
        }

        System.out.println("\nAnotações iniciais: ");
        String anotacoes = sc.nextLine();
        System.out.println("\nMain criado com sucesso: " + nome.getNomeExibicao());
        return new Campeao(nome, anotacoes);
    }

    private Campeao carregaCampeao(){
        List<String> listaArquivosSalvos = PersistenciaService.listarArquivosSalvos();
        exibeListaArquivosSalvos(listaArquivosSalvos);
        int escolha = InputUtils.lerInteiro(sc, "Digite o número correspondente ao campeão: ");
        Campeao campeaoCarregado = PersistenciaService.carregarCampeao(listaArquivosSalvos.get(escolha-1));
        return campeaoCarregado;
    }

    private void mostraSobreProjeto(){
        System.out.println(SobreProjeto.TEXTO);
    }

    

    private NomeCampeao selecionaCampeaoPorLetra(){

        char x = InputUtils.letLetra(sc, "\nDigite a letra inicial do campeão: ");

        List <NomeCampeao> lista = NomeCampeao.filtrarPorLetra(x);

        if (lista.isEmpty()){
            System.out.println("Nenhum campeão encontrado.");
            return null;
        }
        
        ExibicaoUtils.exibeListaCampeoes(lista);

        int escolha = InputUtils.lerInteiro(sc, "\nDigite o número correspondente ao campeão: ");

        if (escolha < 1 || escolha > lista.size()){
            System.out.println("Opção inválida.");
            return null;
        }else{
            return lista.get(escolha-1);
        }
    }

    private void exibeListaArquivosSalvos(List<String> lista){
        for (int i=0; i<lista.size(); i++){
            System.out.println((i+1) + " - " + lista.get(i));
        }
    }

    private void sair(){
        menuAtivo = false;
    }
}

    