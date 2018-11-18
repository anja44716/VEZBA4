public class Pretrazivac {
    private String ime, URLadresa;
    public Pretrazivac(String ime, String URLadresa){
        this.ime=ime;
        this.URLadresa=URLadresa;
    }
    public String napraviURL(String pojam){
        return(URLadresa+pojam);
    }
    public String getIme(){
        return(ime);
    }
}
