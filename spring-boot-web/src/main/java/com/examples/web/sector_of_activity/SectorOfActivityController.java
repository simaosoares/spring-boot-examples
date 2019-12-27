package com.examples.web.sector_of_activity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RestController
@RequestMapping("sectorsOfActivity")
public class SectorOfActivityController {

    static List<SectorOfActivity> sectorOfActivityList = new ArrayList<SectorOfActivity>() {{
        add(new SectorOfActivity("Automotive & Transportation"));
        add(new SectorOfActivity("Electro-electronics & Telecoms"));
    }};

    @GetMapping
    @ResponseBody
    public List<SectorOfActivity> findAll() {
        return sectorOfActivityList;
    }

    @ResponseBody
    @GetMapping("/{name}")
    public SectorOfActivity findByName(@PathVariable("name") String name) throws Throwable {
        return sectorOfActivityList.stream()
                .filter(sectorOfActivity -> sectorOfActivity.getName().equals(name))
                .findFirst()
                .orElseThrow((Supplier<Throwable>) SectorOfActivityNotFound::new);
    }

    @ResponseBody
    @GetMapping("/findBySearchTerm")
    public List<SectorOfActivity> findBySearchTerm(@RequestParam("searchTerm") String searchTerm) {
        return sectorOfActivityList.stream()
                .filter(sectorOfActivity -> sectorOfActivity.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }

}
