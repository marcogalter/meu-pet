public class HistoricoEvolucao {
    private int id;
    private Pet pet;
    private String peso;   // Alterado para String
    private String altura; // Alterado para String
    private String dataHora;

    // Construtor da classe HistoricoEvolucao
    public HistoricoEvolucao(int id, Pet pet, String peso, String altura, String dataHora) {
        this.id = id;
        this.pet = pet;
        this.peso = peso;
        this.altura = altura;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
