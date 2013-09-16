package org.eclipse.test.ui.rap;

import org.eclipse.scout.rt.ui.rap.mobile.AbstractMobileStandaloneRwtEnvironment;
import org.eclipse.test.client.ClientSession;

public class MobileStandaloneRwtEnvironment extends AbstractMobileStandaloneRwtEnvironment {

  public MobileStandaloneRwtEnvironment() {
    super(Activator.getDefault().getBundle(), ClientSession.class);
  }
}
