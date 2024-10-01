public class PetShopController {
    private PetShopService petShopService = new PetShopService();

    // Métodos para Proprietário

    // Cadastrar um novo proprietário
    public int cadastrarProprietario(String nome, String sexo, String cpf, String email, String celular) {
        Proprietario proprietario = new Proprietario(0, nome, sexo, cpf, email, celular);
        int idProprietario = petShopService.inserirProprietario(proprietario);
        System.out.println("Proprietário cadastrado com sucesso. ID: " + idProprietario);
        return idProprietario;
    }

    // Atualizar um proprietário existente
    public void atualizarProprietario(int id, String nome, String sexo, String cpf, String email, String celular) {
        Proprietario proprietario = new Proprietario(id, nome, sexo, cpf, email, celular);
        petShopService.atualizarProprietario(proprietario);
        System.out.println("Proprietário atualizado com sucesso.");
    }

    // Buscar proprietário por ID
    public Proprietario buscarProprietario(int id) {
        return petShopService.buscarProprietarioPorId(id);
    }

    // Deletar proprietário
    public void deletarProprietario(int id) {
        petShopService.deletarProprietario(id);
        System.out.println("Proprietário excluído com sucesso.");
    }

    // Métodos para Pet

    // Cadastrar um novo pet
    public int cadastrarPet(String nome, String idade, String sexo, String especie, String raca, int proprietarioId) {
        Proprietario proprietario = petShopService.buscarProprietarioPorId(proprietarioId);
        if (proprietario == null) {
            throw new RuntimeException("Proprietário não encontrado.");
        }
        Pet pet = new Pet(0, nome, idade, sexo, especie, raca, proprietario);
        int idPet = petShopService.inserirPet(pet);
        System.out.println("Pet cadastrado com sucesso. ID: " + idPet);
        return idPet;
    }

    // Atualizar um pet existente (Alterado para tratar idade como String)
    public void atualizarPet(int id, String nome, String idade, String sexo, String especie, String raca, int proprietarioId) {
        Proprietario proprietario = petShopService.buscarProprietarioPorId(proprietarioId);
        if (proprietario == null) {
            throw new RuntimeException("Proprietário não encontrado.");
        }
        Pet pet = new Pet(id, nome, idade, sexo, especie, raca, proprietario);  // Alterado para String idade
        petShopService.atualizarPet(pet);  // Certifique-se de que o método atualizar esteja implementado no serviço
        System.out.println("Pet atualizado com sucesso.");
    }

    // Deletar um pet
    public void deletarPet(int id) {
        petShopService.deletarPet(id);  // Supondo que o método exista no serviço
        System.out.println("Pet excluído com sucesso.");
    }

    // Métodos para Histórico de Evolução

    // Cadastrar um novo histórico de evolução
    public void cadastrarHistoricoEvolucao(int petId, String peso, String altura, String dataHora) {
        Pet pet = petShopService.buscarPetPorId(petId);
        if (pet == null) {
            throw new RuntimeException("Pet não encontrado.");
        }
        HistoricoEvolucao historico = new HistoricoEvolucao(0, pet, peso, altura, dataHora);
        petShopService.inserirHistoricoEvolucao(historico);
        System.out.println("Histórico de evolução cadastrado com sucesso.");
    }

    // Métodos para Vacina

    // Cadastrar uma nova vacina
    public void cadastrarVacina(int petId, String nome, String descricao, String dataAplicacao) {
        Pet pet = petShopService.buscarPetPorId(petId);  // Agora, usa o método correto para buscar o pet
        if (pet == null) {
            throw new RuntimeException("Pet não encontrado.");
        }
        Vacina vacina = new Vacina(0, pet, nome, descricao, dataAplicacao);
        petShopService.inserirVacina(vacina);
        System.out.println("Vacina cadastrada com sucesso.");
    }
}
