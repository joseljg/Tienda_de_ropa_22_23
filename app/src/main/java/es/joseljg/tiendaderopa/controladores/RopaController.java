package es.joseljg.tiendaderopa.controladores;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import es.joseljg.tiendaderopa.clases.Ropa;
import es.joseljg.tiendaderopa.tareas.TareaGuardarRopa;
import es.joseljg.tiendaderopa.tareas.TareaObtenerTodasLasRopas;

public class RopaController {

    public static boolean guardarRopa(Ropa p)
    {
        FutureTask t = new FutureTask(new TareaGuardarRopa(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            return insercionOK;
        }
    }

    public static ArrayList<Ropa> obtenerTodasLasRopas() {
        FutureTask t = new FutureTask(new TareaObtenerTodasLasRopas());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        ArrayList<Ropa> ropas = new ArrayList<Ropa>();
        try {
            ropas = (ArrayList<Ropa>) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            return ropas;
        }
    }
}
