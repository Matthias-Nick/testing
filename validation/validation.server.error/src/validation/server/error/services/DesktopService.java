/**
 *
 */
package validation.server.error.services;

import org.eclipse.scout.service.AbstractService;

import validation.shared.error.services.DesktopFormData;
import validation.shared.error.services.IDesktopService;

/**
 * @author mnc
 */
public class DesktopService extends AbstractService implements IDesktopService {

  @Override
  public DesktopFormData load(DesktopFormData formData) {
    return formData;
  }
}
