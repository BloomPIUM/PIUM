package com.bloom.pium.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class Board extends BaseEntity{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


}
