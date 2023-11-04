package dados;

import java.util.ArrayList;

import beans.NotaFiscal;

public class IRepositorioNotaFiscal {
    private ArrayList<NotaFiscal> series;
    private ArrayList<NotaFiscal> clientes;
    private ArrayList<NotaFiscal> valorNf;

    public IRepositorioNotaFiscal(){
        series = new ArrayList<NotaFiscal>();
        clientes = new ArrayList<NotaFiscal>();
        valorNf = new ArrayList<NotaFiscal>();
    }

    public void addNotas(NotaFiscal n){
        if(n != null){
            series.add(n);
            clientes.add(n);
            valorNf.add(n);
        }
    }

    public ArrayList<NotaFiscal> getSeries(){
        return series;
    }

    public ArrayList<NotaFiscal> getClientes(){
        return clientes;
    }

    public ArrayList<NotaFiscal> getValorNf(){
        return valorNf;
    }
}
