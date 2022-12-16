package es.joseljg.tiendaderopa.tareas;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.joseljg.tiendaderopa.clases.Ropa;
import es.joseljg.tiendaderopa.modelo.RopaDB;

public class TareaObtenerTodasLasRopas implements Callable<ArrayList<Ropa>> {
    @Override
    public ArrayList<Ropa> call() throws Exception {
        ArrayList<Ropa> ropas = RopaDB.obtenerRopas();
        return ropas;
    }
}
