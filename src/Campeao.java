public class Campeao {
    private String nome;
    private String anotacoes;
    private String build;
    private String runas;
    public Campeao(String nome, String anotacoes, String build, String runas) {
        this.nome = nome;
        this.anotacoes = anotacoes;
        this.build = build;
        this.runas = runas;
    }
    public String getNome() {
        return nome;
    }
    public String getAnotacoes() {
        return anotacoes;
    }
    public String getBuild() {
        return build;
    }
    public String getRunas() {
        return runas;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
    public void setBuild(String build) {
        this.build = build;
    }
    public void setRunas(String runas) {
        this.runas = runas;
    }

    

}
