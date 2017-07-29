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
    public ResponseEntity<PutResponse> putText1(@PathVariable("text") String text) {
        PutResponse putResponse = new PutResponse();
        Optional<IGUIDOM> guiDOMOpt = Optional.ofNullable(gui.getGuiDOM());
        if (guiDOMOpt.isPresent()) {
            final IGUIDOM guiDOM = guiDOMOpt.get();
            putResponse.setOldText(guiDOM.getText1());
            guiDOM.setText1(text);
        } else {
            putResponse.setOldText("GUI DOM Unavailable!");
            return new ResponseEntity<>(putResponse, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(putResponse, HttpStatus.OK);
    }

    @GetMapping("text1")
    public ResponseEntity<GetResponse> getText1() {
        GetResponse getResponse = new GetResponse();
        Optional<IGUIDOM> guiDOMOpt = Optional.ofNullable(gui.getGuiDOM());
        if (guiDOMOpt.isPresent()) {
            getResponse.setText(HtmlUtils.htmlEscape(guiDOMOpt.get().getText1()));
        } else {
            getResponse.setText("GUI DOM Unavailable!");
            return new ResponseEntity<>(getResponse, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(getResponse, HttpStatus.OK);
    }
}
