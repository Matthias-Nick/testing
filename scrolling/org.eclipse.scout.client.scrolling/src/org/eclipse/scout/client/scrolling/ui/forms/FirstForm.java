/**
 *
 */
package org.eclipse.scout.client.scrolling.ui.forms;

import org.eclipse.scout.client.scrolling.DateLookupCall;
import org.eclipse.scout.client.scrolling.ui.forms.FirstForm.MainBox.OpenSecondFormButton;
import org.eclipse.scout.client.scrolling.ui.forms.FirstForm.MainBox.StringfieldField;
import org.eclipse.scout.client.scrolling.ui.forms.FirstForm.MainBox.TreeBoxField;
import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.client.ui.form.fields.treebox.AbstractTreeBox;
import org.eclipse.scout.rt.extension.client.ui.basic.tree.AbstractExtensibleTree;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.lookup.LookupCall;
import org.eclipse.scout.service.SERVICES;
import org.eclipse.scout.shared.scrolling.Icons;
import org.eclipse.scout.shared.scrolling.services.DesktopFormData;
import org.eclipse.scout.shared.scrolling.services.IDesktopService;

/**
 * @author mnc
 */
@FormData(value = DesktopFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class FirstForm extends AbstractForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public FirstForm() throws ProcessingException {
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

  /**
   * @return the OpenSecondFormButton
   */
  public OpenSecondFormButton getOpenSecondFormButton() {
    return getFieldByClass(OpenSecondFormButton.class);
  }

  /**
   * @return the StringfieldField
   */
  public StringfieldField getStringfieldField() {
    return getFieldByClass(StringfieldField.class);
  }

  /**
   * @return the TreeBoxField
   */
  public TreeBoxField getTreeBoxField() {
    return getFieldByClass(TreeBoxField.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Override
    protected int getConfiguredGridColumnCount() {
      return 1;
    }

    @Override
    protected boolean getConfiguredScrollable() {
      return true;
    }

    @Order(10.0)
    public class StringfieldField extends AbstractStringField {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Stringfield");
      }
    }

    @Order(20.0)
    public class TreeBoxField extends AbstractTreeBox<Long> {

      @Override
      protected boolean getConfiguredAutoExpandAll() {
        return true;
      }

      @Override
      protected int getConfiguredGridH() {
        return 6;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("TreeBox");
      }

      @Override
      protected Class<? extends LookupCall> getConfiguredLookupCall() {
        return DateLookupCall.class;
      }

      @Order(10.0)
      public class Tree extends AbstractExtensibleTree {
      }
    }

    @Order(30.0)
    public class OpenSecondFormButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("OpenSecondForm");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        SecondForm form = new SecondForm();
        form.startNew();
        form.waitFor();
      }
    }
  }

  public class ViewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IDesktopService service = SERVICES.getService(IDesktopService.class);
      DesktopFormData formData = new DesktopFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);

    }
  }
}
