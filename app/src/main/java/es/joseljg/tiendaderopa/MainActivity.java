package es.joseljg.tiendaderopa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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
    }
}