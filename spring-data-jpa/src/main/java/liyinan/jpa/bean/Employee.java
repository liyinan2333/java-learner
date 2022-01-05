package liyinan.jpa.bean;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Convert(disableConversion = true)
    @Column(name = "birthday")
    private Instant birthday;

    @Column(name = "del_tag")
    private Boolean delTag;

}