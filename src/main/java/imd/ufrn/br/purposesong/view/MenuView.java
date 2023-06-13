package imd.ufrn.br.purposesong.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import imd.ufrn.br.purposesong.entity.Song;

public class MenuView implements Initializable {
    private MenuViewModel viewModel = MenuViewModel.getInstance();

    @FXML
    private ListView<String> SongView;

    @FXML
    private ListView<String> PlaylistView;

    @FXML
    private ImageView atual_imagem;

    @FXML
    private Label myLabel;

    @FXML
    private VBox currentSong;

    @FXML
    private Button play;

    @FXML
    private Label nameActiiveUser;

    @FXML
    protected void goToRegister() {
        this.viewModel.goToRegister();
    }

    @FXML
    protected void goToLogin() {
        currentSong.visibleProperty().set(false);
        this.viewModel.goToLogin();

    }

    @FXML
    protected void goToSettings() {
        this.viewModel.goToSettings();
    }

    @FXML
    protected void addNewFile() {
        this.viewModel.addNewFile();
        this.viewModel.updateListSongName();
    }

    @FXML
    protected void addNewFolder() {
        this.viewModel.openFolderChooser();
    }

    @FXML
    public void setNameUser() {
        nameActiiveUser.setText(viewModel.setNameUser());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SongView.itemsProperty().bind(this.viewModel.songNames);

        System.out.println("HELLOOOOO");
        // !conditionals by type of user
        PlaylistView.getItems().addAll(viewModel.getPlaylists());
        PlaylistView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                // SongView.getItems().add("Adicionando nova música...");
                ;
            }
        });

        // !Songs for testing

        SongView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                currentSong.visibleProperty().set(true);
                viewModel.setCurrentSong(SongView.getSelectionModel().getSelectedItem());
                try {
                    atual_imagem.setImage(viewModel.getImages().get(SongView.getSelectionModel().getSelectedIndex()));
                } catch (Exception e) {
                    atual_imagem
                            .setImage(new Image(viewModel.getDefaultImage()));
                }
                myLabel.setText(viewModel.getCurrentSong());

                ;
            }
        });

    }
}
