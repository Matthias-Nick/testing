/**
 * 
 */
package org.eclipse.scout.server.scrolling;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.service.AbstractService;
import org.eclipse.scout.shared.scrolling.ISecondService;
import org.eclipse.scout.shared.scrolling.SecondFormData;

/**
 * @author mnc
 */
public class SecondService extends AbstractService implements ISecondService {

  @Override
  public SecondFormData create(SecondFormData formData) throws ProcessingException {
    //TODO [mnc] business logic here.
    return formData;
  }

  @Override
  public SecondFormData load(SecondFormData formData) throws ProcessingException {
    //TODO [mnc] business logic here.
    return formData;
  }

  @Override
  public SecondFormData prepareCreate(SecondFormData formData) throws ProcessingException {
    //TODO [mnc] business logic here.
    return formData;
  }

  @Override
  public SecondFormData store(SecondFormData formData) throws ProcessingException {
    //TODO [mnc] business logic here.
    return formData;
  }
}
