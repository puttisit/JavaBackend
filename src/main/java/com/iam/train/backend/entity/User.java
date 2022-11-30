package com.iam.train.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="m_user")

public class User extends BaseEntity{
    @Column(nullable = false,unique = true,length = 60) //name="Email",ห้ามเป็นค่า null,ห้ามซ้ำ,ขนาดห้ามเกิน 60 ตัวอักษร
    private String email;

    @Column(nullable = false,length = 120)
    private String password;

    @Column(nullable = false,length = 120)
    private String name;

}
