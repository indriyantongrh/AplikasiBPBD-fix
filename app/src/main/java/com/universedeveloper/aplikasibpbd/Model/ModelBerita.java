package com.universedeveloper.aplikasibpbd.Model;

import com.google.gson.annotations.SerializedName;

public class ModelBerita {
    @SerializedName("id_post") //ini yg ada di json
    private String id_post;

    @SerializedName("date") //ini yg ada di json
    private String date;

    @SerializedName("time") //ini yg ada di json
    private String time;

    @SerializedName("editor") //ini yg ada di json
    private String editor;

    @SerializedName("active") //ini yg ada di json
    private String active;

    @SerializedName("headline") //ini yg ada di json
    private String headline;

    @SerializedName("picture") //ini yg ada di json
    private String picture;

    @SerializedName("picture_description") //ini yg ada di json
    private String picture_description;

    @SerializedName("id_language") //ini yg ada di json
    private String id_language;

    @SerializedName("title") //ini yg ada di json
    private String title;

    @SerializedName("content") //ini yg ada di json
    private String content;

    @SerializedName("id_category") //ini yg ada di json
    private String id_category;

    public String getId_post() {
        return id_post;
    }

    public void setId_post(String id_post) {
        this.id_post = id_post;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture_description() {
        return picture_description;
    }

    public void setPicture_description(String picture_description) {
        this.picture_description = picture_description;
    }

    public String getId_language() {
        return id_language;
    }

    public void setId_language(String id_language) {
        this.id_language = id_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }
}
