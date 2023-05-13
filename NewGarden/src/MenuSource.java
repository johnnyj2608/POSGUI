public class MenuSource {
    
    private final int id;
    private final String food;
    private final String half1;
    private final String half2;
    private final int amt;
    private final String categ;
    
    public String getName(){
        return food;
    }
    
    public String getHalf1(){
        return half1;
    }
    
    public String getHalf2(){
        return half2;
    }
    
    public int getAmount(){
        return amt;
    }
    
    public String getCateg() {
        return categ;
    }
    
    public int getID() {
        return id;
    }
    
    public MenuSource(int id, String food, String half1, String half2, int amt, String categ) {
        this.id = id;
        this.food = food;
        this.half1 = half1;
        this.half2 = half2;
        this.amt = amt;
        this.categ = categ;
    }
}
