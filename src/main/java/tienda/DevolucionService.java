package tienda;

import java.time.LocalDate;

public class DevolucionService {
    public String registrarDevoluciones(String codigoDev, String codigoPro,
                                        String nombreCliente, String motivo,
                                        LocalDate fechaCompra, LocalDate fechaDev) {

        if (codigoDev.isEmpty() || codigoPro.isEmpty() || nombreCliente.isEmpty() || motivo.isEmpty()) {
            return "Debe ingresar todos los datos requeridos";
        }

        if (!codigoDev.matches("D\\d{4}")) {
            return "Ingrese un código de devolución válido";
        }

        if (!codigoPro.matches("[a-zA-Z0-9]{6}")) {
            return "Ingrese un código de producto válido";
        }

        if (!nombreCliente.matches("[a-zA-Z]{4,}")) {
            return "El nombre del cliente debe tener al menos cuatro caracteres alfabéticos";
        }

        if (motivo.length() < 10) {
            return "El motivo de la devolución debe tener al menos diez caracteres";
        }

        if (fechaDev.isBefore(fechaCompra) || fechaDev.isAfter(LocalDate.now())) {
            return "Ingrese una fecha de devolución válida";
        }

        return "La devolución ha sido registrada correctamente";
    }
}