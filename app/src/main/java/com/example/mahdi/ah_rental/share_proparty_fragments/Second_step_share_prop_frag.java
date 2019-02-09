package com.example.mahdi.ah_rental.share_proparty_fragments;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.mahdi.ah_rental.R;
import com.example.mahdi.ah_rental.interfaces.share_fragments_data;
import com.example.mahdi.ah_rental.share_proparty_fragments.Adapter.ImageAdapterStepTwo;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class Second_step_share_prop_frag extends Fragment {


    View rootView;
    share_fragments_data fragments_data;
    private static int GALLERY_REQUEST_CODE = 100;
    Uri imageUri;
    Bundle bundle;
    public Second_step_share_prop_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_second_step_share_prop_frag, container, false);
        fragments_data = (share_fragments_data) getActivity();
        bundle = new Bundle();
        bundle.putInt("step",2);
        GridView gridView_image = rootView.findViewById(R.id.image_proparty_share);
        gridView_image.setAdapter(new ImageAdapterStepTwo(getActivity()));
        Button btn_add_image_file = rootView.findViewById(R.id.btn_share_add_image);
        Button btn_share_next = rootView.findViewById(R.id.btn_share_next_second);


        // add data set of step into interface class
        btn_share_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // put bundle into interface method
                fragments_data.oneDoneClick(bundle);
            }
        });


        // open gallery of android give it single image
        btn_add_image_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });


        // set image into grideview of on event onclick each item and how each postion of items in grideview
        gridView_image.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "your click on item = "+position, Toast.LENGTH_LONG).show();
            }
        });

        // return whole of view in fragment
        return rootView;
    }

    // get result of openGallery from activity
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            try {
                imageUri = data.getData();
                Bitmap imageBit = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
//                imageview.setImageBitmap(imageBit);
                Toast.makeText(getActivity(), "Image choose in gallary", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


        // open gallery from implicity activity
        private void openGallery(){
            Intent gIntent = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            gIntent.setType("image/*");
            startActivityForResult(gIntent,GALLERY_REQUEST_CODE);
        }
}
