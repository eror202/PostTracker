package ru.smirnov.PostOffice.PostOffice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.PostOffice.PostOffice.models.TypesOfPost;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypesOfPostRepository extends JpaRepository<TypesOfPost, Integer> {
    public List<TypesOfPost> findByType(String type);
}