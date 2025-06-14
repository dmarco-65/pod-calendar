package entity.survey;

import jakarta.persistence.*;
import lombok.Data;
import utils.QuestionTypeEnum;

import java.util.UUID;

@Entity
@Table(name = "question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionTypeEnum type;

    @Column(nullable = false)
    private boolean isRequired;

    @Column(nullable = false)
    private int rankOrder;
}