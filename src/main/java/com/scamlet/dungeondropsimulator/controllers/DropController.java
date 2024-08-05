package com.scamlet.dungeondropsimulator.controllers;

import com.scamlet.dungeondropsimulator.entities.Item;
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
public class DropController {

    private final DungeonService dungeonService;

    @Autowired
    public DropController(DungeonService dungeonService) {
        this.dungeonService = dungeonService;
    }

    @GetMapping("/getdroplist")
    public ResponseEntity<List<List<Item>>> getDropList() {
        List<List<Item>> itemDropList = dungeonService.getDropListAll();
        if (itemDropList.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .header("DropList", "Empty")
                    .body(null);
        }


        return ResponseEntity
                .status(HttpStatus.OK)
                .header("DropList", "Values")
                .body(itemDropList);
    }

    @GetMapping("/getdrop/{name}")
    public ResponseEntity<List<Item>> getDrop(@PathVariable String name) {
        List<Item> itemDropList = dungeonService.getDropList(name);

        if (itemDropList.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .header("Drop", "Empty")
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Drop", "Value")
                .body(itemDropList);

    }

}
