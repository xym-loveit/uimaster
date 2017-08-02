package org.shaolin.bmdp.persistence.internal;

import org.shaolin.bmdp.persistence.HibernateUtil;
import org.shaolin.bmdp.runtime.AppContext;
import org.shaolin.bmdp.runtime.spi.ILifeCycleProvider;
import org.shaolin.bmdp.runtime.spi.IServerServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitialPersistenceService implements ILifeCycleProvider {

	private static final Logger logger = LoggerFactory.getLogger(InitialPersistenceService.class);
	
	@Override
	public void configService() {
		
	}
	
	@Override
	public void startService() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getConfiguration();
		
		// share the session object of the master node to all applications.
		if (IServerServiceManager.INSTANCE.getMasterNodeName().equals(AppContext.get().getAppName())) {
			IServerServiceManager.INSTANCE.setHibernateSessionFactory(
					HibernateUtil.getSessionFactory());
			IServerServiceManager.INSTANCE.setHibernateConfiguration(
					HibernateUtil.getConfiguration());
			logger.info("The session object of the master node is ready for sharing.");
		}
	}

	@Override
	public boolean readyToStop() {
		return true;
	}

	@Override
	public void stopService() {
		HibernateUtil.getSessionFactory().close();
		logger.info("shutdown hibernate connection.");
	}

	@Override
	public void reload() {
		
	}

	@Override
	public int getRunLevel() {
		return 0;
	}

}
