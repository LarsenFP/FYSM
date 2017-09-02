package valery.pankov.fysm.model.view.counter;

import valery.pankov.fysm.model.Likes;

/**
 * Created by Valery on 01.09.2017.
 */

public class LikeCounterViewModel extends CounterViewModel{

    private Likes mLikes;

    public LikeCounterViewModel(Likes likes) {
        super(likes.getCount());

        this.mLikes = likes;

        if (mLikes.getUserLikes() == 1) {
            setAccentColor();
        }
    }

    public Likes getLikes() {
        return mLikes;
    }
}
