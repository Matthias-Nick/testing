package org.eclipse.scout.ui.swt.scrolling.application.button;

import org.eclipse.jface.action.Action;
import org.eclipse.scout.rt.client.ui.action.IAction;
import org.eclipse.scout.ui.swt.scrolling.Activator;

public class CoolbarButton extends Action {

  private IAction m_button;

  public CoolbarButton() {
    setText(" ");
    setEnabled(false);
  }

  public void init(IAction b) {
    setText(b.getText());
    setId(b.getActionId());
    setActionDefinitionId(b.getActionId());
    setToolTipText(b.getTooltipText());
    setImageDescriptor(Activator.getDefault().getEnvironment().getImageDescriptor(b.getIconId()));
    m_button = b;
  }

  @Override
  public void run() {
    Runnable r = new Runnable() {
      @Override
      public void run() {
        m_button.setSelected(true);
        m_button.getUIFacade().fireActionFromUI();
      }
    };
    Activator.getDefault().getEnvironment().invokeScoutLater(r, 10000);
  }
}
