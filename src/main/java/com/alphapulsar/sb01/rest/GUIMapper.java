package com.alphapulsar.sb01.rest;

import com.alphapulsar.sb01.gui.GUI;
import com.alphapulsar.sb01.gui.IGUIDOM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/gui")
public class GUIMapper {

    private GUI gui;

    public GUIMapper(@Autowired GUI gui) {
        this.gui = gui;
    }

    @PutMapping("text/{text}")
    public ResponseEntity<PutResponse> putText(@PathVariable("text") String text) {
        return processPut((IGUIDOM guiDOM, RESTResponse restResponse) -> {
            ((PutResponse)restResponse).setOldText(guiDOM.getText());
            guiDOM.setText(text);
        });
    }

    @GetMapping("text")
    public ResponseEntity<GetResponse> getText() {
        return processGet((IGUIDOM guiDOM, RESTResponse restResponse) -> ((GetResponse)restResponse).setText(guiDOM.getText())
        );
    }

    @PutMapping("prompt/{prompt}")
    public ResponseEntity<PutResponse> putPrompt(@PathVariable("prompt") String prompt) {
        return processPut((IGUIDOM guiDOM, RESTResponse restResponse) -> {
            ((PutResponse)restResponse).setOldText(guiDOM.getPrompt());
            guiDOM.setPrompt(prompt);
        });
    }

    @GetMapping("prompt")
    public ResponseEntity<GetResponse> getPrompt() {
        return processGet((IGUIDOM guiDOM, RESTResponse restResponse) -> ((GetResponse)restResponse).setText(guiDOM.getPrompt()));
    }

    private interface IDelegate {
        void process(IGUIDOM guiDOM, RESTResponse putResponse);
    }

    private ResponseEntity<PutResponse> processPut(IDelegate delegate) {
        PutResponse putResponse = new PutResponse();
        return processREST(delegate, putResponse);
    }

    private ResponseEntity<GetResponse> processGet(IDelegate delegate) {
        GetResponse getResponse = new GetResponse();
        return processREST(delegate, getResponse);
    }

    private <T extends RESTResponse> ResponseEntity<T> processREST(IDelegate delegate, T response) {
        Optional<IGUIDOM> guiDOMOpt = Optional.ofNullable(gui.getGuiDOM());
        if (guiDOMOpt.isPresent()) {
            delegate.process(guiDOMOpt.get(), response);
        } else {
            response.setError("GUI DOM Unavailable!");
            return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}