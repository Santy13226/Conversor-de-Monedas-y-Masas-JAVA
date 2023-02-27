package challenge_conversor_santiago_guaylla;

import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorDeMasa {
    public void convertirMasa() {
    	String[] masa = {"De Libras a onzas","De Libras a miligramos","De Dlibras a gramos", "De Libras a Kilogramos", "De libras a Toneladas"};
	    double[] tiposDeCambio = {16, 453592, 453.59199986863, 0.45359199986863002474, 0.00045359199986863004512};
	    String MasasSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione la masa a la que desea convertir:",
	            "Conversión de moneda", JOptionPane.PLAIN_MESSAGE, null, masa, masa[0]);
	 // Obtener la cantidad de masas a convertir
	    double cantidadMasa = 0.0;
	    boolean esNumerico = false;
	    while (!esNumerico) {
	        JTextField cantidadMonedaField = new JTextField(10);
	        JPanel panel = new JPanel();
	        panel.add(new JLabel("Ingrese la cantidad a convertir " + MasasSeleccionada));
	        panel.add(cantidadMonedaField);
	        int result = JOptionPane.showConfirmDialog(null, panel, "Conversión de moneda", JOptionPane.OK_CANCEL_OPTION);
	        if (result == JOptionPane.OK_OPTION) {
	            String cantidadMonedaStr = cantidadMonedaField.getText();
	            try {
	                cantidadMasa = Double.parseDouble(cantidadMonedaStr);
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
	        double cantidadMonedaConvertida = cantidadMasa * tiposDeCambio[Arrays.asList(masa).indexOf(MasasSeleccionada)];
	        JOptionPane.showMessageDialog(null, cantidadMasa + " libras = " + cantidadMonedaConvertida + " " + MasasSeleccionada);
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
