package nutricionista.telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nutricionista.banco.Conexão_Banco;
import nutricionista.banco.Funções_com_BD;
import nutricionista.objetos.Alimentação;
import nutricionista.objetos.Cliente;
import nutricionista.objetos.Remédios;
import nutricionista.objetos.Restrição;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class busca {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField campoNomeCliente;

    @FXML
    private VBox dadosCliente;

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

        if (result.next()) {
            Cliente cliente = new Cliente(
                    result.getString("nome"),
                    result.getString("sexo"),
                    result.getInt("idade"),
                    result.getString("email"),
                    result.getString("celular"),
                    result.getString("endereco"));

            preencheDadosCliente(cliente);
            preencheComboAlimentacao(result.getInt("id"));
            preencheComboRestricao(result.getInt("id"));
            preencheComboRemedio(result.getInt("id"));

        }

        comboAlimentacao.setDisable(false);
        comboRestricao.setDisable(false);
        comboRemedio.setDisable(false);
    }

    private void preencheDadosCliente(Cliente cliente) {
        dadosCliente.getChildren().clear();

        dadosCliente.getChildren().add(new Text("Nome: "+ cliente.getNome()));
        dadosCliente.getChildren().add(new Text("sexo: "+ cliente.getSexo()));
        dadosCliente.getChildren().add(new Text("idade: "+ cliente.getIdade()));
        dadosCliente.getChildren().add(new Text("email: "+ cliente.getEmail()));
        dadosCliente.getChildren().add(new Text("celular: "+ cliente.getCelular()));
        dadosCliente.getChildren().add(new Text("endereço: "+ cliente.getEndereco()));
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
    @FXML
    public void changeAlimentacao() {
        // Cria stage
        final Stage primaryStage = (Stage) pane.getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(primaryStage);

        // Cria conteúdo
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(40));

        Alimentação alimentacao = comboAlimentacao.getSelectionModel().getSelectedItem();

        dialogVbox.getChildren().add(new Text("ID: "+ alimentacao.getId()));
        dialogVbox.getChildren().add(new Text("Descrição: "+ alimentacao.getDescricao()));
        dialogVbox.getChildren().add(new Text("Grama: "+ alimentacao.getGrama()));
        dialogVbox.getChildren().add(new Text("Dia_semana: "+ alimentacao.getDia_semana()));

        dialogVbox.getChildren().add(new Text(""));

        javafx.scene.control.Button button = new javafx.scene.control.Button();
        button.setText("Fechar");
        button.setOnAction(event -> dialog.hide());
        dialogVbox.getChildren().add(button);

        // Abrir popup
        Scene dialogScene = new Scene(dialogVbox, 500, 300);
        dialog.setScene(dialogScene);
        dialog.show();

        comboAlimentacao.getSelectionModel().clearSelection();
    }

    public void changeRestricao(ActionEvent actionEvent) {
        // Cria stage
        final Stage primaryStage = (Stage) pane.getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(primaryStage);

        // Cria conteúdo
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(40));

        Restrição restricao = comboRestricao.getSelectionModel().getSelectedItem();

        dialogVbox.getChildren().add(new Text("ID: "+ restricao.getId()));
        dialogVbox.getChildren().add(new Text("Tipo: "+ restricao.getTipo()));
        dialogVbox.getChildren().add(new Text("Descrição: "+ restricao.getDescricao()));

        dialogVbox.getChildren().add(new Text(""));

        javafx.scene.control.Button button = new javafx.scene.control.Button();
        button.setText("Fechar");
        button.setOnAction(event -> dialog.hide());
        dialogVbox.getChildren().add(button);

        // Abrir popup
        Scene dialogScene = new Scene(dialogVbox, 500, 300);
        dialog.setScene(dialogScene);
        dialog.show();

        comboRestricao.getSelectionModel().clearSelection();
    }


    public void changeRemedio(ActionEvent actionEvent) {
        // Cria stage
        final Stage primaryStage = (Stage) pane.getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(primaryStage);

        // Cria conteúdo
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(40));

        Remédios remedio = comboRemedio.getSelectionModel().getSelectedItem();

        dialogVbox.getChildren().add(new Text("ID: "+ remedio.getId()));
        dialogVbox.getChildren().add(new Text("Prescricao: "+ remedio.getPrescricao()));
        dialogVbox.getChildren().add(new Text("Dose_diaria: "+ remedio.getDose_diaria()));
        dialogVbox.getChildren().add(new Text("Tempo_total: "+ remedio.getTempo_total()));
        dialogVbox.getChildren().add(new Text("Dia_semana: "+ remedio.getDia_semana()));
        dialogVbox.getChildren().add(new Text("Intervalos: "+ remedio.getIntervalos()));

        dialogVbox.getChildren().add(new Text(""));

        javafx.scene.control.Button button = new javafx.scene.control.Button();
        button.setText("Fechar");
        button.setOnAction(event -> dialog.hide());
        dialogVbox.getChildren().add(button);

        // Abrir popup
        Scene dialogScene = new Scene(dialogVbox, 500, 300);
        dialog.setScene(dialogScene);
        dialog.show();

        comboRemedio.getSelectionModel().clearSelection();
    }

}
