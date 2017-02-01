package layout;

import java.util.ArrayList;

/**
 * Created by KeeporderGO on 1/9/2017.
 */

public interface CommunicatorFragment {
    void onListClick(int position);
    void checkViewCreated(Boolean created);
    public void RespondString(String data);
    public void RespondStringArrayList(ArrayList<String> data);
}
