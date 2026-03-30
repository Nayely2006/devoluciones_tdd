package com.tienda;

import org.junit.jupiter.api.Test;
import tienda.DevolucionService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DevolucionServiceTest {

    DevolucionService service = new DevolucionService();

    @Test
    void testCodigoDevolucionInvalido() {
        String res = service.registrarDevoluciones(
                "1234","ABC123","Jose",
                "Producto fallado",
                LocalDate.now().minusDays(1),
                LocalDate.now());

        assertEquals("Ingrese un código de devolución válido", res);
    }

    @Test
    void testCodigoProductoInvalido() {
        String res = service.registrarDevoluciones(
                "D1234","ABC12","Jose",
                "Producto fallado",
                LocalDate.now().minusDays(1),
                LocalDate.now());

        assertEquals("Ingrese un código de producto válido", res);
    }

    @Test
    void testNombreInvalido() {
        String res = service.registrarDevoluciones(
                "D1234","ABC123","J1",
                "Producto fallado",
                LocalDate.now().minusDays(1),
                LocalDate.now());

        assertEquals("El nombre del cliente debe tener al menos cuatro caracteres alfabéticos", res);
    }

    @Test
    void testMotivoInvalido() {
        String res = service.registrarDevoluciones(
                "D1234","ABC123","Jose",
                "Corto",
                LocalDate.now().minusDays(1),
                LocalDate.now());

        assertEquals("El motivo de la devolución debe tener al menos diez caracteres", res);
    }

    @Test
    void testFechaInvalida() {
        String res = service.registrarDevoluciones(
                "D1234","ABC123","Jose",
                "Producto defectuoso",
                LocalDate.now(),
                LocalDate.now().minusDays(1));


        assertEquals("Ingrese una fecha de devolución válida", res);
    }

    @Test
    void testRegistroCorrecto() {
        String res = service.registrarDevoluciones(
                "D1234","ABC123","Jose",
                "Producto defectuoso",
                LocalDate.now(),
                LocalDate.now().minusDays(2));


        assertEquals("La devolución ha sido registrada correctamente", res);
    }
}
