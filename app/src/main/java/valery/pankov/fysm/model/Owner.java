package valery.pankov.fysm.model;

import com.vk.sdk.api.model.Identifiable;

/**
 * Created by Valery on 31.08.2017.
 */

public interface Owner extends Identifiable {

    String getFullName();
    String getPhoto();
}
