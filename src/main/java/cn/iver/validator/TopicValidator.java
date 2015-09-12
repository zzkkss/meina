package cn.iver.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class TopicValidator extends Validator {
    @Override
    protected void validate(Controller c) {
        validateString("topic.content", 1, 50, "msg", "标题不能为空且长度不超过50");
    }

    @Override
    protected void handleError(Controller c) {
        c.renderError(500);
    }
}
