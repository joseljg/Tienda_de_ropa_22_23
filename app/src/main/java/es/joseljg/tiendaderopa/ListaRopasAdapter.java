package es.joseljg.tiendaderopa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.joseljg.tiendaderopa.clases.Ropa;


public class ListaRopasAdapter extends RecyclerView.Adapter<RopaViewHolder> {
    // atributos
    private Context contexto = null;
    private ArrayList<Ropa> ropas = null;
    private LayoutInflater inflate = null;

    public ListaRopasAdapter(Context contexto, ArrayList<Ropa> ropas) {
        this.contexto = contexto;
        this.ropas = ropas;
        inflate =  LayoutInflater.from(this.contexto);
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Ropa> getRopas() {
        return ropas;
    }

    public void setRopas(ArrayList<Ropa> ropas) {
        this.ropas = ropas;
    }

    @NonNull
    @Override
    public RopaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflate.inflate(R.layout.item_mostrar_ropa,parent,false);
        RopaViewHolder evh = new RopaViewHolder(mItemView,this);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull RopaViewHolder holder, int position) {
     Ropa p = this.ropas.get(position);
     holder.getTxt_item_codropa().setText("codigo: " + p.getCodropa());
     holder.getTxt_item_tipo().setText("tipo " + String.valueOf(p.getTipo()));
     holder.getTxt_item_precio().setText(String.valueOf("precio: " + p.getPreciov()));
     holder.getImg_item_ropa().setImageResource(R.drawable.fruta);
    }

    @Override
    public int getItemCount() {
        return this.ropas.size();
    }
}
