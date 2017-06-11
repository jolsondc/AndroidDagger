package com.jolly.androiddagger.Model;

/**
 * Created by Jollyboy on 10/06/17.
 */

public class Model {
    String id,title;

    public String getId() {
        return id;
    }

    public Model(String id,String title) {
        this.id = id;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

}
