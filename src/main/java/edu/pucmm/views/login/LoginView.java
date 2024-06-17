package edu.pucmm.views.login;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import edu.pucmm.services.UserService;
import edu.pucmm.views.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Login")
@Route(value = "login", layout = MainLayout.class)
public class LoginView extends Composite<VerticalLayout> {

    @Autowired
    private UserService userService;

    public LoginView() {
        LoginForm loginForm = new LoginForm();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().setAlignItems(Alignment.CENTER);
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, loginForm);
        loginForm.setId("loginForm");

        loginForm.addLoginListener(e -> {
           if (userService.validateUser(e.getUsername(), e.getPassword())) {
               UI.getCurrent().navigate("");
           } else {
               loginForm.setError(true);
               Notification.show("Usuario o contraseña incorrectos");
           }
        });

        getContent().add(loginForm);
    }
}
