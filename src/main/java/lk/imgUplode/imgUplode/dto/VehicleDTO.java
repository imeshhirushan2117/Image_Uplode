package lk.imgUplode.imgUplode.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created By Imesh Hirushan
 * Project Name : imgUplode
 * Package Name : lk.imgUplode.imgUplode.dto
 * Date : Mar 26, 2024
 * Time : 9:26 PM
 */
@Data
public class VehicleDTO {
    private int vehicle_Id;
    private String brandName;
    private MultipartFile img;
}
