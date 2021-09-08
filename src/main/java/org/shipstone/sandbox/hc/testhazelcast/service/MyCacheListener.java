package org.shipstone.sandbox.hc.testhazelcast.service;

import com.hazelcast.cache.impl.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCacheListener implements CacheEventListener {

  public static final Logger LOGGER = LoggerFactory.getLogger(MyCacheListener.class);

  @Override
  public void handleEvent(Object eventObject) {
    LOGGER.info(
        "cache handle event"
    );
  }
}
