package leoli.killtrycatch.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author leoli
 * @date 2020/10/12
 */
@Data
@Entity
@Table(name = "licence")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Licence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "licence_id")
    private String licenceId;

    @Column(name = "organization_id")
    private String organizationId;

    @Column(name = "licence_type")
    private String licenceType;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "licence_max")
    private Integer licenceMax;

    @Column(name = "licence_allocated")
    private Integer licenceAllocated;

}