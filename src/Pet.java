public class Pet {
    private int id;
    private String nome;
    private String idade;  // Alterado para String
    private String sexo;
    private String especie;
    private String raca;
    private Proprietario proprietario;

    // Construtor, Getters e Setters
    public Pet(int id, String nome, String idade, String sexo, String especie, String raca, Proprietario proprietario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;  // Alterado para String
        this.sexo = sexo;
        this.especie = especie;
        this.raca = raca;
        this.proprietario = proprietario;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {  // Alterado para String
        return idade;
    }

    public void setIdade(String idade) {  // Alterado para String
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
