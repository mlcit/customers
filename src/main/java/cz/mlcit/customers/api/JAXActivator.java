package cz.mlcit.customers.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by Mlcit on 07.02.2017.
 * JAXActivator is an arbitrary name, what is important is that javax.ws.rs.core.Application is extended
 * and the @ApplicationPath annotation is used with a "/api" path.
 */
@ApplicationPath("/api")
public class JAXActivator extends Application {
    // Left empty intentionally
}