package validation.shared.error.services.common.text;

import org.eclipse.scout.rt.shared.services.common.text.AbstractDynamicNlsDocumentationTextProviderService;

public class DefaultDocumentationTextProviderService extends AbstractDynamicNlsDocumentationTextProviderService {

  @Override
  protected String getDynamicNlsBaseName() {
    return "resources.docs.Docs";
  }
}
