/**
 *
 */
package org.eclipse.scout.client.scrolling.ui.forms;

import org.eclipse.scout.client.scrolling.DateLookupCall;
import org.eclipse.scout.client.scrolling.ui.forms.SecondForm.MainBox.CancelButton;
import org.eclipse.scout.client.scrolling.ui.forms.SecondForm.MainBox.GroupBox;
import org.eclipse.scout.client.scrolling.ui.forms.SecondForm.MainBox.GroupBox.TreeBoxField;
import org.eclipse.scout.client.scrolling.ui.forms.SecondForm.MainBox.OkButton;
import org.eclipse.scout.client.scrolling.ui.forms.SecondForm.MainBox.SecondGroupBox;
import org.eclipse.scout.client.scrolling.ui.forms.SecondForm.MainBox.SecondGroupBox.SomeTextField;
import org.eclipse.scout.client.scrolling.ui.forms.SecondForm.MainBox.ThirdGroupBox;
import org.eclipse.scout.client.scrolling.ui.forms.SecondForm.MainBox.ThirdGroupBox.MyLabelField;
import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.labelfield.AbstractLabelField;
import org.eclipse.scout.rt.client.ui.form.fields.textfield.AbstractTextField;
import org.eclipse.scout.rt.client.ui.form.fields.treebox.AbstractTreeBox;
import org.eclipse.scout.rt.extension.client.ui.basic.tree.AbstractExtensibleTree;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.lookup.LookupCall;
import org.eclipse.scout.service.SERVICES;
import org.eclipse.scout.shared.scrolling.ISecondService;
import org.eclipse.scout.shared.scrolling.SecondFormData;

/**
 * @author mnc
 */
@FormData(value = SecondFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class SecondForm extends AbstractForm {

  private Long m_secondNr;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public SecondForm() throws ProcessingException {
    super();
  }

  @Override
  protected int getConfiguredDisplayHint() {
    return DISPLAY_HINT_VIEW;
  }

  @Override
  protected String getConfiguredDisplayViewId() {
    return VIEW_ID_CENTER;
  }

  /**
   * @return the SecondNr
   */
  @FormData
  public Long getSecondNr() {
    return m_secondNr;
  }

  /**
   * @param secondNr
   *          the SecondNr to set
   */
  @FormData
  public void setSecondNr(Long secondNr) {
    m_secondNr = secondNr;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Second");
  }

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public void startModify() throws ProcessingException {
    startInternal(new ModifyHandler());
  }

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public void startNew() throws ProcessingException {
    startInternal(new NewHandler());
  }

  /**
   * @return the CancelButton
   */
  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  /**
   * @return the GroupBox
   */
  public GroupBox getGroupBox() {
    return getFieldByClass(GroupBox.class);
  }

  /**
   * @return the MainBox
   */
  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  /**
   * @return the MyLabelField
   */
  public MyLabelField getMyLabelField() {
    return getFieldByClass(MyLabelField.class);
  }

  /**
   * @return the OkButton
   */
  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  /**
   * @return the SecondGroupBox
   */
  public SecondGroupBox getSecondGroupBox() {
    return getFieldByClass(SecondGroupBox.class);
  }

  /**
   * @return the SomeTextField
   */
  public SomeTextField getSomeTextField() {
    return getFieldByClass(SomeTextField.class);
  }

  /**
   * @return the ThirdGroupBox
   */
  public ThirdGroupBox getThirdGroupBox() {
    return getFieldByClass(ThirdGroupBox.class);
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
    protected boolean getConfiguredScrollable() {
      return true;
    }

    @Order(10.0)
    public class GroupBox extends AbstractGroupBox {

      protected boolean getConfiguredExpandable() {
        return true;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("GroupBox");
      }

      @Order(10.0)
      public class TreeBoxField extends AbstractTreeBox<Long> {

        @Override
        protected boolean getConfiguredAutoExpandAll() {
          return true;
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
    }

    @Order(20.0)
    public class SecondGroupBox extends AbstractGroupBox {

      @Override
      protected boolean getConfiguredExpandable() {
        return true;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("SecondGroupBox");
      }

      @Order(10.0)
      public class SomeTextField extends AbstractTextField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("SomeText");
        }
      }
    }

    @Order(30.0)
    public class ThirdGroupBox extends AbstractGroupBox {

      @Override
      protected boolean getConfiguredExpandable() {
        return true;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("ThirdGroupBox");
      }

      @Order(10.0)
      public class MyLabelField extends AbstractLabelField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("MyLabel");
        }
      }
    }

    @Order(40.0)
    public class OkButton extends AbstractOkButton {
    }

    @Order(50.0)
    public class CancelButton extends AbstractCancelButton {
    }
  }

  public class ModifyHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      ISecondService service = SERVICES.getService(ISecondService.class);
      SecondFormData formData = new SecondFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);

    }

    @Override
    protected void execStore() throws ProcessingException {
      ISecondService service = SERVICES.getService(ISecondService.class);
      SecondFormData formData = new SecondFormData();
      exportFormData(formData);
      formData = service.store(formData);

    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      ISecondService service = SERVICES.getService(ISecondService.class);
      SecondFormData formData = new SecondFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);

    }

    @Override
    protected void execStore() throws ProcessingException {
      ISecondService service = SERVICES.getService(ISecondService.class);
      SecondFormData formData = new SecondFormData();
      exportFormData(formData);
      formData = service.create(formData);

    }
  }
}
