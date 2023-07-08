package a.swing;

import a.entities.Item;
import a.interfaces.LeitorInterface;
import a.interfaces.VerificadorInterface;
import a.services.Leitor;
import a.util.Verificador;

import javax.swing.*;
import java.util.Set;

public class StringInputGUI extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button;

    public StringInputGUI() {
        // Configurações da janela
        setTitle("Input de Strings");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Criação dos componentes
        textField1 = new JTextField();
        textField1.setBounds(50, 30, 200, 30);

        textField2 = new JTextField();
        textField2.setBounds(50, 80, 200, 30);

        button = new JButton("Confirmar");
        button.setBounds(100, 130, 100, 30);
        button.addActionListener(e -> {
            String input1 = textField1.getText();
            String input2 = textField2.getText();
            LeitorInterface leitor = new Leitor();
            Set<Item> listEmp = leitor.lerArchiveEmp(input1);
            Set<Item> listMLG = leitor.lerArchiveMlg(input2);
            VerificadorInterface verificador = new Verificador();
            verificador.compararListas(listEmp, listMLG);
        });

        // Adiciona os componentes à janela
        add(textField1);
        add(textField2);
        add(button);

        // Exibe a janela
        setVisible(true);
    }

    private void minhaFuncao(String input1, String input2) {
        // Faça algo com as strings digitadas
        JOptionPane.showMessageDialog(this, "Você digitou: " + input1 + " e " + input2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StringInputGUI());
    }
}
