package com.tasks_api.tasks_api.model;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title_task")
    @NotEmpty(message = "O título não pode estar vazio")
    @Length(min = 4, message = "O título deve ter pelo menos 4 caracteres")
    private String title;

    @Column(name = "description_task")
    @NotEmpty(message = "A descrição não pode estar vazia")
    @Length(min = 4, message = "A descrição deve ter pelo menos 4 caracteres")
    private String description;

    @Column(name = "completed_task")
    @NotNull(message = "Deve ser definido um valor (TRUE/FALSE) no campo \"Completed\"")
    private boolean completed;

    public Task() {
    }
}
