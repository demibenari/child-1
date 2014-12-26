package demibenari.controllers;

import com.google.inject.Inject;
import demibenari.common.Initializable;
import demibenari.common.authentication.AuthSecurityException;
import demibenari.common.authentication.SecurityService;
import demibenari.common.guice.providers.SecurityServiceProvider;

/**
 *
 * Created by Demi Ben-Ari on 12/26/2014.
 */
public class MainController implements Initializable {
    private SecurityService securityService;

    // Note: You have to inject the CheckedException Provider to the constructor
    @Inject
    public MainController(SecurityServiceProvider<SecurityService> securityServiceProvider) {
        System.out.println("Main Controller Constructor Started");

        // Because we are using the Provider to get the SecurityService,
        // And the SecurityService might throw AuthSecurityException,
        // This becomes a Check Exception like we wanted
        try {
            securityService = securityServiceProvider.get();
        } catch (AuthSecurityException e) {
            System.out.println("Couldn't initiate security service");
            e.printStackTrace();
        }

        System.out.println("Main Controller Constructor Finished");
    }

    public SecurityService getSecurityService() {
        System.out.println("Getting and returning security service");
        return securityService;
    }

    @Override
    public void initialize() {
        System.out.println("Starting the initialization of the Main controller");

        System.out.println("Finished the initialization of the Main controller");
    }
}
