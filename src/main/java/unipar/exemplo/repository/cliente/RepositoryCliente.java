package unipar.exemplo.repository.cliente;

import unipar.exemplo.connection.ConnectionGeneric;
import unipar.exemplo.entity.Cliente;
import unipar.exemplo.entity.Produto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryCliente {

    public Integer inserirCliente(Cliente cliente){

        try {
            //conexao
            ConnectionGeneric connection = new ConnectionGeneric();
            connection.getConnection();

            //insertBD
            String query = "INSERT INTO clientes (id, nome, cnpj, telefone, email, situacao, cidade, estado, credito)" +
                    "VALUES ("+cliente.getId()+", '"+cliente.getNome()+"', '"+cliente.getCnpj()
                    + "','" +cliente.getTelefone() +"', '"+cliente.getEmail()+"', '"+cliente.getSituacao()+"', '"+cliente.getCidade()+"', '"+cliente.getEstado()+"'" +
                    ", '"+cliente.getCredito()+"' )";
            Integer retorno = connection.statement.executeUpdate(query);
            connection.closeConnection();
            return retorno;

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }





    }
    public void alterarCliente(){}
    public void deletarCliente(){}



    public List<Cliente> buscarCliente(){
        ConnectionGeneric connection = new ConnectionGeneric();

        try {
            List<Cliente> listaRetorno = new ArrayList<>();
            connection.getConnection();
            String query = "SELECT * FROM clientes";

            ResultSet result = connection.statement.executeQuery(query);

            while (result.next()){

                Integer id = result.getInt("id");
                String nome = result.getString("nome");
                String cnpj = result.getString("cnpj");
                String telefone = result.getString("telefone");
                String email = result.getString("email");
                String situacao = result.getString("situacao");
                String cidade = result.getString("cidade");
                String estado = result.getString("estado");
                Double credito = result.getDouble("credito");


                Cliente clienteBanco = new Cliente();
                clienteBanco.setId(id);
                clienteBanco.setSituacao(situacao);
                clienteBanco.setNome(nome);
                clienteBanco.setCnpj(cnpj);
                clienteBanco.setTelefone(telefone);
                clienteBanco.setEstado(estado);
                clienteBanco.setCidade(cidade);
                clienteBanco.setCredito(credito);
                clienteBanco.setEmail(email);

                listaRetorno.add(clienteBanco);

                /*System.out.println("----------Cadastro cliente---------");
                System.out.println("id: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("CNPJ: " + cnpj);
                System.out.println("telefone: " + telefone);
                System.out.println("email: " + email);
                System.out.println("situacao: " + situacao);
                System.out.println("cidade: " + cidade);
                System.out.println("estado: " + estado);
                System.out.println("credito: " + credito);*/

            }


            connection.closeConnection();
            return listaRetorno;




        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

}
