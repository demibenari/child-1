package demibenari;

import com.google.inject.Injector;
import demibenari.common.authentication.SecutiryService;
import demibenari.common.configuration.ConfigProvider;
import demibenari.common.guice.modules.CommonModule;
import demibenari.controllers.guice.modules.ControllersModule;
import demibenari.common.guice.modules.factories.InjectorFactory;
import demibenari.model.guice.modules.ModelModule;
import demibenari.view.guice.modules.ViewModule;

public class Main {
    public static void main(String[] args) {
        intiateModules();

        startApplication();
    }

    private static void startApplication() {
        System.out.println("Application started");

        Injector injector = InjectorFactory.getInjector();

        ConfigProvider configProvider = injector.getInstance(ConfigProvider.class);

        String property = configProvider.getProperty("some.property.name");

        SecutiryService securityService = injector.getInstance(SecutiryService.class);


        System.out.println("Application Finished");
    }

    private static void intiateModules() {
        InjectorFactory.injectModule(new CommonModule());
        InjectorFactory.injectModule(new ControllersModule());
        InjectorFactory.injectModule(new ModelModule());
        InjectorFactory.injectModule(new ViewModule());
    }
}