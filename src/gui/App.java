package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class App extends JDialog {
    private JPanel Root;
    private JLabel Titulo;
    private JTabbedPane abas;
    private JPanel estoque;
    private JPanel btnContainer1;
    private JButton removerButton;
    private JButton editarButton;
    private JPanel pedido;
    private JPanel btnContainer2;
    private JButton btnAdiciona;
    private JButton btnRemove;
    private JButton btnEdit;
    private JPanel content2;
    private JTable tabelaEstoque;
    private JTextField inputNome;
    private JTextField inputPreco;
    private JSpinner inputQuantidade;
    private JPanel FormCadastro;
    private JLabel lblNome;
    private JLabel lblPreco;
    private JLabel lblQuantidade;
    private JLabel Produto;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JPanel inputs;
    private JLabel labelQuantidade1;
    private JLabel lblDesconto;
    private JSpinner spinner2;
    private JPanel registros2;
    private JLabel lblProduto;
    private JLabel lblQtd;
    private JLabel lblValor;
    private JTable tabelaPedido;
    private JLabel lblTotal;
    private JButton adicionarButton1;
    private JButton btnAdd;
    private JTextField inputQtd;

    public App() {
        setContentPane(Root);
        setModal(true);

        btnAdd.addActionListener(e -> {
            if (inputNome.getText().isEmpty() || inputPreco.getText().isEmpty() || inputQtd.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "preencha todos os campos!");
            }
            else {
                // inputs to array
                String[] data = {inputNome.getText(), inputPreco.getText(), inputQtd.getText()};
                DefaultTableModel tableModel = (DefaultTableModel) tabelaEstoque.getModel();
                tableModel.addRow(data); // add
                // clear
                inputNome.setText("");
                inputPreco.setText("");
                inputQtd.setText("");
                System.out.println(123);
            }
        });
    }

    private void btnDeleteAction(ActionEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) tabelaEstoque.getModel();

        int linhaSelecionada = tabelaEstoque.getSelectedRow();
        // Verificando se há uma linha selecionada
        if (linhaSelecionada != -1) {
            // Removendo a linha selecionada
            tableModel.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(getParent(), "Selecione uma linha para remover.");
        }

    }

    private void btnAddAction(ActionEvent e) {
        if (inputNome.getText().isEmpty() || inputPreco.getText().isEmpty() || inputQtd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "preencha todos os campos!");
        }
        else {
            // inputs to array
            String[] data = {inputNome.getText(), inputPreco.getText(), inputQtd.getText()};
            DefaultTableModel tableModel = (DefaultTableModel) tabelaEstoque.getModel();
            tableModel.addRow(data); // add
            // clear
        }

    }



    public static void main(String[] args) {

        String[][] data = {
                {"ana", "jessica", "caroline"},
                {"ana", "jessica", "caroline"},
                {"ana", "jessica", "caroline"}
        };

        String[] columnNames = {"nome", "age", "price"};

        App dialog = new App();

        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        dialog.tabelaPedido.setModel(modelo);
        dialog.pack();


        dialog.setVisible(true);
        System.exit(0);
    }
}
