package es.joseljg.tiendaderopa.tareas;

import java.util.concurrent.Callable;

import es.joseljg.tiendaderopa.clases.Ropa;
import es.joseljg.tiendaderopa.modelo.RopaDB;

public class TareaGuardarRopa implements Callable<Boolean> {

    private Ropa p;

    public TareaGuardarRopa(Ropa p) {
        this.p = p;
    }

    @Override
    public Boolean call() throws Exception {
        boolean guardadoOK = RopaDB.guardarRopa(p);
        return guardadoOK;
    }
}
