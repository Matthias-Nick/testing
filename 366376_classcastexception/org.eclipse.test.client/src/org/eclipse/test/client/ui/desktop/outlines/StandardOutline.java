package org.eclipse.test.client.ui.desktop.outlines;

import java.util.Collection;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.extension.client.ui.desktop.outline.AbstractExtensibleOutline;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.test.client.ui.desktop.outlines.pages.SubRootNodePage;
import org.eclipse.test.client.ui.desktop.outlines.pages.RootNodePage;

public class StandardOutline extends AbstractExtensibleOutline {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("StandardOutline");
  }

  @Override
  protected void execCreateChildPages(Collection<IPage> pageList) throws ProcessingException {
//    RootNodePage rootNodePage = new RootNodePage();
//    pageList.add(rootNodePage);

    RootNodePage test = new RootNodePage();
    pageList.add(test);
  }
}
