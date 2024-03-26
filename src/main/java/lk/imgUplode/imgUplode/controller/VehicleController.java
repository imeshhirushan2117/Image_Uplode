package lk.imgUplode.imgUplode.controller;

import lk.imgUplode.imgUplode.dto.VehicleDTO;
import lk.imgUplode.imgUplode.dto.VehicleImageSaveDTO;
import lk.imgUplode.imgUplode.entity.Vehicle;
import lk.imgUplode.imgUplode.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created By Imesh Hirushan
 * Project Name : imgUplode
 * Package Name : lk.imgUplode.imgUplode.controller
 * Date : Mar 26, 2024
 * Time : 9:25 PM
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
   final VehicleService vehicleService;

   @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //save image
    @PostMapping("/saveVehicleImg")
    public ResponseEntity<Object> saveVehicle(@ModelAttribute VehicleDTO vehicleDTO)  {
        try {
            VehicleImageSaveDTO vehicleImageSaveDTO = vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity<>(vehicleImageSaveDTO , HttpStatus.CREATED);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>("Image Upload Fail" , HttpStatus.FORBIDDEN);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllVehicle/Images")
    public ResponseEntity<Object> getAllVehicle(){
        List<Vehicle> allVehicle = vehicleService.getAllVehicle();
        return new ResponseEntity<>(allVehicle , HttpStatus.CREATED);
    }
}
