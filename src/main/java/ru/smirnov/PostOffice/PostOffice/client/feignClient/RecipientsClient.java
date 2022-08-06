package ru.smirnov.PostOffice.PostOffice.client.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.smirnov.PostOffice.PostOffice.DTO.RecipientsResponse;

import java.util.List;
import java.util.Map;

@FeignClient(name = "recipients", url = "http://localhost:8090")
public interface RecipientsClient {
    @GetMapping("recipients")
    ResponseEntity<Map> getRecipients();

    @GetMapping("/recipients/1")
    ResponseEntity<List> getRecipientsTest();
}
