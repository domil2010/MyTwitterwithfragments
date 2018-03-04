package com.codepath.apps.mytwitterapp.models;

import java.io.Serializable;

/**
 * Created by domil2010 on 3/3/2018.
 */

public class DraftTweet implements Serializable {

    long _id;
    String draft;

    public DraftTweet(long _id, String draft) {
        this._id = _id;
        this.draft = draft;
    }

    public long get_id() {
        return _id;
    }

    public DraftTweet(String draft) {
        this.draft = draft;
    }

    public String getDraft() {
        return draft;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    @Override
    public String toString() {
        return getDraft().length()<=30 ? getDraft() : getDraft().substring(0,30);
    }
}
