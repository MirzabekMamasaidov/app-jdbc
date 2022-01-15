package entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Currency {
    private Integer id;
    private String name;
    private boolean active;
}
