package ru.smirnov.PostOffice.PostOffice.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.PostOffice.PostOffice.Repositories.TypesOfPostRepository;
import ru.smirnov.PostOffice.PostOffice.models.TypesOfPost;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TypesOfPostService {
    private final TypesOfPostRepository typesOfPostRepository;
    private final RecipientsService recipientsService;

    public TypesOfPostService(TypesOfPostRepository typesOfPostRepository, RecipientsService recipientsService) {
        this.typesOfPostRepository = typesOfPostRepository;
        this.recipientsService = recipientsService;
    }

    public List<TypesOfPost> findAll() {
        return typesOfPostRepository.findAll();
    }

    public List<TypesOfPost> findByType(String type) {
        return typesOfPostRepository.findByType(type);
    }

    @Transactional
    public void registerTypeOfPost(TypesOfPost typesOfPost) {
        typesOfPost.setRecipient_identification(recipientsService.
                findByIdentification(typesOfPost.getRecipient_identification().getIdentification()).get());

        typesOfPostRepository.save(typesOfPost);
    }


}
