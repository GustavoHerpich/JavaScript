/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.exemplobd;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author coelho
 */
public class FXMLController implements Initializable {

    private Dao_Aluno dao_contato;
    private ObservableList<Aluno> dados_tabela;

    @FXML
    private TextField texto_nome_insere,
            texto_nota1_insere,
            texto_nota2_insere,
            texto_nota3_insere;

    @FXML
    private ChoiceBox<String> choice_remove;

    @FXML
    private ChoiceBox<String> choice_altera;
    @FXML
    private TextField texto_nome_altera,
            texto_nota1_altera,
            texto_nota2_altera,
            texto_nota3_altera;

    @FXML
    private TableView<Aluno> tabela;
    @FXML
    private TableColumn<Aluno, String> coluna_nome;
    @FXML
    private TableColumn<Aluno, Float> coluna_nota1, 
            coluna_nota2, 
            coluna_nota3,
            coluna_media;
    
    @FXML
    public void evento_insere(ActionEvent event) {
        if (!texto_nome_insere.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Confirma cadastro?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> bt = a.showAndWait();

            if (bt.get() == ButtonType.YES) {
                try {
                    Aluno contato = new Aluno();

                    contato.setNome(texto_nome_insere.getText());
                    contato.setNota1(Float.parseFloat(texto_nota1_insere.getText()));
                    contato.setNota2(Float.parseFloat(texto_nota2_insere.getText()));
                    contato.setNota3(Float.parseFloat(texto_nota3_insere.getText()));
                    dao_contato.adiciona(contato);
                    contato.setMatricula(dao_contato.buscaId(contato));
                        atualizaDados();
                        Alert b = new Alert(Alert.AlertType.INFORMATION);

                        b.setContentText("Contato cadastrado com sucesso!");
                        b.setTitle("INFO");
                        b.showAndWait();
                        limpaCamposInserção();
                } catch (SQLException ex) {
                    Alert c = new Alert(Alert.AlertType.ERROR);

                    c.setContentText("Erro ao cadastrar contato.");
                    c.setTitle("ERROR");
                    c.showAndWait();
                }
            }
        } else {
            Alert c = new Alert(Alert.AlertType.ERROR);

            c.setContentText("O campo nome deve estar preenchido.");
            c.setTitle("ERROR");
            c.showAndWait();
        }

    }

    @FXML
    public void evento_remove(ActionEvent event) throws SQLException {
        System.out.println("ok");
        Aluno c = dao_contato.pesquisaAluno((String) choice_remove.getSelectionModel().getSelectedItem());

        if (c != null) {
            dao_contato.remove(c);
            Alert d = new Alert(Alert.AlertType.INFORMATION);

            d.setContentText("Contato removido com sucesso!");
            d.setTitle("INFO");
            d.showAndWait();
            atualizaDados();
        } else {
            Alert d = new Alert(Alert.AlertType.ERROR);

            d.setContentText("Erro durante a remoção do contato " + c.getNome());
            d.setTitle("ERROR");
            d.showAndWait();
        }

    }

    @FXML
    public void evento_altera(ActionEvent event) {
        Aluno contato = new Aluno();

        try {
            contato.setMatricula(dao_contato.buscaId((String) choice_altera.getSelectionModel().getSelectedItem()));
            contato.setNota1(Float.parseFloat(texto_nota1_altera.getText()));
            contato.setNota2(Float.parseFloat(texto_nota2_altera.getText()));
            contato.setNota3(Float.parseFloat(texto_nota3_altera.getText()));
            contato.setNome(texto_nome_altera.getText());
            dao_contato.altera(contato);
            Alert d = new Alert(Alert.AlertType.INFORMATION);
                d.setContentText("Contato atualizado com sucesso!");
                d.setTitle("INFO");
                d.showAndWait();
                atualizaDados();
        } catch (SQLException ex) {
            Alert d = new Alert(Alert.AlertType.ERROR);

            d.setContentText("Erro durante a atualização do contato " + contato.getNome());
            d.setTitle("ERROR");
            d.showAndWait();
        }
    }

    @FXML
    public void evento_seleciona_altera(ActionEvent event) throws SQLException {
        if (((String) choice_altera.getSelectionModel().getSelectedItem()) == null
                || ((String) choice_altera.getSelectionModel().getSelectedItem()).isEmpty()) {
            limpaCamposAlteração();
        } else {
            List<Aluno> todos = dao_contato.pesquisaTodos();

            for (Object m : todos) {
                Aluno c = (Aluno) m;

                if (c.getNome().equals((String) choice_altera.getSelectionModel().getSelectedItem())) {
                    texto_nome_altera.setText(c.getNome());
                    texto_nota1_altera.setText(String.valueOf(c.getNota1()));
                    texto_nota2_altera.setText(String.valueOf(c.getNota2()));
                    texto_nota3_altera.setText(String.valueOf(c.getNota3()));
                    break;
                }
            }
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao_contato = new Dao_Aluno();
        coluna_nome.setCellValueFactory(new PropertyValueFactory("nome"));
        coluna_nota1.setCellValueFactory(new PropertyValueFactory("nota1"));
        coluna_nota2.setCellValueFactory(new PropertyValueFactory("nota2"));
        coluna_nota3.setCellValueFactory(new PropertyValueFactory("nota3"));
        coluna_media.setCellValueFactory(new PropertyValueFactory("media")); 
        tabela.getColumns().clear();
        tabela.getColumns().addAll(coluna_nome, coluna_nota1, coluna_nota2, coluna_nota3, coluna_media);
        try {
            atualizaDados();
        } catch (SQLException throwables) {
            Alert c = new Alert(Alert.AlertType.ERROR);

            c.setContentText("Erro ao buscar dados no BD.");
            c.setTitle("ERROR");
            c.showAndWait();
        }
    }

    private void atualizaDados() throws SQLException {
        choice_remove.getItems().clear();
        choice_altera.getItems().clear();
        tabela.getItems().clear();        
        List<Aluno> m;
        
        m = this.dao_contato.pesquisaTodos();
        dados_tabela = FXCollections.observableArrayList();
        for (Object c : m) {
            Aluno contato = (Aluno) c;
            
            dados_tabela.add(contato);
            choice_remove.getItems().add(contato.getNome());
            choice_altera.getItems().add(contato.getNome());            
        }        
        tabela.setItems(dados_tabela);
        tabela.refresh();
        choice_altera.getSelectionModel().select(0);
        choice_remove.getSelectionModel().select(0);
    }

    private void limpaCamposInserção() {
        texto_nome_insere.setText("");
        texto_nota1_insere.setText("");
        texto_nota2_insere.setText("");
        texto_nota3_insere.setText("");
    }

    private void limpaCamposAlteração() {
        texto_nome_altera.setText("");
        texto_nota1_altera.setText("");
        texto_nota2_altera.setText("");
        texto_nota3_altera.setText("");
    }

}
