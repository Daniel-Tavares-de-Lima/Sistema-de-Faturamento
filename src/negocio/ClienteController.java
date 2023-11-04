package negocio;

import Main.App;
import beans.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ClienteController {
    //CONTROLE DE PASSAGEM DE TELA
    @FXML
    protected void btnNotas(ActionEvent e){
        App.mudarTela(TelasEnum.NOTASFISCAIS);
    }
    @FXML
    protected void btnEstoque(ActionEvent e){
        App.mudarTela(TelasEnum.ESTOQUE);
    }
    @FXML
    protected void btnClientes(ActionEvent e){
        App.mudarTela(TelasEnum.CLIENTES);
    }
    @FXML
    protected void btnContas(ActionEvent e){
        App.mudarTela(TelasEnum.CONTAS);
    }
}
