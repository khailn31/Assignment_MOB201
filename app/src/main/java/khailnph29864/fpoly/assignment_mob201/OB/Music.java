package khailnph29864.fpoly.assignment_mob201.OB;

public class Music {
 private String title;
 private int file;

    public Music(String title, int file) {
        this.title = title;
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public String toString(){
        return  this.title;
    }
}
