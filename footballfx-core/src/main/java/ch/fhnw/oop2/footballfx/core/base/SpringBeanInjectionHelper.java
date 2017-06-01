package ch.fhnw.oop2.footballfx.core.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Helper class which is able to resolve Spring dependencies for Jersey Services.
 * <p>
 * Jersey Services are not SpringBeans and Spring is therefore not able to inject beans.
 * <p>
 * Usage: SpringBeanInjectionHelper.inject(this)
 */
public class SpringBeanInjectionHelper implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public SpringBeanInjectionHelper() {
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) {
        SpringBeanInjectionHelper.applicationContext = applicationContext;
    }

    public static void inject(Object classToAutowire) {
        applicationContext.getAutowireCapableBeanFactory().autowireBean(classToAutowire);
    }
}
