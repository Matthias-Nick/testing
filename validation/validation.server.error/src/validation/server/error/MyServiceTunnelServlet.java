/**
 *
 */
package validation.server.error;

import org.eclipse.scout.rt.server.ServiceTunnelServlet;
import org.eclipse.scout.rt.shared.servicetunnel.ServiceTunnelRequest;
import org.eclipse.scout.rt.shared.servicetunnel.ServiceTunnelResponse;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

/**
 * @author mnc
 */
public class MyServiceTunnelServlet extends ServiceTunnelServlet {

  @Override
  protected ServiceTunnelResponse runServerJobTransactionWithDelegate(ServiceTunnelRequest req, Bundle[] loaderBundles, Version requestMinVersion, boolean debug) throws Exception {
    return new MyDefaultTransactionDelegate(loaderBundles, requestMinVersion, debug).invoke(req);
  }
}
