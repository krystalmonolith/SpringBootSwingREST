package com.alphapulsar.sb01.rest;

import com.alphapulsar.sb01.gui.GUI;
import com.alphapulsar.sb01.gui.IGUIDOM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Optional;

@RestController
public class GUIMapper {

    private Optional<GUI> gui;

    public GUIMapper(@Autowired GUI gui) {
        this.gui = Optional.ofNullable(gui);
    }

    @PutMapping("/gui/text1/{text}")
    public @ResponseBody ResponseEntity<String> putText1(@PathVariable("text") String text) {
        String oldText = "";
        if (gui.isPresent()) {
            final IGUIDOM guiDOM = gui.get().getGuiDOM();
            oldText = guiDOM.getText1();
            guiDOM.setText1(text);
        } else {
            return new ResponseEntity<>("GUI DOM Unavailable!", HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(HtmlUtils.htmlEscape(oldText), HttpStatus.OK);
    }

    @GetMapping("/gui/text1")
    public @ResponseBody ResponseEntity<String> getText1() {
        String text = gui.get().getGuiDOM().getText1();
        return new ResponseEntity<>(HtmlUtils.htmlEscape(text), HttpStatus.OK);
    }
}
