package com.basic.thrift.service;

import com.basic.thrift.beans.DataException;
import com.basic.thrift.beans.Person;
import com.basic.thrift.beans.PersonService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonServiceImpl implements PersonService.Iface {
    Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
    
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        log.info("Get client param:"+username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        log.info("Get client param:");
        log.info("姓名：{}",person.getUsername());
        log.info("年龄：{}",person.getAge());
        log.info("婚姻：{}",person.isMarried());
    }
}
