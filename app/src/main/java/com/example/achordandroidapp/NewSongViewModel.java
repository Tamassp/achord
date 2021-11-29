package com.example.achordandroidapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewSongViewModel extends ViewModel {

    private MutableLiveData<Sheet> sheet = new MutableLiveData<Sheet>();
    private static Sheet sheet2 = new Sheet("","","","",0);

    /*NewSongViewModel(){
        sheet = new MutableLiveData<Sheet>();
        Sheet sheetObj = new Sheet("","","","",0);
        sheet.setValue(sheetObj);
    }*/

    public LiveData<Sheet> getSheet() {
        return sheet;
    }

    public void updateSheet (Sheet sheet){
//        if(sheet.getTitle() != null) {
//            this.sheet.setValue(sheet);
//        }
//        if(sheet.getAuthor() != null) {
//            this.sheet.getValue().setAuthor(sheet.getAuthor());
//        }
//        if(sheet.getKey() != null) {
//            this.sheet.getValue().setKey(sheet.getKey());
//        }
//        if(sheet.getTimeSignature() != null) {
//            this.sheet.getValue().setTimeSignature(sheet.getTimeSignature());
//        }
        this.sheet.setValue(sheet);

    }

    public void setTitle(String title){
        sheet2.setTitle(title);
        sheet.setValue(sheet2);
   }

   public void setAuthor(String author){
        sheet2.setAuthor(author);
        sheet.setValue(sheet2);
   }

   public void setKey(String key){
        sheet2.setKey(key);
        sheet.setValue(sheet2);
   }

   public void setTimeSignature(String timeSignature){
        sheet2.setTimeSignature(timeSignature);
        sheet.setValue(sheet2);
   }





}
