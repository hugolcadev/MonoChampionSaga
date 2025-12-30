package service;

import java.util.List;

import model.NomeCampeao;

public class ExibicaoUtils {
    
    private ExibicaoUtils(){

    }

    public static void exibeListaCampeoes(List<NomeCampeao> lista){
        for (int i=0; i<lista.size(); i++){
            System.out.println((i+1) + " - " + lista.get(i).getNomeExibicao());
        }
    }

}
