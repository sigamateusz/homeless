package wsb.homeless.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wsb.homeless.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
