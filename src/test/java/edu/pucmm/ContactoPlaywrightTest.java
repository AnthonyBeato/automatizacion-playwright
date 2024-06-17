package edu.pucmm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ContactoPlaywrightTest extends PlaywrightIT {

    @LocalServerPort
    private int port;

    @Test
    void test_contact_form_submission_success() {
        // Navegando a la página de contacto
        page.navigate("http://localhost:" + port + "/contact");

        // Asegurándonos de que el formulario de contacto esté visible
        assertThat(page.locator("#name-field")).isVisible();
        assertThat(page.locator("#email-field")).isVisible();
        assertThat(page.locator("#msg-text-area")).isVisible();

        // Ingresando nombre, correo y mensaje
        page.fill("vaadin-text-field[id='name-field'] > input", "Usuario de Prueba");
        page.fill("vaadin-email-field[id='email-field'] > input", "prueba@probando.com");
        page.fill("vaadin-text-area[id='msg-text-area'] > textarea", "Este es un mensaje de prueba.");

        // Haciendo clic en el botón de enviar
        page.locator("#submit-button").click();

        // Verificando que se muestre el mensaje de éxito
        assertThat(page.locator("vaadin-notification-card")).hasText("Mensaje envíado con éxito.");
    }

    @Test
    void test_contact_form_submission_failure() {
        // Navegando a la página de contacto
        page.navigate("http://localhost:" + port + "/contact");

        // Asegurarse de que el formulario de contacto esté visible
        assertThat(page.locator("#name-field")).isVisible();
        assertThat(page.locator("#email-field")).isVisible();
        assertThat(page.locator("#msg-text-area")).isVisible();

        // Dejar los campos vacíos y hacer clic en el botón de enviar
        page.locator("#submit-button").click();

        // Verificar que se muestre el mensaje de error
        assertThat(page.locator("vaadin-notification-card")).hasText("Por favor, completa todos los campos.");
    }
}
