/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.kasim.system.app;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tr.kasim.system.login.LoginType;
import tr.kasim.system.remote.MainService;

/**
 *
 * @author S.KasımYurtaslan
 */
public class Application {

    static Application app;
    EntityManagerFactory entityManagerFactory;
    AppConfig config;
    static ApplicationContext spring;
    Logger log;
    Object loginUserObj;
    LoginType loginType;

    public static void main(String[] args) {
        app = new Application();
        app.init();
    }

    public static Application getApp() {
        if (app == null) {
            initSpring();
            app = (Application) spring.getBean("application");
            app.init();
        }
        return app;
    }

    private void init() {
        setLoginType(LoginType.Admin);
        //initConsoleLog();
        initSpring();
        initFileLog();
        initDb();

    }

    private void initDb() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ogrenci");
        if (log.isDebugEnabled()) {
            log.debug("[Application][Db] initialized");
        }
    }

    public AppConfig getConfig() {
        return config;
    }

    public void setConfig(AppConfig config) {
        this.config = config;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    private void initFileLog() {
        PropertyConfigurator.configure(ClassLoader.getSystemResource("./log4j/logger.properties"));

        log = Logger.getLogger(Application.class);
        if (log.isDebugEnabled()) {
            log.debug("[Application][Logger] initialized");
        }
    }

    private void initConsoleLog() {
        Properties logProperties = new Properties();
        logProperties.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        logProperties.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
        logProperties.setProperty("log4j.appender.stdout.layout.conversionPattern", "%-5p-%d{ISO8601}: %-10t :[%C{1}][%M]: %m%n");
        logProperties.setProperty("log4j.logger.tr.kasim", "DEBUG,stdout");
        PropertyConfigurator.configure(logProperties);

        log = Logger.getLogger(Application.class);
        if (log.isDebugEnabled()) {
            log.debug("[Application][Logger] initialized");
        }
    }

    public MainService getMainService() {
        return (MainService) spring.getBean("mainService");
    }

    public Object getLoginUserObj() {
        return loginUserObj;
    }

    public void setLoginUserObj(Object loginUserObj) {
        this.loginUserObj = loginUserObj;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    private void initDisplay() {
        if (log.isDebugEnabled()) {
            log.debug("[Application][Display] Starting");
        }
    }

    public void destroy() {
        entityManagerFactory.close();
    }

    private static void initSpring() {
        spring = new ClassPathXmlApplicationContext("/spring/application.xml");
    }

    public ApplicationContext getSpring() {
        return spring;
    }
}
