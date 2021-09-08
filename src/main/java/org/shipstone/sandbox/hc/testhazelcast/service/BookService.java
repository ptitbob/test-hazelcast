package org.shipstone.sandbox.hc.testhazelcast.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  public static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

  @Cacheable(cacheNames = {"books"}, key = "#id")
  public String getBookTitle(
      String id
  ) {
    LOGGER.info("Coucou from service Books");
    return this.getBookTitleByVeryLongProcess() + String.format(" pour l'id %s", id);
  }

  private String getBookTitleByVeryLongProcess() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {

    }
    return "Book title";
  }

  @CacheEvict(cacheNames = {"books"}, key = "#id")
  public void deleteBook(String id) {

  }
}
