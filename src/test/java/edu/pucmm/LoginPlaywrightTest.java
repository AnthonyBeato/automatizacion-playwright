package edu.pucmm;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LoginPlaywrightTest extends PlaywrightIT{
    @LocalServerPort
    private int port;

    @Test
    void test_login_success() {
        // Navegando a la página de login
        page.navigate("http://localhost:" + port + "/login");

        // Asegurarse de que el formulario de login esté visible
        assertThat(page.locator("vaadin-login-form")).isVisible();

        // Ingresando nombre de usuario y contraseña
        page.fill("#loginForm input[name='username']", "anthonybeato");
        page.fill("#loginForm input[name='password']", "1234");

        // Haciendo clic en el botón de login
        page.locator("vaadin-login-form vaadin-button[slot='submit']").click();


        // Verificando que la redirección a la página de inicio fue exitosa
        assertThat(page).hasURL("http://localhost:" + port + "/");
    }

    @Test
    void test_login_failure() {
        // Navegando a la página de login
        page.navigate("http://localhost:" + port + "/login");

        // Asegurarse de que el formulario de login esté visible
        assertThat(page.locator("vaadin-login-form")).isVisible();

        // Ingresando nombre de usuario y contraseña incorrectos
        page.fill("#loginForm input[name='username']", "wronguser");
        page.fill("#loginForm input[name='password']", "wrongpass");

        // Haciendo clic en el botón de login
        page.locator("vaadin-login-form vaadin-button[slot='submit']").click();

        // Verificando que el atributo error esté presente en el formulario de login
        assertThat(page.locator("vaadin-login-form")).hasAttribute("error", "");
    }
}
