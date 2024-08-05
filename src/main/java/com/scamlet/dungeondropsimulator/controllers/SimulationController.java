package com.scamlet.dungeondropsimulator.controllers;

import com.scamlet.dungeondropsimulator.entities.Item;
import com.scamlet.dungeondropsimulator.entities.Spec;
import com.scamlet.dungeondropsimulator.services.CharacterService;
import com.scamlet.dungeondropsimulator.services.DungeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SimulationController {

    private final CharacterService characterService;
    private final DungeonService dungeonService;

    @Autowired
    public SimulationController(CharacterService characterService, DungeonService dungeonService) {
        this.characterService = characterService;
        this.dungeonService = dungeonService;
    }


    @GetMapping("/simlist/{name}/{spec}")
    public Optional<List<Item>> simpleSimulationList(@PathVariable String name, @PathVariable String spec) {
        Optional<Spec> findSpec = characterService.findSpec(spec);

        return dungeonService.simpleSimulationList(name, findSpec);
    }

    @GetMapping("/sim/{name}/{spec}")
    public Optional<Item> simpleSimulation(@PathVariable String name, @PathVariable String spec) {
        Optional<Spec> findSpec = characterService.findSpec(spec);

        return dungeonService.simpleSimulation(name, findSpec);
    }


}
