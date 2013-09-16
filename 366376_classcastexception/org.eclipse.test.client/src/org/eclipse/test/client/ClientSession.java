package org.eclipse.test.client;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.logger.IScoutLogger;
import org.eclipse.scout.commons.logger.ScoutLogManager;
import org.eclipse.scout.rt.client.AbstractClientSession;
import org.eclipse.scout.rt.client.ClientJob;
import org.eclipse.scout.rt.client.ClientSyncJob;
import org.eclipse.scout.rt.client.services.common.bookmark.IBookmarkService;
import org.eclipse.scout.rt.client.servicetunnel.http.HttpServiceTunnel;
import org.eclipse.scout.rt.shared.services.common.bookmark.Bookmark;
import org.eclipse.scout.rt.shared.services.common.code.CODES;
import org.eclipse.scout.service.SERVICES;
import org.eclipse.test.client.ui.desktop.Desktop;

public class ClientSession extends AbstractClientSession {
  private static IScoutLogger logger = ScoutLogManager.getLogger(ClientSession.class);

  public ClientSession() {
    super(true);
  }

  /**
   * @return session in current ThreadContext
   */
  public static ClientSession get() {
    return ClientJob.getCurrentSession(ClientSession.class);
  }

  @Override
  public void execLoadSession() throws ProcessingException {
    setServiceTunnel(new HttpServiceTunnel(this, getBundle().getBundleContext().getProperty("server.url")));

    //pre-load all known code types
    CODES.getAllCodeTypes(org.eclipse.test.shared.Activator.PLUGIN_ID);

    setDesktop(new Desktop());

    IBookmarkService bookmarkService = SERVICES.getService(IBookmarkService.class);
    bookmarkService.loadBookmarks();
    Bookmark b = bookmarkService.getStartBookmark();
    if (b != null) {
      try {
        ClientSyncJob.getCurrentSession().getDesktop().activateBookmark(b, false);
      }
      catch (Throwable t) {
        logger.error(null, t);
      }
    }

    // turn client notification polling on
    // getServiceTunnel().setClientNotificationPollInterval(2000L);
  }

  @Override
  public void execStoreSession() throws ProcessingException {
  }
}
