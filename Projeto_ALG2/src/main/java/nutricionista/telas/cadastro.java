package nutricionista.telas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class cadastro implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoCelular;
    @FXML
    private TextField campoEndereco;
    @FXML
    private TextField campoIdade;
    @FXML
    private Text quantidadeAlimentacao;
    @FXML
    private Text quantidadeRemedio;
    @FXML
    private Text quantidadeRestricao;
    @FXML
    private ComboBox<String> campoSexo;

    public ArrayList<Alimentação> alimentacoes = new ArrayList<>();
    public ArrayList<Remédios> remedios = new ArrayList<>();
    public ArrayList<Restrição> restricoes = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        campoSexo.getItems().add("Masculino");
        campoSexo.getItems().add("Feminino");
    }

    @FXML
    public void addAlimentacao() {
        // Cria stage
        final Stage primaryStage = (Stage) pane.getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(primaryStage);

        // Cria conteúdo
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(40));

        TextField descricao = new TextField();
        descricao.setPromptText("Descrição");
        dialogVbox.getChildren().add(descricao);

        ComboBox<String> periodo = new ComboBox<>();
        periodo.setPromptText("Período");
        periodo.getItems().add("Desjejum");
        periodo.getItems().add("Pré-treino");
        periodo.getItems().add("Pós-treino");
        periodo.getItems().add("Café da manhã");
        periodo.getItems().add("Almoço");
        periodo.getItems().add("Lanche da tarde");
        periodo.getItems().add("Janta");
        periodo.getItems().add("Ceia");
        dialogVbox.getChildren().add(periodo);

        TextField grama = new TextField();
        grama.setPromptText("Gramas");
        dialogVbox.getChildren().add(grama);

        ComboBox<String> diaSemana = new ComboBox<>();
        diaSemana.setPromptText("Dia da semana");
        diaSemana.getItems().add("Domingo");
        diaSemana.getItems().add("Segunda");
        diaSemana.getItems().add("Terça");
        diaSemana.getItems().add("Quarta");
        diaSemana.getItems().add("Quinta");
        diaSemana.getItems().add("Sexta");
        diaSemana.getItems().add("Sábado");
        dialogVbox.getChildren().add(diaSemana);

        dialogVbox.getChildren().add(new Text(""));

        Button button = new Button();
        button.setText("Criar alimentação");
        button.setOnAction(event -> {
            alimentacoes.add(new Alimentação(
                    descricao.getText(),
                    periodo.getSelectionModel().getSelectedItem(),
                    Double.parseDouble(grama.getText()),
                    diaSemana.getSelectionModel().getSelectedItem()
            ));
            dialog.hide();

            quantidadeAlimentacao.setText(String.format("%s alimentação(ões)", alimentacoes.size()));
        });
        dialogVbox.getChildren().add(button);

        // Abrir popup
        Scene dialogScene = new Scene(dialogVbox, 500, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    @FXML
    public void addRestricao() {
        // Cria stage
        final Stage primaryStage = (Stage) pane.getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(primaryStage);

        // Cria conteúdo
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(40));

        ComboBox<String> tipo = new ComboBox<>();
        tipo.setPromptText("Tipo da Restrição");
        tipo.getItems().add("Alimento");
        tipo.getItems().add("Remédio");
        dialogVbox.getChildren().add(tipo);

        TextField descricao = new TextField();
        descricao.setPromptText("Descrição da restrição");
        dialogVbox.getChildren().add(descricao);

        dialogVbox.getChildren().add(new Text(""));

        Button button = new Button();
        button.setText("Criar restrição");
        button.setOnAction(event -> {
            restricoes.add(new Restrição(
                    tipo.getSelectionModel().getSelectedItem(),
                    descricao.getText()
            ));
            dialog.hide();

            quantidadeRestricao.setText(String.format("%s restrição(ões)", restricoes.size()));
        });
        dialogVbox.getChildren().add(button);

        // Abrir popup
        Scene dialogScene = new Scene(dialogVbox, 500, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    @FXML
    public void addRemedio() {
        // Cria stage
        final Stage primaryStage = (Stage) pane.getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(primaryStage);

        // Cria conteúdo
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(40));

        TextField prescricao = new TextField();
        prescricao.setPromptText("Prescricao");
        dialogVbox.getChildren().add(prescricao);

        TextField dose_diaria = new TextField();
        dose_diaria.setPromptText("Dose diaria em grama");
        dialogVbox.getChildren().add(dose_diaria);

        TextField tempo_total = new TextField();
        tempo_total.setPromptText("Tempo total de uso por mês");
        dialogVbox.getChildren().add(tempo_total);

        ComboBox<String> dia_semana = new ComboBox<>();
        dia_semana.setPromptText("Dia da semana");
        dia_semana.getItems().add("Domingo");
        dia_semana.getItems().add("Segunda");
        dia_semana.getItems().add("Terça");
        dia_semana.getItems().add("Quarta");
        dia_semana.getItems().add("Quinta");
        dia_semana.getItems().add("Sexta");
        dia_semana.getItems().add("Sábado");
        dialogVbox.getChildren().add(dia_semana);

        TextField intervalos = new TextField();
        intervalos.setPromptText("Intervalos entre os rémedios");
        dialogVbox.getChildren().add(intervalos);

        dialogVbox.getChildren().add(new Text(""));

        Button button = new Button();
        button.setText("Criar remédio");
        button.setOnAction(event -> {
            remedios.add(new Remédios(
                    prescricao.getText(),
                    Double.parseDouble(dose_diaria.getText()),
                    Double.parseDouble(tempo_total.getText()),
                    dia_semana.getSelectionModel().getSelectedItem(),
                    intervalos.getText()
            ));
            dialog.hide();

            quantidadeRemedio.setText(String.format("%s remedio(s)", remedios.size()));
        });
        dialogVbox.getChildren().add(button);

        // Abrir popup
        Scene dialogScene = new Scene(dialogVbox, 500, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }


    @FXML
    public void criarCliente() throws SQLException {
        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.INSERT_cliente, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, campoNome.getText());
        statement.setString(2, campoSexo.getSelectionModel().getSelectedItem() == "Masculino" ? "M" : "F");
        statement.setInt(3, Integer.parseInt(campoIdade.getText()));
        statement.setString(4, campoEmail.getText());
        statement.setString(5, campoCelular.getText());
        statement.setString(6, campoEndereco.getText());
        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating client failed, no rows affected.");
        }

        int clientId = 0;
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                clientId = (int) generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating client failed, no ID obtained.");
            }
        }

        criarAlimentacoes(clientId);
        criarRemedios(clientId);
        criarRestricoes(clientId);

        // Limpa campos
        campoNome.setText("");
        campoEmail.setText("");
        campoIdade.setText("");
        campoCelular.setText("");
        campoEndereco.setText("");
        campoSexo.getSelectionModel().clearSelection();

        alimentacoes.clear();
        restricoes.clear();
        remedios.clear();
        quantidadeAlimentacao.setText("");
        quantidadeRemedio.setText("");
        quantidadeRestricao.setText("");
    }

    public void criarAlimentacoes(int clientId) throws SQLException {
        for (Alimentação alimentação : alimentacoes) {
            PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.INSERT_alimentacao);
            statement.setString(1, alimentação.getDescricao());
            statement.setString(2, alimentação.getPeriodo());
            statement.setDouble(3, alimentação.getGrama());
            statement.setString(4, alimentação.getDia_semana());
            statement.setInt(5, clientId);
            statement.executeUpdate();
        }
    }

    public void criarRemedios(int clientId) throws SQLException {
        for (Remédios remedio : remedios) {
            PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.INSERT_remedio);
            statement.setString(1, remedio.getPrescricao());
            statement.setDouble(2, remedio.getDose_diaria());
            statement.setDouble(3, remedio.getTempo_total());
            statement.setString(4, remedio.getDia_semana());
            statement.setString(5, remedio.getIntervalos());
            statement.setInt(6, clientId);

            statement.executeUpdate();
        }
    }

    public void criarRestricoes(int clientId) throws SQLException {
        for (Restrição restricao : restricoes) {
            PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.INSERT_restricao);
            statement.setString(1, restricao.getTipo());
            statement.setString(2, restricao.getDescricao());
            statement.setInt(3, clientId);
            statement.executeUpdate();
        }
    }

}

