package br.com.xt.dio.java.services;

import br.com.xt.dio.java.entities.LocationData;
import br.com.xt.dio.java.entities.Person;

import java.time.LocalDate;

public class RegisterPerson {

    private MailApi mailApi;

    public RegisterPerson(final MailApi mailApi) {
        this.mailApi = mailApi;
    }

    public Person register(String name, String document, LocalDate birth, String code) {
        Person person = new Person(name, document, birth);
        LocationData dadosLocalizacao = mailApi.searchLocationDataByPostalCode(code);
        person.addLocationData(dadosLocalizacao);
        return person;
    }
}
