package csc180.roeback.lia.DearDiaryAPI;
public class DiaryEntry{
    private int id;
    private String text;
    private String createDate;
    public DiaryEntry(String createDate, int id, String text){
        this.createDate = createDate;
        this.id = id;
        this.text = text;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getCreateDate(){
        return createDate;
    }
    public void setCreateDate(String createDate){
        this.createDate = createDate;
    }
}
