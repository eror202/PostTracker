package ru.smirnov.PostOffice.PostOffice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.PostOffice.PostOffice.Repositories.RecipientsRepository;
import ru.smirnov.PostOffice.PostOffice.models.Recipients;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RecipientsService {
   private final RecipientsRepository recipientsRepository;
   private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RecipientsService(RecipientsRepository recipientsRepository, JdbcTemplate jdbcTemplate) {
        this.recipientsRepository = recipientsRepository;
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Recipients> findAll()
    {
       return recipientsRepository.findAll();
    }

    public List<Recipients> findByName(String name){
      return  recipientsRepository.findByName(name);
    }

    public Optional<Recipients> findByIndex(Integer index){
        return recipientsRepository.findByIndex(index);
    }

    public Optional<Recipients> findById(int id){
        return recipientsRepository.findById(id);
    }

    public Optional<Recipients> findByIdentification(int identification){
        return recipientsRepository.findRecipientsByIdentification(identification);
    }

    @Transactional
    public void registerRecipient(Recipients recipients){
        recipientsRepository.save(recipients);
    }
    @Transactional
    public void delivered(int identification){
        Recipients recipients = recipientsRepository.findRecipientsByIdentification(identification).get();
        recipients.setDelivered(true);
        recipients.setTimeOfDelivered(time());
        recipientsRepository.save(recipients);
    }

    private String time(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(time
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
       return String.valueOf(formatter).replace(";","");
    }
}

