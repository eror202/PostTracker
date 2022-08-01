package ru.smirnov.PostOffice.PostOffice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smirnov.PostOffice.PostOffice.DTO.PostPathDTO;
import ru.smirnov.PostOffice.PostOffice.models.PostPath;
import ru.smirnov.PostOffice.PostOffice.services.PostPathService;

@RestController
@RequestMapping("postPath")
public class PostPathController {

    private final PostPathService postPathService;
    private final ModelMapper modelMapper;

    public PostPathController(PostPathService postPathService, ModelMapper modelMapper) {
        this.postPathService = postPathService;
        this.modelMapper = modelMapper;
    }
    @PostMapping("/registerPostPath")
    public ResponseEntity<HttpStatus> registerPostPath(@RequestBody PostPathDTO postPathDTO,
                                                       BindingResult bindingResult){
        PostPath postPath = converterToPostPath(postPathDTO);
        postPathService.registerPostPath(postPath);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    private PostPath converterToPostPath(PostPathDTO postPathDTO){
        return modelMapper.map(postPathDTO,PostPath.class);
    }
}
