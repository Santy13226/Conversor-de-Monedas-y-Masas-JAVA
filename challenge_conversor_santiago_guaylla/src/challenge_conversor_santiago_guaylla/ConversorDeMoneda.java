package challenge_conversor_santiago_guaylla;

import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorDeMoneda {
    private String[] monedas = { "De Dólar a Pesos Colombianos", "De Dólar a Pesos Mexicanos", "De Dólar a Euro",
            "De Dólar a Libra británica", "De Dólar a Yen Japonés" };
    private double[] tiposDeCambio = { 4855.32, 18.40, 0.95, 0.84, 136.27 };

    public void convertirMoneda() {
        String monedaSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda a la que desea convertir:",
                "Conversión de moneda", JOptionPane.PLAIN_MESSAGE, null, monedas, monedas[0]);

        // Obtener la cantidad de moneda a convertir
        double cantidadMoneda = 0.0;
        boolean esNumerico = false;
        while (!esNumerico) {
            JTextField cantidadMonedaField = new JTextField(10);
            JPanel panel = new JPanel();
            panel.add(new JLabel("Ingrese la cantidad a convertir " + monedaSeleccionada));
            panel.add(cantidadMonedaField);
            int result = JOptionPane.showConfirmDialog(null, panel, "Conversión de moneda", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String cantidadMonedaStr = cantidadMonedaField.getText();
                try {
                    cantidadMoneda = Double.parseDouble(cantidadMonedaStr);
                    esNumerico = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es un caracter numérico, Ingrese un valor nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                break;
            }
        }

        if (esNumerico) {
            // Realizar la conversión y mostrar el resultado
            double cantidadMonedaConvertida = cantidadMoneda * tiposDeCambio[Arrays.asList(monedas).indexOf(monedaSeleccionada)];
            JOptionPane.showMessageDialog(null, cantidadMoneda + " dólares = " + cantidadMonedaConvertida + " " + monedaSeleccionada);
            
         // Preguntar si desea continuar
            int continuar = PreguntarContinuar.preguntar("¿Desea continuar?");

            // Si el usuario selecciona "Sí", volver al menú de conversión
            if (continuar == JOptionPane.YES_OPTION) {
                MenuConversor.menu();
            } else {
                // Si el usuario selecciona "No" o "Cancelar", mostrar mensaje de finalización
                JOptionPane.showMessageDialog(null, "Programa finalizado");
            }
        }
    }
}
