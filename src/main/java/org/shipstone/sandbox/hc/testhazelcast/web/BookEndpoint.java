package org.shipstone.sandbox.hc.testhazelcast.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shipstone.sandbox.hc.testhazelcast.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
@Slf4j
public class BookEndpoint {

  private final BookService bookService;

  @GetMapping("{id}")
  public String getBookTitle(
      @PathVariable("id") String id
  ) {
    log.info("Endpoint : Avant appel Service");
    String bookTilte = bookService.getBookTitle(id);
    log.info("Endpoint : Apres appel Service");
    return bookTilte;
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteBook(
      @PathVariable("id") String id
  ) {
    bookService.deleteBook(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
