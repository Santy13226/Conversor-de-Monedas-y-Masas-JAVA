package challenge_conversor_santiago_guaylla;

import javax.swing.JOptionPane;

public class MenuConversor {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String[] opciones = { "Convertir moneda", "Convertir Masa", "SALIR" };
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú de conversión",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) {
            ConversorDeMoneda conversor = new ConversorDeMoneda();
            conversor.convertirMoneda();
        } else if (seleccion == 1) {
            ConversorDeMasa conversor = new ConversorDeMasa();
            conversor.convertirMasa();
        } else if (seleccion == 2) {
            int continuar = JOptionPane.showOptionDialog(null, "Programa Finalizado. ¿Desea continuar?", "Confirmación",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No", "Cancelar" },
                    "Sí");
            if (continuar == JOptionPane.YES_OPTION) {
                menu();
            } else {
                JOptionPane.showMessageDialog(null, "Programa Finalizado");
            }
        }
    }
}
