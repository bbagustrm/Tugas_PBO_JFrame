package rectangle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxShapes;
    private JTextField input1, input2;
    private JLabel labelInput1, labelInput2, resultLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainFrame() {
        setTitle("Perhitungan Luas Bangun Datar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblChooseShape = new JLabel("Pilih Bangun Datar:");
        lblChooseShape.setBounds(30, 30, 150, 20);
        contentPane.add(lblChooseShape);

        comboBoxShapes = new JComboBox<>(new String[] { "Persegi", "Persegi Panjang", "Segitiga", "Lingkaran" });
        comboBoxShapes.setBounds(180, 30, 200, 20);
        contentPane.add(comboBoxShapes);

        labelInput1 = new JLabel("Sisi:");
        labelInput1.setBounds(30, 70, 150, 20);
        contentPane.add(labelInput1);

        input1 = new JTextField();
        input1.setBounds(180, 70, 200, 20);
        contentPane.add(input1);

        labelInput2 = new JLabel("");
        labelInput2.setBounds(30, 110, 150, 20);
        contentPane.add(labelInput2);

        input2 = new JTextField();
        input2.setBounds(180, 110, 200, 20);
        input2.setVisible(false);
        contentPane.add(input2);

        JButton btnCalculate = new JButton("Hitung Luas");
        btnCalculate.setBounds(150, 150, 150, 30);
        contentPane.add(btnCalculate);

        resultLabel = new JLabel("Hasil: ");
        resultLabel.setBounds(30, 200, 350, 20);
        contentPane.add(resultLabel);

        // Event listeners
        comboBoxShapes.addActionListener(e -> updateInputFields());
        btnCalculate.addActionListener(e -> calculateArea());
    }

    private void updateInputFields() {
        String selectedShape = (String) comboBoxShapes.getSelectedItem();
        switch (selectedShape) {
            case "Persegi":
                labelInput1.setText("Sisi:");
                labelInput2.setText("");
                input2.setVisible(false);
                break;
            case "Persegi Panjang":
                labelInput1.setText("Panjang:");
                labelInput2.setText("Lebar:");
                labelInput2.setVisible(true);
                input2.setVisible(true);
                break;
            case "Segitiga":
                labelInput1.setText("Alas:");
                labelInput2.setText("Tinggi:");
                labelInput2.setVisible(true);
                input2.setVisible(true);
                break;
            case "Lingkaran":
                labelInput1.setText("Jari-jari:");
                labelInput2.setText("");
                input2.setVisible(false);
                break;
        }
    }

    private void calculateArea() {
        String selectedShape = (String) comboBoxShapes.getSelectedItem();
        try {
            double value1 = Double.parseDouble(input1.getText());
            double value2 = input2.isVisible() ? Double.parseDouble(input2.getText()) : 0;
            double area = 0;

            switch (selectedShape) {
                case "Persegi":
                    area = value1 * value1;
                    break;
                case "Persegi Panjang":
                    area = value1 * value2;
                    break;
                case "Segitiga":
                    area = 0.5 * value1 * value2;
                    break;
                case "Lingkaran":
                    area = Math.PI * value1 * value1;
                    break;
            }
            resultLabel.setText(String.format("Hasil: %.2f", area));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan nilai yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
