package com.best.great.controller;


import com.best.great.entity.Test_Member;
import com.best.great.repository.Test_MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaConnectTestController {

    @Autowired
    Test_MemberRepository repository;

    @GetMapping("/findall")
    public String findAll() {
        String result = "";

        for (Test_Member member : repository.findAll()) {
            result += member.toString() + "</br>";
        }

        return result;
    }

    @GetMapping ("/findbyid")
    public String findById (@RequestParam("id") long id){
        String result = "";

        for (Test_Member member : repository.findById(id)) {
            result += member.toString() + "</br>";
        }

        return result;
    }

    @GetMapping ("/findbylastname")
    public String findById (@RequestParam("lastname") String lastName){
        String result = "";

        for (Test_Member member : repository.findByLastName(lastName)) {
            result += member.toString() + "</br>";
        }

        return result;
    }

    @GetMapping("/add")
    public String addMember(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("email") String email) {

        repository.save(new Test_Member (firstName, lastName, email));

        return "Addition done!";
    }

    @GetMapping ("/update")
    public String updateMember(@RequestParam("id") long id, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("email") String email) {

        Test_Member member = repository.findById(id).get(0);

        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setEmail(email);
        repository.save(member);

        return "Update done!";
    }

    @GetMapping ("/delete")
    public String deleteMember(@RequestParam("id") long id) {

        repository.deleteById(id);

        return "Delete done!";
    }
}
