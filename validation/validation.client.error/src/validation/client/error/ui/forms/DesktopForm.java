/**
 *
 */
package validation.client.error.ui.forms;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.listbox.AbstractListBox;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;
import org.eclipse.scout.service.SERVICES;

import validation.client.error.ui.forms.DesktopForm.MainBox.GroupBox;
import validation.client.error.ui.forms.DesktopForm.MainBox.GroupBox.ListBoxField;
import validation.client.error.ui.forms.DesktopForm.MainBox.ListBoxTest2Field;
import validation.shared.error.CompanyTypeLookupCall;
import validation.shared.error.Icons;
import validation.shared.error.services.DesktopFormData;
import validation.shared.error.services.IDesktopService;

/**
 * @author mnc
 */
@FormData(value = DesktopFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class DesktopForm extends AbstractForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public DesktopForm() throws ProcessingException {
    super();
  }

  @Override
  protected boolean getConfiguredAskIfNeedSave() {
    return false;
  }

  @Override
  protected int getConfiguredDisplayHint() {
    return DISPLAY_HINT_VIEW;
  }

  @Override
  protected String getConfiguredDisplayViewId() {
    return VIEW_ID_CENTER;
  }

  @Override
  protected String getConfiguredIconId() {
    return Icons.EclipseScout;
  }

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public void startView() throws ProcessingException {
    startInternal(new ViewHandler());
  }

  /**
   * @return the MainBox
   */
  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public GroupBox getGroupBox() {
    return getFieldByClass(GroupBox.class);
  }

  public ListBoxField getListBoxField() {
    return getFieldByClass(ListBoxField.class);
  }

  public ListBoxTest2Field getListBoxTest2Field() {
    return getFieldByClass(ListBoxTest2Field.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {
    @Order(10.0)
    public class GroupBox extends AbstractGroupBox {

      @Order(10.0)
      public class ListBoxField extends AbstractListBox<Long> {

        @Override
        protected int getConfiguredGridH() {
          return 5;
        }

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ListBox");
        }

        @Override
        protected Class<? extends ILookupCall<Long>> getConfiguredLookupCall() {
          return CompanyTypeLookupCall.class;
        }
      }
    }

    @Order(20.0)
    public class ListBoxTest2Field extends AbstractListBoxGroupBox {

    }
  }

  public class ViewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IDesktopService service = SERVICES.getService(IDesktopService.class);
      DesktopFormData formData = new DesktopFormData();
      Set<Long> values = new HashSet<Long>();
      values.add(1L);
      getListBoxTest2Field().getListBoxTestField().setValue(values);
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);

    }
  }
}
