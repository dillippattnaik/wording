package org.learn.word.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.learn.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dillip
 */
@Controller
@RequestMapping("/wording")
public class WordController {

    private final static Logger LOGGER = Logger.getLogger(WordController.class.getName());
    @Autowired
    private WordService wordService;

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public @ResponseBody
    String get(@PathVariable Integer number, Model model) {
        String responseValue = null;
        if (number < 0) {
            LOGGER.log(Level.WARNING, "invalid number:{0}", number);
            responseValue = "Invalid input";
        } else {
            responseValue = wordService.getWord(number);
        }
        return responseValue;
    }
}
