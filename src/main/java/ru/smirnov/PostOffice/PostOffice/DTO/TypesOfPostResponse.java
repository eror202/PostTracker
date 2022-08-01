package ru.smirnov.PostOffice.PostOffice.DTO;

import ru.smirnov.PostOffice.PostOffice.models.TypesOfPost;

import java.util.List;

public class TypesOfPostResponse {
    private List<TypesOfPostDTO> typesOfPostResponse;

    public TypesOfPostResponse(List<TypesOfPostDTO> typesOfPostResponse) {
        this.typesOfPostResponse = typesOfPostResponse;
    }
    
    public List<TypesOfPostDTO> getTypesOfPostResponse() {
        return typesOfPostResponse;
    }

    public void setTypesOfPostResponse(List<TypesOfPostDTO> typesOfPostResponse) {
        this.typesOfPostResponse = typesOfPostResponse;
    }
}
