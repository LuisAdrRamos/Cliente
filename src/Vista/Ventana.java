package Vista;

import Cliente.Clase.Cliente;

import javax.swing.*;

public class Ventana extends JFrame {
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JButton btnClean;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JLabel lblResultado;

    public Ventana() {
        setTitle("Calculadora");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(50, 20, 200, 30);
        add(txtNumero1);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(50, 60, 200, 30);
        add(txtNumero2);

        btnSumar = new JButton("+");
        btnSumar.setBounds(50, 100, 80, 30);
        add(btnSumar);

        btnRestar = new JButton("-");
        btnRestar.setBounds(140, 100, 80, 30);
        add(btnRestar);

        btnMultiplicar = new JButton("*");
        btnMultiplicar.setBounds(50, 140, 80, 30);
        add(btnMultiplicar);

        btnDividir = new JButton("/");
        btnDividir.setBounds(140, 140, 80, 30);
        add(btnDividir);

        btnClean = new JButton("Limpiar");
        btnClean.setBounds(50, 180, 170, 30);
        add(btnClean);

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 210, 200, 30);
        add(lblResultado);

        btnClean.addActionListener(e -> {
            txtNumero1.setText("");
            txtNumero2.setText("");
            lblResultado.setText("Resultado: ");
        });

        btnSumar.addActionListener(e -> enviarOperacion("+"));
        btnRestar.addActionListener(e -> enviarOperacion("-"));
        btnMultiplicar.addActionListener(e -> enviarOperacion("*"));
        btnDividir.addActionListener(e -> enviarOperacion("/"));
    }

    private void enviarOperacion(String operacion) {
        try {
            String ipServidor = "127.0.0.1"; // Cambia si el servidor está en otra máquina
            int puertoServidor = 5000;

            int num1 = Integer.parseInt(txtNumero1.getText());
            int num2 = Integer.parseInt(txtNumero2.getText());

            Cliente cliente = new Cliente();
            String respuesta = cliente.enviarNumeros(ipServidor, puertoServidor, num1, num2, operacion);

            lblResultado.setText("Resultado: " + respuesta);

        } catch (Exception ex) {
            lblResultado.setText("Error al procesar operación");
        }
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
