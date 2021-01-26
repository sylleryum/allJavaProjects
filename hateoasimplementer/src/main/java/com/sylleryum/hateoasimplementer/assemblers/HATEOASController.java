package com.sylleryum.hateoasimplementer.assemblers;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 * needs to be implemented by the controllers which will be part of the HATEOAS,
 *
 */
public interface HATEOASController {

    ResponseEntity<?> findAll(Pageable pageable);
    ResponseEntity<?> findById(Long id);

}
