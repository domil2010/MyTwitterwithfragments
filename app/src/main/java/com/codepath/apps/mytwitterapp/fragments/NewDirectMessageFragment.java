package com.codepath.apps.mytwitterapp.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.codepath.apps.mytwitterapp.R;
import com.codepath.apps.mytwitterapp.databinding.NewPostDirectMessageBinding;
import com.codepath.apps.mytwitterapp.utils.TwitterApplication;
import com.codepath.apps.mytwitterapp.utils.TwitterClient;

/**
 * Created by domil2010 on 3/3/2018.
 */

public class NewDirectMessageFragment extends DialogFragment {
    Context ctx;
    FragmentManager fm;
    ImageView delete;
    EditText edit_message;
    EditText edit_name;
    private NewPostDirectMessageBinding binding;
    private TwitterClient client;

    public interface postDirectMessageListener{
        void postDirectMessage(String name, String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ctx = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        final Button sendBtn;

        binding = DataBindingUtil.inflate(inflater, R.layout.new_post_direct_message,container,false);
        View view = binding.getRoot();
        Bundle bun = getArguments();

        edit_message = binding.messageText;
        edit_name = binding.messageName;
        delete = binding.delete;
        sendBtn = binding.send;

        fm = getChildFragmentManager();


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDirectMessageListener listener = (postDirectMessageListener) getActivity();
                listener.postDirectMessage(edit_name.getText().toString(),edit_message.getText().toString());
                dismiss();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                            dismiss();
            }
        });

        return view;
    }




}
