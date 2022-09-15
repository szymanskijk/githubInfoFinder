package pl.szymanski.githubInformationFinder.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymanski.githubInformationFinder.Entity.Owner;

@Repository
public interface RepoRepository extends CrudRepository<Owner, Long> {
}
