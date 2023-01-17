package ds.DAO.Repositories;
import ds.DAO.Entities.Declaration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepDec  extends CrudRepository<Declaration,Long> {
}
