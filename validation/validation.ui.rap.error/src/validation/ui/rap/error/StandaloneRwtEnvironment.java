package validation.ui.rap.error;

import org.eclipse.scout.rt.ui.rap.AbstractStandaloneRwtEnvironment;

import validation.client.error.ClientSession;

public class StandaloneRwtEnvironment extends AbstractStandaloneRwtEnvironment {

  public StandaloneRwtEnvironment() {
    super(Activator.getDefault().getBundle(), ClientSession.class);
  }
}
