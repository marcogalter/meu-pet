public class Vacina {
    private int id;
    private Pet pet;
    private String nome;
    private String descricao;
    private String dataAplicacao;

    // Construtor, Getters e Setters
    public Vacina(int id, Pet pet, String nome, String descricao, String dataAplicacao) {
        this.id = id;
        this.pet = pet;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAplicacao = dataAplicacao;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}
