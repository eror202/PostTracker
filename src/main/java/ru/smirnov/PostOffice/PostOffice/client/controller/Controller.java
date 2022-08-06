package ru.smirnov.PostOffice.PostOffice.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smirnov.PostOffice.PostOffice.client.feignClient.RecipientsClient;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("testFeign")
public class Controller {
    private final RecipientsClient client;

    public Controller(RecipientsClient client) {
        this.client = client;
    }
    @GetMapping("/get")
    public ResponseEntity<Map> getRecipients(){
        return ResponseEntity.ok(client.getRecipients().getBody());
    }

    @GetMapping("/get1")
    public ResponseEntity<List> getRecipients1(){
        return ResponseEntity.ok(client.getRecipientsTest().getBody());
    }
}
