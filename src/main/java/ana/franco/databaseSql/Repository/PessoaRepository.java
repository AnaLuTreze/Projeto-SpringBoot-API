package ana.franco.databaseSql.Repository;

import ana.franco.databaseSql.model.PessoaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntity, Long> { // retorno long


}
