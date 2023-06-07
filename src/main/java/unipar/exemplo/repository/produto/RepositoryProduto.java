package unipar.exemplo.repository.produto;

import unipar.exemplo.connection.ConnectionGeneric;
import unipar.exemplo.entity.Produto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProduto {

    public Integer inserirProduto(Produto produto){

        try {
            //conexao
            ConnectionGeneric connection = new ConnectionGeneric();
            connection.getConnection();

            //insertBD
            String query = "INSERT INTO produtos (codigo, nome, ean, preco)" +
                    "VALUES ("+produto.getCodigo()+", '"+produto.getNome()+"', '"+produto.getEan()
                    + "'," +produto.getPreco() +" )";
            System.out.println(query);

            Integer retorno = connection.statement.executeUpdate(query);

            connection.closeConnection();
            return retorno;
            /*
            System.out.println(retorno);

            /*if (retorno == 1){
                System.out.println("cadastrado com sucesso");
            }else{
                System.out.println("problema ao cadastrar");
            }

            connection.closeConnection();
        */
         }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }
    public void alterarProduto(){}
    public void deletarProduto(){}


    public List <Produto> buscarProduto(){
        ConnectionGeneric connection = new ConnectionGeneric();

        try {
            List<Produto> listaRetorno = new ArrayList<>();
            connection.getConnection();
            String query = "SELECT * FROM produtos";

            ResultSet result = connection.statement.executeQuery(query);

            while (result.next()){
                //retorna dados do banco
                Integer codigo = result.getInt("codigo");
                String nome = result.getString("nome");
                String ean = result.getString("ean");
                Double preco = result.getDouble("preco");

                //joga dados em um objeto produto
                Produto produtoBanco = new Produto();
                produtoBanco.setCodigo(codigo);
                produtoBanco.setNome(nome);
                produtoBanco.setEan(ean);
                produtoBanco.setPreco(preco);

                //guarda objeto lista retorno
                listaRetorno.add(produtoBanco);

                /*System.out.println("----------Cadastro produto---------");
                System.out.println("Codigo: " + codigo);
                System.out.println("Nome: " + nome);
                System.out.println("EAN: " + ean);
                System.out.println("Preco: " + preco);*/

            }


            connection.closeConnection();
            return listaRetorno;



        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    }
}
