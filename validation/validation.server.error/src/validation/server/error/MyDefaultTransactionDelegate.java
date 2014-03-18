/**
 *
 */
package validation.server.error;

import java.lang.reflect.Method;

import org.eclipse.scout.rt.server.DefaultTransactionDelegate;
import org.eclipse.scout.rt.shared.validate.IValidationStrategy;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

/**
 * @author mnc
 */
public class MyDefaultTransactionDelegate extends DefaultTransactionDelegate {

  /**
   * @param loaderBundles
   * @param requestMinVersion
   * @param debug
   */
  public MyDefaultTransactionDelegate(Bundle[] loaderBundles, Version requestMinVersion, boolean debug) {
    super(loaderBundles, requestMinVersion, debug);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void validateInput(IValidationStrategy validationStrategy, Object service, Method op, Object[] args) throws Exception {
    defaultValidateInput(validationStrategy, service, op, args);
  }

}
