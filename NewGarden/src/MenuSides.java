public class MenuSides {
    
    private final String food;
    private final double sizeOne;
    private final double sizeTwo;
    private final double sizeThree;
    
    public String getName(){
        return food;
    }
    
    public double getSizeOne(){
        return sizeOne;
    }
    
    public double getSizeTwo(){
        return sizeTwo;
    }
    
    public double getSizeThree(){
        return sizeThree;
    }
    
    public MenuSides(String food, double sizeOne, double sizeTwo, double sizeThree) {
        this.food = food;
        this.sizeOne = sizeOne;
        this.sizeTwo = sizeTwo;
        this.sizeThree = sizeThree;
    }
}
