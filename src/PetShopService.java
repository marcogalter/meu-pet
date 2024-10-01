import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetShopService {

    // Inserir Proprietário
    // Inserir Proprietário
    public int inserirProprietario(Proprietario proprietario) {
        String sql = "INSERT INTO Proprietario (nome, sexo, cpf, email, celular) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getSexo());
            stmt.setString(3, proprietario.getCpf());
            stmt.setString(4, proprietario.getEmail());
            stmt.setString(5, proprietario.getCelular());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);  // Retorna o ID gerado
                    }
                }
            }

            throw new RuntimeException("Erro ao cadastrar o proprietário, nenhum ID gerado.");

        } catch (SQLException e) {
            // Verificar a mensagem da exceção para identificar violação de chave única
            if (e.getMessage().contains("UNIQUE constraint failed: Proprietario.email")) {
                throw new RuntimeException("Este email já existe no nosso sistema.");
            } else if (e.getMessage().contains("UNIQUE constraint failed: Proprietario.cpf")) {
                throw new RuntimeException("Este CPF já existe no nosso sistema.");
            } else if (e.getMessage().contains("UNIQUE constraint failed: Proprietario.celular")) {
                throw new RuntimeException("Este celular já existe no nosso sistema.");
            } else {
                throw new RuntimeException("Erro ao inserir o proprietário: " + e.getMessage());
            }
        }
    }

    

    // Inserir Pet
    // Inserir Pet
    public int inserirPet(Pet pet) {
        String sql = "INSERT INTO Pet (nome, idade, sexo, especie, raca, proprietario_id) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getIdade());  // Alterado para String
            stmt.setString(3, pet.getSexo());
            stmt.setString(4, pet.getEspecie());
            stmt.setString(5, pet.getRaca());
            stmt.setInt(6, pet.getProprietario().getId());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);  // Retorna o ID gerado
                    }
                }
            }

            throw new RuntimeException("Erro ao cadastrar o pet, nenhum ID gerado.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o pet: " + e.getMessage());
        }
    }

        // Deletar Pet
    public void deletarPet(int id) {
        String sql = "DELETE FROM Pet WHERE id = ?";

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar pet: " + e.getMessage());
        }
    }

    // Atualizar Pet
    public void atualizarPet(Pet pet) {
        String sql = "UPDATE Pet SET nome = ?, idade = ?, sexo = ?, especie = ?, raca = ?, proprietario_id = ? WHERE id = ?";

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getIdade());  // Idade como String
            stmt.setString(3, pet.getSexo());
            stmt.setString(4, pet.getEspecie());
            stmt.setString(5, pet.getRaca());
            stmt.setInt(6, pet.getProprietario().getId());
            stmt.setInt(7, pet.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar pet: " + e.getMessage());
        }
    }
    

    // Inserir Histórico de Evolução
    // Inserir Histórico de Evolução
    public void inserirHistoricoEvolucao(HistoricoEvolucao historico) {
        String sql = "INSERT INTO HistoricoEvolucao (pet_id, peso, altura, data_hora) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, historico.getPet().getId());
            stmt.setString(2, historico.getPeso());   // Alterado para setString
            stmt.setString(3, historico.getAltura()); // Alterado para setString
            stmt.setString(4, historico.getDataHora());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir histórico de evolução: " + e.getMessage());
        }
    }


    // Inserir Vacina
    public void inserirVacina(Vacina vacina) {
        String sql = "INSERT INTO Vacina (pet_id, nome, descricao, data_aplicacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vacina.getPet().getId());
            stmt.setString(2, vacina.getNome());
            stmt.setString(3, vacina.getDescricao());
            stmt.setString(4, vacina.getDataAplicacao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir vacina: " + e.getMessage());
        }
    }

    // Métodos de Busca, Atualização e Exclusão (exemplo para Proprietario)

    // Buscar Proprietário por ID
    public Proprietario buscarProprietarioPorId(int id) {
        String sql = "SELECT * FROM Proprietario WHERE id = ?";
        Proprietario proprietario = null;

        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                proprietario = new Proprietario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("celular")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar proprietário: " + e.getMessage());
        }

        return proprietario;
    }

    // Método para buscar Pet por ID
        // Método para buscar Pet por ID
        public Pet buscarPetPorId(int id) {
            String sql = "SELECT * FROM Pet WHERE id = ?";
            Pet pet = null;

            try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // Buscando o proprietário associado ao pet
                    Proprietario proprietario = buscarProprietarioPorId(rs.getInt("proprietario_id"));

                    pet = new Pet(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("idade"),  // Alterado para String
                        rs.getString("sexo"),
                        rs.getString("especie"),
                        rs.getString("raca"),
                        proprietario
                    );
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar pet: " + e.getMessage());
            }

            return pet;
        }



    // Atualizar Proprietário
    public void atualizarProprietario(Proprietario proprietario) {
        String sql = "UPDATE Proprietario SET nome = ?, sexo = ?, cpf = ?, email = ?, celular = ? WHERE id = ?";

        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getSexo());
            stmt.setString(3, proprietario.getCpf());
            stmt.setString(4, proprietario.getEmail());
            stmt.setString(5, proprietario.getCelular());
            stmt.setInt(6, proprietario.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar proprietário: " + e.getMessage());
        }
    }

    // Deletar Proprietário
    public void deletarProprietario(int id) {
        String sql = "DELETE FROM Proprietario WHERE id = ?";

        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar proprietário: " + e.getMessage());
        }
    }

    // Outros métodos para Pet, Histórico de Evolução e Vacina podem ser adicionados da mesma forma

}
