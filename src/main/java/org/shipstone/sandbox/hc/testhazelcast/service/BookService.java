package org.shipstone.sandbox.hc.testhazelcast.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {

  @Cacheable(cacheNames = {"books"}, key = "#id")
  public String getBookTitle(
      String id
  ) {
    log.info("Coucou from service Books");
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
