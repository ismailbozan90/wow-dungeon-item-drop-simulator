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

@RestController
@RequestMapping("/api")
public class DropItemSimulatorController {

    private final CharacterService characterService;
    private final DungeonService dungeonService;

    @Autowired
    public DropItemSimulatorController(CharacterService characterService, DungeonService dungeonService) {
        this.characterService = characterService;
        this.dungeonService = dungeonService;
    }

    @GetMapping("/getdroplist")
    public ResponseEntity<List<List<Item>>> getDropList() {
        List<List<Item>> itemDropList = dungeonService.getDropListAll();
        if (itemDropList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok(itemDropList);
    }

    @GetMapping("/getdrop/{name}")
    public ResponseEntity<List<Item>> getDrop(@PathVariable String name) {
        List<Item> itemDropList = dungeonService.getDropList(name);
        if (itemDropList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok(itemDropList);

    }

    @GetMapping("/simlist/{name}/{spec}")
    public ResponseEntity<List<Item>> simpleSimulationList(@PathVariable String name, @PathVariable String spec) {
        Spec findSpec = characterService.findSpec(spec);
        if (findSpec == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        List<Item> itemDropList = dungeonService.simpleSimulationList(name, findSpec);
        if (itemDropList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok(itemDropList);
    }

    @GetMapping("/sim/{name}/{spec}")
    public ResponseEntity<Item> simpleSimulation(@PathVariable String name, @PathVariable String spec) {
        Spec findSpec = characterService.findSpec(spec);
        if (findSpec == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Item item = dungeonService.simpleSimulation(name, findSpec);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok(item);
    }


}
