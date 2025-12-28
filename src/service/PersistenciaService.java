package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import model.Campeao;

public class PersistenciaService{
    private static final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    public static void salvarCampeao(Campeao campeao){
        String nomeArquivo = campeao.getNome().name().toLowerCase() + ".json";

        try (FileWriter writer = new FileWriter(nomeArquivo)){
            gson.toJson(campeao, writer);
            System.out.println("Campeão salvo em " + nomeArquivo);
        } catch (IOException e){
            System.out.println("Erro ao salvar campeão.");
        }
    }

    public static Campeao carregarCampeao(String nomeArquivo){
        try (FileReader reader = new FileReader(nomeArquivo)){
            return gson.fromJson(reader, Campeao.class);
        }catch (IOException e){
            System.out.println("Erro ao carregar campeão.");
            return null;
        }
    }
}