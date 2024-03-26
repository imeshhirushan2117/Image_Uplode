package lk.imgUplode.imgUplode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Created By Imesh Hirushan
 * Project Name : imgUplode
 * Package Name : lk.imgUplode.imgUplode.entity
 * Date : Mar 26, 2024
 * Time : 9:26 PM
 */
@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer vehicle_Id;
    private String brandName;
    private String img;
}
