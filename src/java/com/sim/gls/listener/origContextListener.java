 package com.sim.gls.listener;

 import org.apache.log4j.PropertyConfigurator;

 import javax.servlet.ServletContext;
 import javax.servlet.ServletContextEvent;
 import javax.servlet.ServletContextListener;
 import java.io.File;

/**
 *
 * @author Levi
 */
public class origContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        System.setProperty("rootPath", context.getRealPath("/"));
        System.out.println("XXXXXXXXXXXXXXXXXX Log Path " + context.getRealPath("/"));
        String prefix = context.getRealPath("/");
        String file = "WEB-INF" + System.getProperty("file.separator") + "classes" + System.getProperty("file.separator") + "log4j.properties";
        if (file != null) {
            PropertyConfigurator.configure(prefix + System.getProperty("file.separator") + file);
            System.out.println("Log4J Logging started for application: " + prefix + System.getProperty("file.separator") + file);
        } else {
            System.out.println("Log4J Is not configured for application Application: " + prefix + System.getProperty("file.separator") + file);
        }
        String otherreports = context.getRealPath("/Other Reports");
        File or = new File(otherreports);
        if (!or.exists()) {
            or.mkdirs();
        }
        context.setAttribute("reportdir", or.getAbsolutePath());
        context.setAttribute("otherreps", or.getAbsolutePath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}

