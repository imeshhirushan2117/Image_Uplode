package lk.imgUplode.imgUplode.service;

import lk.imgUplode.imgUplode.dto.VehicleDTO;
import lk.imgUplode.imgUplode.dto.VehicleImageSaveDTO;
import lk.imgUplode.imgUplode.entity.Vehicle;
import lk.imgUplode.imgUplode.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created By Imesh Hirushan
 * Project Name : imgUplode
 * Package Name : lk.imgUplode.imgUplode.service
 * Date : Mar 26, 2024
 * Time : 9:28 PM
 */
@Service
public class VehicleService {
    final VehicleRepo vehicleRepo;

    @Autowired
    public VehicleService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public VehicleImageSaveDTO saveVehicle(VehicleDTO vehicleDTO) throws URISyntaxException, IOException {
        String absolutePath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();

        File uploadDir = new File(absolutePath + "/src/main/resources/static/uploads");
        uploadDir.mkdir();

        vehicleDTO.getImg().transferTo(new File(uploadDir.getAbsolutePath() + "/" + vehicleDTO.getImg().getOriginalFilename()));


        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(vehicleDTO.getBrandName());
        vehicle.setImg("uploads/" +vehicleDTO.getImg().getOriginalFilename());




        Vehicle save = vehicleRepo.save(vehicle);
        System.out.println(vehicleDTO.getImg());

        return new VehicleImageSaveDTO(save.getVehicle_Id(),save.getBrandName(),save.getBrandName());

    }

    public List<Vehicle> getAllVehicle() {
        List<Vehicle> all = vehicleRepo.findAll();
        return all;
    }
}
