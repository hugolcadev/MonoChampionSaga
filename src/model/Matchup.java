package model;

public class Matchup {
    private NomeCampeao oponente;
    private String anotacoes;

    public Matchup (NomeCampeao nome, String anotacoes){
        this.oponente = nome;
        this.anotacoes = anotacoes;
    }

    public Matchup (NomeCampeao nome){
        this.oponente = nome;
    }

    public NomeCampeao getNome() {
        return oponente;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setNome(NomeCampeao nome) {
        this.oponente = nome;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    
}
