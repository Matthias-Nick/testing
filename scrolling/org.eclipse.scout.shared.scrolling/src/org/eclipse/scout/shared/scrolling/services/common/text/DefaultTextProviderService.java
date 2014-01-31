package org.eclipse.scout.shared.scrolling.services.common.text;

import org.eclipse.scout.rt.shared.services.common.text.AbstractDynamicNlsTextProviderService;

public class DefaultTextProviderService extends AbstractDynamicNlsTextProviderService {
  @Override
  protected String getDynamicNlsBaseName() {
    return "resources.texts.Texts";
  }
}
