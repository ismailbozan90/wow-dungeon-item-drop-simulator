package com.scamlet.dungeondropsimulator.controllers;

import com.scamlet.dungeondropsimulator.entities.Item;
import com.scamlet.dungeondropsimulator.entities.Spec;
import com.scamlet.dungeondropsimulator.services.CharacterService;
import com.scamlet.dungeondropsimulator.services.DungeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Item>> simpleSimulationList(@PathVariable String name, @PathVariable String spec) {
        Optional<Spec> findSpec = characterService.findSpec(spec);
        Optional<List<Item>> result = dungeonService.simpleSimulationList(name, findSpec);

        if (result.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .header("Simulation", "Empty")
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Simulation", "Value")
                .body(result.get());



    }

    @GetMapping("/sim/{name}/{spec}")
    public ResponseEntity<Item> simpleSimulation(@PathVariable String name, @PathVariable String spec) {
        Optional<Spec> findSpec = characterService.findSpec(spec);
        Optional<Item> result = dungeonService.simpleSimulation(name, findSpec);

        if (result.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .header("Simulation", "Empty")
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Simulation", "Value")
                .body(result.get());
    }


}
