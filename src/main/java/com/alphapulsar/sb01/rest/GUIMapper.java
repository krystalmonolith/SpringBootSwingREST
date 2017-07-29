package com.alphapulsar.sb01.rest;

import com.alphapulsar.sb01.gui.GUI;
import com.alphapulsar.sb01.gui.IGUIDOM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Optional;

@RestController
@RequestMapping("/gui")
public class GUIMapper {

    private GUI gui;

    public GUIMapper(@Autowired GUI gui) {
        this.gui = gui;
    }

    @PutMapping("text1/{text}")
    public ResponseEntity<String> putText1(@PathVariable("text") String text) {
        String oldText = "";
        Optional<IGUIDOM> guiDOMOpt = Optional.ofNullable(gui.getGuiDOM());
        if (guiDOMOpt.isPresent()) {
            final IGUIDOM guiDOM = guiDOMOpt.get();
            oldText = guiDOM.getText1();
            guiDOM.setText1(text);
        } else {
            return new ResponseEntity<>("GUI DOM Unavailable!", HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(HtmlUtils.htmlEscape(oldText), HttpStatus.OK);
    }

    @GetMapping("text1")
    public ResponseEntity<String> getText1() {
        String text = "";
        Optional<IGUIDOM> guiDOMOpt = Optional.ofNullable(gui.getGuiDOM());
        if (guiDOMOpt.isPresent()) {
            text = guiDOMOpt.get().getText1();
        } else {
            return new ResponseEntity<>("GUI DOM Unavailable!", HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(HtmlUtils.htmlEscape(text), HttpStatus.OK);
    }
}
