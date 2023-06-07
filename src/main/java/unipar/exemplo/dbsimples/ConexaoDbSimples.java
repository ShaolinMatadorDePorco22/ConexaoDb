package unipar.exemplo.dbsimples;

import java.sql.*;

public class ConexaoDbSimples {
    public static void main(String[] args) throws SQLException {

        conectarBancoDeDados();

    }

    public static void conectarBancoDeDados() throws SQLException {

        String url = "jdbc:posgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "admin123";



        try{
            //iniciamos a criacao da conexao com o banco
            Connection conn = DriverManager.getConnection(url, username, password);

            //cria a interface para a conexao com o banco de dados
            //nela vamos executar o select, insert, update, delete
            Statement statement = conn.createStatement();

            Integer codigoWhere = 1;

            //executa comando SQL
            ResultSet result = statement.executeQuery("SELECT * FROM produtos where codigo =" + codigoWhere);



            while (result.next()){
                Integer codigo = result.getInt("codigo");
                String nome = result.getString("nome");
                String ean = result.getString("eans");
                Double preco = result.getDouble("preco");

                System.out.println("Cadastro produto");
                System.out.println("Codigo" + codigo);
                System.out.println("Nome" + nome);
                System.out.println("EAN" + ean);
                System.out.println("Preco" + preco);

            }

            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        }

        }



