package edu.pucmm.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_messages")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;

    @NotEmpty(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe ser válido")
    private String email;

    @NotEmpty(message = "El mensaje no puede estar vacío")
    private String text;

}
