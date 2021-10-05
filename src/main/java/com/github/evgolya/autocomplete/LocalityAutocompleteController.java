package com.github.evgolya.autocomplete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalityAutocompleteController {

    private final LocalityAutocompleteService localityAutocompleteService;

    public LocalityAutocompleteController(LocalityAutocompleteService localityAutocompleteService) {
        this.localityAutocompleteService = localityAutocompleteService;
    }

    @GetMapping("/autocomplete")
    @ResponseBody
    public ResponseEntity<LocalityAutocompleteDto> getLocalities(@RequestBody LocalityAutocompleteCommand localityAutocompleteCommand) {
         return ResponseEntity
             .ok()
             .header("Access-Control-Allow-Origin", "*")
             .body(localityAutocompleteService.getLocalitiesAutocomplete(localityAutocompleteCommand.getLocality()));
    }
}
