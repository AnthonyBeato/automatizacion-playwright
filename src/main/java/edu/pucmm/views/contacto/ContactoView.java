package edu.pucmm.views.contacto;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import edu.pucmm.data.Message;
import edu.pucmm.data.MessageRepository;
import edu.pucmm.views.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@PageTitle("Contacto")
@Route(value = "contact", layout = MainLayout.class)
public class ContactoView extends Composite<VerticalLayout> {

    @Autowired
    private MessageRepository messageRepository;

    public ContactoView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H2 h2 = new H2();
        Paragraph textMedium = new Paragraph();
        TextField nameField = new TextField();
        EmailField emailField = new EmailField();
        TextArea messageTextArea = new TextArea();
        Button submitButton = new Button();
        Notification notification = new Notification();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutRow.setAlignItems(Alignment.START);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setMaxWidth("700px");
        layoutColumn2.getStyle().set("flex-grow", "1");

        h2.setText("¿Quieres ponerte en contacto con nosotros?");
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.START, h2);
        h2.setWidth("100%");

        textMedium.setText(
                "Si tienes cualquier duda o sugerencia para la página no dudes en escribir en el formulario de debajo.");
        textMedium.setWidth("100%");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");

        nameField.setLabel("Nombre");
        nameField.setId("name-field");
        nameField.setWidth("100%");
        nameField.setRequired(true);

        emailField.setLabel("Correo");
        emailField.setId("email-field");
        emailField.setWidth("100%");
        emailField.setRequired(true);

        messageTextArea.setLabel("Mensaje");
        messageTextArea.setId("msg-text-area");
        messageTextArea.setWidth("100%");
        messageTextArea.getStyle().set("flex-grow", "1");
        messageTextArea.setRequired(true);

        submitButton.setText("Enviar");
        submitButton.setWidth("min-content");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        submitButton.setId("submit-button");

        // Acción de enviar el mensaje de contacto
        submitButton.addClickListener(e -> {
            if (nameField.getValue().isEmpty() || emailField.getValue().isEmpty() || messageTextArea.getValue().isEmpty()) {
                notification.setText("Por favor, completa todos los campos.");
                notification.setDuration(3000);
                notification.open();
            } else {
                try {
                    Message message = Message.builder()
                            .name(nameField.getValue())
                            .email(emailField.getValue())
                            .text(messageTextArea.getValue())
                            .build();

                    messageRepository.save(message);

                    notification.setText("Mensaje envíado con éxito.");
                    notification.setDuration(3000);
                    notification.open();

                    nameField.clear();
                    emailField.clear();
                    messageTextArea.clear();
                } catch (Exception ex) {
                    notification.setText("Error al enviar el mensaje: " + ex.getMessage());
                    notification.setDuration(3000);
                    notification.open();
                }
            }
        });

        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(h2);
        layoutColumn2.add(textMedium);
        layoutColumn2.add(nameField);
        layoutColumn2.add(emailField);
        layoutColumn2.add(messageTextArea);
        layoutColumn2.add(submitButton);
    }
}
