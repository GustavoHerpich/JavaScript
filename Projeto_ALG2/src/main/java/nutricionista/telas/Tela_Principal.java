package nutricionista.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;


public class Tela_Principal {

    @FXML
    private TabPane pane;
    @FXML
    private Tab busca;
    @FXML
    private Tab cadastro;
    @FXML
    private Tab remove;
    @FXML
    private Tab altera;

    @FXML
    public void muda_busca() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/busca.fxml"));
        Parent tela_Busca = loader.load();
        busca.setContent(tela_Busca);
    }

    @FXML
    public void muda_cadastro() throws IOException {
        System.out.println(getClass().getPackageName());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/cadastro.fxml"));
        Parent tela_Cadastro = loader.load();
        cadastro.setContent(tela_Cadastro);
    }

    @FXML
    public void muda_altera() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/altera.fxml"));
        Parent tela_Altera = loader.load();
        altera.setContent(tela_Altera);
    }

    @FXML
    public void muda_remove() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/remove.fxml"));
        Parent tela_Remove = loader.load();
        remove.setContent(tela_Remove);
    }
}
