package button;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;

/**
 * A CheckBox whose label supports multiline. See {@link MultilineButton} for more information
 * 
 * @since 3.10.0-M4
 */
public class MultilineCheckbox extends MultilineButton {
  private static final long serialVersionUID = 1L;

  public MultilineCheckbox(Composite parent, int style) {
    super(parent, style | SWT.CHECK);

    m_label.addMouseListener(new P_LabelMouseListener());
  }

  /**
   * Install a mouse listener on the label. Otherwise, the CheckBox would only react on mouse clicks on the button.
   */
  private class P_LabelMouseListener implements MouseListener {

    @Override
    public void mouseDoubleClick(MouseEvent e) {
    }

    @Override
    public void mouseDown(MouseEvent e) {
    }

    @Override
    public void mouseUp(MouseEvent e) {
      if (leftMouseButtonClicked(e)) {
        m_btn.setFocus();
        m_btn.setSelection(!m_btn.getSelection());
      }
    }

    private boolean leftMouseButtonClicked(MouseEvent e) {
      if (e.button == 1) {
        return true;
      }
      return false;
    }
  }
}
