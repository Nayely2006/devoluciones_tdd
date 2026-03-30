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
}
