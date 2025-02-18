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
    private JButton adicionarButton;
    private JButton removerButton;
    private JButton editarButton;
    private JPanel pedido;
    private JPanel historico;
    private JPanel btnContainer2;
    private JButton adicionarButton1;
    private JButton removerButton1;
    private JButton editarButton1;
    private JPanel btnContainer3;
    private JButton adicionarButton2;
    private JButton removerButton2;
    private JButton editarButton3;
    private JPanel content2;
    private JPanel content3;
    private JPanel content1;
    private JTable table1;
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

    public App() {
        setContentPane(Root);
        setModal(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        Root.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void loadTable() {
        String[][] data = {
                {"joao", "23", "slz"},
                {"joao", "23", "slz"},
                {"joao", "23", "slz"},
        };
        String[] row = {"joao", "23", "slz"};
        String[] collumNames = {"nome", "age", "uf"};

        DefaultTableModel modelo = new DefaultTableModel(data, collumNames);
        tabelaPedido.setModel(modelo);
    }

    public static void main(String[] args) {
        App dialog = new App();
        dialog.loadTable();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
