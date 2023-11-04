package beans;

public class NotaFiscal {
    private String serieNf;
    private String cliente;
    private String valorNf;

    public NotaFiscal(String serie, String cliente, String valorNf){
        this.serieNf = serie;
        this.cliente = cliente;
        this.valorNf = valorNf;
    }

    public String getSerie(){
        return this.serieNf;
    }

    public String getCliente(){
        return this.cliente;
    }

    public String getValor(){
        return this.valorNf;
    }

    public void setSerie(String serie){
        this.serieNf = serie;
    }

    public void setCliente(String cliente){
        this.cliente = cliente;
    }

    public void setValorNf(String valorNf){
        this.valorNf = valorNf;
    }
}
