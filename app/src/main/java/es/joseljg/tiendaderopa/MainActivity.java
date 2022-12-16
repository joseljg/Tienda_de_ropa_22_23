package es.joseljg.tiendaderopa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.sql.Connection;
import java.util.ArrayList;

import es.joseljg.tiendaderopa.clases.Ropa;
import es.joseljg.tiendaderopa.modelo.ConfiguracionDB;
import es.joseljg.tiendaderopa.modelo.RopaDB;

public class MainActivity<foreach> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  /*      Connection c = ConfiguracionDB.conectarConBaseDeDatos();
        if(c == null)
        {
            Log.i("sql", "error al conectar");
        }
        else{
            Log.i("sql", "conectado correctamente");
        }*/
   /*
    ArrayList<Ropa> ropas = RopaDB.obtenerRopas();
    if(ropas!= null) {
        for (Ropa r : ropas) {
            Log.i("sql", r.toString());
            System.out.println(r.toString());
        }
    }
    else{
        Log.i("sql", "no se pudieron obtener los datos");
        System.out.println("no se pudieron obtener los datos");
    }
    */
    /*
       boolean ropaBorrada = RopaDB.borrarRopa("r1");
       if(ropaBorrada == true)
       {
           Log.i("sql", "se ha borrado correctamente");
           System.out.println("se ha borrado correctamente");
       }
       else{
           Log.i("sql", "no se pudo borrar");
           System.out.println("no se pudo borrar");
       }

     */
   /*     Ropa r = new Ropa("r10", "pantalon", "l","azul",43.2);
        boolean ropaInsertadaOK = RopaDB.guardarRopa(r);
        if(ropaInsertadaOK)
        {
            Log.i("sql", "se ha insertado correctamente");
            System.out.println("se ha insertado correctamente");
        }
        else{
            Log.i("sql", "no se pudo guardar");
            System.out.println("no se pudo guardar");
        }
    */
     /*   Ropa r = new Ropa("r10", "pantalon", "l","azul",43.2);
        String codigoOriginal = r.getCodropa();
        r.setCodropa("r110");
        r.setTipo("camiseta");
        r.setColor("rojo");
        r.setTalla("m");
        r.setPreciov(50.0);
        boolean ropaActualizacionOK = RopaDB.actualizarRopa(r, codigoOriginal);
        if(ropaActualizacionOK)
        {
            Log.i("sql", "se ha actualizado correctamente");
            System.out.println("se ha actualizado correctamente");
        }
        else{
            Log.i("sql", "no se pudo actualizar");
            System.out.println("no se pudo actualizar");
        }
*/
        //---------------------------------------------------------
      /*  ArrayList<Ropa> ropas = RopaDB.buscarRopasGeneral("camiseta");
        if(ropas!= null) {
            for (Ropa r : ropas) {
                Log.i("sql", r.toString());
                System.out.println(r.toString());
            }
        }
        else{
            Log.i("sql", "no se pudieron obtener los datos");
            System.out.println("no se pudieron obtener los datos");
        }
        */


    }

    public void insertarRopa(View view) {
        Intent intent = new Intent(this,InsertarRopaActivity.class);
        startActivity(intent);
    }

    public void mostrarRopa(View view) {
        Intent intent = new Intent(this,MostrarRopaActivity.class);
        startActivity(intent);
    }
}