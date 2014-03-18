/**
 * 
 */
package validation.shared.error.services;

import org.eclipse.scout.rt.shared.validate.IValidationStrategy;
import org.eclipse.scout.rt.shared.validate.InputValidation;
import org.eclipse.scout.service.IService;

/**
 * @author mnc
 */
@InputValidation(IValidationStrategy.PROCESS.class)
public interface IDesktopService extends IService {

  /**
   * @param formData
   * @return
   */
  DesktopFormData load(DesktopFormData formData);
}
