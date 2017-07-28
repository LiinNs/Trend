package xyz.liinns.mongodb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.liinns.mongodb.domain.City;

/**
 * Description:
 * Created by LiinNs on 2017-7-28 0028.
 */
public interface CityRepository extends MongoRepository<City, String> {

    Page<City> findAll(Pageable pageable);

    City findByNameAndZipCode(String name, String zipCode);
}
