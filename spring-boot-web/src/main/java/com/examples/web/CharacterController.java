package com.examples.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CharacterController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public CharacterDto returnACharacter(){
        final CharacterDto characterDto = new CharacterDto();
        characterDto.setName("Liu Kang");
        characterDto.setDateOfCreation(LocalDate.of(1990, 10, 25));
        return characterDto;
    }
}
