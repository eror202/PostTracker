package ru.smirnov.PostOffice.PostOffice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.PostOffice.PostOffice.DTO.TypesOfPostDTO;
import ru.smirnov.PostOffice.PostOffice.DTO.TypesOfPostResponse;
import ru.smirnov.PostOffice.PostOffice.models.TypesOfPost;
import ru.smirnov.PostOffice.PostOffice.services.TypesOfPostService;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("typesOfPost")
public class TypesOfPostController {
    private final TypesOfPostService typesOfPostService;
    private final ModelMapper modelMapper;

    public TypesOfPostController(TypesOfPostService typesOfPostService, ModelMapper modelMapper) {
        this.typesOfPostService = typesOfPostService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registerType")
    public ResponseEntity<HttpStatus> registerTypes(@RequestBody @Valid TypesOfPostDTO typesOfPostDTO,

                                                    BindingResult bindingResult){
        TypesOfPost typesOfPost = convertToTypesOfPost(typesOfPostDTO);
        typesOfPostService.registerTypeOfPost(typesOfPost);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/getAllPosts")
    public TypesOfPostResponse getAllPosts(){
        return new TypesOfPostResponse(typesOfPostService.findAll().stream().
                map(this::convertToTypesOfPostDTO).collect(Collectors.toList()));
    }

    @GetMapping("/getAllPostsByType")
    public TypesOfPostResponse getAllByType(String type){
        return new TypesOfPostResponse(typesOfPostService.findByType(type).stream()
                .map(this::convertToTypesOfPostDTO).collect(Collectors.toList()));
    }


    private TypesOfPost convertToTypesOfPost(TypesOfPostDTO typesOfPostDTO){
        return modelMapper.map(typesOfPostDTO, TypesOfPost.class);
    }

    private TypesOfPostDTO convertToTypesOfPostDTO(TypesOfPost typesOfPost){
        return modelMapper.map(typesOfPost, TypesOfPostDTO.class);
    }
}
