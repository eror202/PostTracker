package ru.smirnov.PostOffice.PostOffice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.PostOffice.PostOffice.models.Recipients;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipientsRepository extends JpaRepository<Recipients, Integer> {
    List<Recipients> findByName(String name);

    Optional<Recipients> findByIndex(Integer index);

    Optional<Recipients> findRecipientsByIdentification(int identification);

}
