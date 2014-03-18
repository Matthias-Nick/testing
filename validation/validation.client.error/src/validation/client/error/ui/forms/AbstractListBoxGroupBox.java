package validation.client.error.ui.forms;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.FormData.DefaultSubtypeSdkCommand;
import org.eclipse.scout.commons.annotations.FormData.SdkCommand;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.rt.client.ui.form.fields.IValueField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.listbox.AbstractListBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;

import validation.shared.error.AbstractListBoxGroupBoxData;
import validation.shared.error.CompanyTypeLookupCall;

/**
 *
 */
@FormData(value = AbstractListBoxGroupBoxData.class, sdkCommand = SdkCommand.CREATE, defaultSubtypeSdkCommand = DefaultSubtypeSdkCommand.CREATE)
public class AbstractListBoxGroupBox extends AbstractGroupBox {

  public ConstraintField getConstraintField() {
    return getFieldByClass(ConstraintField.class);
  }

  public ListBoxTestField getListBoxTestField() {
    return getFieldByClass(ListBoxTestField.class);
  }

  @Order(12)
  public class ConstraintField extends AbstractStringField {

    @Override
    protected String getConfiguredLabel() {
      return "Constraint";
    }

  }

  @Order(15)
  public class ListBoxTestField extends AbstractListBox<Long> {

    @Override
    protected String getConfiguredLabel() {
      return TEXTS.get("ListBox");
    }

    @Override
    protected Class<? extends ILookupCall<Long>> getConfiguredLookupCall() {
      return CompanyTypeLookupCall.class;
    }

    @Override
    protected Class<? extends IValueField> getConfiguredMasterField() {
      return ConstraintField.class;
    }

  }

}
