package tree.nodo;

import menu.tree.MenuOpciones;
import menu.tree.ServicioMenuImpl;
import java.util.*;

import org.zkoss.bind.annotation.*;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.*;

public class Menu {

	private List<MenuOpciones> datos;
	TreeModel _model;

	public TreeModel getModel() {
		if (_model == null) {
			_model = new FooModel(getFooRoot());
		}
		return _model;
	}

	// create a FooNodes tree structure and return the root

	private FooNode getFooRoot() {

		datos = new ServicioMenuImpl().menuOp("CONTE");

		for (MenuOpciones op : datos) {
			int posicion = 0;
			int[] cabecera = new int[datos.size()];
			int cont = 0;
			FooNode primerNivelMenu;
			FooNode segundoNivelMenu;
			FooNode tercerNivelMenu;
			FooNode cuartoNivelMenu;
			FooNode quintoNivelMenu;
			FooNode root = new FooNode(null, 0, "");
			for (int i = 0; i <= datos.size(); i++) { // el ciclo se termina
														// hasta que se terminen
														// todos
														// los datos del arreglo
				System.out.println(datos.get(posicion).getOrden());
				// compara si los datos en la posición 0
				do {

					primerNivelMenu = new FooNode(root, i, datos.get(posicion)
							.getUrl_img());
					cabecera[posicion] = datos.get(posicion).getId_padre();
					posicion++;
					

					root.appendChild(primerNivelMenu);
					if (datos.get(posicion).getOrden() != 0) {
						if(datos.get(posicion).getOrden() == cabecera[cont]){
							for (int e = 0; e < datos.size() - 4; e++) {
								segundoNivelMenu = new FooNode(root, i, datos.get(
										posicion).getUrl_img());
								cabecera[posicion] = datos.get(posicion)
										.getId_padre();
								
								
								primerNivelMenu.appendChild(segundoNivelMenu);
								posicion++;
								cont++;
								
							}
						}
						
					}

				} while (datos.get(posicion).getOrden() == 0);
				

				return root;
			}

		}
		return null;

	}
}
