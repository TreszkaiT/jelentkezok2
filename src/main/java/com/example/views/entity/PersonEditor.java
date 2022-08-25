package com.example.views.entity;

import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

// tag::snippet[]
public class PersonEditor extends FormLayout {
    private Binder<BusinessPerson> binder;					// Binding - kötés deklarálása

    public PersonEditor(boolean readOnly) {
        // For binding the form to the data model -- az űrlap adatmodellhez kötéséhez(bind)
        binder = new Binder<>(BusinessPerson.class);

        TextField nameField = new TextField();				// 1. mező deklarálása  (Name)
        addFormItem(nameField, "Name");						// mező formhoz adása
        binder.bind(nameField, BusinessPerson::getName,		// mező bindelése, méghozzá a business person / Name GET-SET metódusainak
            BusinessPerson::setName);
        nameField.setReadOnly(readOnly);					// read only 

        TextField titleField = new TextField();				// 2. mező deklarálása  (Title)
        addFormItem(titleField, "Title");
        binder.forField(titleField)
              .bind(BusinessPerson::getTitle,
                    BusinessPerson::setTitle);
        titleField.setReadOnly(readOnly);
    }

    public Binder<BusinessPerson> getBinder() {return binder;}
}
// end::snippet[]
