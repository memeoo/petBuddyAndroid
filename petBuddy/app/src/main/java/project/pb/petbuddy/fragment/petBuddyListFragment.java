package project.pb.petbuddy.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.pb.petbuddy.R;


public class PetBuddyListFragment extends OriginEachTabFragment {


    @Override
    void setInitialViewComponents() {
        Log.d("meme", " PetBuddyListFragment !! ");
        setListView(0);
    }
}
