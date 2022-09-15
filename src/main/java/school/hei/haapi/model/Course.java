package school.hei.haapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "\"course\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Reference cannot be blank.")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Reference cannot be blank.")
    private String ref;

    @Column(nullable = false)
    @NotBlank(message = "Credits cannot be blank.")
    @Min(message = "Credits cannot be negative.", value = 1)
    private int credits;

    @Column(nullable = false)
    private int totalHours;
}
