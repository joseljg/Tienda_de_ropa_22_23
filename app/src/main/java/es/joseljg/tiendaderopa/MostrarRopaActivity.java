package es.joseljg.tiendaderopa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

import es.joseljg.tiendaderopa.clases.Ropa;
import es.joseljg.tiendaderopa.controladores.RopaController;

public class MostrarRopaActivity extends AppCompatActivity {

    private RecyclerView rv_mostrar_ropa;
    ListaRopasAdapter adaptadorRopas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ropa);
        rv_mostrar_ropa = (RecyclerView) findViewById(R.id.rv_mostrar_ropa);
        ArrayList<Ropa> ropas = new ArrayList<Ropa>();
        //ropas = RopaController.obtenerTodasLasRopas();
        ropas.add(new Ropa("r1234","pantalon","L","azul",3));
        ropas.add(new Ropa("r1235","pantalon","XL","rojo",4));
        ropas.add(new Ropa("r1236","pantalon","XL","amarillo",5));
        ropas.add(new Ropa("r1237","pantalon","L","verde",6));

        //-----------------------------------------------------------------
        adaptadorRopas = new ListaRopasAdapter(this,ropas);
        rv_mostrar_ropa.setAdapter(adaptadorRopas);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            rv_mostrar_ropa.setLayoutManager(new GridLayoutManager(this,2));
        } else {
            // In portrait
            rv_mostrar_ropa.setLayoutManager(new LinearLayoutManager(this));
        }
//----------------------------------------------------------------------------------------------
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(ropas, from, to);
                adaptadorRopas.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                    // Ciudad c = ciudades.get(viewHolder.getAdapterPosition());
                    // CiudadController.borrarCiudad(c);
                    ropas.remove(viewHolder.getAdapterPosition());
                    adaptadorRopas.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    ropas.remove(viewHolder.getAdapterPosition());
                    adaptadorRopas.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.UP)
                {
                    //estudiantes.remove(viewHolder.getAdapterPosition());
                    //adaptadorEstudiantes.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.DOWN)
                {
                    //estudiantes.remove(viewHolder.getAdapterPosition());
                    //adaptadorEstudiantes.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(rv_mostrar_ropa);
    }
}