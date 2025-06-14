package vo.survey;

import entity.survey.Question;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class SurveyVO {
    private UUID id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private UUID createdBy;

    private List<Question> questions;

    private boolean isActive;
}
