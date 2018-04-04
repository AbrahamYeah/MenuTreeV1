package menu.tree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexcionSQL.ConexionSQL;;;

public class ServicioMenuImpl implements ServicioMenu {
	
	private PreparedStatement pst;
	private ResultSet rst;
	private ConexionSQL con = new ConexionSQL();

	@Override
	public List<MenuOpciones> menuOp(String app) {
		Connection conn = con.getConexion();
		try{
			String query = "SELECT ID_OPCION_MENU,NIVEL,ORDEN,NOMBRE_MENU,URL_IMG,URL_PAG FROM MENU WHERE ID_APP ='"+app+"'";
	        ArrayList<MenuOpciones> almacenes = new ArrayList<MenuOpciones>();
	        pst = conn.prepareStatement(query);
			rst = pst.executeQuery();
			while (rst.next()) {
				MenuOpciones almacenesCon = cursorToContact(rst);
	            almacenes.add(almacenesCon);
			}
	        rst.close();
	        return almacenes;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	 private MenuOpciones cursorToContact(ResultSet cursor) throws SQLException {
		 MenuOpciones alma1 = new MenuOpciones(
                        cursor.getInt(1),
	                cursor.getInt(2),
	                cursor.getString(3),
	                cursor.getString(4),
	                cursor.getString(5)
	                );
	        alma1.setId_menu(cursor.getInt(1));

	        return alma1;
	    }

}
