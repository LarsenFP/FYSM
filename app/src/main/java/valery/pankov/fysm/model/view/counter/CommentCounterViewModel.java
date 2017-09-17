package valery.pankov.fysm.model.view.counter;

import valery.pankov.fysm.model.countable.Comments;

/**
 * Created by Valery on 01.09.2017.
 */

public class CommentCounterViewModel extends CounterViewModel{

    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());

        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}
