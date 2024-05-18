package dao;

import model.Funcionario;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public void addFuncionario(Funcionario funcionario) throws SQLException {
        String query = "INSERT INTO Funcionarios (tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, funcionario.getTipoIdentificacion());
            pst.setString(2, funcionario.getNumeroIdentificacion());
            pst.setString(3, funcionario.getNombres());
            pst.setString(4, funcionario.getApellidos());
            pst.setString(5, funcionario.getEstadoCivil());
            pst.setString(6, String.valueOf(funcionario.getSexo()));
            pst.setString(7, funcionario.getDireccion());
            pst.setString(8, funcionario.getTelefono());
            pst.setDate(9, new Date(funcionario.getFechaNacimiento().getTime()));
            pst.executeUpdate();
        }
    }

    public List<Funcionario> getAllFuncionarios() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM Funcionarios";
        try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setTipoIdentificacion(rs.getString("tipo_identificacion"));
                funcionario.setNumeroIdentificacion(rs.getString("numero_identificacion"));
                funcionario.setNombres(rs.getString("nombres"));
                funcionario.setApellidos(rs.getString("apellidos"));
                funcionario.setEstadoCivil(rs.getString("estado_civil"));
                funcionario.setSexo(rs.getString("sexo").charAt(0));
                funcionario.setDireccion(rs.getString("direccion"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }

    public void updateFuncionario(Funcionario funcionario) throws SQLException {
        String query = "UPDATE Funcionarios SET tipo_identificacion=?, nombres=?, apellidos=?, estado_civil=?, sexo=?, direccion=?, telefono=?, fecha_nacimiento=? WHERE numero_identificacion=?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, funcionario.getTipoIdentificacion());
            pst.setString(2, funcionario.getNombres());
            pst.setString(3, funcionario.getApellidos());
            pst.setString(4, funcionario.getEstadoCivil());
            pst.setString(5, String.valueOf(funcionario.getSexo()));
            pst.setString(6, funcionario.getDireccion());
            pst.setString(7, funcionario.getTelefono());
            pst.setDate(8, new Date(funcionario.getFechaNacimiento().getTime()));
            pst.setString(9, funcionario.getNumeroIdentificacion());
            pst.executeUpdate();
        }
    }

    public void deleteFuncionario(String numeroIdentificacion) throws SQLException {
        String query = "DELETE FROM Funcionarios WHERE numero_identificacion=?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, numeroIdentificacion);
            pst.executeUpdate();
        }
    }
}
