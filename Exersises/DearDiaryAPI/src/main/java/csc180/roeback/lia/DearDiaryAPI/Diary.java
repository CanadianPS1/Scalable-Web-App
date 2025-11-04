package csc180.roeback.lia.DearDiaryAPI;
import java.util.ArrayList;
import java.util.List;
public class Diary{
    List<DiaryEntry> entries = new ArrayList<>();
    public void add(DiaryEntry entry){
        this.entries.add(entry);
    }
    public List<DiaryEntry> findAll(){
        return entries;
    }
}
