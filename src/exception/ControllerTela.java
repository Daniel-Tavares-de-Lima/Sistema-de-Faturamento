package exception;

import java.util.ArrayList;

import beans.TelasEnum;

public class ControllerTela {
    
    private static ArrayList<mudanca> listeners = new ArrayList<>();

    public static interface  mudanca{
        void mudar(TelasEnum novaTela, Object userData);
    }

    public static void mudancaListeners(mudanca NovaMudanca){
        listeners.add(NovaMudanca);
    }

    public static void notificar(TelasEnum novaTela, Object userData){
        for(mudanca m : listeners){
            m.mudar(novaTela, userData);
        }
    }
}
