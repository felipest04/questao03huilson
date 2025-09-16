package DAO;

import Entidade.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    // Conectar ao banco de dados
    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sua_base_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";
        return DriverManager.getConnection(url, usuario, senha);
    }

    // Função para buscar pessoas pelo nome
    public List<Pessoa> buscarPessoasPorNome(String nome) {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT id, nome FROM pessoas WHERE nome LIKE ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Definir o parâmetro da consulta (o '%' no LIKE é para buscar qualquer coisa antes e depois da letra fornecida)
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomePessoa = rs.getString("nome");
                pessoas.add(new Pessoa(id, nomePessoa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }
}
