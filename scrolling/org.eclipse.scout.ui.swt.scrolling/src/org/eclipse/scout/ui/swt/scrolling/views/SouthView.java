package org.eclipse.scout.ui.swt.scrolling.views;

import org.eclipse.scout.rt.ui.swt.ISwtEnvironment;
import org.eclipse.scout.rt.ui.swt.window.desktop.view.AbstractScoutView;
import org.eclipse.scout.ui.swt.scrolling.Activator;

public class SouthView extends AbstractScoutView {

  public SouthView() {
  }

  @Override
  protected ISwtEnvironment getSwtEnvironment() {
    return Activator.getDefault().getEnvironment();
  }
}
