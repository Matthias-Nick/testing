package org.eclipse.test.client.ui.desktop.outlines.pages;

import java.util.Collection;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;

public class SubRootNodePage extends AbstractPageWithNodes {

  @Override
  protected String getConfiguredTitle() {
    return "SubRootNodePage";
  }

  @Override
  protected void execCreateChildPages(Collection<IPage> pageList) throws ProcessingException {
    FolderNodePage folderNodePage = new FolderNodePage();
    pageList.add(folderNodePage);

    /**
     * In order to reproduce the bug, I will outcomment this two lines
     */
    TablePage tablePage = new TablePage();
    pageList.add(tablePage);
  }
}
