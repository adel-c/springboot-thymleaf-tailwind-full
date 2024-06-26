package com.ace.thymleafdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CUSTOMER")
@NoArgsConstructor
@Getter
@Setter
class CustomerEntity {
    @Id
    private Integer id;
    private String name;
    private String email;
}
