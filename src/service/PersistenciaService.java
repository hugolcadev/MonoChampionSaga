package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

import model.Campeao;
import model.NomeCampeao;

public class PersistenciaService{
    private static final String PASTA = "saves/";
    private static final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    public static void salvarCampeao(Campeao campeao){
        File pasta = new File("saves");
        if (!pasta.exists()){
            pasta.mkdir();
        }

        String nomeArquivo = "saves" + File.separator + campeao.getNome().name().toLowerCase() + ".json";

        try (FileWriter writer = new FileWriter(nomeArquivo)){
            gson.toJson(campeao, writer);
            System.out.println("Campeão salvo em " + nomeArquivo);
        } catch (IOException e){
            System.out.println("Erro ao salvar campeão.");
        }
    }

    public static Campeao carregarCampeao(String nomeArquivo){
        try (FileReader reader = new FileReader(PASTA + nomeArquivo + ".json")){
            return gson.fromJson(reader, Campeao.class);
        }catch (IOException e){
            System.out.println("Erro ao carregar campeão.");
            return null;
        }
    }

    public static List<String> listarArquivosSalvos(){
        List<String> arquivos = new ArrayList<>();
        File pasta = new File(PASTA);
        if (!pasta.exists() || !pasta.isDirectory()){
            return arquivos;
        }

        File[] files = pasta.listFiles((dir, name) -> name.endsWith(".json"));

        if (files != null){
            for (File f: files){
                String nome = f.getName();
                nome = nome.replace(".json", "");
                arquivos.add(nome);
            }
        }

        return arquivos;
    }
}