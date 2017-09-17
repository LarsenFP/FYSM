package valery.pankov.fysm.model.view.attachment.doc;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Valery on 17.09.2017.
 */

public class PhotoPreview extends RealmObject {
    RealmList<Size> sizes;

    public RealmList<Size> getSizes() {
        return sizes;
    }

    public void setSizes(RealmList<Size> sizes) {
        this.sizes = sizes;
    }
}
