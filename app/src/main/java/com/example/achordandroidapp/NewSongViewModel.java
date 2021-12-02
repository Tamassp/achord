package com.example.achordandroidapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.achordandroidapp.Editor.Bar;

import java.util.List;

public class NewSongViewModel extends ViewModel {

    private MutableLiveData<Sheet> sheetMut = new MutableLiveData<Sheet>();
    private static Sheet sheetItem = new Sheet("","","","",0);

    /*NewSongViewModel(){
        sheet = new MutableLiveData<Sheet>();
        Sheet sheetObj = new Sheet("","","","",0);
        sheet.setValue(sheetObj);
    }*/

    public LiveData<Sheet> getSheetMut() {
        return sheetMut;
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
        this.sheetMut.setValue(sheet);

    }

    public void setTitle(String title){
        sheetItem.setTitle(title);
        sheetMut.setValue(sheetItem);
   }

   public void setAuthor(String author){
        sheetItem.setAuthor(author);
        sheetMut.setValue(sheetItem);
   }

   public void setKey(String key){
        sheetItem.setKey(key);
        sheetMut.setValue(sheetItem);
   }

   public void setTimeSignature(String timeSignature){
        sheetItem.setTimeSignature(timeSignature);
        sheetMut.setValue(sheetItem);
   }


//   public void setBarList(List<Bar> barList){
//        sheetItem.setBarList(barList);
//       sheetMut.setValue(sheetItem);
//   }
//
//   public void addBar(Bar bar){
//        sheetItem.addBarToList(bar);
//       sheetMut.setValue(sheetItem);
//   }


}
