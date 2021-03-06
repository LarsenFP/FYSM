package valery.pankov.fysm.di.component;

import javax.inject.Singleton;

import dagger.Component;
import valery.pankov.fysm.MVP.presenter.BoardPresenter;
import valery.pankov.fysm.MVP.presenter.CommentsPresenter;
import valery.pankov.fysm.MVP.presenter.InfoPresenter;
import valery.pankov.fysm.MVP.presenter.MainPresenter;
import valery.pankov.fysm.MVP.presenter.MembersPresenter;
import valery.pankov.fysm.MVP.presenter.NewsFeedPresenter;
import valery.pankov.fysm.MVP.presenter.OpenedCommentPresenter;
import valery.pankov.fysm.MVP.presenter.OpenedPostPresenter;
import valery.pankov.fysm.MVP.presenter.TopicCommentsPresenter;
import valery.pankov.fysm.common.manager.NetworkManager;
import valery.pankov.fysm.di.module.ApplicationModule;
import valery.pankov.fysm.di.module.ManagerModule;
import valery.pankov.fysm.di.module.RestModule;
import valery.pankov.fysm.model.view.CommentBodyViewModel;
import valery.pankov.fysm.model.view.CommentFooterViewModel;
import valery.pankov.fysm.model.view.TopicViewModel;
import valery.pankov.fysm.ui.activity.BaseActivity;
import valery.pankov.fysm.ui.activity.MainActivity;
import valery.pankov.fysm.ui.fragment.CommentsFragment;
import valery.pankov.fysm.ui.fragment.NewsFeedFragment;
import valery.pankov.fysm.ui.fragment.OpenedCommentFragment;
import valery.pankov.fysm.ui.fragment.OpenedPostFragment;
import valery.pankov.fysm.ui.fragment.TopicCommentsFragment;
import valery.pankov.fysm.ui.holder.NewsItemBodyHolder;
import valery.pankov.fysm.ui.holder.NewsItemFooterHolder;
import valery.pankov.fysm.ui.holder.attachment.ImageAttachmentHolder;
import valery.pankov.fysm.ui.holder.attachment.VideoAttachmentHolder;

/**
 * Created by Valery on 28.08.2017.
 */

@Singleton
@Component(modules={ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragments
    void inject(NewsFeedFragment fragment);
    void inject(OpenedPostFragment fragment);
    void inject(CommentsFragment fragment);
    void inject(OpenedCommentFragment fragment);
    void inject(TopicCommentsFragment fragment);

    //holders
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);
    void inject(ImageAttachmentHolder holder);
    void inject(VideoAttachmentHolder holder);
    void inject(CommentBodyViewModel.CommentBodyViewHolder holder);
    void inject(CommentFooterViewModel.CommentFooterHolder holder);
    void inject(TopicViewModel.TopicViewHolder holder);

    //presenters
    void inject(NewsFeedPresenter presenter);
    void inject(MainPresenter presenter);
    void inject(MembersPresenter presenter);
    void inject(BoardPresenter presenter);
    void inject(InfoPresenter presenter);
    void inject(OpenedPostPresenter presenter);
    void inject(CommentsPresenter presenter);
    void inject(OpenedCommentPresenter presenter);
    void inject(TopicCommentsPresenter presenter);

    //managers
    void inject(NetworkManager manager);




}
