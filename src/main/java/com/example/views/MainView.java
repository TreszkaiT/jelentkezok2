package com.example.views;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.bean.Card;
import com.example.views.controller.PersonController;
import com.example.views.entity.BusinessPerson;
import com.example.views.entity.Person;
import com.example.views.entity.PersonEditor;
import com.example.views.repository.PersonRepository;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

import org.springframework.beans.factory.annotation.Autowired;

//import com.vaadin.demo.DemoExporter;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route(value = "")	//"/start")
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
//@Theme(themeFolder = "feltoltes")
//@CssImport("./themes/feltoltes/styles/styles.css")
//@CssImport(value = "./themes/feltoltes/main-layout.css", themeFor = "vaadin-text-field")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
//@Route(value="", layout = MainLayout.class) 
@PageTitle("Contacts | Vaadin CRM")
public class MainView extends VerticalLayout {


    private static final String SZEMELYES_ADATOK = "Személyes adatok";    
    private static final String LAKCIM_ADATOK = "Lakcím adatok";
    private static final String TANULMANYOK = "Tanulmányok";
    private static final String SZAKMAI_TAPASZTALAT = "Szakmai tapasztalat";
    private static final String NYELVISMERET = "Nyelvismeret";
    private static final String EGYEB_KESZSEGEK = "Egyéb készségek";
    private static final String MOTIVACIOS_LEVEL = "Motivációs levél";
    
    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) {
    	    	
    	
    	/*TextField fisrtName = new TextField("Vezetéknév");
    	fisrtName.addThemeName("bordered");
    	fisrtName.setRequiredIndicatorVisible(true);
    	fisrtName.setErrorMessage("Kötelező kitölteni");
    	
        // Use TextField for standard text input
        TextField lastName = new TextField("Keresztnév");
        lastName.addThemeName("bordered");
        lastName.setRequiredIndicatorVisible(true);
        lastName.setErrorMessage("Kötelező kitölteni");
        
        EmailField emailField = new EmailField();
        emailField.setLabel("Email-cím");
        
        DatePicker szulDatum = new DatePicker();
        szulDatum.setLabel("Születési dátum");
        
        TextField phoneNumber = new TextField();
        phoneNumber.setLabel("Telefonszám");
        phoneNumber.setHelperText("Ország és vidék tulajdonságok beépítve");
        
        // Button click listeners can be defined as lambda expressions
        Button button = new Button("Szia!",
                e -> Notification.show(service.greet(fisrtName.getValue())));

        // Theme variants give you predefined extra styles for components.
        // Example: Primary button has a more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        button.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");

        add(fisrtName, lastName, emailField, phoneNumber, szulDatum, button);
        
    	
        
        DataBinding();*/

        AccordionSummary();
    }
    
   /* public void DataBinding() {
        // Data model
        BusinessPerson person = new BusinessPerson();			// Bean- adat osztály deklarálása

        // Two editors: the actual editor and read-only display
        PersonEditor editor1 = new PersonEditor(false);			// a két mezőből egy példány készítése balra
        PersonEditor editor2 = new PersonEditor(true);			// ------ || ---- másik ----- || ----  jobbra

        // The editor and buttons
        VerticalLayout layout1 = new VerticalLayout();
        HorizontalLayout buttons = new HorizontalLayout();
        Button saveButton = new Button("Save");
        saveButton.addClickListener(click -> {
            try {
                editor1.getBinder().writeBean(person);
                editor2.getBinder().readBean(person);
            } catch (ValidationException e) {}
        });
        Button resetButton = new Button("Reset");
        resetButton.addClickListener(click -> {
            editor1.getBinder().readBean(person);
        });
        buttons.add(saveButton, resetButton);
        layout1.add(editor1, buttons);

        VerticalLayout layout2 = new VerticalLayout();
        layout2.add(editor2);

        // Show the two editors side-by-side
        HorizontalLayout hlayout = new HorizontalLayout();
        hlayout.setDefaultVerticalComponentAlignment(
            FlexComponent.Alignment.START);
        hlayout.add(layout1, layout2);
        add(hlayout);
    }*/
    
    

    

    public void AccordionSummary() {
    	
    	//Person person = new Person();
    	
    	Accordion accordion = new Accordion();
    	
        Binder<Person> personBinder = new Binder<>(Person.class);
        personBinder.setBean(new Person());

        Binder<Card> cardBinder = new Binder<>(Card.class);
        cardBinder.setBean(new Card());

        FormLayout customerDetailsFormLayout = createFormLayout();
        AccordionPanel customDetailsPanel = accordion.add(SZEMELYES_ADATOK,  customerDetailsFormLayout);

        FormLayout cimAddressFormLayout = createFormLayout();
        AccordionPanel cimAddressPanel = accordion.add(LAKCIM_ADATOK,  cimAddressFormLayout);
        
        FormLayout tanulmFormLayout = createFormLayout();
        AccordionPanel tanulmPanel = accordion.add(TANULMANYOK,  tanulmFormLayout);
        
        FormLayout szakmtapFormLayout = createFormLayout();
        AccordionPanel szakmtapPanel = accordion.add(SZAKMAI_TAPASZTALAT,  szakmtapFormLayout);
        
        FormLayout nyelvismFormLayout = createFormLayout();
        AccordionPanel nyelvismPanel = accordion.add(NYELVISMERET,  nyelvismFormLayout);
        
        FormLayout egyebkeszsFormLayout = createFormLayout();
        AccordionPanel egyebkeszsPanel = accordion.add(EGYEB_KESZSEGEK,  egyebkeszsFormLayout);
        
        FormLayout motivlevFormLayout = createFormLayout();
        AccordionPanel motivlevPanel = accordion.add(MOTIVACIOS_LEVEL,  motivlevFormLayout);

        // Személyes adatok fields -----------------------------------------------------------------------------

        HorizontalLayout textfields1 = new HorizontalLayout();           
	        TextField firstName = new TextField("Vezetéknév");
	        personBinder.forField(firstName).bind("firstName");
	        firstName.addThemeName("bordered");
	        firstName.setRequiredIndicatorVisible(true);
	        firstName.setErrorMessage("Kötelező kitölteni");
	        
	
	        TextField lastName = new TextField("Keresztnév");
	        lastName.addThemeName("bordered");
	        lastName.setRequiredIndicatorVisible(true);
	        lastName.setErrorMessage("Kötelező kitölteni");
	        personBinder.forField(lastName).bind("lastName");              
        textfields1.add(firstName, lastName);         
        
        EmailField email = new EmailField("Email-cím");
        personBinder.forField(email).bind("email");
        
        HorizontalLayout textfields4 = new HorizontalLayout();
	        DatePicker szulDatum = new DatePicker();
	        szulDatum.setLabel("Születési dátum");
	        szulDatum.setHelperText("Figyelj a helyes beírásra");
	
	        TextField phone = new TextField("Telefonszám");
	        personBinder.forField(phone).bind(person -> {
	            if  (person.getAddress() != null) {
	                //return person.getAddress().getPhone();
	            	return person.getPhone();
	            }
	            return "";
	        }, (person, value) -> {
	            /*if (person.getAddress() == null) {
	                person.setAddress(new Address());
	            }*/
	            //person.getAddress().setPhone(value);
	            person.setPhone(value);
	        });
        textfields4.add(szulDatum, phone);

        customerDetailsFormLayout.add(textfields1, 2);
        customerDetailsFormLayout.add(email, 2);
        customerDetailsFormLayout.add(textfields4, 2);    	
    	
    	//AccordionPanel customDetailsPanel = accordion.add(SZEMELYES_ADATOK,  customerDetailsFormLayout);
    	customDetailsPanel.addOpenedChangeListener(e -> {
    	    if(e.isOpened()) {
    	        customDetailsPanel.setSummaryText(SZEMELYES_ADATOK);
    	    } else if(personBinder.getBean() != null) {
    	        Person personValues = personBinder.getBean();
    	        customDetailsPanel.setSummary(createSummary(SZEMELYES_ADATOK,
    	            personValues.getFirstName() + " " + personValues.getLastName(),
    	            personValues.getEmail(),
    	            personValues.getPhone()	//getAddress() != null ? personValues.getAddress().getPhone() : ""
    	        ));
    	    }
    	});

    	Button customDetailsButton = new Button("Tovább", (e) -> cimAddressPanel.setOpened(true));
        customDetailsButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        customDetailsPanel.addContent(customDetailsButton);

        
        
        // Cím adatok fields -----------------------------------------------------------------------------
        
        TextField address = new TextField("Lakcím");
        personBinder.forField(address).bind(person -> {
                return person.getAddress();
        }, (person, value) -> {
            person.setAddress(value);
        });
        
        HorizontalLayout textfields2 = new HorizontalLayout(); 
	        TextField zipCode = new TextField("Irányítószám");
	        personBinder.forField(address).bind(person -> {
	        	return person.getZip();//return Integer.toString(person.getZip()); //
	        }, (person, value) -> {
	        	person.setZip(value); //person.setZip(Integer.parseInt(value));  // 
	        });
	        
	        TextField city = new TextField("Város");
	        personBinder.forField(address).bind(person -> {
	                return person.getCity();
	        }, (person, value) -> {
	            person.setCity(value);
	        });
        textfields2.add(zipCode, city);  
        
        TextField countries = new TextField("Ország");
        personBinder.forField(address).bind(person -> {
                return person.getCountry();
        }, (person, value) -> {
            person.setCountry(value);
        });
        
        
        cimAddressFormLayout.add(address, 2);
        cimAddressFormLayout.add(textfields2, 2);
        cimAddressFormLayout.add(countries, 1);

        cimAddressPanel.addOpenedChangeListener(e -> {
            if(e.isOpened()) {
                cimAddressPanel.setSummaryText(LAKCIM_ADATOK);
            } else if(personBinder.getBean().getAddress() != null) {
                /*Address addressValues = personBinder.getBean().getAddress();
                cimAddressPanel.setSummary(createSummary(LAKCIM_ADATOK,
                    addressValues.getStreet(),
                    addressValues.getZip() + " " + addressValues.getCity(),
                    addressValues.getCountry()
                ));*/
            }
        });

        Button cimAddressButton = new Button("Tovább", (e) -> cimAddressPanel.setOpened(true));
        cimAddressButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cimAddressPanel.addContent(cimAddressButton);


        // Tanulmányok fields -----------------------------------------------------------------------------
        
/*        TextField accountNumber = new TextField("Card number");
        personBinder.forField(accountNumber).bind("accountNumber");

        tanulmFormLayout.add(accountNumber, 2);
*/
        tanulmPanel.addOpenedChangeListener(e -> {
            if(e.isOpened()) {
                tanulmPanel.setSummaryText(TANULMANYOK);
            } else if(personBinder.getBean().getAddress() != null) {
                /*Address addressValues = personBinder.getBean().getAddress();
                tanulmAddressPanel.setSummary(createSummary(LAKCIM_ADATOK,
                    addressValues.getStreet(),
                    addressValues.getZip() + " " + addressValues.getCity(),
                    addressValues.getCountry()
                ));*/
            }
        });

        Button tanulmButton = new Button("Tovább", (e) -> tanulmPanel.setOpened(true));
        tanulmButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        tanulmPanel.addContent(tanulmButton);

        // Szakmai Tapasztalat fields -----------------------------------------------------------------------------
        
/*        TextField accountNumber = new TextField("Card number");
        //cardBinder.forField(accountNumber).bind("accountNumber");

        HorizontalLayout textfields3 = new HorizontalLayout();
        TextField expiryDate = new TextField("Expiry date");
        //cardBinder.forField(expiryDate).bind("expiryDate");

        TextField cvv = new TextField("CVV");
        //cardBinder.forField(cvv).bind("cvv");
        textfields3.add(expiryDate, cvv);

        szakmtapFormLayout.add(accountNumber, 2);
        szakmtapFormLayout.add(textfields3);
*/
        szakmtapPanel.addOpenedChangeListener(e -> {
            if(e.isOpened()) {
                szakmtapPanel.setSummaryText(SZAKMAI_TAPASZTALAT);
            } else if(personBinder.getBean().getAddress() != null) {
                /*Address addressValues = personBinder.getBean().getAddress();
                tanulmAddressPanel.setSummary(createSummary(LAKCIM_ADATOK,
                    addressValues.getStreet(),
                    addressValues.getZip() + " " + addressValues.getCity(),
                    addressValues.getCountry()
                ));*/
            }
        });

        Button szakmtapButton = new Button("Tovább", (e) -> szakmtapPanel.setOpened(true));
        szakmtapButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        szakmtapPanel.addContent(szakmtapButton);
        
        // Nyelvismeret fields -----------------------------------------------------------------------------
        
/*        TextField accountNumber = new TextField("Card number");
        //cardBinder.forField(accountNumber).bind("accountNumber");

        HorizontalLayout textfields3 = new HorizontalLayout();
        TextField expiryDate = new TextField("Expiry date");
        //cardBinder.forField(expiryDate).bind("expiryDate");

        TextField cvv = new TextField("CVV");
        //cardBinder.forField(cvv).bind("cvv");
        textfields3.add(expiryDate, cvv);

        nyelvismFormLayout.add(accountNumber, 2);
        nyelvismFormLayout.add(textfields3);
*/
        nyelvismPanel.addOpenedChangeListener(e -> {
            if(e.isOpened()) {
                nyelvismPanel.setSummaryText(NYELVISMERET);
            } else if(personBinder.getBean().getAddress() != null) {
                /*Address addressValues = personBinder.getBean().getAddress();
                tanulmAddressPanel.setSummary(createSummary(LAKCIM_ADATOK,
                    addressValues.getStreet(),
                    addressValues.getZip() + " " + addressValues.getCity(),
                    addressValues.getCountry()
                ));*/
            }
        });

        Button nyelvismButton = new Button("Tovább", (e) -> nyelvismPanel.setOpened(true));
        nyelvismButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        nyelvismPanel.addContent(nyelvismButton);
        
        // Egyéb készségek fields -----------------------------------------------------------------------------
        
/*        TextField accountNumber = new TextField("Card number");
        //cardBinder.forField(accountNumber).bind("accountNumber");

        HorizontalLayout textfields3 = new HorizontalLayout();
        TextField expiryDate = new TextField("Expiry date");
        //cardBinder.forField(expiryDate).bind("expiryDate");

        TextField cvv = new TextField("CVV");
        //cardBinder.forField(cvv).bind("cvv");
        textfields3.add(expiryDate, cvv);

        egyebkeszsFormLayout.add(accountNumber, 2);
        egyebkeszsFormLayout.add(textfields3);
*/
        egyebkeszsPanel.addOpenedChangeListener(e -> {
            if(e.isOpened()) {
                egyebkeszsPanel.setSummaryText(EGYEB_KESZSEGEK);
            } else if(personBinder.getBean().getAddress() != null) {
                /*Address addressValues = personBinder.getBean().getAddress();
                tanulmAddressPanel.setSummary(createSummary(LAKCIM_ADATOK,
                    addressValues.getStreet(),
                    addressValues.getZip() + " " + addressValues.getCity(),
                    addressValues.getCountry()
                ));*/
            }
        });

        Button egyebkeszsButton = new Button("Tovább", (e) -> egyebkeszsPanel.setOpened(true));
        egyebkeszsButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        egyebkeszsPanel.addContent(egyebkeszsButton);

    
        
        // Motivációs levél fields -----------------------------------------------------------------------------
        
/*        TextField accountNumber = new TextField("Card number");
        //cardBinder.forField(accountNumber).bind("accountNumber");

        HorizontalLayout textfields3 = new HorizontalLayout();
        TextField expiryDate = new TextField("Expiry date");
        //cardBinder.forField(expiryDate).bind("expiryDate");

        TextField cvv = new TextField("CVV");
        //cardBinder.forField(cvv).bind("cvv");
        textfields3.add(expiryDate, cvv);

        motivlevFormLayout.add(accountNumber, 2);
        tanulmFormLayout.add(textfields3);
*/
        motivlevPanel.addOpenedChangeListener(e -> {
            if(e.isOpened()) {
                motivlevPanel.setSummaryText(MOTIVACIOS_LEVEL);
            } else if(cardBinder.getBean() != null) {
               /* Card cardValues = cardBinder.getBean();
                motivlevPanel.setSummary(createSummary(TANULMANYOK,
                    cardValues.getAccountNumber(),
                    cardValues.getExpiryDate()
                ));*/
            }
        });

        HorizontalLayout buttons = new HorizontalLayout();
	        Button resetButton = new Button("Reset");
	        resetButton.addClickListener(click -> {
	        	//accordion.getBinder().readBean(person);
	        	address.setValue("");//.setLabel("aa");	        	
	        });              
	        //Button motivlevButton = new Button("Mentés", (e) -> motivlevPanel.setOpened(false));
	        Button motivlevButton = new Button("Mentés");
	        motivlevButton.addClickListener(click -> {
	        	//PersonController::findById(1);   
	        	motivlevPanel.setOpened(false);
	        }); 
	        motivlevButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        buttons.add(motivlevButton, resetButton); 
        motivlevPanel.addContent(buttons);

        add(accordion);    	
    }
    
    
    private FormLayout createFormLayout() {
        FormLayout cimAddressFormLayout = new FormLayout();
        cimAddressFormLayout.setResponsiveSteps(
          new FormLayout.ResponsiveStep("0", 1),
          new FormLayout.ResponsiveStep("20em", 2)
        );
        return cimAddressFormLayout;
    }

    private VerticalLayout createSummary(String title, String... details) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(false);
        layout.setPadding(false);

        layout.add(title);

        if (details.length > 0) {   
            VerticalLayout detailsLayout = new VerticalLayout();
            detailsLayout.setSpacing(false);
            detailsLayout.setPadding(false);
            detailsLayout.getStyle().set("font-size", "var(--lumo-font-size-s)");
            
            for (String detail: details) {
                if (detail != null && !detail.isEmpty()) {
                    detailsLayout.add(new Span(detail));
                }
            }
            
            layout.add(detailsLayout);
        }

        return layout;
    }
    
    


}

/*
	 PS C:\> cd Users
	PS C:\Users> netstat -ona | findstr :8080 | findstr LISTENING
	  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       66380
	  TCP    [::]:8080              [::]:0                 LISTENING       66380
	PS C:\Users> taskkill /PID 66380 /F
	SUCCESS: The process with PID 66380 has been terminated.
 */
