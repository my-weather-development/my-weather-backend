package com.github.evgolya.autocomplete;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

// TODO: use ip from HttpServletRequest instead publicIpMock
@RestController
public class LocalityAutocompleteController {

    private final LocalityAutocompleteService localityAutocompleteService;
    private final String publicIpMock;

    public LocalityAutocompleteController(@Value("${public.ip.mock}") String publicIpMock, LocalityAutocompleteService localityAutocompleteService) {
        this.localityAutocompleteService = localityAutocompleteService;
        this.publicIpMock = publicIpMock;
    }

    @GetMapping("/autocomplete")
    @ResponseBody
    public ResponseEntity<LocalityAutocompleteDto> getLocalities(
        @RequestBody LocalityAutocompleteCommand localityAutocompleteCommand,
        HttpServletRequest httpServletRequest
    ) {
        return ResponseEntity
             .ok()
             .body(localityAutocompleteService.getLocalitiesAutocomplete(localityAutocompleteCommand.getLocality(), publicIpMock));
    }
}
