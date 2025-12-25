package model;
public class Campeao {
    private NomeCampeao nome;
    private String anotacoes;
    
    //private String build;
    //private String runas;
    public Campeao(NomeCampeao nome, String anotacoes) {
        this.nome = nome;
        this.anotacoes = anotacoes;
        //this.build = build;
        //this.runas = runas;
    }
    public Campeao(){

    }

    public NomeCampeao getNome() {
        return nome;
    }
    public String getAnotacoes() {
        return anotacoes;
    }
    public void setNome(NomeCampeao nome) {
        this.nome = nome;
    }
    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

}
