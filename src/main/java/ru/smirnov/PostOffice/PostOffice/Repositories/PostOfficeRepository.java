package ru.smirnov.PostOffice.PostOffice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.PostOffice.PostOffice.models.PostOffice;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice,Integer> {


   Optional<PostOffice> findPostOfficeByName(String name);
}
