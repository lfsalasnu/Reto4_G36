package Modelo.dao;
import java.sql.*;
import Utilidades.JDBCUtilities;
public class DeudasPorProyectoDao {
    
    public static ResultSet consulta(Double limiteInferior) {
        Statement stmt= null;
        ResultSet rs=null;
        try {
            var conn=JDBCUtilities.getConnection();
            
            String csql="SELECT ID_Proyecto, SUM(Cantidad*Precio_Unidad) as VALOR FROM Compra JOIN MaterialConstruccion USING(ID_MaterialConstruccion) WHERE Pagado='No' GROUP BY ID_Proyecto HAVING VALOR>"+limiteInferior+" ORDER BY VALOR DESC;";
            
            stmt=conn.createStatement();
            rs=stmt.executeQuery(csql);

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }

        return rs;
    }
}
