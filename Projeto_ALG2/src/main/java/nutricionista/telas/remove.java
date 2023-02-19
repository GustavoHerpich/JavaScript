package nutricionista.telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import nutricionista.banco.Conexão_Banco;
import nutricionista.banco.Funções_com_BD;
import nutricionista.objetos.Alimentação;
import nutricionista.objetos.Cliente;
import nutricionista.objetos.Remédios;
import nutricionista.objetos.Restrição;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class remove {

    @FXML
    public TextField campoNomeCliente;

    @FXML
    public Button botaoAlimentacao;
    @FXML
    public Button botaoRemedio;
    @FXML
    public Button botaoRestricao;
    @FXML
    public Button botaoCliente;

    @FXML
    public ComboBox<Alimentação> comboAlimentacao;

    @FXML
    public ComboBox<Restrição> comboRestricao;

    @FXML
    public ComboBox<Remédios> comboRemedio;

    @FXML
    public void inputCampoNome() throws SQLException {
        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.SEARCH_cliente);
        statement.setString(1, campoNomeCliente.getText());
        ResultSet result = statement.executeQuery();

        Cliente cliente = new Cliente(campoNomeCliente.getText());

        if (result.next()) {
            cliente.setId(result.getInt("id"));
        }

        preencheComboAlimentacao(cliente.getId());
        preencheComboRemedio(cliente.getId());
        preencheComboRestricao(cliente.getId());

        comboAlimentacao.setDisable(false);
        comboRestricao.setDisable(false);
        comboRemedio.setDisable(false);

        botaoCliente.setDisable(false);
    }

    private void preencheComboAlimentacao(int clienteId) throws SQLException {
        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.SEARCH_alimentacao);
        statement.setInt(1, clienteId);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            Integer id = result.getInt("id");
            String descricao = result.getString("descricao");
            String periodo = result.getString("periodo");
            Double grama = result.getDouble("grama");
            String dia_semana = result.getString("dia_semana");
            Alimentação alimentação = new Alimentação(descricao, periodo, grama, dia_semana);
            alimentação.setId(id);

            comboAlimentacao.getItems().add(alimentação);
        }
    }

    private void preencheComboRestricao(int clienteId) throws SQLException {
        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.SEARCH_restricao);
        statement.setInt(1, clienteId);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            Integer id = result.getInt("id");
            String tipo = result.getString("tipo");
            String descricao = result.getString("descricao");
            Restrição restricao = new Restrição(tipo, descricao);
            restricao.setId(id);

            comboRestricao.getItems().add(restricao);
        }
    }

    private void preencheComboRemedio(int clienteId) throws SQLException {
        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.SEARCH_remedio);
        statement.setInt(1, clienteId);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            Integer id = result.getInt("id");
            String prescricao = result.getString("prescricao");
            Double dose_diaria = result.getDouble("dose_diaria");
            Double tempo_total = result.getDouble("tempo_total");
            String dia_semana = result.getString("dia_semana");
            String intervalos = result.getString("intervalos");
            Remédios remedios = new Remédios(prescricao, dose_diaria, tempo_total, dia_semana, intervalos);
            remedios.setId(id);

            comboRemedio.getItems().add(remedios);
        }
    }

    @FXML
    public void changeAlimentacao() {
        botaoAlimentacao.setDisable(false);
    }

    @FXML
    public void removeAlimentacao() throws SQLException {
        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.REMOVE_alimentacao);
        statement.setInt(1, comboAlimentacao.getSelectionModel().getSelectedItem().getId());
        statement.executeUpdate();

        comboAlimentacao.getItems().remove(comboAlimentacao.getSelectionModel().getSelectedItem());
        comboAlimentacao.getSelectionModel().clearSelection();
    }

    @FXML
    public void removeCliente() throws SQLException {
        for (Alimentação alimentacao : comboAlimentacao.getItems()) {
            PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.REMOVE_alimentacao);
            statement.setInt(1, alimentacao.getId());
            statement.executeUpdate();
        }

        for (Remédios remedio : comboRemedio.getItems()) {
            PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.REMOVE_remedio);
            statement.setInt(1, remedio.getId());
            statement.executeUpdate();
        }

        for (Restrição restricao : comboRestricao.getItems()) {
            PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.REMOVE_restricao);
            statement.setInt(1, restricao.getId());
            statement.executeUpdate();
        }

        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.REMOVE_cliente);
        statement.setString(1, campoNomeCliente.getText());
        statement.executeUpdate();


        campoNomeCliente.setText("");

        comboAlimentacao.getItems().clear();
        comboAlimentacao.getSelectionModel().clearSelection();
        comboRemedio.getItems().clear();
        comboRemedio.getSelectionModel().clearSelection();
        comboRestricao.getItems().clear();
        comboRestricao.getSelectionModel().clearSelection();

        comboAlimentacao.setDisable(true);
        comboRestricao.setDisable(true);
        comboRemedio.setDisable(true);

        botaoAlimentacao.setDisable(true);
        botaoRemedio.setDisable(true);
        botaoRestricao.setDisable(true);

        botaoCliente.setDisable(true);
    }

    public void changeRestricao(ActionEvent actionEvent) {
        botaoRestricao.setDisable(false);
    }

    public void removeRestricao(ActionEvent actionEvent) throws SQLException {
        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.REMOVE_restricao);
        statement.setInt(1, comboRestricao.getSelectionModel().getSelectedItem().getId());
        statement.executeUpdate();

        comboRestricao.getItems().remove(comboRestricao.getSelectionModel().getSelectedItem());
        comboRestricao.getSelectionModel().clearSelection();
    }


    public void removeRemedio(ActionEvent actionEvent) throws SQLException {
        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.REMOVE_remedio);
        statement.setInt(1, comboRemedio.getSelectionModel().getSelectedItem().getId());
        statement.executeUpdate();

        comboRemedio.getItems().remove(comboRemedio.getSelectionModel().getSelectedItem());
        comboRemedio.getSelectionModel().clearSelection();
    }


    public void changeRemedio(ActionEvent actionEvent) {
        botaoRemedio.setDisable(false);
    }
}
