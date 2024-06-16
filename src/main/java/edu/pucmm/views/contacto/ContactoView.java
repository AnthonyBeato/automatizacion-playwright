package edu.pucmm.views.contacto;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
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
import edu.pucmm.views.MainLayout;

@PageTitle("Contacto")
@Route(value = "contact", layout = MainLayout.class)
public class ContactoView extends Composite<VerticalLayout> {

    public ContactoView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H2 h2 = new H2();
        Paragraph textMedium = new Paragraph();
        TextField textField = new TextField();
        EmailField emailField = new EmailField();
        TextArea textArea = new TextArea();
        Button buttonPrimary = new Button();
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
        textField.setLabel("Text field");
        textField.setWidth("100%");
        emailField.setLabel("Email");
        emailField.setWidth("100%");
        textArea.setLabel("Text area");
        textArea.setWidth("100%");
        textArea.getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Button");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(h2);
        layoutColumn2.add(textMedium);
        layoutColumn2.add(textField);
        layoutColumn2.add(emailField);
        layoutColumn2.add(textArea);
        layoutColumn2.add(buttonPrimary);
    }
}
