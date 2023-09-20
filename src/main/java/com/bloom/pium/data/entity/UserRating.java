package com.bloom.pium.data.entity;


import javax.persistence.*;

@Entity
@Table(name = "user_ratings")
public class UserRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    private int rating; // 별점 (1~5)

    public void setRating(Object rating) {
    }

    public void setUser(Object user) {
    }

    // Getter와 Setter 메소드...
}
