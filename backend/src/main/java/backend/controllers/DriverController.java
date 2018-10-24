package backend.controllers;

import backend.model.dto.DriverDto;
import backend.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v0", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {
    private final DriverService driverService;

    @PostMapping(value = "/driver")
    public Long register(@RequestBody final DriverDto driverDto) {
        return driverService.registerDriver(driverDto);
    }

    @GetMapping(value = "/driver/{id}")
    public DriverDto find(@PathVariable("id") Long id) {
        return driverService.findById(id);
    }
}
