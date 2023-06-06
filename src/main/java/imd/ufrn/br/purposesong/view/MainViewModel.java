package imd.ufrn.br.purposesong.view;

import imd.ufrn.br.purposesong.App;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MainViewModel {
    // Singleton ----------
    private static MainViewModel instance = new MainViewModel();
    private MainViewModel() {}
    public static MainViewModel getInstance() {
        return MainViewModel.instance;
    }
    // -----------------



    // Fields
    private App app = App.getInstance();
    private final StringProperty helloMessage = new SimpleStringProperty("Essa é a tela principal: Aperte para adicionar");

    public StringProperty helloMessage() {
        return helloMessage;
    }

    public String getHelloMessage() {
        return helloMessage.get();
    }

    public void setHelloMessage(String message) {
        helloMessage.set(message);
    }

    public void goToLogin() {

        this.app.changeToLoginScene();
    }
}