package vo.survey;

import lombok.Builder;
import lombok.Data;
import utils.QuestionTypeEnum;

import java.util.UUID;

@Data
@Builder
public class QuestionVO {
    private UUID id;

    private String label;

    private QuestionTypeEnum type;

    private boolean isRequired;

    private int rankOrder;
}