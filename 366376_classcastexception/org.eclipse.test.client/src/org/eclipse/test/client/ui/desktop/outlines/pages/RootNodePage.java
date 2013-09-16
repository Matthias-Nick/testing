package org.eclipse.test.client.ui.desktop.outlines.pages;

import java.util.Collection;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;

public class RootNodePage extends AbstractPageWithNodes {

  @Override
  protected String getConfiguredTitle() {
    return "RootNodePage";
  }

  @Override
  protected void execCreateChildPages(Collection<IPage> pageList) throws ProcessingException {
    SubRootNodePage rootNodePage = new SubRootNodePage();
    pageList.add(rootNodePage);
  }
}
