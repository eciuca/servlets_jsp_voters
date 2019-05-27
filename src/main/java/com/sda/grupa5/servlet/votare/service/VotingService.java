package com.sda.grupa5.servlet.votare.service;

import com.sda.grupa5.servlet.votare.model.Person;

import java.util.ArrayList;
import java.util.List;

public class VotingService {

    private static VotingService INSTANCE;

    private List<Person> personList;

    private VotingService() {
        this.personList = new ArrayList<>();

        Person e = new Person("Emanuel", "Ciuca");
        this.personList.add(e);
        this.personList.add(new Person("Beatrice", "Bucur"));
        this.personList.add(new Person("Andor", "Toth"));
        this.personList.add(new Person("Cristi", "Cojocaru"));

    }

    public static VotingService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VotingService();
        }

        return INSTANCE;
    }

    public void addVoter(String firstName, String lastName) {
        Person voter = new Person(firstName, lastName);
        this.personList.add(voter);
    }

    public void deleteVoterByLastName(String lastName) {
        this.personList.removeIf(
                person -> person.getLastName().equals(lastName)
        );
    }

    public List<Person> getVotersList() {
        return personList;
    }

    public void updateVoter(Integer index, String firstName, String lastName) {
        Person voter = this.personList.get(index);

        voter.setFirstName(firstName);
        voter.setLastName(lastName);
    }
}
