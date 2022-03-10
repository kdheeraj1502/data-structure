package com.web.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : dheerajkumar02
 * @date : 28-12-2021
 * @project : web-mvc
 */
@Component
@Table(name = "user_detail")
@Entity
@Data
public class UserDetails {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

}
