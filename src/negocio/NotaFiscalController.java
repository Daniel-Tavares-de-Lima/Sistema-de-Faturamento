package negocio;

import beans.NotaFiscal;
import beans.TelasEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;

import Main.App;

public class NotaFiscalController {
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
   

    /*-----VARIAVEIS FXML */
    @FXML
    private TextField clientes;
    @FXML
    private TextField serieNf;
    @FXML
    private TextField valorNf;
    @FXML
    private DatePicker data;
    @FXML
    private TableView<NotaFiscal> informacoes;

    //----VARIAVEIS
    private ObservableList<NotaFiscal> obsNotaFiscal;
    int comparar;


    public void getData(ActionEvent e){
        LocalDate dataAtual = LocalDate.now();
        LocalDate calenDate = data.getValue();
        comparar = dataAtual.compareTo(calenDate);
    }
    
    @FXML
    protected void btAdicionar(ActionEvent e){
        String nomeNota = serieNf.getText();
        String nomeCliente = clientes.getText();
        String nomeValorNf = valorNf.getText();

        if(nomeNota != null && nomeCliente != null &&  nomeValorNf != null && data.getValue() != null){
            if(comparar <= 0){
                NotaFiscal nota = new NotaFiscal(nomeNota, nomeCliente, nomeValorNf);
                App.notaFiscal.addNotas(nota);
                obsNotaFiscal = FXCollections.observableArrayList(App.notaFiscal.getClientes());
                informacoes.setItems(obsNotaFiscal);



                /*---ALERT PESSOA SALVA */
                Alert alertSalvaPessoa = new Alert(Alert.AlertType.INFORMATION);
                alertSalvaPessoa.setTitle("NOTA FISCAL");
                alertSalvaPessoa.setContentText("NOTA FISCAL SALVA COM SUCESSO!");
                alertSalvaPessoa.show();
                /*------ */

                serieNf.setText("");
                clientes.setText("");
                valorNf.setText("");

                System.out.println("Nome" + nomeNota + "Cliente: " + nomeCliente + "Valor: " + nomeValorNf);

            }else{
                /*---ALERT */
                Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
                alertSalvaPessoa.setTitle("DATA INCORRETA");
                alertSalvaPessoa.setContentText("Por favor, selecione a data atual em diante.");
                alertSalvaPessoa.show();
                /*------ */
                data.getEditor().clear();
            }
        }else{
            /*---ALERT */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("CAMPO VAZIL");
            alertSalvaPessoa.setContentText("Por favor, digite um campo");
            alertSalvaPessoa.show();
            /*------ */
        }
    }
}
