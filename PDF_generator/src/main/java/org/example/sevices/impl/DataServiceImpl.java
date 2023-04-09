package org.example.sevices.impl;

import org.example.models.Address;
import org.example.models.Region;
import org.example.sevices.DataService;
import org.example.enums.Gender;
import org.example.models.Person;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class DataServiceImpl implements DataService {
    private final Random random;
    private final List<String> maleFirstNames;
    private final List<String> maleMiddleNames;
    private final List<String> maleLastNames;
    private final List<String> femaleFirstNames;
    private final List<String> femaleMiddleNames;
    private final List<String> femaleLastNames;
    private final List<Region> regions;
    private final List<String> cities;
    private final List<String> streets;

    private static final String country = "Россия";

    public DataServiceImpl() {
        this.random = new Random();
        this.maleFirstNames = Arrays.asList("Александр", "Дмитрий", "Максим", "Иван", "Артем", "Кирилл", "Сергей", "Никита", "Андрей", "Михаил");
        this.maleMiddleNames = Arrays.asList("Александрович", "Дмитриевич", "Максимович", "Иванович", "Артемович", "Кириллович", "Сергеевич", "Никитович", "Андреевич", "Михайлович");
        this.maleLastNames = Arrays.asList("Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов", "Попов", "Васильев", "Соколов", "Михайлов", "Федоров");

        this.femaleFirstNames = Arrays.asList("Анна", "Мария", "Екатерина", "Софья", "Анастасия", "Виктория", "Дарья", "Елизавета", "Александра", "Полина");
        this.femaleMiddleNames = Arrays.asList("Александровна", "Дмитриевна", "Максимовна", "Ивановна", "Артемовна", "Кирилловна", "Сергеевна", "Никитична", "Андреевна", "Михайловна");
        this.femaleLastNames = Arrays.asList("Иванова", "Петрова", "Сидорова", "Смирнова", "Кузнецова", "Попова", "Васильева", "Соколова", "Михайлова", "Федорова");

        this.regions = new ArrayList<>();
        String city = "Москва";
        Map postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(101000, 136000)));
        regions.add(new Region("Московская", Arrays.asList(city), postCodes));

        city = "Воронеж";
        postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(394000, 398000)));
        regions.add(new Region("Воронежская", Arrays.asList(city), postCodes));

        city = "Новосибирск";
        postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(630000, 634000)));
        regions.add(new Region("Новосибирская", Arrays.asList(city), postCodes));

        city = "Екатеринбург";
        postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(620000, 625000)));
        regions.add(new Region("Свердловская", Arrays.asList(city), postCodes));

        city = "Казань";
        postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(420000, 424000)));
        regions.add(new Region("Казанская", Arrays.asList(city), postCodes));

        city = "Нижний Новгород";
        postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(603000, 608000)));
        regions.add(new Region("Нижегородская", Arrays.asList(city), postCodes));

        city = "Челябинск";
        postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(454000, 458000)));
        regions.add(new Region("Челябинская", Arrays.asList(city), postCodes));

        city = "Самара";
        postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(443000, 447000)));
        regions.add(new Region("Самарская", Arrays.asList(city), postCodes));

        city = "Омск";
        postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(644000, 647000)));
        regions.add(new Region("Омская", Arrays.asList(city), postCodes));

        city = "Ростов-на-Дону";
        postCodes = new HashMap();
        postCodes.put(city, Arrays.asList(ThreadLocalRandom.current().nextInt(344000, 348000)));
        regions.add(new Region("Ростовская", Arrays.asList(city), postCodes));

        this.cities = Arrays.asList("Москва", "Воронеж", "Новосибирск", "Екатеринбург", "Казань", "Нижний Новгород", "Челябинск", "Самара", "Омск", "Ростов-на-Дону");
        this.streets = Arrays.asList("Ленина", "9 января", "Лесная", "Профсоюзная", "Железнодорожная", "Титова", "Грушевая", "Авангардная", "Королева", "Гагарина");

    }

    @Override
    public Person getPersonInfoByGender(Gender gender) {
        String firstName, middleName, lastName;
        if (gender.equals(Gender.MALE)) {
            firstName = maleFirstNames.get(random.nextInt(maleFirstNames.size()));
            middleName = maleMiddleNames.get(random.nextInt(maleMiddleNames.size()));
            lastName = maleLastNames.get(random.nextInt(maleLastNames.size()));
        } else {
            firstName = femaleFirstNames.get(random.nextInt(femaleFirstNames.size()));
            middleName = femaleMiddleNames.get(random.nextInt(femaleMiddleNames.size()));
            lastName = femaleLastNames.get(random.nextInt(femaleLastNames.size()));
        }

        LocalDate birthDate = LocalDate.of(random.nextInt(50) + 1950, random.nextInt(12) + 1, random.nextInt(28) + 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = birthDate.format(formatter);


        String birthPlace = cities.get(random.nextInt(cities.size()));

        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return new Person(firstName, lastName, middleName, age, gender, formattedDate, birthPlace);
    }

    @Override
    public Address getPersonAddress() {
        Region region = regions.get(random.nextInt(regions.size()));
        String regionName = region.getName();
        List<String> cities = region.getCities();
        String city = cities.get(random.nextInt(cities.size()));
        List<Integer> postCodes = region.getPostCodesByCity(city);
        String postalCode = String.format("%06d", postCodes.get(random.nextInt(postCodes.size())));

        String street = streets.get(random.nextInt(streets.size()));
        String house = String.valueOf(random.nextInt(200) + 1);
        String apartment = String.valueOf(random.nextInt(500) + 1);
        return new Address(postalCode, country, regionName, city, street, house, apartment);
    }
}
