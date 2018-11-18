public class VrstePretrazivaca {
    private static Pretrazivac[] pretrazivaci=
        { new Pretrazivac("Google", "https://www.google.com/#q="),
          new Pretrazivac("Bing","https://www.bing.com/search?q="),
          new Pretrazivac("Yahoo","https://search.yahoo.com/bin/search?p=")
        };
    public static Pretrazivac[] getPretrazivaci(){
        return(pretrazivaci);
    }
    public static String napraviURL(String searchEngineName, String searchString){
        Pretrazivac[] searchSpecs = getPretrazivaci();
        String URLadresa = null;
        for(Pretrazivac spec : searchSpecs){
            if(spec.getIme().equalsIgnoreCase(searchEngineName)){
                URLadresa = spec.napraviURL(searchString);
                break;
            }
        }
        return(URLadresa);
    }
}
