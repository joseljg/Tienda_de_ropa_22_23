package es.joseljg.tiendaderopa;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RopaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static final String EXTRA_PRODUCTO_ITEM = "es.joseljg.productosviewholder.producto";
    // atributos
    private TextView txt_item_codropa;
    private TextView txt_item_tipo;
    private TextView txt_item_precio;
    private ImageView img_item_ropa;
    //-------------------------------------
    private ListaRopasAdapter lpa;

    public ImageView getImg_item_ropa() {
        return img_item_ropa;
    }

    public void setImg_item_ropa(ImageView img_item_ropa) {
        this.img_item_ropa = img_item_ropa;
    }

    public RopaViewHolder(@NonNull View itemView, ListaRopasAdapter listaProductosAdapter) {
        super(itemView);
        txt_item_codropa = (TextView) itemView.findViewById(R.id.txt_item_codropa);
        txt_item_tipo = (TextView) itemView.findViewById(R.id.txt_item_precio);
        txt_item_precio = (TextView) itemView.findViewById(R.id.txt_item_precio);
        img_item_ropa = (ImageView) itemView.findViewById(R.id.img_item_ropa);
        //-----------------------------------------------------------------------------
        lpa = listaProductosAdapter;
        itemView.setOnClickListener(this);
    }

    public TextView getTxt_item_codropa() {
        return txt_item_codropa;
    }

    public void setTxt_item_codropa(TextView txt_item_codropa) {
        this.txt_item_codropa = txt_item_codropa;
    }

    public TextView getTxt_item_tipo() {
        return txt_item_tipo;
    }

    public void setTxt_item_tipo(TextView txt_item_codtipo) {
        this.txt_item_tipo = txt_item_tipo;
    }

    public TextView getTxt_item_precio() {
        return txt_item_tipo;
    }

    public void setTxt_item_precio(TextView txt_item_precio) {
        this.txt_item_tipo = txt_item_precio;
    }


    @Override
    public void onClick(View view) {
 //      int posicion = getLayoutPosition();
 //      Ropa p = lpa.getRopas().get(posicion);
 //      Intent intent = new Intent(lpa.getContexto(),DetallesRopaActivity.class);
 //      intent.putExtra(EXTRA_ROPA_ITEM,p);
 //      lpa.getContexto().startActivity(intent);
    }
}
