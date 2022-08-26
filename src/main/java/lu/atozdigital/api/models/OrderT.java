package lu.atozdigital.api.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
public class OrderT {
    @Id
    @GeneratedValue
    private Long id;
    private String reference;
    private Date date;
    @JsonManagedReference
    @OneToMany( fetch = FetchType.LAZY)
    private List<Article> articles=new ArrayList<>();
}
