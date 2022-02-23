package wsb.homeless.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wsb.homeless.model.DonorPlace;
import wsb.homeless.model.DonorPlaceDTO;
import wsb.homeless.repository.DonorPlaceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DonorPlaceServiceImpl implements DonorPlaceService {

    private DonorPlaceRepository donorPlaceRepository;

    @Override
    public void add(DonorPlaceDTO donorPlaceDTO) {
        DonorPlace donorPlace = donorPlaceDTO.toEntity();
        donorPlaceRepository.save(donorPlace);
    }

    @Override
    public List<DonorPlaceDTO> getAll() {
        return donorPlaceRepository.findAll().stream()
                .map(DonorPlaceDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
