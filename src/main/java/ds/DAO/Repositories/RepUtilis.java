package ds.DAO.Repositories;
import ds.DAO.Entities.Declaration;
import ds.DAO.Entities.Propriete;
import org.springframework.data.repository.CrudRepository;

public interface RepProp extends CrudRepository<Propriete,Long> {
}
