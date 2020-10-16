package leoli.killtrycatch.controller;

import leoli.killtrycatch.bean.Licence;
import leoli.killtrycatch.service.LicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author leoli
 * @date 2020/10/16
 */
@RestController
@RequestMapping("licence")
public class LicenceController {

    @Autowired
    LicenceService service;

    @GetMapping("/{id}")
    public Licence get(@PathVariable String id) {
        Licence licence = service.get(null);
        return licence;
    }

}