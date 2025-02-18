package mercado2;

import mercado2.ItemPedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App extends JFrame {
    private List<Produto> listaProdutos = new ArrayList<>();
    private List<Pedido> listaPedidos = new ArrayList<>();

    private JTable tabelaProdutos, tabelaPedidos;
    private DefaultTableModel modeloProdutos, modeloPedidos;
    private static int contador = 1;

    public App() {
        super("Farmácia/Mercadinho"); // Define o título da janela
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabela de Produtos
        String[] colunasProdutos = {"ID", "Nome", "Preço", "Quantidade"};
        modeloProdutos = new DefaultTableModel(colunasProdutos, 0);
        tabelaProdutos = new JTable(modeloProdutos);
        JScrollPane scrollProdutos = new JScrollPane(tabelaProdutos);

        // Tabela de Pedidos
        String[] colunasPedidos = {"ID Pedido", "Itens", "Quantidades", "Total (R$)"};
        modeloPedidos = new DefaultTableModel(colunasPedidos, 0);
        tabelaPedidos = new JTable(modeloPedidos);
        JScrollPane scrollPedidos = new JScrollPane(tabelaPedidos);

        // Painel para as tabelas
        JPanel painelTabelas = new JPanel(new GridLayout(2, 1));
        painelTabelas.add(scrollProdutos);
        painelTabelas.add(scrollPedidos);

        // Botões
        JButton btnAdicionar = new JButton("Adicionar Produto");
        JButton btnEditar = new JButton("Editar Produto");
        JButton btnRemover = new JButton("Remover Produto");
        JButton btnPedido = new JButton("Adicionar Pedido");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnPedido);

        add(painelTabelas, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Ações dos botões
        btnAdicionar.addActionListener(this::adicionarProduto);
        btnEditar.addActionListener(this::editarProduto);
        btnRemover.addActionListener(this::removerProduto);
        btnPedido.addActionListener(this::adicionarPedido);

        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }

    private void adicionarProduto(ActionEvent e) {
        String nome = JOptionPane.showInputDialog("Nome do produto:");
        for (Produto p : listaProdutos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(this, "Produto já cadastrado");
                return;
            }
        }
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do produto:"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));

        Produto p = new Produto(contador++, nome, preco, quantidade);
        listaProdutos.add(p);
        modeloProdutos.addRow(new Object[]{p.getId(), p.getNome(), p.getPreco(), p.getQuantidade()});
    }

    private void editarProduto(ActionEvent e) {
        int linhaSelecionada = tabelaProdutos.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
            return;
        }

        Produto p = listaProdutos.get(linhaSelecionada);
        String novoNome = JOptionPane.showInputDialog("Novo nome:", p.getNome());
        double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo preço:", p.getPreco()));
        int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Nova quantidade:", p.getQuantidade()));

        p.setNome(novoNome);
        p.setPreco(novoPreco);
        p.setQuantidade(novaQuantidade);

        modeloProdutos.setValueAt(novoNome, linhaSelecionada, 1);
        modeloProdutos.setValueAt(novoPreco, linhaSelecionada, 2);
        modeloProdutos.setValueAt(novaQuantidade, linhaSelecionada, 3);
    }

    private void removerProduto(ActionEvent e) {
        int linhaSelecionada = tabelaProdutos.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para remover.");
            return;
        }

        listaProdutos.remove(linhaSelecionada);
        modeloProdutos.removeRow(linhaSelecionada);
    }
    private void adicionarPedido(ActionEvent e) {
        if (listaProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há produtos disponíveis para criar um pedido.");
            return;
        }

        List<ItemPedido> itensPedido = new ArrayList<>();
        String input = JOptionPane.showInputDialog("Digite os IDs dos produtos separados por vírgula:");
        String[] ids = input.split(",");

        for (String id : ids) {
            int index = Integer.parseInt(id.trim()) - 1;
            if (index >= 0 && index < listaProdutos.size()) {
                Produto produto = listaProdutos.get(index);
                String quantidadeStr = JOptionPane.showInputDialog("Digite a quantidade do produto \"" + produto.getNome() + "\":");
                try {
                    int quantidade = Integer.parseInt(quantidadeStr.trim());
                    if (quantidade > 0 && quantidade <= produto.getQuantidade()) { // Verifica se há estoque suficiente
                        itensPedido.add(new ItemPedido(produto, quantidade)); // Adiciona o item com a quantidade no pedido
                        atualizarEstoque(produto, quantidade); // Atualiza o estoque após a venda
                    } else {
                        JOptionPane.showMessageDialog(this, "Quantidade inválida para o produto \"" + produto.getNome() + "\".");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Quantidade inválida para o produto \"" + produto.getNome() + "\".");
                }
            }
        }

        if (itensPedido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum produto válido foi selecionado.");
            return;
        }

        // Cria o pedido com a lista de itens (Produto + Quantidade)
        Pedido pedido = new Pedido(listaPedidos.size() + 1, itensPedido);
        listaPedidos.add(pedido);

        // Exibe a descrição dos itens do pedido
        String descricaoItens = itensPedido.stream()
                .map(item -> item.getProduto().getNome())
                .collect(Collectors.joining(", "));

        // Exibe as quantidades dos itens do pedido
        String quantidades = itensPedido.stream()
                .map(item -> String.valueOf(item.getQuantidade()))
                .collect(Collectors.joining(", "));

        modeloPedidos.addRow(new Object[]{pedido.getId(), descricaoItens, quantidades, pedido.getTotal()});
        JOptionPane.showMessageDialog(this, "Pedido #" + pedido.getId() + " registrado! Total: R$ " + pedido.getTotal());
    }


    // Função para atualizar o estoque de um produto após a venda
    private void atualizarEstoque(Produto produto, int quantidadeVendida) {
        for (Produto p : listaProdutos) {
            if (p.getId() == produto.getId()) {
                p.setQuantidade(p.getQuantidade() - quantidadeVendida);  // Atualiza a quantidade no estoque
                break;
            }
        }

        // Atualizar a tabela de produtos (modelo)
        atualizarTabelaProdutos();
    }

    // Função para atualizar a tabela de produtos na interface
    private void atualizarTabelaProdutos() {
        // Limpa todas as linhas da tabela
        modeloProdutos.setRowCount(0);

        // Adiciona as linhas com os produtos atualizados
        for (Produto produto : listaProdutos) {
            modeloProdutos.addRow(new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getPreco(),
                    produto.getQuantidade()
            });
        }

        // Notifica que a tabela foi atualizada
        modeloProdutos.fireTableDataChanged();
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}
