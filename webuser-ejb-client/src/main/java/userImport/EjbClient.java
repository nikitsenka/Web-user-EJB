package userImport;


import org.apache.log4j.Logger;
import org.jboss.ejb.client.ContextSelector;
import org.jboss.ejb.client.EJBClientConfiguration;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;

import static userImport.FileUtils.getPropertiesFromFile;

public class EjbClient {
    private static Logger logger = Logger.getLogger(EjbClient.class);
    private static final String APP_NAME = "web-user-ear";
    private static final String MODULE_NAME = "web-user-ejb";
    private Context initialContext;
    private String propertyFile;


    public EjbClient(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    public Object getRemoteEjb(Class clazz){
        String jndiName = "ejb:" + APP_NAME + "/" + MODULE_NAME + "/" + clazz.getSimpleName() + "Bean!" + clazz.getName();
        final Context context = getInitialContext();
        // The JNDI lookup name for a stateless session bean has the syntax of:
        // ejb:<APP_NAME>/<MODULE_NAME>/<distinctName>/<beanName>!<viewClassName>
        //
        // <APP_NAME> The application name is the name of the EAR that the EJB is deployed in
        // (without the .ear). If the EJB JAR is not deployed in an EAR then this is
        // blank. The app name can also be specified in the EAR's application.xml
        //
        // <MODULE_NAME> By the default the module name is the name of the EJB JAR file (without the
        // .jar suffix). The module name might be overridden in the ejb-jar.xml
        //
        // <distinctName> : AS7 allows each deployment to have an (optional) distinct name.
        // This example does not use this so leave it blank.
        //
        // <beanName> : The name of the session been to be invoked.
        //
        // <viewClassName>: The fully qualified classname of the remote interface. Must include
        // the whole package name.
        try {
            return context.lookup(jndiName);
        } catch (NamingException e) {
            logger.error("Can't find the object for JNDI: "+jndiName);
        }
        return null;
    }

    private Context getInitialContext(){
        if (this.initialContext !=null ){
            return initialContext;
        }else{
            Properties prop = getPropertiesFromFile(propertyFile);
            // Create a EJB client configuration
            final EJBClientConfiguration ejbClientConfiguration = new PropertiesBasedEJBClientConfiguration(prop);

            // EJB client context selection is based on selectors. So let's create a ConfigBasedEJBClientContextSelector which uses our EJBClientConfiguration created in previous step
            final ContextSelector<EJBClientContext> ejbClientContextSelector = new ConfigBasedEJBClientContextSelector(ejbClientConfiguration);

            // Now let's setup the EJBClientContext to use this selector
            EJBClientContext.setSelector(ejbClientContextSelector);

            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            final Context context;
            try {
                context = new InitialContext(jndiProperties);
                this.initialContext = context;
                return context;
            } catch (NamingException e) {
                logger.error("Can't create initial context. Please check the properties in  file: "+propertyFile);
            }
            return null;
        }
    }


}
