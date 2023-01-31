package aula03;

public class Ave {
    private String nome;
    private boolean isVoa;
    private boolean isNada;

    Ave(String nome, boolean isVoa, boolean isNada) {
        this.nome = nome;
        this.isVoa = isVoa;
        this.isNada = isNada;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVoa() {
        return isVoa;
    }

    public boolean isNada() {
        return isNada;
    }
}
