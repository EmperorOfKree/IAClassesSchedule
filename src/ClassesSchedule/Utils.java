package ClassesSchedule;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static <T extends Clonavel<T>> List<T> clonarLista(List<T> listaOriginal) {
		List<T> listaNova = new ArrayList<>(listaOriginal.size());
		
		for (T elemento : listaOriginal) {
			listaNova.add(elemento.clonar());
		}
		
		return listaNova;
	}
}
