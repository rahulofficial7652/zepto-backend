package zepto.Zepto_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zepto.Zepto_backend.model.Location;
import zepto.Zepto_backend.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Location saveLocation (Location location){
        return locationRepository.save(location);
    }
}
