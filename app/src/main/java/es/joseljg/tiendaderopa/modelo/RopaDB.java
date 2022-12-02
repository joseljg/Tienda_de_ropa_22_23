package es.joseljg.tiendaderopa.modelo;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    //-----------------------------------------------------------------------------------------------------
    public static boolean borrarRopa(String cod_ropa) {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
            String ordensql = "DELETE FROM ropa WHERE (codropa = ?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setString(1, cod_ropa);
            int filasafectadas = sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            if(filasafectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------
public static boolean guardarRopa(Ropa r) {
    Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
    if(conexion == null)
    {
        return false;
    }
    try {
        String ordensql = "INSERT INTO ropa (codropa, tipo, talla, color, preciov) VALUES (?,?,?,?,?);";
        PreparedStatement sentencia = conexion.prepareStatement(ordensql);
        sentencia.setString(1, r.getCodropa());
        sentencia.setString(2, r.getTipo());
        sentencia.setString(3,r.getTalla());
        sentencia.setString(4,r.getColor());
        sentencia.setDouble(5, r.getPreciov());
        int filasafectadas = sentencia.executeUpdate();
        sentencia.close();
        conexion.close();
        if(filasafectadas > 0)
        {
            return true;
        }
        else {
            return false;
        }
    } catch (SQLException e) {
        return false;
    }
}
    //------------------------------------------------------------------------------------------------
    public static boolean actualizarRopa(Ropa r, String codropaAntiguo) {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
            String ordensql = "UPDATE ropa SET codropa = ?, tipo = ?, talla = ?, color = ? , preciov = ? WHERE codropa = ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, r.getCodropa());
            pst.setString(2, r.getTipo());
            pst.setString(3, r.getTalla());
            pst.setString(4, r.getColor());
            pst.setDouble(5, r.getPreciov());
            pst.setString(6, codropaAntiguo);
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
   //-------------------------------------------------------------------------------
   public static ArrayList<Ropa> buscarRopasPorTipo(String eltipo) {
       Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
       if(conexion == null)
       {
           return null;
       }
       ArrayList<Ropa> ropas = new ArrayList<Ropa>();
       try {
           String ordensql = "SELECT * from ropa WHERE tipo LIKE ?";
           PreparedStatement pst = conexion.prepareStatement(ordensql);
           String elementoBuscado = "%"+eltipo+"%";
           pst.setString(1, elementoBuscado);
           ResultSet resultado = pst.executeQuery();
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
           pst.close();
           conexion.close();
           return ropas;
       } catch (SQLException e) {
           Log.i("sql", "error sql");
           return null;
       }
   }


//------------------------------------------------------------
public static ArrayList<Ropa> buscarRopasGeneral(String lapalabra) {
    Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
    if(conexion == null)
    {
        return null;
    }
    ArrayList<Ropa> ropas = new ArrayList<Ropa>();
    try {
        String ordensql = "SELECT DISTINCT * from ropa WHERE tipo LIKE ? OR talla LIKE ? OR color LIKE ? OR preciov LIKE ? ";
        PreparedStatement pst = conexion.prepareStatement(ordensql);
        String elementoBuscado = "%"+ lapalabra+"%";
        pst.setString(1, elementoBuscado);
        pst.setString(2, elementoBuscado);
        pst.setString(3, elementoBuscado);
        pst.setString(4, elementoBuscado);

        ResultSet resultado = pst.executeQuery();
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
        pst.close();
        conexion.close();
        return ropas;
    } catch (SQLException e) {
        Log.i("sql", "error sql");
        return null;
    }
}
}