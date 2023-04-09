package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.sevices.DataService;
import org.example.utils.PdfGenerator;
import org.example.models.Address;
import org.example.enums.Gender;
import org.example.models.Person;
import org.example.sevices.impl.DataServiceImpl;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите количество людей (1-30): ");
                numberOfPersons = scanner.nextInt();

                if (numberOfPersons >= 1 && numberOfPersons <= 30) {
                    validInput = true;
                } else {
                    System.out.println("Error: please enter a value between 1 and 30.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: please enter a valid integer value between 1 and 30.");
                scanner.next();
            }
        }

        DataService dataService = new DataServiceImpl();
        List<Person> personalDataList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();
        for (int i = 0; i < numberOfPersons; i++) {
            Gender gender = i % 2 == 0 ? Gender.MALE : Gender.FEMALE;
            personalDataList.add(dataService.getPersonInfoByGender(gender));
            addressList.add(dataService.getPersonAddress());
        }

        PdfGenerator.generatePDF(personalDataList, addressList, "personal_data.pdf");
    }
}
