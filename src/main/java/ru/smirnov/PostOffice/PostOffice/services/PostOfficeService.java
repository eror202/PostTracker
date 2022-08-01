package ru.smirnov.PostOffice.PostOffice.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.PostOffice.PostOffice.Repositories.PostOfficeRepository;
import ru.smirnov.PostOffice.PostOffice.models.PostOffice;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    public PostOfficeService(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }
    @Transactional
    public void registerPostOffice(PostOffice postOffice){
        postOfficeRepository.save(postOffice);
    }
    public Optional<PostOffice> findByName(String name){
        return postOfficeRepository.findPostOfficeByName(name);
    }
}
