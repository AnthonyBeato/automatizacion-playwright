package edu.pucmm;

import edu.pucmm.services.PhotoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class InicioPlaywrightTest extends PlaywrightIT{

    @LocalServerPort
    private int port;

    @Autowired
    private PhotoService photoService;

    @Test
    void verify_inicio_page(){
        // Navegando a la página de inicio
        page.navigate("http://localhost:" + port + "/");

        // Verificando que el título de la página sea "Inicio"
        assertThat(page).hasTitle("Inicio");

        // Verificando que el encabezado esté presente
        assertThat(page.locator("h2")).hasText("Wallpapers para ti");

        // Verificando que la lista de imágenes esté presente
        assertThat(page.locator("ol")).isVisible();

        // Obteniendo la cantidad de fotos desde el servicio
        int photoCount = photoService.listAllPhotos().size();

        // Verificando que el número de elementos en la lista sea igual al número de fotos
        assertThat(page.locator("ol li")).hasCount(photoCount);

        // Verificando que el diálogo se haya cerrado
        assertThat(page.locator("vaadin-dialog-overlay")).not().isVisible();
    }
}
