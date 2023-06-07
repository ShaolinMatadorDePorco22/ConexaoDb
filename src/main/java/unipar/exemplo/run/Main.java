package unipar.exemplo.run;

import unipar.exemplo.entity.Produto;
import unipar.exemplo.repository.cliente.RepositoryCliente;
import unipar.exemplo.repository.produto.RepositoryProduto;


public class Main {

    public static void main(String[] args) {


        RepositoryProduto repo = new RepositoryProduto();
        repo.buscarProduto();

        //clientes
        RepositoryCliente busca = new RepositoryCliente();
        busca.buscarCliente();




    }

}
