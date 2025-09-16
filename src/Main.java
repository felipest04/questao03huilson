import DAO.PessoaDAO;
import Entidade.Pessoa;

import java.util.List;

public class Main {

    /*

A solução envolve a criação de uma função para buscar pessoas pelo nome no banco de dados usando JDBC e SQL.

Resumo da solução:

Classe Pessoa: Modelo para armazenar os dados da pessoa (ID e nome).

Função de busca (buscarPessoasPorNome):

Conecta ao banco de dados com JDBC.

Realiza uma consulta SQL com LIKE para buscar nomes que contenham o termo passado.

Usa PreparedStatement para segurança contra SQL Injection.

Retorna uma lista de objetos Pessoa com os resultados.

Execução:

No main, chamamos a função buscarPessoasPorNome com o nome desejado e exibimos os resultados.

Exemplo:

Se você passar "A", a consulta retorna pessoas com "A" no nome, como "Ana", "Amanda", etc.

Benefícios:

Uso seguro do banco de dados.

Busca flexível e eficiente.

Código simples e direto com PreparedStatement para evitar SQL Injection.*/
    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        List<Pessoa> pessoas = pessoaDAO.buscarPessoasPorNome("A");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
