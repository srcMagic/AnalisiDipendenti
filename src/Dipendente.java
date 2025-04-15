public class Dipendente {

    private String nome;
    private int eta;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipendente(String nome) {
        this.nome = nome;
    }

    public Dipendente(String nome, int eta, double stipendio, Dipartimento dipartimento) {
        this.nome = nome;
        this.eta = eta;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    public enum Dipartimento {HR, IT, FINANCE, SALES}

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                ", stipendio=" + stipendio +
                ", dipartimento=" + dipartimento +
                '}';
    }
}