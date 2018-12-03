package components;

import java.text.ParseException;
import java.util.Scanner;

public interface Component {
	Scanner DADES = new Scanner(System.in);

	void mostrarComponent();

	public void modificarComponent() throws ParseException;

	default Object demanarDades(String peticio, int tipus) {
		System.out.println(peticio);
		switch (tipus) {
		case 1:
			int resInt = DADES.nextInt();
			DADES.nextLine();
			return resInt;
		case 2:
			String resToken = DADES.next();
			DADES.nextLine();
			return resToken;
		case 3:
			double resDouble = DADES.nextDouble();
			DADES.nextLine();
			return resDouble;
		case 4:
			String resStr = DADES.nextLine();
			return resStr;
		}
		return null;
	}
}
