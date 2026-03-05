public class Movie {
    public String title = "킹콩";
    public String director = "피터 잭슨";
    public String starring = "나오미 왓츠";
    public int rating = 15;

    public void setTitle( String newTitle ) {
         title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    public void playMovie() {
         System.out.println( title +
                                     "를 상영합니다.");
    }

}
