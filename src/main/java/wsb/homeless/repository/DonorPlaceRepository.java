package wsb.homeless.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wsb.homeless.model.DonorPlace;

@Repository
public interface DonorPlaceRepository extends JpaRepository<DonorPlace, Integer> {

}
