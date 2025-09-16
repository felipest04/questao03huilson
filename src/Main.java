import DAO.PessoaDAO;
import Entidade.Pessoa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        List<Pessoa> pessoas = pessoaDAO.buscarPessoasPorNome("A");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
