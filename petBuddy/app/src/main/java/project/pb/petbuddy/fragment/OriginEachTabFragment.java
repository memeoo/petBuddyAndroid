package project.pb.petbuddy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import project.pb.petbuddy.R;
import project.pb.petbuddy.activities.LogInActivity;
import project.pb.petbuddy.adapter.ListViewAdapter;
import project.pb.petbuddy.base.PetBuddyApplication;
import project.pb.petbuddy.views.SlidingTabLayout;

/**
 * Created by meme on 15. 5. 28..
 */
public abstract class OriginEachTabFragment extends Fragment {

    protected SlidingTabLayout mSlidingTabLayout;
    protected ListViewAdapter listViewAdapter;
    protected ListView listPetSitter;

    private ArrayAdapter<String> arrayAdapter;
    abstract void setInitialViewComponents();


    private final int REQUEST_CODE_LOGIN = 999;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

         listPetSitter = (ListView) rootView.findViewById(R.id.listPetSitter);
         listPetSitter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("meme", " onItemClicked !!");
                if(PetBuddyApplication.getPreferencesBoolean("loginOK") == false) {
                    Intent goLogin = new Intent(getActivity(), LogInActivity.class);
                    startActivityForResult(goLogin, REQUEST_CODE_LOGIN);
                }else{

                }
            }
        });
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_LOGIN){
//            Toast.makeText(getActivity(), "환영합니다 " +data.getStringExtra("id") +" 님~", Toast.LENGTH_SHORT).show();
        }
    }

    public static OriginEachTabFragment getInstance(final int tabId) {
        OriginEachTabFragment instance = null;
        switch (tabId) {
            case 0:
                instance = new PetBuddyListFragment();
                break;
            case 1:
                instance = new HowItWorksFragment();
                break;
        }
        return instance;
    }

    public void setSlidingTabLayout(final SlidingTabLayout slidingTabLayout) {
        mSlidingTabLayout = slidingTabLayout;
    }

    public void setListView(int tabId){
        if(listViewAdapter == null) {
            Log.d("meme", " NULL !!");
            listViewAdapter = new ListViewAdapter(getActivity());
//            arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, new String []{"aa","bb","cc"});
            listPetSitter.setAdapter(listViewAdapter);
        }else{
            Log.d("meme", " NOT NULL !!");
            listViewAdapter.notifyDataSetChanged();
//            arrayAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        setInitialViewComponents();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


}
