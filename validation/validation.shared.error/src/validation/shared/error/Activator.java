package validation.shared.error;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  public static String PLUGIN_ID = "validation.shared.error";

  private static Activator plugin;

  public static Activator getDefault() {
    return plugin;
  }

  @Override
  public void start(BundleContext context) throws Exception {
    plugin = this;
  }

  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
  }
}
