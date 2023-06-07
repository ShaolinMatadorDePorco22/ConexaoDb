package unipar.exemplo.ui;

import unipar.exemplo.entity.Cliente;
import unipar.exemplo.repository.cliente.RepositoryCliente;
import unipar.exemplo.repository.produto.RepositoryProduto;
import unipar.exemplo.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCadastroCliente {
    private JTextField textId;
    private JTextField textNome;
    private JTextField textCnpj;
    private JTextField textTelefone;
    private JTextField textEmail;
    private JTextField textSituacao;
    private JTextField textCidade;
    private JTextField textEstado;
    private JTextField textCredito;
    private JButton btnCadastroCliente;
    public JPanel formCadastroCliente;
    private JTable tabelaCliente;
    private JComboBox comboBox1;


    public TelaCadastroCliente() {
    //carregarDadosCliente();

    btnCadastroCliente.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Cliente novoCliente = new Cliente();

            novoCliente.setId(Utils.convertInteger(textId));
            novoCliente.setNome(textNome.getText());
            novoCliente.setCnpj(textCnpj.getText());
            novoCliente.setTelefone(textTelefone.getText());
            novoCliente.setEmail(textEmail.getText());
            novoCliente.setSituacao(textSituacao.getText());
            novoCliente.setCidade(textCidade.getText());
            novoCliente.setEstado(textEstado.getText());
            novoCliente.setCredito(Utils.convertDouble(textCredito));

            RepositoryCliente repo = new RepositoryCliente();
            Integer retorno = repo.inserirCliente(novoCliente);

            Utils.validarRetorno(retorno);



        }
    });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


   /* private void carregarDadosCliente() {
        tabelaCliente.setModel(new DefaultTableModel(null,
                new Object[]{"ID", "Nome", "CNPJ", "Telefone", "Email", "Situacao", "Cidade", "Estado", "Credito"}));


        RepositoryCliente repo = new RepositoryCliente();
        List<Cliente> listaClienteBanco = repo.buscarCliente();

        DefaultTableModel tabela = (DefaultTableModel) tabelaCliente.getModel();

        listaClienteBanco.forEach(cliente -> {
            tabela.addRow(new Object[]{cliente.getId(),
                    cliente.getNome(),
                    cliente.getCnpj(),
                    cliente.getTelefone(),
                    cliente.getEmail(),
                    cliente.getSituacao(),
                    cliente.getCidade(),
                    cliente.getEstado(),
                    cliente.getCredito()});


        });*/
    }





