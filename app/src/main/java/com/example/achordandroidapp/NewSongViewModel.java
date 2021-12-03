package com.example.achordandroidapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.achordandroidapp.Editor.Bar;

import java.util.List;

public class NewSongViewModel extends ViewModel {

    //LiveData instance to pass the data within the viewmodel
    private MutableLiveData<Sheet> sheetMut = new MutableLiveData<Sheet>();

    //Static Sheet object to temporarily keep the data in the view
    private static Sheet sheetItem = new Sheet("","","","",0);


    //Attempt to connect this viewmodel with the repository, but later I found out that it would be better to make a new viemodel for this
    /*NewSongViewModel(Application app){
        super(app);
        sheetRepository = Repository.getInstance(app);

        /*sheetItem.setTitle("Title");
        sheetItem.setAuthor("Author");
        sheetItem.setKey("C");
        sheetItem.setTimeSignature("/4");
        sheetMut.setValue(sheetItem);*/
       /* sheet = new MutableLiveData<Sheet>();
        Sheet sheetObj = new Sheet("","","","",0);
        sheet.setValue(sheetObj);*/
    //}

    //Get the temporary sheet
    public LiveData<Sheet> getSheetMut() {
        return sheetMut;
    }


    //update the whole temporary object, but it is better to update them by fields (less action)
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


    //update the temporary object by its fields
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
