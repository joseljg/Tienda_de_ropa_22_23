package es.joseljg.tiendaderopa.modelo;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.joseljg.tiendaderopa.clases.Ropa;

public class RopaDB {

    public static ArrayList<Ropa> obtenerRopas() {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        ArrayList<Ropa> ropas = new ArrayList<Ropa>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT * FROM ropa ORDER BY tipo";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {
                String codropa = resultado.getString("codropa");
                String tipo = resultado.getString("tipo");
                String talla = resultado.getString("talla");
                String color = resultado.getString("color");
                double preciov = resultado.getDouble("preciov");
                //-----------------------------------------------------------
                Ropa laropa = new Ropa(codropa,tipo,talla,color,preciov);
                //------------------------------------------------------------
                ropas.add(laropa);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return ropas;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return null;
        }
    }
}
