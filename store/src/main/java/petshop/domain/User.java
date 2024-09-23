package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userId;

    private String password;

    private String name;

    private String email;

    private String address;

    private String phone;
}
//>>> DDD / Value Object
