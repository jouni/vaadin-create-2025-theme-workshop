package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        var backButton = new Button("Back");

        var heading = new H1("About Your Business");

        var businessTitle = new TextField("Business Title", "Write title");
        businessTitle.setRequired(true);

        var description = new TextArea("Description", "Write description");
        description.setHelperText("Explain what your business is about");

        var companyType = new RadioButtonGroup<String>("Company Type");
        companyType.setItems("LLC / Partnership / Single-member", "C / S Corporation", "B Corporation");
        companyType.setValue("LLC / Partnership / Single-member");

        var numberOfEmployees = new RadioButtonGroup<String>("Number of Employees");
        numberOfEmployees.setHelperText("How many people work at your company");
        numberOfEmployees.setItems("1–20", "21–49", "50+");
        numberOfEmployees.setValue("1–20");

        var nextButton = new Button("Next");

        add(backButton, heading, businessTitle, description, companyType, numberOfEmployees, nextButton);
    }
}
