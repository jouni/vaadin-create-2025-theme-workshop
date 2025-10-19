package org.vaadin.example;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextAreaVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        addClassName("form");

        var backButton = new Button("Back", new SvgIcon("./icons/arrow-back.svg"));

        var heading = new H1("About Your Business");

        var businessTitle = new TextField("Business Title", "Write title");
        businessTitle.setRequired(true);
        businessTitle.setWidthFull();

        var description = new TextArea("Description", "Write description");
        description.setWidthFull();
        description.setHelperText("Explain what your business is about");
        description.addThemeVariants(TextAreaVariant.LUMO_HELPER_ABOVE_FIELD);

        var companyType = new RadioButtonGroup<String>("Company Type");
        companyType.setItems("LLC / Partnership / Single-member", "C / S Corporation", "B Corporation");
        companyType.setValue("LLC / Partnership / Single-member");
        companyType.setWidthFull();
        companyType.addClassName("grouped-container");
        companyType.addClassName("aura-surface");

        var numberOfEmployees = new RadioButtonGroup<String>("Number of Employees");
        numberOfEmployees.setHelperText("How many people work at your company");
        numberOfEmployees.addThemeVariants(RadioGroupVariant.LUMO_HELPER_ABOVE_FIELD);
        numberOfEmployees.setItems("1–20", "21–49", "50+");
        numberOfEmployees.setValue("1–20");
        numberOfEmployees.setWidthFull();
        numberOfEmployees.addClassName("button-row");
        numberOfEmployees.setRenderer(new ComponentRenderer<>(number -> {
            SvgIcon icon = new SvgIcon();
            if (number == "1–20") {
                icon = new SvgIcon("./icons/user.svg");
            } else if (number == "21–49") {
                icon = new SvgIcon("./icons/users.svg");
            } else if (number == "50+") {
                icon = new SvgIcon("./icons/users2.svg");
            }
            Span numberLabel = new Span(new Text(number));

            return new Div(icon, numberLabel);
        }));

        var nextButton = new Button("Next", new SvgIcon("./icons/arrow-forward.svg"));
        nextButton.setIconAfterText(true);
        nextButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(backButton, heading, businessTitle, description, companyType, numberOfEmployees, nextButton);
    }
}
