package Main;

import javafx.fxml.FXMLLoader;
import beans.TelasEnum;
import exception.ControllerTela;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application{

    /*---FXML */
    private static Stage stage;
    private static Scene mainSistema;
    private static Scene cdtsNotas;
    private static Scene cdtsEstoque;
    private static Scene clientes;
   
    /*---------- */

    public static ControllerTela mudarTela;


    @Override
    public void start(Stage primayStage) throws Exception{

        stage = primayStage;
        primayStage.setTitle("Sistema de Faturamento");

        //TELA PRINCIPAL
        try{
            Parent fxmlMain = FXMLLoader.load(this.getClass().getResource("./view/mainPrincipal.fxml"));
            mainSistema = new Scene(fxmlMain,800,600);
        }catch(Exception e){
            System.out.println("Não foi possivel fazer esse procedimento tente novamente. ERROR:" + e.getMessage());
        }
        
        // --TELA DE EMISSÃO DE NOTA FISCAL
        try{
            Parent fxmlNotaFiScal = FXMLLoader.load(this.getClass().getResource("./view/notaFiscal.fxml"));
            cdtsNotas = new Scene(fxmlNotaFiScal,800,600); 
        }catch(Exception e){
            System.out.println("Não foi possivel fazer esse procedimento tente novamente. ERROR:" + e.getMessage());
        }

        //--TELA PARA CONTROLE DE ESTOQUE
        try{
            Parent fxmlEstoque = FXMLLoader.load(this.getClass().getResource("./view/ControleDeEstoque.fxml"));
            cdtsEstoque = new Scene(fxmlEstoque,800,600);
        }catch(Exception e){
            System.out.println("Não foi possivel fazer esse procedimento tente novamente. ERROR: " + e.getMessage());
        }

        //---TELA CADASTRO DE CLIENTES
        try{
            Parent fxmlClientes = FXMLLoader.load(this.getClass().getResource("./view/Clientes.fxml"));
            clientes = new Scene(fxmlClientes,800,600);
        }catch(Exception e){
            System.out.println("Não foi possivel fazer esse procedimento tente novamente. ERROR: " + e.getMessage());
        }
        
        
        primayStage.setScene(mainSistema);
        primayStage.setResizable(false);
        primayStage.show();
    }

    public static void main(String[] args) throws Exception {

        mudarTela = new ControllerTela();
        launch(args);
    }


    public static void mudarTela(TelasEnum telas, Object userData){
        switch (telas) {
            case MAIN:
                stage.setScene(mainSistema);
                mudarTela.notificar(TelasEnum.MAIN, userData);
                break;
        
            case NOTASFISCAIS:
                stage.setScene(cdtsNotas);
                mudarTela.notificar(TelasEnum.NOTASFISCAIS, userData);
                break;
            
            case ESTOQUE:
                stage.setScene(cdtsEstoque);
                mudarTela.notificar(TelasEnum.ESTOQUE, userData);
                break;
            
            case CLIENTES:
                stage.setScene(clientes);
                mudarTela.notificar(TelasEnum.CLIENTES, userData);
                break;
        }
    }

    public static void mudarTela(TelasEnum telas){
        mudarTela(telas, null);
    }
}
