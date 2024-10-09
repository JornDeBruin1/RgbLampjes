package com.example.rgbled.controller;
import com.example.rgbled.service.LedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class LedController {
    @Autowired
    private LedService ledService;
    @PostMapping("/set_color")
    public String setLedColor(@RequestParam int r, @RequestParam int g, @RequestParam int b) {
        ledService.setColor(r, g, b);
        return "LED color set to RGB(" + r + ", " + g + ", " + b + ")";
    }
    @PostMapping("/cycle_colors")
    public String cycleColors() {
        ledService.cycleColors();
        return "Cycling colors!";
    }
}
// package com.example.rgbled.controller;
// import com.example.rgbled.service.LedService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// @RestController
// @RequestMapping("/api")
// public class LedController {
//     @Autowired
//     private LedService ledService;
//     @PostMapping("/set_color")
//     public String setLedColor(@RequestParam int r, @RequestParam int g, @RequestParam int b) {
//         ledService.setColor(r, g, b);
//         return "LED color set to RGB(" + r + ", " + g + ", " + b + ")";
//     }
//     @PostMapping("/cycle_colors")
//     public String cycleColors() {
//         ledService.cycleColors();
//         return "Cycling colors!";
//     }
// }