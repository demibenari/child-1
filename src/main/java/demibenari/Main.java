package demibenari;

import com.google.inject.Injector;
import demibenari.common.authentication.SecurityService;
import demibenari.common.configuration.ConfigProvider;
import demibenari.common.guice.modules.CommonModule;
import demibenari.controllers.MainController;
import demibenari.controllers.guice.modules.ControllersModule;
import demibenari.common.guice.modules.factories.InjectorFactory;
import demibenari.model.guice.modules.ModelModule;
import demibenari.view.guice.modules.ViewModule;

/**
 *
 * Created by Demi Ben-Ari on 12/13/2014.
 */
public class Main {

    public static void main(String[] args) {
        intiateModules();

        initMainControllerAndStartApplication();
    }

    private static void initMainControllerAndStartApplication() {
        System.out.println("Application started");

        Injector injector = InjectorFactory.getInjector();

        ConfigProvider configProvider = injector.getInstance(ConfigProvider.class);

        String property = configProvider.getProperty("some.property.name");

        MainController mainController = injector.getInstance(MainController.class);

        SecurityService securityService = mainController.getSecurityService();

        System.out.println("Application Finished");
    }

    private static void intiateModules() {
        InjectorFactory.injectModule(new CommonModule());
        InjectorFactory.injectModule(new ControllersModule());
        InjectorFactory.injectModule(new ModelModule());
        InjectorFactory.injectModule(new ViewModule());
    }
}