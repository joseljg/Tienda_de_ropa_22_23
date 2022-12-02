package es.joseljg.tiendaderopa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import es.joseljg.tiendaderopa.clases.Ropa;
import es.joseljg.tiendaderopa.controladores.RopaController;

public class InsertarRopaActivity extends AppCompatActivity {

    private EditText edt_nuevo_codropa = null;
    private EditText edt_nuevo_tipo = null;
    private EditText edt_nuevo_tamaño = null;
    private EditText edt_nuevo_color = null;
    private EditText edt_nuevo_precio = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_ropa);
        //----------------------------------------------------
        edt_nuevo_codropa = (EditText) findViewById(R.id.edt_nuevo_codropa);
        edt_nuevo_tipo = (EditText) findViewById(R.id.edt_nuevo_tipo);
        edt_nuevo_tamaño = (EditText) findViewById(R.id.edt_nuevo_tamaño);
        edt_nuevo_color = (EditText) findViewById(R.id.edt_nuevo_color);
        edt_nuevo_precio = (EditText) findViewById(R.id.edt_nuevo_precio);
        //----------------------------------------------------------


    }

    public void insertar(View view) {
        String codropa = String.valueOf(edt_nuevo_codropa.getText());
        String tipo = String.valueOf(edt_nuevo_tipo.getText());
        String tamaño = String.valueOf(edt_nuevo_tamaño.getText());
        String color = String.valueOf(edt_nuevo_color.getText());
        String textoPrecio = String.valueOf(edt_nuevo_precio.getText());
        if(codropa.isEmpty())
        {
            edt_nuevo_codropa.setError("escribe algo");
        }
        if(tipo.isEmpty())
        {
            edt_nuevo_tipo.setError("escribe algo");
        }
        if(tamaño.isEmpty())
        {
            edt_nuevo_tamaño.setError("escribe algo");
        }
        if(color.isEmpty())
        {
            edt_nuevo_color.setError("escribe algo");
        }
        if(textoPrecio.isEmpty())
        {
            edt_nuevo_precio.setError("escribe algo");
        }
        double precio = Double.valueOf(textoPrecio);
        //--------------------------------------------------------
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("son correctos los datos? (SI/NO)");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Ropa r = new Ropa(codropa,tipo,tamaño,color,precio);
                boolean guardadoOK = RopaController.guardarRopa(r);
                if(guardadoOK)
                {
                    mostrarToast("guardado realizado correctamente");
                }
                else{
                    mostrarToast("no se pudo guardar el dato");
                }
                Log.i("sql", r.toString());

            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mostrarToast("vale, bien cancelado");
            }
        });
       alerta1.show();

    }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }
}