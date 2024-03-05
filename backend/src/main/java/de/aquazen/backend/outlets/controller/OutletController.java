package de.aquazen.backend.outlets.controller;

import de.aquazen.backend.outlets.domain.Outlet;
import de.aquazen.backend.outlets.service.OutletService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outlets")
public class OutletController {
    private final OutletService outletService;

    public OutletController(OutletService outletService) {
        this.outletService = outletService;
    }

    @GetMapping
    public List<OutletDTO> list() {
        return this.outletService.findAllOutlets()
                .stream()
                .map(OutletDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public OutletDTO read(@PathVariable @Min(1) Long id) {
        return this.outletService.findOutletById(id)
                .map(OutletDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public OutletDTO create(@RequestBody @Valid @NotNull @NotEmpty Outlet outlet) {
        return new OutletDTO(this.outletService.createOutlet(outlet));
    }

    @PutMapping("/{id}")
    public OutletDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Outlet outlet) {
        return new OutletDTO(this.outletService.updateOutlet(id, outlet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.outletService.deleteOutlet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
