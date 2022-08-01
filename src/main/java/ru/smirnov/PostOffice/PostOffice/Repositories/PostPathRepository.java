package ru.smirnov.PostOffice.PostOffice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.PostOffice.PostOffice.models.PostPath;

@Repository
public interface PostPathRepository extends JpaRepository<PostPath,Integer> {
}
