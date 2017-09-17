package valery.pankov.fysm.model.view.attachment.video;

import io.realm.RealmObject;

/**
 * Created by Valery on 17.09.2017.
 */

public class File extends RealmObject {
    public String external;

    public String getExternal() {
        return external;
    }

    public void setExternal(String external) {
        this.external = external;
    }
}
