package valery.pankov.fysm.rest.model.response;

import java.util.ArrayList;
import java.util.List;

import valery.pankov.fysm.model.Group;
import valery.pankov.fysm.model.Owner;
import valery.pankov.fysm.model.Profile;

/**
 * Created by Valery on 31.08.2017.
 */

public class ItemWithSendersResponse<T> extends BaseItemResponse<T> {

    private List<Profile> profiles = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    private List<Profile> getProfiles() {
        return profiles;
    }

    private List<Group> getGroups() {
        return groups;
    }

    private List<Owner> getAllSenders() {
        List<Owner> all = new ArrayList<>();
        all.addAll(getProfiles());
        all.addAll(getGroups());
        return all;
    }

    public Owner getSender(int id) {
        for (Owner owner : getAllSenders()) {
            if (owner.getId() == Math.abs(id)) {
                return owner;
            }
        }
        return null;
    }

}
