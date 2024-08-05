package com.scamlet.dungeondropsimulator.controllers;

import com.scamlet.dungeondropsimulator.entities.Item;
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
public class DropController {

    private final DungeonService dungeonService;

    @Autowired
    public DropController(DungeonService dungeonService) {
        this.dungeonService = dungeonService;
    }

    @GetMapping("/getdroplist")
    public Optional<List<List<Item>>> getDropList() {
        List<List<Item>> itemDropList = dungeonService.getDropListAll();

        return Optional.ofNullable(itemDropList);
    }

    @GetMapping("/getdrop/{name}")
    public Optional<List<Item>> getDrop(@PathVariable String name) {
        List<Item> itemDropList = dungeonService.getDropList(name);

        return Optional.ofNullable(itemDropList);

    }

}
