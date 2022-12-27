package liyinan.split.table.rest;

import liyinan.split.table.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRest {

    @Autowired
    UserService userService;

    @RequestMapping("save")
    public ResponseEntity save(@RequestParam String name, @RequestParam Integer age) {
        int ret = userService.save(name, age);
        if (ret > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("list")
    public ResponseEntity list() {
        return ResponseEntity.ok(userService.list());
    }

}
