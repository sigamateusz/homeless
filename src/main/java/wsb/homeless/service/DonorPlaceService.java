package wsb.homeless.service;

import wsb.homeless.model.DonorPlaceDTO;

import java.util.List;

public interface DonorPlaceService {

    void add(DonorPlaceDTO donorPlaceDTO);

    List<DonorPlaceDTO> getAll();
}
