package gui;

import javax.swing.*;
import java.awt.event.*;

public class App extends JDialog {
    private JPanel Root;
    private JButton buttonOK;
    private JButton buttonCancel;
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

    public App() {
        setContentPane(Root);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

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

    public static void main(String[] args) {
        App dialog = new App();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
