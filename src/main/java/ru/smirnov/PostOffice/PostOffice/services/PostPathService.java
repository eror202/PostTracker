package ru.smirnov.PostOffice.PostOffice.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.PostOffice.PostOffice.Repositories.PostPathRepository;
import ru.smirnov.PostOffice.PostOffice.models.PostPath;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.String.valueOf;

@Service
@Transactional(readOnly = true)
public class PostPathService {
    private final PostPathRepository postPathRepository;
    private final PostOfficeService postOfficeService;
    private final RecipientsService recipientsService;

    public PostPathService(PostPathRepository postPathRepository, PostOfficeService postOfficeService, RecipientsService recipientsService) {
        this.postPathRepository = postPathRepository;
        this.postOfficeService = postOfficeService;
        this.recipientsService = recipientsService;
    }

    @Transactional
    public void registerPostPath(PostPath postPath) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter time = DateTimeFormatter.ofPattern(
                localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        String timeToString = String.valueOf(time).replace("'","");
        postPath.setRegistration_time(timeToString);

        postPath.setPost_office_name(postOfficeService.findByName(
                postPath.getPost_office_name().getName()).get());

        postPath.setRecipient_identification(recipientsService.findByIdentification(
                postPath.getRecipient_identification().getIdentification()
        ).get());
        postPathRepository.save(postPath);
    }
}
