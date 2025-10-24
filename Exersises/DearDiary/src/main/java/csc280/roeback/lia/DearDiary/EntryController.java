package csc280.roeback.lia.DearDiary;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/entry")
public class EntryController{
    private Diary diary = new Diary();
    @RequestMapping(path = "", method = RequestMethod.POST)
    public void createEntry(@RequestBody DiaryEntry entry){
        entry.setCreateDate(LocalDateTime.now().toString());
        diary.entries.add(entry);
    }
}
