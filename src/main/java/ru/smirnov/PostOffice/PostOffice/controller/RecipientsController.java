package ru.smirnov.PostOffice.PostOffice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.PostOffice.PostOffice.DTO.RecipientsDTO;
import ru.smirnov.PostOffice.PostOffice.DTO.RecipientsResponse;
import ru.smirnov.PostOffice.PostOffice.client.feignClient.RecipientsClient;
import ru.smirnov.PostOffice.PostOffice.models.Recipients;
import ru.smirnov.PostOffice.PostOffice.services.RecipientsService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("recipients")
public class RecipientsController {

    private final RecipientsService recipientsService;
    private final ModelMapper modelMapper;
    private final RecipientsClient recipientsClient;

    public RecipientsController(RecipientsService recipientsService, ModelMapper modelMapper, RecipientsClient recipientsClient) {
        this.recipientsService = recipientsService;
        this.modelMapper = modelMapper;
        this.recipientsClient = recipientsClient;
    }

    @PostMapping("/registrationOfRecipient")
    public ResponseEntity<HttpStatus> registrationOfPost(@RequestBody @Valid RecipientsDTO recipientsDTO,
                                                         BindingResult bindingResult) {

        Recipients recipients = convertedToRecipient(recipientsDTO);

        recipientsService.registerRecipient(recipients);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping ("/identification/delivered")
    public ResponseEntity<HttpStatus> postIsDeliveredToRecipient(@PathVariable("identification") int identification){
        recipientsService.delivered(identification);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public RecipientsResponse getAllRecipients(){
        return new RecipientsResponse(recipientsService.findAll()
                .stream().map(this::convertedToRecipientDTO).collect(Collectors.toList()));
    }
    @GetMapping("/1")
    public List<Recipients> getAllRecipients1(){
        return recipientsService.findAll();
    }
    private Recipients convertedToRecipient(RecipientsDTO recipientsDTO) {
        return modelMapper.map(recipientsDTO, Recipients.class);
    }

    private RecipientsDTO convertedToRecipientDTO(Recipients recipients) {
        return modelMapper.map(recipients, RecipientsDTO.class);
    }
}
