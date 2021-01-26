package com.sylleryum.hateoasimplementer.controller;

import com.sylleryum.hateoasimplementer.assemblers.HATEOASController;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/states")
public class SampleController implements HATEOASController {


    @Override
    @GetMapping(value={"/", ""})
    public ResponseEntity<?> findAll(Pageable pageable) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return null;
    }
}
