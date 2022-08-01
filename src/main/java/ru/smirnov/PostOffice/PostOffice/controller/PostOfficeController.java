package ru.smirnov.PostOffice.PostOffice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smirnov.PostOffice.PostOffice.DTO.PostOfficeDTO;
import ru.smirnov.PostOffice.PostOffice.models.PostOffice;
import ru.smirnov.PostOffice.PostOffice.services.PostOfficeService;

@RestController
@RequestMapping("PostOffice")
public class PostOfficeController {
    private final PostOfficeService postOfficeService;
    private final ModelMapper modelMapper;

    public PostOfficeController(PostOfficeService postOfficeService, ModelMapper modelMapper) {
        this.postOfficeService = postOfficeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registerPostOffice")
    public ResponseEntity<HttpStatus> registerPostOffice(@RequestBody PostOfficeDTO postOfficeDTO,
                                                         BindingResult bindingResult){
        PostOffice postOffice = converterToPostOffice(postOfficeDTO);

        postOfficeService.registerPostOffice(postOffice);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    private PostOffice converterToPostOffice(PostOfficeDTO postOfficeDTO){
        return modelMapper.map(postOfficeDTO, PostOffice.class);
    }
}
