package view;

import dao.FuncionarioDAO;
import model.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncionarioForm extends JFrame {
    private JTextField txtTipoIdentificacion;
    private JTextField txtNumeroIdentificacion;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtEstadoCivil;
    private JTextField txtSexo;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtFechaNacimiento;
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioForm() {
        funcionarioDAO = new FuncionarioDAO();
        setTitle("Gestión de Funcionarios");
        setSize(400, 400);
        setLayout(new GridLayout(10, 2));

        // Adding form fields
        add(new JLabel("Tipo Identificación:"));
        txtTipoIdentificacion = new JTextField();
        add(txtTipoIdentificacion);

        add(new JLabel("Número Identificación:"));
        txtNumeroIdentificacion = new JTextField();
        add(txtNumeroIdentificacion);

        add(new JLabel("Nombres:"));
        txtNombres = new JTextField();
        add(txtNombres);

        add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        add(txtApellidos);

        add(new JLabel("Estado Civil:"));
        txtEstadoCivil = new JTextField();
        add(txtEstadoCivil);

        add(new JLabel("Sexo:"));
        txtSexo = new JTextField();
        add(txtSexo);

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        add(new JLabel("Fecha Nacimiento (YYYY-MM-DD):"));
        txtFechaNacimiento = new JTextField();
        add(txtFechaNacimiento);

        JButton btnSave = new JButton("Guardar");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFuncionario();
            }
        });
        add(btnSave);
    }

    private void saveFuncionario() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setTipoIdentificacion(txtTipoIdentificacion.getText());
            funcionario.setNumeroIdentificacion(txtNumeroIdentificacion.getText());
            funcionario.setNombres(txtNombres.getText());
            funcionario.setApellidos(txtApellidos.getText());
            funcionario.setEstadoCivil(txtEstadoCivil.getText());
            funcionario.setSexo(txtSexo.getText().charAt(0));
            funcionario.setDireccion(txtDireccion.getText());
            funcionario.setTelefono(txtTelefono.getText());
            Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaNacimiento.getText());
            funcionario.setFechaNacimiento(fechaNacimiento);

            funcionarioDAO.addFuncionario(funcionario);
            JOptionPane.showMessageDialog(this, "Funcionario guardado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el funcionario: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FuncionarioForm form = new FuncionarioForm();
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setVisible(true);
            }
        });
    }
}
