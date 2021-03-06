/**
 * 
 */
package validation.client.mobile.error.ui.forms;

import org.eclipse.scout.commons.annotations.InjectFieldTo;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ClientJob;
import org.eclipse.scout.rt.extension.client.ui.form.fields.button.AbstractExtensibleButton;
import org.eclipse.scout.rt.shared.TEXTS;

import validation.client.error.ui.forms.DesktopForm;

/**
 * @author mnc
 */
public class MobileHomeForm extends DesktopForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public MobileHomeForm() throws ProcessingException {
    super();
  }

  /**
   * @return the LogoutButton
   */
  public LogoutButton getLogoutButton() {
    return getFieldByClass(LogoutButton.class);
  }

  @Order(10.0)
  @InjectFieldTo(DesktopForm.MainBox.class)
  public class LogoutButton extends AbstractExtensibleButton {

    @Override
    protected String getConfiguredLabel() {
      return TEXTS.get("Logoff");
    }

    @Override
    protected void execClickAction() throws ProcessingException {
      ClientJob.getCurrentSession().stopSession();
    }
  }
}
