package lk.imgUplode.imgUplode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created By Imesh Hirushan
 * Project Name : imgUplode
 * Package Name : lk.imgUplode.imgUplode.dto
 * Date : Mar 26, 2024
 * Time : 9:29 PM
 */
@Data
@NoArgsConstructor

public class VehicleImageSaveDTO {
    private int vehicle_Id;
    private String brandName;
    private String img;

    public VehicleImageSaveDTO(int vehicle_Id, String brandName, String img) {
        this.vehicle_Id = vehicle_Id;
        this.brandName = brandName;
        this.img = img;
    }
}




