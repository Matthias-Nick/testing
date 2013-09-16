package org.eclipse.test.ui.rap;

import org.eclipse.scout.rt.ui.rap.AbstractStandaloneRwtEnvironment;
import org.eclipse.test.client.ClientSession;

public class StandaloneRwtEnvironment extends AbstractStandaloneRwtEnvironment {

  public StandaloneRwtEnvironment() {
    super(Activator.getDefault().getBundle(), ClientSession.class);
  }
}
