package org.example.sevices;

import org.example.models.Address;
import org.example.models.Person;
import org.example.enums.Gender;

public interface DataService {
    Person getPersonInfoByGender(Gender gender);

    Address getPersonAddress();
}
