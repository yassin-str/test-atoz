package lu.atozdigital.api.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
public class Article {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] picture;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY)
    List<OrderT> actions = new ArrayList<>();


}