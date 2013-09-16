package org.eclipse.test.client.ui.desktop.outlines.pages;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.extension.client.ui.basic.table.AbstractExtensibleTable;

public class TablePage extends AbstractPageWithTable<TablePage.Table> {

  @Override
  protected String getConfiguredTitle() {
    return "TablePage";
  }

  @Order(10.0)
  public class Table extends AbstractExtensibleTable {
  }
}
