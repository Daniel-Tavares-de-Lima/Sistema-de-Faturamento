package negocio;

import beans.TelasEnum;
import javafx.event.ActionEvent;

import Main.App;


import javafx.fxml.FXML;

public class MainController {
    
    @FXML
    protected void btnMain(ActionEvent e){
        App.mudarTela(TelasEnum.MAIN);
        System.out.println("Oi");
    }
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
   
    
}
