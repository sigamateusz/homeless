package wsb.homeless.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wsb.homeless.model.Address;
import wsb.homeless.repository.AddressRepository;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }
}